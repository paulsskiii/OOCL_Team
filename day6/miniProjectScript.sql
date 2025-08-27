
-- Stored Procedure: GetCustomerDeliveryHistory
DELIMITER //

CREATE PROCEDURE GetCustomerDeliveryHistory(IN customerId INT)
BEGIN
    SELECT 
        CONCAT(c.firstName, ' ', c.lastName) AS fullName,
        (SELECT COUNT(*) FROM package WHERE senderId = customerId) AS totalSent,
        (SELECT COUNT(*) FROM package WHERE recepientId = customerId) AS totalReceived;

    SELECT 
        p.id AS packageId,
        p.deliveryDate,
        pt.name AS packageType,
        ps.status AS deliveryStatus,
        CONCAT(cr.firstName, ' ', cr.lastName) AS courierName
    FROM package p
    LEFT JOIN packageTypes pt ON pt.id = p.packageTypesId
    LEFT JOIN trackingEvent te ON te.packageId = p.id
    LEFT JOIN packageStatus ps ON ps.id = te.packageStatusId
    LEFT JOIN courier cr ON cr.id = te.courierIdGetActiveDeliveryCitiesGetActiveDeliveryCitiesGetActiveDeliveryCities
    WHERE p.senderId = customerId OR p.recepientId = customerId
    GROUP BY p.id, te.packageStatusId
    ORDER BY p.deliveryDate DESC;
END //

DELIMITER ;

-- index
CREATE INDEX idx_customer_id ON package(senderId, recepientId);
CREATE INDEX idx_courier_id ON trackingEvent(courierId);



CALL GetCustomerDeliveryHistory(1);
CALL GetActiveDeliveryCities();
CALL getPackageJourneyTracker(65);
CALL getCourierScorecard(45);

SELECT DISTINCT CONCAT(a.firstName, ' ', a.lastName) AS 'Customer', 
b.id AS 'Package_Id', b.deliveryDate 
--  AS 'Delivery Date', e.`name` 
--  AS 'Package Type', f.`status` 
--  AS 'Status', CONCAT(c.firstName, ' ', c.lastName) 
--  AS 'Courier'
    FROM customer a
  JOIN package b ON b.senderId = 1 OR b.recepientId = 1
    -- JOIN trackingevent d ON d.packageId = b.id
--     JOIN courier c ON c.id = d.courierId
--     JOIN packagetypes e ON e.id = b.packageTypesId
--     JOIN packagestatus f ON f.id = d.packageStatusId
    WHERE a.id = 1
    AND f.`status` not like 'In-Transit';

 SELECT DISTINCT CONCAT(a.firstName, ' ', a.lastName) AS 'Customer', b.id 
 AS 'Package_Id', b.deliveryDate AS 'Delivery Date', e.`name` 
 AS 'Package Type', f.`status` AS 'Status', CONCAT(c.firstName, ' ', c.lastName) AS 'Courier'
    FROM customer a
    JOIN package b ON b.senderId = 1 OR b.recepientId = 1
    JOIN trackingevent d ON d.packageId = b.id
    JOIN courier c ON c.id = d.courierId
    JOIN packagetypes e ON e.id = b.packageTypesId
    JOIN packagestatus f ON f.id = d.packageStatusId
    WHERE a.id = 1
    AND f.`status` != 'In-Transit';

SELECT * FROM getCourierScorecard WHERE courierId = 45;
SELECT id FROM package LIMIT 5;
SELECT * FROM customer WHERE id = 1;
SELECT * FROM courier;
SELECT COUNT(*) FROM courier;
SHOW PROCEDURE STATUS WHERE Name = 'GetActiveDeliveryCities';

SELECT COUNT(*) FROM package p
JOIN trackingEvent te ON te.packageId = p.id
JOIN packageStatus ps ON ps.id = te.packageStatusId
WHERE ps.status = 'Delivered' AND p.deliveryDate >= CURDATE() - INTERVAL 30 DAY;



-- Stored Procedure: GetActiveDeliveryCities
DELIMITER //

CREATE PROCEDURE GetActiveDeliveryCities()
BEGIN
    -- Subquery to get most frequent courier per city
    SELECT 
        city,
        deliveredPackages,
        mostFrequentCourier,
        avgDeliveryDays
    FROM (
        SELECT 
            c.city,
            COUNT(p.id) AS deliveredPackages,
            (
                SELECT CONCAT(cr.firstName, ' ', cr.lastName)
                FROM trackingEvent te2
                JOIN courier cr ON cr.id = te2.courierId
                JOIN package p2 ON p2.id = te2.packageId
                JOIN customer c2 ON c2.id = p2.recepientId
                JOIN packageStatus ps2 ON ps2.id = te2.packageStatusId
                WHERE ps2.status = 'Delivered'
                  AND p2.deliveryDate >= CURDATE() - INTERVAL 30 DAY
                  AND c2.city = c.city
                GROUP BY te2.courierId
                ORDER BY COUNT(*) DESC
                LIMIT 1
            ) AS mostFrequentCourier,
            ROUND(AVG(DATEDIFF(p.deliveryDate, p.pickupDate)), 2) AS avgDeliveryDays
        FROM package p
        JOIN customer c ON c.id = p.recepientId
        JOIN trackingEvent te ON te.packageId = p.id
        JOIN packageStatus ps ON ps.id = te.packageStatusId
        WHERE ps.status = 'Delivered'
          AND p.deliveryDate >= CURDATE() - INTERVAL 30 DAY
        GROUP BY c.city
    ) AS result
    ORDER BY deliveredPackages DESC;
END //

DELIMITER ;

-- Stored Procedure: TrackPackageJourney
DELIMITER //

CREATE PROCEDURE TrackPackageJourney(IN packId INT)
BEGIN
    SELECT 
        CONCAT(s.firstName, ' ', s.lastName) AS sender,
        CONCAT(r.firstName, ' ', r.lastName) AS recipient
    FROM package p
    JOIN customer s ON s.id = p.senderId
    JOIN customer r ON r.id = p.recepientId
    WHERE p.id = packId;

    SELECT 
        te.description,
        l.locationName,
        ps.status,
        te.id AS eventTime,
        CONCAT(cr.firstName, ' ', cr.lastName) AS courierName
    FROM trackingEvent te
    JOIN location l ON l.id = te.locationId
    JOIN packageStatus ps ON ps.id = te.packageStatusId
    LEFT JOIN courier cr ON cr.id = te.courierId
    WHERE te.packageId = packId
    ORDER BY te.id;
END //

DELIMITER ;

-- Stored Procedure: GetCourierScorecard
DELIMITER //

CREATE PROCEDURE GetCourierScorecard(IN courierId INT)
BEGIN
    DECLARE totalDelivered INT;
    DECLARE avgDeliveryTime DECIMAL(10,2);
    DECLARE failedDeliveries INT;
    DECLARE cityCoverage INT;
    DECLARE reliabilityScore INT;

    -- Total Delivered
    SELECT COUNT(DISTINCT p.id) INTO totalDelivered
    FROM package p
    JOIN trackingEvent te ON te.packageId = p.id
    JOIN packageStatus ps ON ps.id = te.packageStatusId
    WHERE te.courierId = courierId AND ps.status = 'Delivered';

    -- Average Delivery Time
    SELECT AVG(DATEDIFF(p.deliveryDate, p.pickupDate)) INTO avgDeliveryTime
    FROM package p
    JOIN trackingEvent te ON te.packageId = p.id
    WHERE te.courierId = courierId AND p.deliveryDate IS NOT NULL;

    -- Failed Deliveries
    SELECT COUNT(DISTINCT p.id) INTO failedDeliveries
    FROM package p
    JOIN trackingEvent te ON te.packageId = p.id
    JOIN packageStatus ps ON ps.id = te.packageStatusId
    WHERE te.courierId = courierId AND (ps.status LIKE '%Failed%' OR ps.status LIKE '%Returned%');

    -- City Coverage
    SELECT COUNT(DISTINCT c.city) INTO cityCoverage
    FROM package p
    JOIN customer c ON c.id = p.recepientId
    JOIN trackingEvent te ON te.packageId = p.id
    WHERE te.courierId = courierId;

    -- Score
    SET reliabilityScore = (totalDelivered * 2) - (failedDeliveries * 3) - avgDeliveryTime + cityCoverage;

    -- Output
    SELECT 
        CONCAT(cr.firstName, ' ', cr.lastName) AS courierName,
        totalDelivered AS totalPackagesDelivered,
        avgDeliveryTime AS averageDeliveryDays,
        failedDeliveries,
        cityCoverage AS uniqueCitiesDelivered,
        reliabilityScore,
        CASE
            WHEN reliabilityScore >= 80 THEN 'TOP performer'
            WHEN reliabilityScore >= 50 THEN 'Reliable'
            ELSE 'Needs Improvement'
        END AS interpretation
    FROM courier cr
    WHERE cr.id = courierId;
END //

DELIMITER ;


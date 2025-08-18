DELIMITER $$
USE `group3_miniproject`$$
CREATE PROCEDURE `GetCourierScorecard` (IN courierId INT)
BEGIN
		SELECT 
			CourierName,
            TotalDelivered,
            FailedDeliveries,
            AverageDeliveryTime,
            CityCoverage,
            IF(((TotalDelivered * 2) - (FailedDeliveries * 3) - (AverageDeliveryTime - CityCoverage)) < 0, 0,  ((TotalDelivered * 2) - (FailedDeliveries * 3) - (AverageDeliveryTime - CityCoverage))) AS ReliabilityScore
        FROM (
			SELECT 
            ( -- #1 Courier Full name
				SELECT CONCAT(co.first_name, ' ', co.last_name) AS 'Courier Name' FROM Couriers co
				WHERE co.id = courierId
            ) AS CourierName,
            ( -- #2 Total packages delivered
				SELECT COUNT(p.id) 'Total No. of Packages Delivered'  FROM Couriers co
				INNER JOIN PACKAGES p ON co.id = p.courier_id
                WHERE co.id = courierId
				) AS TotalDelivered,
            (
			-- #3 Average Delivery Time
				SELECT AVG(TIMESTAMPDIFF(HOUR, p.delivery_date, p.pickup_date)) AS 'Average Delivery Time'  FROM Couriers co
				INNER JOIN PACKAGES p ON co.id = p.courier_id
				WHERE co.id = courierId
			) AS AverageDeliveryTime,
            (
			-- #4 Failed Deliveries (In Transit, Pending, Delivered, Cancelled, Returned)
				SELECT COUNT(p.id) AS 'Failed Orders' FROM Couriers co
				INNER JOIN PACKAGES p ON co.id = p.courier_id
				INNER JOIN TRACKING_EVENTS t ON p.id = t.package_id
				WHERE t.package_status = 'Cancelled' AND co.id = courierId
				) AS FailedDeliveries,
			(
			-- #5 Number of Unique Cities Delivered To
				SELECT COUNT(*) AS 'No. of Unique Cities Delivered to' FROM (
					SELECT DISTINCT c.city FROM Couriers co
					INNER JOIN PACKAGES p ON co.id = p.courier_id
					INNER JOIN DELIVERY_DETAILS d ON d.id = p.delivery_details_id
					INNER JOIN CUSTOMERS c on c.id = d.recipient_id 
					WHERE co.id = courierId
				) AS unique_cities
            ) AS CityCoverage
        ) AS METRICS;
END$$
DELIMITER ;

CALL GetCourierScorecard(1);

-- SHOW INDEX from tracking_events;



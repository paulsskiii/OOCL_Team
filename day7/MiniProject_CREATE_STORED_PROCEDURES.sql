SELECT 
    c.name AS city_name,
    COUNT(p.package_id) AS packages_delivered,
    (
        SELECT CONCAT(courier.first_name, ' ', courier.last_name)
        FROM Package p2
        INNER JOIN Courier courier ON p2.courier_id = courier.courier_id
        INNER JOIN Customer cust2 ON p2.recipient_id = cust2.customer_id
        INNER JOIN Address a2 ON cust2.address_id = a2.address_id
        WHERE a2.city_id = c.city_id 
        AND p2.delivery_date >= DATE_SUB(NOW(), INTERVAL 30 DAY)
        GROUP BY p2.courier_id, courier.first_name, courier.last_name
        ORDER BY COUNT(*) DESC
        LIMIT 1
    ) AS most_frequent_courier,
    ROUND(AVG(DATEDIFF(p.delivery_date, p.pickup_date)), 2) AS avg_delivery_time_days
FROM City c
INNER JOIN Address a ON c.city_id = a.city_id
INNER JOIN Customer cust ON a.address_id = cust.address_id
INNER JOIN Package p ON cust.customer_id = p.recipient_id
WHERE p.delivery_date >= DATE_SUB(NOW(), INTERVAL 30 DAY)
GROUP BY c.city_id, c.name
ORDER BY packages_delivered DESC, avg_delivery_time_days ASC; 
 
DELIMITER //
CREATE PROCEDURE GetCustomerDeliveryHistory (
    IN customer_id_input INTEGER
)
BEGIN
    DECLARE EXIT HANDLER FOR SQLEXCEPTION
    BEGIN
        SELECT 'An error occurred!' AS ErrorMessage;
    END;

    SELECT
		c.customer_id,
		CONCAT(c.first_name, ' ', c.last_name) AS customer_name,
		p.sender_id,
		p.recipient_id,
		p.package_id,
		p.pickup_date,
		p.delivery_date,
		ps.status_name,
		pt.classification_name,
		CONCAT(cr.first_name, ' ', cr.last_name) AS courier,
		(
			SELECT COUNT(p.package_id)
			FROM package p 
            JOIN customer c ON p.sender_id = c.customer_id
			WHERE c.customer_id = customer_id_input
		) AS total_sent_packages,
		(
			SELECT COUNT(p.package_id)
			FROM package p 
            JOIN customer c ON p.recipient_id = c.customer_id
			WHERE c.customer_id = customer_id_input
		) AS total_recieved_packages
	FROM customer c
	JOIN package p ON (p.sender_id = c.customer_id OR p.recipient_id = c.customer_id)
	JOIN courier cr ON p.courier_id = cr.courier_id
	JOIN packagetype pt ON p.package_type_id = pt.package_type_id
	JOIN trackingevent te ON p.package_id = te.package_id
	JOIN packagestatus ps ON te.package_status_id = ps.package_status_id
	WHERE c.customer_id = customer_id_input
	ORDER BY p.package_id;
END //
DELIMITER ;

CREATE DEFINER=`root`@`localhost` PROCEDURE `GetCourierScoreCard`(IN courier_id INTEGER)
BEGIN
 SELECT
    (SELECT CONCAT(a.first_name, ' ', a.last_name) FROM Courier a
    WHERE a.courier_id = courier_id ) AS courier_name,
    
 (SELECT COUNT(*) FROM Courier a
 INNER JOIN TrackingEvent b
 INNER JOIN Package c
 INNER JOIN PackageStatus d
 WHERE a.courier_id = c.courier_id
 AND b.package_id = c.package_id
 AND d.package_status_id = b.package_status_id
 AND d.status_name = 'DELIVERED'
 AND a.courier_id = courier_id) AS total_number_of_deliveries,

 (SELECT AVG(DATEDIFF(c.delivery_date, c.pickup_date)) FROM Courier a
 INNER JOIN TrackingEvent b
 INNER JOIN Package c
 INNER JOIN PackageStatus d
 WHERE a.courier_id = c.courier_id
 AND b.package_id = c.package_id
 AND d.package_status_id = b.package_status_id
 AND d.status_name = 'DELIVERED'
 AND a.courier_id = courier_id) AS average_delivery_time,

 (SELECT COUNT(*) FROM Courier a
 INNER JOIN TrackingEvent b
 INNER JOIN Package c
 INNER JOIN PackageStatus d
 WHERE a.courier_id = c.courier_id
 AND b.package_id = c.package_id
 AND d.package_status_id = b.package_status_id
 AND d.status_name = 'FAILED DELIVERY'
 AND a.courier_id = courier_id) AS number_of_failed_deliveries,

 (SELECT COUNT(DISTINCT(b.location_id)) FROM Courier a
 INNER JOIN TrackingEvent b
 INNER JOIN Package c
 INNER JOIN PackageStatus d
 WHERE a.courier_id = c.courier_id
 AND b.package_id = c.package_id
 AND d.package_status_id = b.package_status_id
 AND d.status_name = 'DELIVERED'
 AND a.courier_id = courier_id) AS number_of_unique_city_deliveries,
    
    (SELECT ((total_number_of_deliveries * 2) - (number_of_failed_deliveries * 3) - average_delivery_time + number_of_unique_city_deliveries)) AS calculated_reliability_score;
END
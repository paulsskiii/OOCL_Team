CREATE DEFINER=`root`@`localhost` PROCEDURE `most_active_delivery_cities`()
BEGIN
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
END
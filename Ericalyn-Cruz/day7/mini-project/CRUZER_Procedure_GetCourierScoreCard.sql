DELIMITER $$
CREATE DEFINER=`root`@`localhost` PROCEDURE `GetCourierScorecard`(IN in_courier_id INT, 
OUT out_courier_fullname VARCHAR(60),
 OUT out_total_delivered INT,
    OUT out_failed_deliveries INT,
    OUT out_avg_delivery_time DECIMAL(5,2),
    OUT out_city_coverage INT,
    OUT out_reliability_score DECIMAL(10,2))
BEGIN
    SELECT 
		-- 	get fullname 
		CONCAT(c.first_name, ' ', c.last_name) AS courier_fullname,
        -- Total Delivered
        SUM(CASE WHEN e.package_status = 'Delivered' THEN 1 ELSE 0 END) AS total_delivered,

        -- Failed Deliveries
        SUM(CASE WHEN e.package_status IN ('Failed', 'Returned') THEN 1 ELSE 0 END) AS failed_deliveries,

        -- Average Delivery Time
        ROUND(AVG(TIMESTAMPDIFF(DAY, t.pickup_date, t.delivery_date)), 2) AS avg_delivery_time,

        -- City Coverage
        COUNT(DISTINCT CASE WHEN e.package_status = 'Delivered' THEN l.city END) AS city_coverage,

        -- Reliability Score
        (
            (SUM(CASE WHEN e.package_status = 'Delivered' THEN 1 ELSE 0 END) * 2)
            - (SUM(CASE WHEN e.package_status IN ('Failed', 'Returned') THEN 1 ELSE 0 END) * 3)
            - ROUND(AVG(TIMESTAMPDIFF(DAY, t.pickup_date, t.delivery_date)), 2)
            + COUNT(DISTINCT CASE WHEN e.package_status = 'Delivered' THEN l.city END)
        ) AS reliability_score
        
  INTO 
		out_courier_fullname,
        out_total_delivered,
        out_failed_deliveries,
        out_avg_delivery_time,
        out_city_coverage,
        out_reliability_score
    FROM Courier c
    JOIN Transactions t 
        ON c.courier_id = t.courier_id
    JOIN Package p 
        ON t.package_id = p.package_id
    JOIN TrackingEvent e 
        ON e.package_id = t.package_id
    JOIN Location l
        ON t.destination = l.location_id
    WHERE c.courier_id = in_courier_id
    GROUP BY courier_fullname;
END$$
DELIMITER ;

-- SELECT CONCAT(s.first_name, ' ', s.last_name) AS 'Customer Name', p.contents_description FROM PACKAGES p
-- INNER JOIN DELIVERY_DETAILS d ON d.id = p.delivery_details_id
-- INNER JOIN CUSTOMERS s ON d.recipient_id = s.id
-- WHERE d.recipient_id = 1;

-- #3
CALL get_packages_of_recipient(80);

-- SELECT t.package_status, p.delivery_date FROM tracking_events t
-- 		INNER JOIN packages p ON p.id = t.package_id;
        


-- #4
CALL update_dates('2025-01-13 10:00:00');

SELECT t.package_status, p.delivery_date FROM tracking_events t
		INNER JOIN packages p ON p.id = t.package_id
        WHERE t.package_status = 'Delivered';
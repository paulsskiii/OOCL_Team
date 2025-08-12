-- 1
SELECT CONCAT(a.first_name, " ", a.last_name) AS name, c.name as city from customer a
INNER JOIN Address b
INNER JOIN City c
WHERE a.address_id = b.address_id
AND b.city_id = c.city_id
AND c.name LIKE '%z%';

-- 2
SELECT * FROM PACKAGE 
WHERE MONTH(pickup_date) 
BETWEEN 1 AND 8 
ORDER BY pickup_date DESC;

-- 3 
SELECT packagetype.classification_name AS package_type, MAX(weight) AS heaviest_package 
FROM package INNER JOIN packagetype 
ON package.package_type_id = packagetype.package_type_id 
GROUP BY packagetype.classification_name;

-- 4 
SELECT p.package_id, p.pickup_date, p.delivery_date, p.package_type_id, p.weight, p.contents_description, p.sender_id, p.recipient_id, 
c.customer_id, c.first_name, c.last_name, c.email_address FROM package p 
INNER JOIN customer c
ON p.recipient_id = c.customer_id
WHERE YEAR(p.pickup_date) = YEAR(NOW()) AND c.email_address LIKE '%@gmail.com'
ORDER BY pickup_date DESC;

-- 5
SELECT * FROM Customer a
INNER JOIN Package b
INNER JOIN TrackingEvent c
INNER JOIN PackageStatus d
WHERE a.customer_id = b.recipient_id
AND b.package_id = c.package_id
AND c.package_status_id = d.package_status_id
AND d.package_status_id = 9;

-- Exercise 1.1
SELECT 	p.package_id, 
		CONCAT(sender.first_name, " ", sender.last_name ) AS Sender, 
        CONCAT(recipient.first_name, " ", recipient.last_name ) AS Recipient,
        CONCAT(courier.first_name, " ", courier.last_name ) AS Courier,
        courier.vehicle_type
FROM package p 
INNER JOIN customer sender ON p.sender_id = sender.customer_id
INNER JOIN customer recipient ON p.recipient_id = recipient.customer_id
JOIN courier courier ON p.courier_id = courier.courier_id;

SELECT c.customer_id, CONCAT(c.first_name, " ", c.last_name ) AS Customer
FROM customer c 
LEFT JOIN package p ON c.customer_id = p.sender_id
WHERE p.sender_id IS NULL;
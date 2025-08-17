-- Retrieve the first name and last name of customers who live in a city that contains the letter “z” (case-insensitive)
----------------------------------------------------------------------
SELECT first_name as "First Name", last_name as "Last Name", city
FROM customers
WHERE city LIKE '%z%';
 
-- Display all details from the package table for packages with a pickup date between January and August (any year)
----------------------------------------------------------------------
SELECT *
FROM packages
WHERE MONTH(pickup_date) BETWEEN 1 AND 8;
 
-- Find the heaviest package (weight) for each package_type
----------------------------------------------------------------------
SELECT package_type as "Package Type", MAX(weight) AS "Heaviest Weight"
FROM packages
GROUP BY package_type
ORDER BY MAX(weight) DESC;
 
-- Find all packages picked up in the most recent year, but only by customers with a Gmail address
 ----------------------------------------------------------------------
SELECT p.*, c.email_address
FROM packages p
JOIN delivery_details d ON p.delivery_details_id = d.id
JOIN customers c ON d.sender_id = c.id
WHERE YEAR(p.pickup_date) = (
    SELECT MAX(YEAR(pickup_date)) FROM packages
)
AND c.email_address LIKE '%@gmail.com'
ORDER BY p.pickup_date DESC;

-- List the full name of all customers who have sent AND received at least one package
 ----------------------------------------------------------------------
SELECT DISTINCT CONCAT(c.first_name, ' ', c.last_name) AS "Full Name", COUNT(p.id) AS "Packaged Received"
FROM customers c 
JOIN delivery_details d ON c.id = d.recipient_id
JOIN packages p ON d.id = p.delivery_details_id
JOIN tracking_events t ON p.id = t.package_id
WHERE c.id IN (
    SELECT sender_id FROM delivery_details
)
AND c.id IN (
    SELECT recipient_id FROM delivery_details
)
AND t.package_status = 'Delivered'
GROUP BY p.delivery_details_id;

select distinct package_status from tracking_events;

--------------------------------------
-- MINIPROJECT EXERCISES
----------------------------------------------------------------------
-- CREATE EPROCEDURE : get the most active delivery cities in th epast 30 days.
----------------------------------------------------------------------
USE `group3_miniproject`;
DROP procedure IF EXISTS `getMostActiveDeliveryCities`;

DELIMITER $$
USE `group3_miniproject`$$
CREATE PROCEDURE getMostActiveDeliveryCities()
BEGIN
    SELECT custout.city AS "Active Delivery Cities",
	COUNT(pout.id) AS "No. of Packages Delivered",
    (	SELECT CONCAT(courin.first_name, ' ', courin.last_name)
		FROM COURIERS courin
		INNER JOIN PACKAGES pin ON courin.id = pin.courier_id
		INNER JOIN DELIVERY_DETAILS din ON pin.delivery_details_id = din.id
		INNER JOIN CUSTOMERS custin ON din.recipient_id = custin.id
		WHERE custin.city = custout.city
		AND pin.delivery_date >= CURDATE() - INTERVAL 30 DAY
		GROUP BY courin.id
		ORDER BY COUNT(pin.id) DESC
		LIMIT 1
	) AS "Most Frequent Courier",
	ROUND(AVG(DATEDIFF(pout.delivery_date, pout.pickup_date)), 2) AS "Average Delivery Day/s"
	FROM PACKAGES pout
	INNER JOIN DELIVERY_DETAILS dout ON pout.delivery_details_id = dout.id
	INNER JOIN CUSTOMERS custout ON dout.recipient_id = custout.id
	WHERE pout.delivery_date >= CURDATE() - INTERVAL 30 DAY
	GROUP BY custout.city
	ORDER BY COUNT(pout.id) DESC;
END$$

DELIMITER ;

CALL getMostActiveDeliveryCities();


----------------------------------------------------------------------
-- CREATE STORED PROCEDURE : get the customer's entire delivery history.
----------------------------------------------------------------------

SELECT
	CONCAT(c.first_name, ' ', c.last_name) AS "full name",
	COUNT(CASE WHEN dd.sender_id = 1 THEN 1 END)
		OVER () AS "total sent",
	COUNT(CASE WHEN dd.recipient_id = 1 THEN 1 END)
		OVER () AS "total received",
	p.id AS package_id, p.delivery_date, p.package_type,
        COALESCE(te.package_status, 'Delivered') AS "package status",
        COALESCE(CONCAT(cr.first_name, ' ', cr.last_name), 'No Courier Assigned') AS "courier name"
    FROM customers c
    INNER JOIN delivery_details dd ON c.id = dd.sender_id OR c.id = dd.recipient_id
    INNER JOIN packages p ON dd.id = p.delivery_details_id
    LEFT JOIN couriers cr ON p.courier_id = cr.id
    LEFT JOIN tracking_events te ON p.id = te.package_id
	WHERE c.id = 1
    ORDER BY p.delivery_date DESC;

---------------------------------

WITH SENDER AS (
SELECT COUNT(*) AS SENT
FROM CUSTOMERS A
INNER JOIN DELIVERY_DETAILS B ON A.ID = B.SENDER_ID
INNER JOIN PACKAGES C ON B.ID = C.DELIVERY_DETAILS_ID
INNER JOIN TRACKING_EVENTS D ON C.ID = D.PACKAGE_ID
WHERE D.PACKAGE_STATUS = 'DELIVERED'
AND A.ID = CUSTOMER_ID
),
RECEIVER AS (
SELECT COUNT(*) AS RECEIVED
FROM CUSTOMERS A 
INNER JOIN DELIVERY_DETAILS B ON A.ID = B.RECIPIENT_ID
INNER JOIN PACKAGES C ON B.ID = C.DELIVERY_DETAILS_ID
INNER JOIN TRACKING_EVENTS D ON C.ID = D.PACKAGE_ID
WHERE D.PACKAGE_STATUS = 'DELIVERED'
AND A.ID = CUSTOMER_ID
),
CUSTOMER_NAME AS(
SELECT CONCAT(FIRST_NAME, ' ',LAST_NAME) AS FULL_NAME
FROM CUSTOMERS
WHERE ID = CUSTOMER_ID
)
SELECT C.FULL_NAME, A.SENT, B.RECEIVED
FROM SENDER A, RECEIVER B, CUSTOMER_NAME C;
 
SELECT C.ID, C.DELIVERY_DATE, C.PACKAGE_TYPE, D.PACKAGE_STATUS, CONCAT(E.FIRST_NAME, ' ',E.LAST_NAME)
FROM CUSTOMERS A
INNER JOIN DELIVERY_DETAILS B ON A.ID = B.RECIPIENT_ID
INNER JOIN PACKAGES C ON B.ID = C.DELIVERY_DETAILS_ID
INNER JOIN TRACKING_EVENTS D ON C.ID = D.PACKAGE_ID
INNER JOIN COURIERS E ON C.COURIER_ID = E.ID
WHERE A.ID = CUSTOMER_ID;

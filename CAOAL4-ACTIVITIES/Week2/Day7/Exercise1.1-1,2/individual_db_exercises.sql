----------------------------
-- EXCERCISE 1.1
----------------------------

-- List of all packages with sender and recipient full names, courier name, and vehicle type
--------------------------------------------------------------------------------------------

SELECT p.contents_description AS "Package Description", CONCAT(cs.first_name,' ',cs.last_name) AS "Sender's Fullname",
		CONCAT(cr.first_name,' ',cr.last_name) AS "Recepient's Fullname",
		CONCAT(courier.first_name,' ',courier.last_name) AS "Courier's Fullname",
        courier.vehicle_type
FROM couriers courier
JOIN packages p ON courier.id = p.courier_id
JOIN delivery_details d ON p.delivery_details_id = d.id
JOIN customers cs ON d.sender_id = cs.id
JOIN customers cr ON d.recipient_id = cr.id 
;


-- Find customers who have never sent a package
-------------------------------------------------

SELECT CONCAT(c.first_name,' ',c.last_name) AS "Customers with no sending records"
FROM CUSTOMERS c
LEFT OUTER JOIN DELIVERY_DETAILS d ON d.sender_id = c.id
WHERE d.sender_id IS NULL;

-- using recursive CTE
-- simulate delivery chain (e.g. tracking events per package, ordered)
--------------------------------------------------------------------------
USE group3_miniproject;

WITH RECURSIVE delivery_chain AS (
    -- Anchor: start with the first event (no previous_event_id)
    SELECT 
        t.id,
        t.package_id,
        t.package_status,
        t.created_at,
        t.previous_event_id,
        1 AS step_no
    FROM tracking_events t
    WHERE t.previous_event_id IS NULL
      AND t.package_id = 1   
    UNION ALL
    -- Recursive part: get next events linked by previous_event_id
    SELECT 
        te.id,
        te.package_id,
        te.package_status,
        te.created_at,
        te.previous_event_id,
        dc.step_no + 1
    FROM tracking_events te
    INNER JOIN delivery_chain dc 
        ON te.previous_event_id = dc.id
)
SELECT * FROM delivery_chain
ORDER BY step_no;


------------------------------------------------------------------------------
-- EXCERCISE 1.2
----------------------------
USE `group3_miniproject`;

-- CREATE INDEXES
-- Create index on the last_name coulm of the customer table.
--------------------------------------------------------------

-- DROP INDEX idx_customer_lastname ON CUSTOMERS;
CREATE INDEX idx_customer_lastname ON CUSTOMERS(last_name);

SHOW INDEX FROM CUSTOMERS;


-- EXECUTION PLAN
-- use EXPLAIN keyword before SELECT query on the package table.
--------------------------------------------------------------

EXPLAIN SELECT * FROM PACKAGES;


-- BASIC STORED PROCEDURE
-- Retrieves all packages for a given recipient.
-------------------------------------------------
DROP procedure IF EXISTS `GetAllPackagesByRecepient`;

DELIMITER $$
USE `group3_miniproject`$$
CREATE PROCEDURE GetAllPackagesByRecepient (IN recipient_id INT)
BEGIN
	SELECT p.contents_description AS "Package Description", d.recipient_id AS "Recepient's ID" FROM PACKAGES p
    JOIN DELIVERY_DETAILS d ON d.id = p.delivery_details_id
    WHERE d.recipient_id = recipient_id;
END$$
DELIMITER ;

CALL GetAllPackagesByRecepient (8);


-- STORED PROCEDURE with LOGIC and ERROR HANDLING
-- Stored procedure that updates delivery date of a package
-- only if it hasn't been delivered yet, with error handling
-------------------------------------------------
DELIMITER //
CREATE PROCEDURE `updatePackageDeliveryDate` (in packageId int)
BEGIN
	DECLARE CONTINUE HANDLER FOR SQLEXCEPTION
    BEGIN
		SELECT 'WRONG DATE FORMAT';
	END;
		UPDATE PACKAGES
        INNER JOIN TRACKING_EVENTS ON packages.id = tracking_events.package_id        
        SET delivery_date = CASE 
        WHEN tracking_events.package_status = 'Delivered' THEN now()
        ELSE packages.delivery_date
        END
        WHERE packages.id = packageId;
END
//
DELIMITER //

CALL updatePackageDeliveryDate(63);



-----------------------------------------------------------------------------------
-- Display each packageType along with the total number of products of that type:
-----------------------------------------------------------------------------------
use group3_miniproject;

SELECT package_type, COUNT(*) AS "No. of Packages" FROM PACKAGES
GROUP BY package_type
ORDER BY COUNT(*) desc;


-- Retrieve the first name and last name of customers who live in a city that contains the letter “k” (case-insensitive)
----------------------------------------------------------------------
-- USE caoal4_db;
SELECT firstName as "First Name", lastName as "Last Name", location
FROM customer
WHERE Location LIKE '%k%';


-- Display all details from the package table for packages with a pickup date between January and August (any year)
----------------------------------------------------------------------
use group3_miniproject;
SELECT * FROM delivery_details
WHERE MONTH(created_at) BETWEEN 1 AND 8;



-- Find highest-priced product in each productType from all Product table.
------------------------------------------------------------------------------
-- USE caoal4_db;
SELECT ProductCategory, MAX(ProductPrice) as "Highest Price" FROM PRODUCTS
GROUP BY ProductCategory;



-- Find all packages picked up in the most recent year, but only by customers with a Gmail address
 ----------------------------------------------------------------------
-- USE caoal4_db;
SELECT O.*, C.email from ORDERLIST O INNER JOIN CUSTOMER C
WHERE O.OrderID = C.CustomerID
AND C.email like '%@gmail.com'
ORDER BY O.OrderDate desc;












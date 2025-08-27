-- Retrieve the first name and last name of customers who live in a city that contains the letter “z” (case-insensitive)
USE GROUP3_MINIPROJECT;
SELECT first_name as "First Name", last_name as "Last Name", city
FROM customers
WHERE city LIKE '%z%';
-- Display all details from the package table for packages with a pickup date between January and August (any year)

SELECT *
FROM packages
WHERE MONTH(pickup_date) BETWEEN 1 AND 8;
-- Find the heaviest package (weight) for each package_type
SELECT package_type as "Package Type", MAX(weight) AS "Heaviest Weight"
FROM packages
GROUP BY package_type
ORDER BY MAX(weight) DESC;
-- Find all packages picked up in the most recent year, but only by customers with a Gmail address
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
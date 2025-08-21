SELECT * FROM package;
SELECT * FROM customer;
SELECT * FROM courier;

SELECT package_id, 
CONCAT(first_name, " ", last_name ) AS full_Name, 
CONCAT(courier.first_name, " ", courier.last_name ) AS courier_name, 
courier.vehicle_type 
FROM package
LEFT JOIN customer ON package.recipient_id = customer.customer_id;

SELECT * FROM package
LEFT JOIN customer
ON package.sender_id = customer.customer_id
WHERE sender_id IS NULL;



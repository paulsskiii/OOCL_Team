-- ARELLMA EXERCISE 1.1
-- #1

SELECT 
	CONCAT(c.first_name, '  ', c.last_name) AS 'Sender', 
	CONCAT(r.first_name, ' ', r.last_name) AS 'Recepient', 
	p.contents_description AS 'Package Description', p.weight, 
	co.vehicle_type FROM packages p
INNER JOIN DELIVERY_DETAILS d ON p.delivery_details_id = d.id
INNER JOIN CUSTOMERS c on d.sender_id = c.id
INNER JOIN CUSTOMERS r on d.recipient_id = r.id
INNER JOIN COURIERS co on p.courier_id = co.id;

-- #2
SELECT c.* FROM CUSTOMERS c
LEFT OUTER JOIN DELIVERY_DETAILS d ON d.sender_id = c.id
WHERE d.sender_id IS NULL;


-- #3


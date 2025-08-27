-- Custom Function
DELIMITER //

CREATE FUNCTION get_name(id int)
RETURNS VARCHAR(100)
DETERMINISTIC
BEGIN
	SET @firstName = (SELECT c.firstName FROM customer c WHERE c.id = id);
	SET @lastName = (SELECT c.lastName FROM customer c WHERE c.id = id);
	RETURN CONCAT(@firstName, ' ', @lastName);
END //

-- List all packages with sender and recepient, full names, courier name, and vehicle type
SELECT
	p.contentsDescription as "Contents",
    pt.name as "Package Type",
    get_name(p.senderId) as "Sender",
    get_name(p.recepientId) as "Recepient"
FROM
    package p
LEFT JOIN
    packagetypes pt
ON
	p.packageTypesId = pt.id;
	
-- Find customers who have never sent a package
SELECT
	get_name(c.id) as "Customer"
FROM
	customer c
WHERE
	c.id NOT IN (
		SELECT
			p.senderId
		FROM 
			package p
	);
	
-- Use a recursive CTE to simulate a delivery chain (e.g., tracking events per package, ordered)

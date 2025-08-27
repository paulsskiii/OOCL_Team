-- NO.1
SELECT productType as 'Product Type', COUNT(*) as 'Product Count' 
FROM Products GROUP BY productType;
-- NO.2
SELECT firstName, lastName, city FROM Customers WHERE city LIKE '%a%' GROUP BY id;
-- NO.3
SELECT * FROM Orders WHERE MONTH(createdAt) BETWEEN '01' AND '08';

-- NO.4
SELECT productType, MAX(price) as 'Max Price' FROM products GROUP BY productType;
-- N0.5  
SELECT 
	co.orderID as "ORDER#",
	CONCAT(c.firstName, " ", c.lastName) AS "CUSTOMER NAME", 
	c.email AS "EMAIL", p.productName AS "PRODUCT NAME",  
	s.storeName AS "STORE NAME", 
	o.createdAt AS "DATE"
FROM orders o 
	INNER JOIN CustomerOrders co ON o.id = co.orderID 
	INNER JOIN customers c ON c.id = co.customerID 
	INNER JOIN products p ON p.id = o.productID
	INNER JOIN sellers s ON s.id = o.sellerID
WHERE YEAR(o.createdAt) = YEAR(NOW()) AND c.email LIKE "%@gmail.com"
ORDER BY o.id;


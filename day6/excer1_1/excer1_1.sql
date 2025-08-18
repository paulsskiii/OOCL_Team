SELECT productType, COUNT(productType) AS Total FROM products
WHERE productType = 'Type 1';

SELECT firstName, lastName, location FROM Customer
WHERE location LIKE '%a%';

SELECT * FROM products;

SELECT productType AS product_type,
	MAX(productPrice) AS highest_priced
FROM Products
GROUP BY productType;
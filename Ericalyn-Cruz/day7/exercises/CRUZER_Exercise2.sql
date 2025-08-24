-- Exercise 2
-- 1. display product type from product_tbl
SELECT COUNT(*) AS TOTAL_SCHOOL_SUPPLIES FROM Products_Tbl WHERE productType = 'School Supply';
SELECT COUNT(*) AS TOTAL_SCHOOL_SUPPLIES FROM Products_Tbl WHERE productType = 'Toys';

-- 2. firstname and lastname of customer that lives in city with letter A
SELECT firstName, lastName FROM Customer_tbl WHERE shipToAddress LIKE '%a%';

-- 3. diplay details from order placed between January and August regardless of the year
SELECT * FROM Order_Tbl WHERE MONTH(orderDate) BETWEEN 1 AND 8;

-- 4. find higherst-priced product in each product type
SELECT productType, MAX(productPrice) AS HighestPrice
FROM Products_Tbl
GROUP BY productType;

-- 5. find all orders placed recently and get only order with customer email ends with @gmail.com
SELECT o.OrderId, o.customerID, c.emailAddress
FROM Order_tbl o
LEFT JOIN  Customer_tbl c on o.customerId = c.customerId
WHERE o.orderDate = (SELECT MAX(orderDate) FROM Order_tbl) AND c.emailAddress LIKE '%@gmail.com';
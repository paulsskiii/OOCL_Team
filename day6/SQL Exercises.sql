-- Display each productType w/ total number of products of that type
SELECT
	PT.PRODUCT_TYPE_NAME AS "Product Type",
	COUNT(*) AS "Number of Products"
FROM
	PRODUCT_TYPE PT,
	PRODUCTS P
WHERE
	PT.PRODUCT_TYPE_ID = P.PRODUCT_TYPE_ID
GROUP BY
	PRODUCT_TYPE_NAME;

-- Retrieve firstName and lastName of customers who live in a city that contains the letter 'a'
SELECT
	CUSTOMER_NAME AS "Customer's Full Name"
FROM
	CUSTOMER
WHERE
	ADDRESS
LIKE
	LOWER("%A%");

-- Display all details from orders table for orders between jan and aug
SELECT
	ORDER_ID AS "Order ID",
    PRODUCT_ID AS "Product ID",
    ORDER_DATE AS "Date of Order",
    CUSTOMER_ID AS "Customer ID"
FROM 
	ORDER_DETAILS
WHERE
	MONTH(ORDER_DATE) BETWEEN 01 AND 08;
    
-- Find highest priced product in each product type
SELECT
	PRODUCT_TYPE_NAME AS "Product Type",
    MAX(P.PRODUCT_PRICE) AS "Most Expensive Price"
FROM
	PRODUCT_TYPE PT,
    PRODUCTS P
WHERE
	P.PRODUCT_TYPE_ID = PT.PRODUCT_TYPE_ID
GROUP BY
	PRODUCT_TYPE_NAME;

-- Find orders placed in most recent year available
SELECT
	OD.ORDER_ID AS "Order ID",
    OD.PRODUCT_ID AS "Product ID",
    OD.ORDER_DATE AS "Date of Order",
    OD.CUSTOMER_ID AS "Customer ID"
FROM
	ORDER_DETAILS OD
WHERE
	YEAR(ORDER_DATE) IN (
		SELECT
			MAX(YEAR(ORDER_DATE))
		FROM
			ORDER_DETAILS
    );

-- order details of customers with gmail
SELECT
	OD.ORDER_ID AS "Order ID",
    OD.PRODUCT_ID AS "Product ID",
    OD.ORDER_DATE AS "Date of Order",
    OD.CUSTOMER_ID AS "Customer ID"
FROM
	ORDER_DETAILS OD
WHERE
	CUSTOMER_ID IN (
		SELECT
			CUSTOMER_ID
		FROM
			CUSTOMER
		WHERE
			EMAIL_ADDRESS LIKE LOWER("%@GMAIL.COM")
    )
ORDER BY
	ORDER_DATE DESC;
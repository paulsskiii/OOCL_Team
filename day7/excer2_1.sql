-- 1. Display product types with the total no of products in that type
SELECT TYPE, COUNT(*) AS TOTAL_PRODUCTS
FROM PRODUCTS
GROUP BY TYPE;
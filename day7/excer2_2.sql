-- Customers with city name containing letter 'A'
SELECT c.FNAME, c.LNAME, city.CITY_NAME
FROM CUSTOMERS c,
     CITY city
WHERE c.CITY_ID = city.CITY_ID
  AND city.CITY_NAME LIKE '%a%';
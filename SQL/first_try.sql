select * from city;
select * from country;
select * from customers;
select * from products;
select * from orders;

show indexes from country;
show columns from ORDERS;

alter table country 
	add constraint unique(country_name);
alter table orders 
	modify column order_id int not null auto_increment;
alter table transactions
	drop constraint transactions_ibfk_1;
    
delete from orders where order_id = null;


INSERT INTO ORDERS (STATUS, TOTAL, TRANSACTION_ID, ORDER_PLACED, ORDER_RECEIVED)
VALUES 
    ('Cancelled', 100, 4, CONVERT('2022-09-1 15:53:36', DATETIME), null)
;

insert into country 
values 
	-- ('Russia'), ('Spain'), ('England'), ('Philippines'), 
	('China'), ('USA');

insert into city (city_name, country)
values 
-- ('Pasay City', 'Philippines'),
	('Shenzhen', 'China'),
    ('Alabama', 'USA');

INSERT INTO CUSTOMERS (FNAME, LNAME, USERNAME, EMAIL_ADDR, ADDR)
VALUES 
	('Jane', 'Doe', 'user001', 'my_email@gmail.com', '123 Somewhere street, Alabama, USA'),
    ('Juan', 'Dela Cruz', 'user002', 'whats_this@yahoo.com', '1 Sa Tabi Lang, Pasay City, Philippines'),
    ('Camy', 'Pritchet', 'bingchiling', 'is_this_allowed@gmail.com', '69 Wanshanghao, Shenzhen, China')
;

ALTER TABLE CUSTOMERS
	ADD COLUMN CITY_ID INT NOT NULL;

UPDATE CUSTOMERS 
SET CITY_ID = 3
WHERE CUSTOMER_ID = 1;

-- 1. Display product types with the total no of products in that type
SELECT TYPE, COUNT(*) AS TOTAL_PRODUCTS
FROM PRODUCTS
GROUP BY TYPE;

-- 2. Customers with city name containing letter 'A'
SELECT c.FNAME, c.LNAME, city.CITY_NAME
FROM CUSTOMERS c, CITY city
WHERE c.CITY_ID = city.CITY_ID
AND city.CITY_NAME LIKE '%a%';

-- 3.
SELECT * 
FROM ORDERS
WHERE MONTH(ORDER_PLACED) BETWEEN 1 AND 8;
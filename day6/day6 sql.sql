CREATE DATABASE ordering_system;
 
Use ordering_system;
DROP TABLE ordering_system;
SHOW TABLES;
DROP TABLE order_table;
DROP TABLE Seller;
DROP TABLE Product;
DROP TABLE Customer;
 
CREATE TABLE order_table (
	id int NOT NULL PRIMARY KEY AUTO_INCREMENT UNIQUE,
    customer_id int,
    seller_id int,
    product_id int,
    orderDate DATETIME DEFAULT now(),
	FOREIGN KEY (customer_id) REFERENCES Customer(id),
    FOREIGN KEY (seller_id) REFERENCES Seller(id),
    FOREIGN KEY (product_id) REFERENCES Product(id)
);
 
CREATE TABLE Customer (
	id int NOT NULL PRIMARY KEY AUTO_INCREMENT UNIQUE,
    fname VARCHAR(32),
    lname VARCHAR(32),
    email VARCHAR(64),
    gender VARCHAR(32),
    city VARCHAR(32)
);
 
CREATE TABLE Seller (
	id int NOT NULL PRIMARY KEY AUTO_INCREMENT UNIQUE,
    fname VARCHAR(32),
    lname VARCHAR(32)
);
 
CREATE TABLE Product (
	id int NOT NULL PRIMARY KEY AUTO_INCREMENT UNIQUE,
    product_name VARCHAR(64),
    price FLOAT(5)
);
 

INSERT INTO Seller (fname, lname) VALUES ('cess', 'fer');
INSERT INTO Seller (fname, lname) VALUES ('Pedru', 'Tami');
INSERT INTO Seller (fname, lname) VALUES ('Domhnaill', 'Jean');
INSERT INTO Seller (fname, lname) VALUES ('Nathan', 'Salamatu');
INSERT INTO Seller (fname, lname) VALUES ('Pemphero', 'Þórarinn');
INSERT INTO Seller (fname, lname) VALUES ('Alcestis', 'Raffaela');
INSERT INTO Seller (fname, lname) VALUES ('Denise', 'Noemi');
INSERT INTO Seller (fname, lname) VALUES ('Luse', 'Emem');
INSERT INTO Seller (fname, lname) VALUES ('Imam', 'Tomine');
INSERT INTO Seller (fname, lname) VALUES ('Burhan', 'Saturninus');
 
select * from seller;
 
 

INSERT INTO product (product_name, price) 
VALUES ('samsung', 1234),
('iphone', 1234),
('nokia', 1435),
('tecno', 3456),
('sharp', 3443),
('sonim', 6557),
('xiaomi', 1456),
('acer', 156),
('lg', 1534),
('panasonic', 345),
('realme', 1567),
('sony', 1569),
('tcl', 9867);
 
TRUNCATE TABLE product;
select * from product;
 
 

INSERT INTO customer (fname, lname, email, gender, city) 
VALUES ('customer1', 'last1', 'customer1@gmail.com', 'male', 'manila'),
('customer2', 'last2', 'customer2@gmail.com', 'male', 'cebu'),
('customer3', 'last3', 'customer3@gmail.com', 'female', 'bicol'),
('customer4', 'last4', 'customer4@gmail.com', 'female', 'qc'),
('customer5', 'last5', 'customer5@gmail.com', 'male', 'caloocan'),
('customer6', 'last6', 'customer6@gmail.com', 'male', 'navotas'),
('customer7', 'last7', 'customer7@gmail.com', 'female', 'valenzuela'),
('customer8', 'last8', 'customer8@gmail.com', 'male', 'makati'),
('customer9', 'last9', 'customer9@gmail.com', 'male', 'manila'),
('customer10', 'last10', 'customer10@gmail.com', 'male', 'manila');
 
select * from customer;
 

INSERT INTO ORDER_TABLE (customer_id, seller_id, product_id, orderDate) 
VALUES (1, 1, 1, '2025-08-01'),
(1, 2, 2, '2025-07-01'),
(3, 2, 1, '2025-09-01'),
(2, 1, 1, '2025-10-01'),
(5, 1, 1, '2025-04-01'),
(4, 1, 1, '2025-03-01'),
(3, 1, 1, '2025-05-07'),
(2, 1, 1, '2025-08-12'),
(8, 1, 1, '2024-07-01'),
(9, 1, 1, '2024-02-01');
TRUNCATE TABLE order_table;
select * from order_table;
 
 
 

SELECT DISTINCT(product_name), price FROM product;
 
SELECT fname, lname from customer where city LIKE '%a%';
 
SELECT * FROM order_table WHERE orderDate BETWEEN '2025-01-01' AND '2025-08-01';
 
SELECT MAX(price) FROM product ORDER BY price DESC;
 
SELECT * FROM order_table WHERE customer_id in (SELECT id FROM customer where email like '%gmail.com') AND orderDate > '2025-01-01';
 
 
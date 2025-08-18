
CREATE TABLE LOGIN(
	userID INT PRIMARY KEY UNIQUE AUTO_INCREMENT,
    username VARCHAR(50) UNIQUE NOT NULL,
    password VARCHAR(50) BINARY,
    lastLogin DATETIME
);

ALTER TABLE LOGIN
MODIFY COLUMN password VARCHAR(50);

DESC LOGIN;

CREATE TABLE CUSTOMERS(
	customerID INT(6) PRIMARY KEY AUTO_INCREMENT NOT NULL,
    firstName VARCHAR(50),
    lastName VARCHAR(50),
    email VARCHAR(50) UNIQUE NOT NULL,
    phoneNumber VARCHAR(20),
    username VARCHAR(50) UNIQUE NOT NULL,
    FOREIGN KEY (username) REFERENCES LOGIN(username)
);

DESC CUSTOMERS;

CREATE TABLE SELLERS(
	sellerID INT(6) PRIMARY KEY AUTO_INCREMENT NOT NULL,
    sellerName VARCHAR(50) UNIQUE,
    phoneNumber VARCHAR(20),
    companyName VARCHAR(50)
);

DESC SELLERS;

CREATE TABLE PRODUCTS(
	productID INT(6) PRIMARY KEY UNIQUE AUTO_INCREMENT NOT NULL,
    productName VARCHAR(50) UNIQUE,
    productPrice VARCHAR(20)
);

DESC PRODUCTS;

DROP TABLE CUSTOMER;
DROP TABLE SELLER;
DROP TABLE PRODUCTS;

CREATE TABLE ORDERS(
	orderID INT(6) PRIMARY KEY UNIQUE AUTO_INCREMENT NOT NULL,
    customerID INT(6) NOT NULL,
    sellerID INT(6) NOT NULL,
    createdAt DATETIME,
    updatedAt DATETIME,
    FOREIGN KEY (customerID) REFERENCES CUSTOMERS(customerID),
    FOREIGN KEY (sellerID) REFERENCES SELLERS(sellerID)
);

DESC ORDERS;

CREATE TABLE ORDER_REFERENCES(
	orderReferenceID INT(6) PRIMARY KEY UNIQUE AUTO_INCREMENT NOT NULL,
    orderID INT(6) NOT NULL,
    productID INT(6) NOT NULL,
    quantity INTEGER NOT NULL,
    FOREIGN KEY (orderID) REFERENCES ORDERS(orderID),
    FOREIGN KEY (productID) REFERENCES PRODUCTS(productID)
);

DESC ORDER_REFERENCES;


INSERT INTO CUSTOMER(firstName, lastName, email, phoneNumber, username)
VALUES ('','',);

INSERT INTO LOGIN(username, password)
VALUES 
('xiayizhou05','missapple'),
('mumeka32','yunosqueen'),
('velvalentine','princess'),
('astalavista','astapasta'),
('lishen','snow123'),
('konakuma','POGGERS'),
('renokami','dog325'),
('zhixuan','cantarella'),
('aku34','furina');

SELECT * FROM LOGIN;

DESC CUSTOMERS;

INSERT INTO CUSTOMERS(firstName, lastName, email, phoneNumber, username)
VALUES 
('Aki','Artemis','aartemis16@gmail.com','0956231465', 'aartemis16'),
('YiZhou','Xia','xiayizhou05@gmail.com','0956235625', 'xiayizhou05'),
('Mumu','Umeka','mumeka32@gmail.com','0936654625', 'mumeka32'),
('Velvet','Valentine','velvalentine@gmail.com','0956235625', 'velvalentine'),
('Asta','Von Pierce','astalavista@gmail.com','097777777', 'astalavista'),
('Shen','Li','lishen@gmail.com','0955535625', 'lishen'),
('Kon','Akuma','konakuma@gmail.com','0999999', 'konakuma'),
('Ren','Okami','renokami@gmail.com','0999999', 'renokami'),
('Zhi','Xuan','zhixuan@gmail.com','0999999', 'zhixuan'),
('Aku','Aku','aku34@gmail.com','0999999', 'aku34');

select * from customers;


desc sellers;
INSERT INTO SELLERS(sellerName, phoneNumber, companyName)
VALUES 
('Infold Games','7777777', 'Paper Games'),
('Mihoyo','666666', 'HoyoVerse'),
('Kuro Games','7777777', 'Paper Games');


INSERT INTO PRODUCTS(productName, productPrice)
VALUES 
('Merchandise', '500'),
('Voice Drama', '400'),
('Gems','1000'),
('Diamonds', '500'),
('T-shirt', '1400'),
('Ring','2500');
select * from products;

INSERT INTO ORDERS(customerID, sellerID, createdAt, updatedAt)
VALUES 
('1', '1',NOW(),NOW()),
('2', '2',NOW(),NOW()),
('3','1',NOW(),NOW()),
('4', '2',NOW(),NOW()),
('5', '3',NOW(),NOW()),
('6','1',NOW(),NOW()),
('7', '3',NOW(),NOW()),
('8', '3',NOW(),NOW()),
('9','3',NOW(),NOW()),
('10', '2',NOW(),NOW());

INSERT INTO ORDERS(customerID, sellerID, createdAt, updatedAt)
VALUES 
('1', '1','2025-01-11 15:22:00',NOW()),
('5', '2','2024-06-11 15:22:00',NOW()),
('6', '3','2024-07-11 15:22:00',NOW());

SELECT * FROM CUSTOMERS;
SELECT * FROM sellers;

select * from orders;
SELECT * FROM PRODUCTS;

SELECT * FROM ORDER_REFERENCES;
DESC ORDER_REFERENCES;


INSERT INTO ORDER_REFERENCES(orderID, productID, quantity)
VALUES 
('1', '6','5'),
('1', '3','5'),
('1', '1','5'),
('2', '2', '2'),
('3','1', '2'),
('4', '6','5'),
('4', '3','5'),
('6', '1','5'),
('7', '2', '2'),
('8','1', '2');

select * from customers;
select * from products;
select * from sellers;

INSERT INTO SELLERS(sellerName, phoneNumber, companyName)
VALUES 
('Matcha','87000', 'Jollibee'),
('Saki','888888', 'KFC'),
('Duke','999999', 'Mcdonalds');


ALTER TABLE CUSTOMERS
ADD city VARCHAR(50); 

UPDATE CUSTOMERS
SET city = 'Beijing'
WHERE customerID = '10';

SELECT * FROM CUSTOMERS;


ALTER TABLE PRODUCTS
ADD type VARCHAR(50);

SELECT * FROM PRODUCTS;
-- 1, 2  

UPDATE PRODUCTS
SET type = 'Item'
WHERE productID IN('7','8','9');








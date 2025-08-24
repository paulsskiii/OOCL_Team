CREATE DATABASE Online_Ordering_System;
USE Online_Ordering_System;
SHOW TABLES;
SHOW DATABASES;
SELECT * FROM Order_Tbl;
-- DROP TABLE Order_Tbl;

CREATE TABLE Customer_Tbl(
customerId int auto_increment NOT NULL primary key,
firstName varchar(25),
lastName varchar(25),
userName varchar(25),
userPassword varchar(25),
contactNum varchar(25),
emailAddress varchar(25),
shipToAddress varchar(100)
);

INSERT INTO Customer_Tbl(firstName, lastName, userName, userPassword, contactNum, emailAddress, shipToAddress)
VALUES ('Anica', 'Marina', 'anica_123', 'anica1234', '56461234', 'anicaa@gmail.com', 'Bolivia'),
		('Roma', 'Rome', 'rome_123', 'roma1234', '541234', 'roma@gmail.com', 'America'); 


CREATE TABLE Seller_Tbl(
sellerId int auto_increment NOT NULL  primary key,
firstName varchar(25),
lastName varchar(25),
userName varchar(25),
userPassword varchar(25),
contactNum varchar(25),
emailAddress varchar(25),
shipFromAddress varchar(100)
);

INSERT INTO Seller_Tbl(firstName, lastName, userName, userPassword, contactNum, emailAddress, shipFromAddress)
VALUES ('Ian', 'Casil', 'ian_123', 'ian1234', '12345', 'ian@gmail.com', 'Philippines'), 
		('Bong', 'Rapas', 'bong_123', 'bong5678', '56789', 'bong@gmail.com', 'Philippines');

CREATE TABLE Products_Tbl(
productId int auto_increment NOT NULL  primary key,
productName varchar(25),
productPrice float(10,2),
productQuantity int
);

ALTER TABLE Products_Tbl ADD productType varchar(25);


INSERT INTO Products_Tbl(productName, productPrice, productQuantity, productType)
VALUES ('Teddy Bear', '100.50', '10', 'Toy'), 
		('Doll', '50.5', '15', 'Toy');
        
UPDATE Products_Tbl SET productType = 'School Supply' WHERE productId = 2;


CREATE TABLE Order_Tbl(
OrderId int auto_increment NOT NULL  primary key,
customerId int,
sellerId  int,
orderDate datetime,
foreign key (customerId) references customer_tbl (customerId),
foreign key (sellerId) references seller_tbl (sellerId)
);


INSERT INTO Order_Tbl(customerId, sellerId, orderDate)
VALUES ('3', '1', '2025-09-11 14:30:00'), 
		('4', '2', '1952-01-11 14:30:00');



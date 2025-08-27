CREATE TABLE products (
	id INTEGER PRIMARY KEY UNIQUE AUTO_INCREMENT,
    productName VARCHAR(50) NOT NULL,
    price FLOAT(6,2) NOT NULL,
    createdAt DATETIME NOT NULL,
    updatedAt DATETIME NOT NULL
);
ALTER TABLE products 
MODIFY COLUMN price FLOAT
CREATE TABLE seller (
	id INTEGER PRIMARY KEY UNIQUE AUTO_INCREMENT,
    storeName VARCHAR(50) NOT NULL,
    email VARCHAR(50) NOT NULL UNIQUE,
    mobileNumber VARCHAR(11) NOT NULL UNIQUE,
    createdAt DATETIME NOT NULL,
    updatedAt DATETIME NOT NULL
);

CREATE TABLE ORDERS (
	id INTEGER PRIMARY KEY UNIQUE AUTO_INCREMENT NOT NULL,
	productID INTEGER NOT NULL,
    sellerID INTEGER NOT NULL,
    quantity INTEGER NOT NULL,
    createdAt DATETIME NOT NULL,
    updatedAt DATETIME NOT NULL,
    FOREIGN KEY (productID) REFERENCES Products(id),
    FOREIGN KEY (sellerID) REFERENCES Sellers(id)
);

CREATE TABLE CustomerOrders (
	id INTEGER PRIMARY KEY UNIQUE AUTO_INCREMENT NOT NULL,
	customerID INTEGER NOT NULL,
    orderID INTEGER NOT NULL,
    quantity INTEGER NOT NULL,
    createdAt DATETIME NOT NULL,
    updatedAt DATETIME NOT NULL,
    FOREIGN KEY (customerID) REFERENCES Customers(id),
    FOREIGN KEY (orderID) REFERENCES Orders(id)
);

ALTER TABLE SELLER
RENAME TO SELLERS;

INSERT INTO CUSTOMERS(firstName, lastName, email, mobileNumber, createdAt, updatedAt)
VALUES
( "Joseph",	"Cardo",	"josephcardocardo@gmail.com",	"09123122132", 
	"2025-08-11", "2025-08-11")
    
INSERT INTO PRODUCTS(productName, price, createdAt, updatedAt)
VALUES
("Pencil",	200.00, "2025-08-11", "2025-08-11"),
("Paper",	150.00, "2025-08-11", "2025-08-11"),
("Nintendo Switch",	10000.00, "2025-08-11", "2025-08-11"),
("iPhone",	30000.00, "2025-08-11", "2025-08-11"),
("Samsung Ultra", 30000.00, "2025-08-11", "2025-08-11"),
("Fried Chicken", 150.00, "2025-08-11", "2025-08-11"),
("Chicken Nuggets", 150.00, "2025-08-11", "2025-08-11"),
("Milo",	10.00, "2025-08-11", "2025-08-11"),
("Milk",	10.00, "2025-08-11", "2025-08-11"),
("Chicken Nuggets", 80.00, "2025-08-11", "2025-08-11")

INSERT INTO SELLERS(storeName, email, mobileNumber, createdAt, updatedAt)
VALUES
("Ministop",	"ministop@gmail.com",	"09473424233", "2025-08-11", "2025-08-11"),
("Uncle John's",	"unclejohns@gmail.com",	"09894503098", "2025-08-11", "2025-08-11"),
("Shopee",	"shopee@gmail.com",	"09145353453", "2025-08-11", "2025-08-11"),
("Lazada",	"lazada@gmail.com",	"09175889872", "2025-08-11", "2025-08-11"),
("MinuteBurger",	"minuteburger@gmail.com", "09176456356", "2025-08-11", "2025-08-11"),
("Abensons",	"abensons@gmail.com",	"09176456357", "2025-08-11", "2025-08-11"),
("Muji",	"muji@gmail.com",	"09176456358", "2025-08-11", "2025-08-11"),
("UNIQLO",	"uniqlo@gmail.com",	"09176456359", "2025-08-11", "2025-08-11"),
("TenderJuicy",	"tenderjuicy@gmail.com",	"09176456353", "2025-08-11", "2025-08-11"),
("DataBlitz",	"datablitz@gmail.com",	"09176456352", "2025-08-11", "2025-08-11")

INSERT INTO ORDERS(productID, sellerID, quantity, createdAt, updatedAt)
VALUES (12,	1,	2, "2025-08-11", "2025-08-11"),
(12,	5,	3, "2025-08-11", "2025-08-11"),
(13,	6,	1, "2025-08-11", "2025-08-11"),
(14,	9,	8, "2025-08-11", "2025-08-11"),
(18,	8,	7, "2025-08-11", "2025-08-11"),
(15,	7,	4, "2025-08-11", "2025-08-11"),
(20,	2,	5, "2025-08-11", "2025-08-11"),
(14,	3,	3, "2025-08-11", "2025-08-11"),
(12,	5,	2, "2025-08-11", "2025-08-11"),
(11,	4,	1, "2025-08-11", "2025-08-11")

ALTER TABLE CUSTOMERORDERS
DROP COLUMN QUANTITY

INSERT INTO CUSTOMERORDERS(customerID, orderID, createdAt, updatedAt)
VALUES
(3,	1, "2025-08-11", "2025-08-11"),
(1,	2, "2025-08-11", "2025-08-11"),
(2,	3, "2025-08-11", "2025-08-11"),
(4,	4, "2025-08-11", "2025-08-11"),
(5,	5, "2025-08-11", "2025-08-11"),
(7,	6, "2025-08-11", "2025-08-11"),
(5,	7, "2025-08-11", "2025-08-11"),
(8,	8, "2025-08-11", "2025-08-11"),
(10,	9, "2025-08-11", "2025-08-11"),
(9,	10, "2025-08-11", "2025-08-11")

TRUNCATE TABLE products;
TRUNCATE TABLE orders;

ALTER TABLE ORDERS
DROP FOREIGN KEY Products;



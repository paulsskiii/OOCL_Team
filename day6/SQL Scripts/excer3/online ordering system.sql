CREATE DATABASE online_ordering_avilavi;
USE online_ordering_avilavi;
DROP DATABASE online_ordering_avilavi;

CREATE TABLE users (id INTEGER NOT NULL UNIQUE AUTO_INCREMENT,
f_name VARCHAR (70) NOT NULL,
l_name VARCHAR (70) NOT NULL,
email VARCHAR (70) UNIQUE NOT NULL,
date_joined DATE DEFAULT (NOW()) NOT NULL,
city VARCHAR (70),
PRIMARY KEY (Id)
);

CREATE TABLE login (user_id INTEGER NOT NULL UNIQUE,
`username` VARCHAR (70) NOT NULL UNIQUE,
`password` VARCHAR (70) NOT NULL,
last_login DATETIME,
FOREIGN KEY (user_id) REFERENCES users (id)
);

CREATE TABLE sellers (id INTEGER AUTO_INCREMENT NOT NULL PRIMARY KEY UNIQUE,
`name` VARCHAR (100),
`description` VARCHAR (100)
);

CREATE TABLE product_types (id VARCHAR(3) NOT NULL UNIQUE PRIMARY KEY,
`type` VARCHAR (50) NOT NULL
);



CREATE TABLE products (id INTEGER AUTO_INCREMENT NOT NULL,
`name` VARCHAR (100),
`description` VARCHAR (100),
`price` FLOAT (6,2),
`type` VARCHAR(3) NOT NULL,
seller_id INTEGER,
PRIMARY KEY (id),
FOREIGN KEY (seller_id) REFERENCES sellers(id),
FOREIGN KEY (`type`) REFERENCES product_types(id)
);

CREATE TABLE orders (id INTEGER AUTO_INCREMENT NOT NULL PRIMARY KEY,
user_id INTEGER NOT NULL,
order_date DATETIME,
delivery_date DATETIME,
completed_date DATETIME,
total FLOAT (7,2),
FOREIGN KEY (user_id) REFERENCES users (id)
);

CREATE TABLE order_breakdown (breakdown_id INTEGER AUTO_INCREMENT NOT NULL PRIMARY KEY UNIQUE,
order_id INTEGER NOT NULL,
product_id INTEGER NOT NULL,
FOREIGN KEY (order_id) REFERENCES orders(id),
FOREIGN KEY (product_id) REFERENCES products(id)
);

CREATE TABLE seller_admins (admin_id INTEGER AUTO_INCREMENT NOT NULL PRIMARY KEY UNIQUE,
seller_id INTEGER NOT NULL,
user_id INTEGER NOT NULL,
FOREIGN KEY (seller_id) REFERENCES sellers(id),
FOREIGN KEY (user_id) REFERENCES users(id)
);

INSERT INTO users (f_name, l_name, email, date_joined, city) VALUES ("Andrew", "Fernandez", "and@gmail.com", NOW(), "Manila");
INSERT INTO users (f_name, l_name, email, date_joined, city) VALUES ("Sam", "Giovanni", "sam@gmail.com", "2025-08-01", "Quezon");
INSERT INTO users (f_name, l_name, email, date_joined, city) VALUES ("Fern", "Haha", "fer@gmail.com", "2025-08-02", "Mandaluyong");
INSERT INTO users (f_name, l_name, email, date_joined, city) VALUES ("Hands", "Kim", "han@oocl.com", NOW(), "Pasay");
INSERT INTO users (f_name, l_name, email, date_joined, city) VALUES ("Yrm", "Irm", "yrm@yahoo.com", NOW(), "Pasay");
INSERT INTO users (f_name, l_name, email, date_joined, city) VALUES ("Rommel", "Yes", "rom@gmail.com", "2025-08-04", "Rizal");
INSERT INTO users (f_name, l_name, email, date_joined, city) VALUES ("Ernest", "Ten", "ern@dlsu.edu.ph", "2025-07-21", "Quezon");
INSERT INTO users (f_name, l_name, email, date_joined, city) VALUES ("David", "Fernandez", "dav@gmail.com", NOW(), "Binondo");
INSERT INTO users (f_name, l_name, email, date_joined, city) VALUES ("Valentine", "Fernando", "val@oocl.com", "2025-05-01", "Tgyty");
INSERT INTO users (f_name, l_name, email, date_joined, city) VALUES ("Nano", "Giovanni", "nan@gmail.com", NOW(), "Manila");

SELECT * FROM users;

INSERT INTO login (user_id, `username`, `password`, last_login) VALUES (1, "Andrew", "123", NOW()),
(2, "Sam", "password", NOW()),
(3 ,"Fern", "password123", NOW()),
(4 ,"Hands", "PASSWORD", NOW()),
(5 ,"Yrm", "123PASSWORD", NOW()),
(6, "Rommel", "too short", NOW()),
(7, "Ernest", "secured", NOW()),
(8, "David", "password!", NOW()),
(9, "Valentine", "eksucaliba", NOW()),
(10, "Nano", "mike", NOW());


INSERT INTO sellers (`name`, `description`) VALUES ("Techno Hub", "Technology Hub"),
("Logitech", "Logical Technology"),
("Eelctro Hub", "Electronic Hub"),
("J*llibee", "J*llibee reseller"),
("Wcdo", "Wcdonalds"),
("JFC", "Jentucky Fried CHicken"),
("JM Keyboards", "JM Keyboards"),
("Crenshaw Ching", "Ching"),
("117", "SeveneLElen"),
("Dell", "Dell Technologies");

INSERT INTO product_types (id, `type`) VALUE ("PC", "Computer Peripheral"),
("GPC", "Gaming Computer Peripheral"),
("FD", "Food"),
("FRN", "Furniture"),
("DSP", "Display device"),
("LUG", "Luggage and Storage")
;

SELECT * FROM product_types;

INSERT INTO products (`name`, `description`, price, seller_id, `type`) VALUES ("SQL for Dummies", "Beginner SQL book for beginners, by beginner", 2340.5, 1, "PC"),
("Backpack", "Leather backpack", 3200, 9, "LUG"),
("Yum Burger", "Yum Burger from J*llibee ala carte", 35, 4, "FD"),
("Keyboard", "Standard Keyboard", 100, 1, "PC"),
("Mouse", "Standard Mouse", 80, 3, "PC"),
("Monitor", "Standard 21\" Monitor", 2570, 10, "DSP"),
("Mouse w/ RGB", "Mouse with improved performance by extra lights", 240, 2, "GPC"),
("Keyboard w/ RGB", "Keyboard with improved performance by extra lights", 300, 2, "GPC"),
("Desk", "Wooden desk: 170 x 70 x 50", 5100, 1, "FRN"),
("Happy Hotdog", "Relatively good hotdog with mustard", 50, 5, "FD");

SELECT * FROM products;

INSERT INTO orders (user_id, order_date, delivery_date, total) VALUES
(1, NOW(), "2025-08-12", 3200), (2, NOW(), "2025-08-15", 130), (2, "2025-08-05", NOW(), 2570), (4, "2025-08-03", "2025-08-11", 5100),
(6, "2025-08-01", "2025-08-01", 2375.5), (1, "2025-08-03", NOW(), 3200), (3, "2025-08-05", NOW(), 300), (10, "2025-08-02", "2025-08-11", 5100),
(8, "2025-07-30", "2025-08-02", 100), (4, "2025-08-04", NOW(), 80), (9, "2025-08-01", NOW(), 240), (10, "2025-08-03", "2025-08-11", 7670);

SELECT * FROM orders;

INSERT INTO order_breakdown (order_id, product_id) VALUES (2, 2), (3, 10), (3, 5), (4, 6), (5,10), (6, 1), (6, 3), (7, 2), (8, 9), (9, 10), (10, 4), (11, 10), (11, 5), (12, 7);

INSERT INTO seller_admins (seller_id, user_id) VALUES (1, 1), (2, 1), (5, 5), (6, 5), (7, 5), (8, 8), (9, 9), (1, 2), (8, 3), (2, 4), (4, 6), (7, 7), (1, 10);



SELECT product_types.`type` AS "Product Type", COUNT(products.id) AS "Number of Products"
FROM product_types, products
WHERE products.`type`=product_types.id
GROUP BY products.`type`;

SELECT users.f_name AS "First Name", users.l_name AS "Last Name", users.city AS "City"
FROM users
WHERE users.city LIKE "%a%";

SELECT * FROM orders
WHERE MONTH(orders.order_date) BETWEEN 01 AND 08;

SELECT product_types.`type` AS "Product Type", MAX(products.price) AS "Product Price"
FROM products INNER JOIN product_types
WHERE products.`type`=product_types.id
GROUP BY product_types.id
;

SELECT orders.*
FROM orders, users
WHERE YEAR(orders.order_date)=YEAR(NOW())
AND orders.user_id=users.id
AND users.email LIKE "%@gmail.com";









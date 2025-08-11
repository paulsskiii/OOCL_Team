CREATE DATABASE online_ordering_avilavi;
USE DATABASE online_ordering_avilavi;
DROP DATABASE online_ordering_avilavi;


CREATE TABLE login (user_id INTEGER AUTO_INCREMENT NOT NULL PRIMARY KEY UNIQUE,
user_name VARCHAR (70) NOT NULL UNIQUE,
user_password VARCHAR (70) NOT NULL,
last_login DATETIME
);

CREATE TABLE users (user_id INTEGER NOT NULL UNIQUE,
f_name VARCHAR (70),
l_name VARCHAR (70),
email VARCHAR (70) UNIQUE NOT NULL,
date_joined DATE,
PRIMARY KEY (user_id),
FOREIGN KEY (user_id) REFERENCES login (user_id)
);

CREATE TABLE sellers (seller_id INTEGER AUTO_INCREMENT NOT NULL PRIMARY KEY UNIQUE,
seller_name VARCHAR (100),
seller_description VARCHAR (100)
);

CREATE TABLE products (product_id INTEGER AUTO_INCREMENT NOT NULL,
product_name VARCHAR (100),
product_description VARCHAR (100),
product_price FLOAT (6,2),
seller_id INTEGER,
PRIMARY KEY (product_id),
FOREIGN KEY (seller_id) REFERENCES sellers(seller_id)
);

CREATE TABLE orders (order_id INTEGER AUTO_INCREMENT NOT NULL PRIMARY KEY,
user_id INTEGER NOT NULL,
order_date DATETIME,
order_delivery DATETIME,
order_completed DATETIME,
order_total FLOAT (7,2),
FOREIGN KEY (user_id) REFERENCES users (user_id)
);

CREATE TABLE order_breakdown (breakdown_id INTEGER AUTO_INCREMENT NOT NULL PRIMARY KEY UNIQUE,
order_id INTEGER NOT NULL,
product_id INTEGER NOT NULL,
FOREIGN KEY (order_id) REFERENCES orders(order_id),
FOREIGN KEY (product_id) REFERENCES products(product_id)
);

CREATE TABLE seller_admins (admin_id INTEGER AUTO_INCREMENT NOT NULL PRIMARY KEY UNIQUE,
seller_id INTEGER NOT NULL,
user_id INTEGER NOT NULL,
FOREIGN KEY (seller_id) REFERENCES sellers(seller_id),
FOREIGN KEY (user_id) REFERENCES users(user_id)
);

INSERT INTO login (user_name, user_password, last_login) VALUES ("Andrew", "123", NOW());
INSERT INTO login (user_name, user_password, last_login) VALUES ("Sam", "password", NOW());
INSERT INTO login (user_name, user_password, last_login) VALUES ("Fern", "password123", NOW());
INSERT INTO login (user_name, user_password, last_login) VALUES ("Hands", "PASSWORD", NOW());
INSERT INTO login (user_name, user_password, last_login) VALUES ("Yrm", "123PASSWORD", NOW());
INSERT INTO login (user_name, user_password, last_login) VALUES ("Rommel", "too short", NOW());
INSERT INTO login (user_name, user_password, last_login) VALUES ("Ernest", "secured", NOW());
INSERT INTO login (user_name, user_password, last_login) VALUES ("David", "password!", NOW());
INSERT INTO login (user_name, user_password, last_login) VALUES ("Valentine", "eksucaliba", NOW());
INSERT INTO login (user_name, user_password, last_login) VALUES ("Nano", "mike", NOW());

INSERT INTO users (user_id, f_name, l_name, email, date_joined) VALUES (1, "Andrew", "Fernandez", "and@gmail.com", NOW());
INSERT INTO users (user_id, f_name, l_name, email, date_joined) VALUES (2, "Sam", "Giovanni", "sam@gmail.com", "2025-08-01");
INSERT INTO users (user_id, f_name, l_name, email, date_joined) VALUES (3 ,"Fern", "Haha", "fer@gmail.com", "2025-08-02");
INSERT INTO users (user_id, f_name, l_name, email, date_joined) VALUES (4 ,"Hands", "Kim", "han@gmail.com", NOW());
INSERT INTO users (user_id, f_name, l_name, email, date_joined) VALUES (5 ,"Yrm", "Irm", "yrm@gmail.com", NOW());
INSERT INTO users (user_id, f_name, l_name, email, date_joined) VALUES (6, "Rommel", "Yes", "rom@gmail.com", "2025-08-04");
INSERT INTO users (user_id, f_name, l_name, email, date_joined) VALUES (7, "Ernest", "Ten", "ern@gmail.com", "2025-07-21");
INSERT INTO users (user_id, f_name, l_name, email, date_joined) VALUES (8, "David", "Fernandez", "dav@gmail.com", NOW());
INSERT INTO users (user_id, f_name, l_name, email, date_joined) VALUES (9, "Valentine", "Fernando", "val@gmail.com", "2025-05-01");
INSERT INTO users (user_id, f_name, l_name, email, date_joined) VALUES (10, "Nano", "Giovanni", "nan@gmail.com", NOW());

INSERT INTO sellers (seller_name, seller_description) VALUES ("Techno Hub", "Technology Hub");
INSERT INTO sellers (seller_name, seller_description) VALUES ("Logitech", "Logical Technology");
INSERT INTO sellers (seller_name, seller_description) VALUES ("Eelctro Hub", "Electronic Hub");
INSERT INTO sellers (seller_name, seller_description) VALUES ("J*llibee", "J*llibee reseller");
INSERT INTO sellers (seller_name, seller_description) VALUES ("Wcdo", "Wcdonalds");
INSERT INTO sellers (seller_name, seller_description) VALUES ("JFC", "Jentucky Fried CHicken");
INSERT INTO sellers (seller_name, seller_description) VALUES ("JM Keyboards", "JM Keyboards");
INSERT INTO sellers (seller_name) VALUES ("Crenshaw Ching");
INSERT INTO sellers (seller_name, seller_description) VALUES ("117", "SeveneLElen");
INSERT INTO sellers (seller_name, seller_description) VALUES ("Dell", "Dell Technologies");

INSERT INTO products (product_name, product_description, product_price, seller_id) VALUES ("SQL for Dummies", "Beginner SQL book for beginners, by beginner", 2340.5, 1);
INSERT INTO products (product_name, product_description, product_price, seller_id) VALUES ("Backpack", "Leather backpack", 3200, 9);
INSERT INTO products (product_name, product_description, product_price, seller_id) VALUES ("Yum Burger", "Yum Burger from J*llibee ala carte", 35, 4);
INSERT INTO products (product_name, product_description, product_price, seller_id) VALUES ("Keyboard", "Standard Keyboard", 100, 1);
INSERT INTO products (product_name, product_description, product_price, seller_id) VALUES ("Mouse", "Standard Mouse", 80, 3);
INSERT INTO products (product_name, product_description, product_price, seller_id) VALUES ("Monitor", "Standard 21\" Monitor", 2570, 10);
INSERT INTO products (product_name, product_description, product_price, seller_id) VALUES ("Mouse w/ RGB", "Mouse with improved performance by extra lights", 240, 2);
INSERT INTO products (product_name, product_description, product_price, seller_id) VALUES ("Keyboard w/ RGB", "Keyboard with improved performance by extra lights", 300, 2);
INSERT INTO products (product_name, product_description, product_price, seller_id) VALUES ("Desk", "Wooden desk: 170 x 70 x 50", 5100, 1);
INSERT INTO products (product_name, product_description, product_price, seller_id) VALUES ("Happy Hotdog", "Relatively good hotdog with mustard", 50, 5);

INSERT INTO orders (user_id, order_date, order_delivery, order_total) VALUES
(1, NOW(), "2025-08-12", 3200), (2, NOW(), "2025-08-15", 130), (2, "2025-08-05", NOW(), 2570), (4, "2025-08-03", "2025-08-11", 5100),
(6, "2025-08-01", "2025-08-01", 2375.5), (1, "2025-08-03", NOW(), 3200), (3, "2025-08-05", NOW(), 300), (10, "2025-08-02", "2025-08-11", 5100),
(8, "2025-07-30", "2025-08-02", 100), (4, "2025-08-04", NOW(), 80), (9, "2025-08-01", NOW(), 240), (10, "2025-08-03", "2025-08-11", 7670);

INSERT INTO order_breakdown (order_id, product_id) VALUES (2, 2), (3, 10), (3, 5), (4, 6), (5,10), (6, 1), (6, 3), (7, 2), (8, 9), (9, 10), (10, 4), (11, 10), (11, 5), (12, 7), (13, 10), (13, 6);

INSERT INTO seller_admins (seller_id, user_id) VALUES (1, 1), (2, 1), (5, 5), (6, 5), (7, 5), (8, 8), (9, 9), (1, 2), (8, 3), (2, 4), (4, 6), (7, 7), (1, 10);
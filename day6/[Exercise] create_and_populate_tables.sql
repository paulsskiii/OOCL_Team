-- Create the database
CREATE DATABASE IF NOT EXISTS `SHOPPING_TRANSACTION`;
USE `SHOPPING_TRANSACTION`;

CREATE TABLE `CUSTOMER` (
  `CUSTOMER_ID` INT NOT NULL AUTO_INCREMENT,
  `SURNAME` VARCHAR(50) NOT NULL,
  `FIRST_NAME` VARCHAR(80) NOT NULL,
  `EMAIL` VARCHAR(50) NOT NULL,
  `CONTACT_NO` VARCHAR(30) NULL,
  `ADDRESS` VARCHAR(300) NULL,
  PRIMARY KEY (`CUSTOMER_ID`)
);

-- Table for Sellers
CREATE TABLE `SELLER` (
  `SELLER_ID` INT NOT NULL AUTO_INCREMENT,
  `SURNAME` VARCHAR(50) NOT NULL,
  `FIRST_NAME` VARCHAR(80) NOT NULL,
  `EMAIL` VARCHAR(50) NOT NULL,
  `CONTACT_NO` VARCHAR(30) NULL,
  `ADDRESS` VARCHAR(300) NULL,
  PRIMARY KEY (`SELLER_ID`)
);

CREATE TABLE `PRODUCT` (
  `PRODUCT_ID` INT NOT NULL AUTO_INCREMENT,
  `PRODUCT_NAME` VARCHAR(50) NOT NULL,
  `PRICE` INT NOT NULL,
  `SELLER_ID` INT NULL,
  `DESCRIPTION` VARCHAR(50) NULL,
  PRIMARY KEY (`PRODUCT_ID`),
  FOREIGN KEY (`SELLER_ID`) REFERENCES `SELLER`(`SELLER_ID`) ON DELETE SET NULL
);

CREATE TABLE `ORDER` (
  `ORDERID` INT NOT NULL AUTO_INCREMENT,
  `MODE_OF_PAYMENT` VARCHAR(50) NOT NULL,
  `DATE_ORDERED` VARCHAR(80) NOT NULL,
  `STATUS` VARCHAR(80) NOT NULL,
  `CUSTOMER_ID` INT NULL,
  `ADDRESS` VARCHAR(300) NULL,
  PRIMARY KEY (`ORDERID`),
  FOREIGN KEY (`CUSTOMER_ID`) REFERENCES `CUSTOMER`(`CUSTOMER_ID`) ON DELETE SET NULL
);

CREATE TABLE `ORDER_ITEM` (
  `ORDER_ITEM_ID` INT NOT NULL AUTO_INCREMENT,
  `ORDER_ID` INT NULL,
  `PRODUCT_ID` INT NULL,
  `QUANTITY` INT NULL,
  PRIMARY KEY (`ORDER_ITEM_ID`),
  FOREIGN KEY (`ORDER_ID`) REFERENCES `ORDER`(`ORDERID`) ON DELETE SET NULL,
  FOREIGN KEY (`PRODUCT_ID`) REFERENCES `PRODUCT`(`PRODUCT_ID`) ON DELETE SET NULL
);

-- Insert data into CUSTOMER
INSERT INTO `CUSTOMER` (`SURNAME`, `FIRST_NAME`, `EMAIL`, `CONTACT_NO`, `ADDRESS`) VALUES
('Doe', 'John', 'john.doe@example.com', '123-456-7890', '123 Main St, Anytown'),
('Smith', 'Jane', 'jane.smith@example.com', '098-765-4321', '456 Oak Ave, Otherville');

-- Insert data into SELLER
INSERT INTO `SELLER` (`SURNAME`, `FIRST_NAME`, `EMAIL`, `CONTACT_NO`, `ADDRESS`) VALUES
('Jones', 'Bob', 'bob.jones@example.com', '555-111-2222', '789 Pine Ln, Sellersburg'),
('Williams', 'Sara', 'sara.williams@example.com', '555-333-4444', '101 Maple Rd, Vendor City');

-- Insert data into PRODUCT
INSERT INTO `PRODUCT` (`PRODUCT_NAME`, `PRICE`, `SELLER_ID`, `DESCRIPTION`) VALUES
('Laptop', 1200, 1, 'Powerful laptop for all needs'),
('Wireless Mouse', 25, 1, 'Ergonomic wireless mouse'),
('T-Shirt', 20, 2, '100% cotton t-shirt');

-- Insert data into ORDER
INSERT INTO `ORDER` (`MODE_OF_PAYMENT`, `DATE_ORDERED`, `STATUS`, `CUSTOMER_ID`, `ADDRESS`) VALUES
('Credit Card', '2023-10-27', 'Processing', 1, '123 Main St, Anytown'),
('PayPal', '2023-10-28', 'Shipped', 2, '456 Oak Ave, Otherville');

-- Insert data into ORDER_ITEM
INSERT INTO `ORDER_ITEM` (`ORDER_ID`, `PRODUCT_ID`, `QUANTITY`) VALUES
(1, 8, 1), 
(1, 7, 2), 
(2, 9, 3); 

-- CUSTOMER
INSERT INTO `CUSTOMER` (`SURNAME`, `FIRST_NAME`, `EMAIL`, `CONTACT_NO`, `ADDRESS`) VALUES
('Brown', 'Charlie', 'charlie.brown@example.com', '321-654-0987', '12 Elm St, Springfield'),
('Taylor', 'Emily', 'emily.taylor@example.com', '654-321-9870', '45 Birch Blvd, Rivertown'),
('Wilson', 'James', 'james.wilson@example.com', '777-888-9999', '78 Cedar Dr, Laketown'),
('Anderson', 'Olivia', 'olivia.anderson@example.com', '222-333-4444', '90 Willow Way, Hillcrest'),
('Thomas', 'Liam', 'liam.thomas@example.com', '999-888-7777', '102 Maple St, Meadowfield'),
('Martin', 'Sophia', 'sophia.martin@example.com', '111-222-3333', '145 Oak St, Forestville'),
('Lee', 'Ethan', 'ethan.lee@example.com', '444-555-6666', '67 Birch Rd, Brookside'),
('Harris', 'Ava', 'ava.harris@example.com', '555-444-3333', '89 Spruce Ln, Westlake'),
('Clark', 'Mason', 'mason.clark@example.com', '888-777-6666', '210 Pine St, Riverbend'),
('Lewis', 'Isabella', 'isabella.lewis@example.com', '666-555-4444', '305 Ash Ave, Eastpoint');

-- SELLER
INSERT INTO `SELLER` (`SURNAME`, `FIRST_NAME`, `EMAIL`, `CONTACT_NO`, `ADDRESS`) VALUES
('White', 'David', 'david.white@example.com', '123-999-8888', '14 Market St, Shopville'),
('Hall', 'Grace', 'grace.hall@example.com', '321-888-7777', '28 Commerce Rd, Trade City'),
('Young', 'Daniel', 'daniel.young@example.com', '555-000-1111', '32 Vendor Ave, Retail Park'),
('King', 'Ella', 'ella.king@example.com', '111-555-0000', '56 Sales St, Bargaintown'),
('Scott', 'Henry', 'henry.scott@example.com', '222-777-9999', '78 Trade Ln, Sellerton'),
('Green', 'Amelia', 'amelia.green@example.com', '999-444-5555', '89 Merchant Rd, Marketview'),
('Baker', 'Lucas', 'lucas.baker@example.com', '444-222-1111', '92 Vendor Blvd, Shop City'),
('Adams', 'Mia', 'mia.adams@example.com', '333-222-4444', '103 Outlet Rd, Fairtrade'),
('Nelson', 'Noah', 'noah.nelson@example.com', '777-333-5555', '115 Store Ave, Buyland'),
('Carter', 'Lily', 'lily.carter@example.com', '666-111-2222', '127 Retail Blvd, Sellpoint');

-- PRODUCT
INSERT INTO `PRODUCT` (`PRODUCT_NAME`, `PRICE`, `SELLER_ID`, `DESCRIPTION`) VALUES
('Smartphone', 800, 3, 'Latest model smartphone'),
('Headphones', 50, 3, 'Noise-cancelling over-ear headphones'),
('Desk Chair', 150, 4, 'Ergonomic office chair'),
('Backpack', 40, 4, 'Durable travel backpack'),
('Blender', 70, 5, 'High-speed kitchen blender'),
('Coffee Maker', 120, 5, 'Automatic drip coffee maker'),
('Gaming Keyboard', 90, 6, 'Mechanical RGB keyboard'),
('Sneakers', 60, 6, 'Comfortable running shoes'),
('Microwave Oven', 110, 7, 'Compact kitchen microwave'),
('Smartwatch', 200, 7, 'Fitness tracking smartwatch');

-- ORDER
INSERT INTO `ORDER` (`MODE_OF_PAYMENT`, `DATE_ORDERED`, `STATUS`, `CUSTOMER_ID`, `ADDRESS`) VALUES
('Credit Card', '2023-10-29', 'Delivered', 3, '12 Elm St, Springfield'),
('PayPal', '2023-10-30', 'Processing', 4, '45 Birch Blvd, Rivertown'),
('Cash on Delivery', '2023-10-31', 'Shipped', 5, '78 Cedar Dr, Laketown'),
('Credit Card', '2023-11-01', 'Delivered', 6, '90 Willow Way, Hillcrest'),
('PayPal', '2023-11-02', 'Processing', 7, '102 Maple St, Meadowfield'),
('Cash on Delivery', '2023-11-03', 'Shipped', 8, '145 Oak St, Forestville'),
('Credit Card', '2023-11-04', 'Delivered', 9, '67 Birch Rd, Brookside'),
('PayPal', '2023-11-05', 'Processing', 10, '89 Spruce Ln, Westlake'),
('Cash on Delivery', '2023-11-06', 'Shipped', 1, '210 Pine St, Riverbend'),
('Credit Card', '2023-11-07', 'Delivered', 2, '305 Ash Ave, Eastpoint');

-- ORDER_ITEM
INSERT INTO `ORDER_ITEM` (`ORDER_ID`, `PRODUCT_ID`, `QUANTITY`) VALUES
(3, 10, 1),
(3, 11, 2),
(4, 12, 1),
(4, 13, 3),
(5, 14, 1),
(5, 15, 2),
(6, 16, 1),
(6, 17, 2),
(7, 18, 1),
(7, 19, 1);
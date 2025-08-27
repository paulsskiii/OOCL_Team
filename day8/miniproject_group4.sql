CREATE SCHEMA `cargo_shipping_system`;

USE cargo_shipping_system;

-- DROP TABLE City;
-- DROP TABLE Address;
-- DROP TABLE Location;
-- DROP TABLE PackageStatus;
-- DROP TABLE PackageType;
-- DROP TABLE Courier;
-- DROP TABLE Customer;
-- DROP TABLE Package;
-- DROP TABLE TrackingEvent;

CREATE TABLE City (
 city_id INTEGER PRIMARY KEY AUTO_INCREMENT,
    name VARCHAR(50) NOT NULL
);

CREATE TABLE Address (
 address_id INTEGER PRIMARY KEY AUTO_INCREMENT,
    address_line1 VARCHAR(50),
    address_line2 VARCHAR(50),
    barangay VARCHAR(50),
    city_id INTEGER NOT NULL,
    postal_code INTEGER,
    region VARCHAR(50),
    country VARCHAR(50),
    FOREIGN KEY (city_id) REFERENCES City(city_id)
);

CREATE TABLE Location (
 location_id INTEGER PRIMARY KEY AUTO_INCREMENT,
    city_id INTEGER NOT NULL,
    contact_number VARCHAR(16),
    FOREIGN KEY (city_id) REFERENCES City(city_id)
);

CREATE TABLE PackageStatus (
 package_status_id INTEGER PRIMARY KEY AUTO_INCREMENT,
    status_name VARCHAR(50) NOT NULL
);

CREATE TABLE PackageType (
 package_type_id INTEGER PRIMARY KEY AUTO_INCREMENT,
    classification_name VARCHAR(50)
);

CREATE TABLE Courier (
 courier_id INTEGER PRIMARY KEY AUTO_INCREMENT,
    first_name VARCHAR(50),
    last_name VARCHAR(50),
    contact_number VARCHAR(16) UNIQUE,
    vehicle_type VARCHAR(32),
    license_number VARCHAR(64),
    created_at DATETIME DEFAULT NOW()
);

CREATE TABLE Customer (
 customer_id INTEGER PRIMARY KEY AUTO_INCREMENT,
    first_name VARCHAR(50),
    last_name VARCHAR(50),
    contact_number VARCHAR(16) UNIQUE,
    email_address VARCHAR(50) UNIQUE,
    address_id INTEGER NOT NULL,
    created_at DATETIME DEFAULT NOW(),
    updated_at DATETIME,
    FOREIGN KEY (address_id) REFERENCES Address(address_id)
);
SELECT * FROM ADDRESS;
CREATE TABLE Package (
 package_id INTEGER PRIMARY KEY AUTO_INCREMENT,
    pickup_date DATETIME, 
    delivery_date DATETIME,
    package_type_id INTEGER NOT NULL,
    weight FLOAT(5),
    contents_description VARCHAR(255),
    sender_id INTEGER NOT NULL, 
    recipient_id INTEGER NOT NULL,
    courier_id INTEGER NOT NULL,
    created_at DATETIME DEFAULT NOW(),
    FOREIGN KEY (package_type_id) REFERENCES PackageType(package_type_id),
    FOREIGN KEY (sender_id) REFERENCES Customer(customer_id),
    FOREIGN KEY (recipient_id) REFERENCES Customer(customer_id),
    FOREIGN KEY (courier_id) REFERENCES Courier(courier_id)
);

CREATE TABLE TrackingEvent (
 tracking_event_id INTEGER PRIMARY KEY AUTO_INCREMENT,
    description VARCHAR(255),
    package_status_id INTEGER NOT NULL,
    package_id INTEGER NOT NULL,
    location_id INTEGER NOT NULL,
    created_at DATETIME DEFAULT NOW(),
    updated_at DATETIME,
    FOREIGN KEY (package_status_id) REFERENCES PackageStatus(package_status_id),
    FOREIGN KEY (package_id) REFERENCES Package(package_id),
    FOREIGN KEY (location_id) REFERENCES Location(location_id)
);

-- MINI PROJECT EXERCISES
-- 1
SELECT CONCAT(a.first_name, " ", a.last_name) AS name, c.name as city from customer a
INNER JOIN Address b
INNER JOIN City c
WHERE a.address_id = b.address_id
AND b.city_id = c.city_id
AND c.name LIKE '%z%';

-- 2
SELECT * FROM PACKAGE 
WHERE MONTH(pickup_date) 
BETWEEN 1 AND 8 
ORDER BY pickup_date DESC;

-- 3 
SELECT packagetype.classification_name AS package_type, MAX(weight) AS heaviest_package 
FROM package INNER JOIN packagetype 
ON package.package_type_id = packagetype.package_type_id 
GROUP BY packagetype.classification_name;

-- 4 
SELECT p.package_id, p.pickup_date, p.delivery_date, p.package_type_id, p.weight, p.contents_description, p.sender_id, p.recipient_id, 
c.customer_id, c.first_name, c.last_name, c.email_address FROM package p 
INNER JOIN customer c
ON p.recipient_id = c.customer_id
WHERE YEAR(p.pickup_date) = YEAR(NOW()) AND c.email_address LIKE '%@gmail.com'
ORDER BY pickup_date DESC;

-- 5
SELECT CONCAT(a.first_name, " ", a.last_name) AS 'Full Name' FROM Customer a
INNER JOIN Package b
INNER JOIN TrackingEvent c
INNER JOIN PackageStatus d
WHERE a.customer_id = b.recipient_id
AND b.package_id = c.package_id
AND c.package_status_id = d.package_status_id
AND d.status_name = "DELIVERED";





-- EXERCISE 1.1 

SELECT CONCAT(s.first_name, ' ', s.last_name) AS SENDER, CONCAT(r.first_name, ' ', r.last_name) AS  RECIPIENT, s.vehicle_type, p.* FROM package p
JOIN courier s ON p.sender_id = s.courier_id
JOIN customer r ON p.recipient_id = r.customer_id;


-- 6
SELECT CONCAT(s.first_name, ' ', s.last_name) AS SENDER, CONCAT(r.first_name, ' ', r.last_name) AS  RECIPIENT, s.vehicle_type, p.* FROM package p
JOIN courier s ON p.sender_id = s.courier_id
JOIN customer r ON p.recipient_id = r.customer_id;

-- SELECT CONCAT(a.first_name, ' ', a.last_name) AS 'customer_full_name', CONCAT(c.first_name, ' ', c.last_name) AS 'courier_full_name', c.vehicle_type, b.* 
-- FROM Customer a
-- INNER JOIN Package b 
-- INNER JOIN Courier c
-- WHERE a.customer_id = b.recipient_id
-- AND b.sender_id = c.courier_id;

-- 7
SELECT DISTINCT(a.customer_id), CONCAT(a.first_name, ' ', a.last_name) AS 'customer_full_name' FROM Customer a
LEFT OUTER JOIN Package b
ON a.customer_id = b.sender_id;

-- 8
SELECT a.tracking_event_id, a.package_id, a.description, c.status_name, a.created_at 
FROM TrackingEvent a
INNER JOIN Package b
INNER JOIN PackageStatus c
WHERE a.package_id = b.package_id
AND a.package_status_id = c.package_status_id
AND a.package_id = 23
ORDER BY a.created_at ASC;


-------------------------------------------------------------------------------------------
-- EXERCISE 1.2 BASIC STORED PROCEDURE
SELECT * FROM package;
CALL new_procedure(34);

SELECT * FROM TRACKINGEVENT WHERE PACKAGE_STATUS_ID != 9;
SELECT * FROM packagestatus;

-- PACKAGE ID: 23 --> LOGIC AND ERROR HANDLING PART OF EX 1.2
CALL logic_procedure('2025-08-12', 1);

SELECT * FROM package where package_id = 23;

--------------------------------


-- Check if we have packages in the past 30 days
SELECT 
    COUNT(*) as total_packages,
    MIN(delivery_date) as earliest_delivery,
    MAX(delivery_date) as latest_delivery
FROM Package 
WHERE delivery_date >= DATE_SUB(NOW(), INTERVAL 30 DAY);

-- Check city and package relationships
SELECT 
    c.name as city_name,
    COUNT(p.package_id) as package_count
FROM City c
INNER JOIN Address a ON c.city_id = a.city_id
INNER JOIN Customer cust ON a.address_id = cust.address_id
INNER JOIN Package p ON cust.customer_id = p.recipient_id
GROUP BY c.city_id, c.name
ORDER BY package_count DESC
LIMIT 10;

CALL GetCustomerDeliveryHistory(1);
CALL most_active_delivery_cities();





	

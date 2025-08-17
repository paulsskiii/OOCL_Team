CREATE SCHEMA `cargo_shipping_system`;

USE cargo_shipping_system;

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
    postal_code VARCHAR(20),
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
    license_number VARCHAR(20),
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
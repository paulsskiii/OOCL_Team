CREATE DATABASE cargo_shipping_system;
USE cargo_shipping_system;

CREATE TABLE Couriers (
   courier_id INTEGER PRIMARY KEY UNIQUE AUTO_INCREMENT NOT NULL,
   first_name VARCHAR(30),
   last_name VARCHAR(30),
   contact_number VARCHAR(20),
   vehicle_type VARCHAR(30),
   license_number VARCHAR(30)
);

CREATE TABLE Locations (
    location_id INTEGER PRIMARY KEY UNIQUE AUTO_INCREMENT NOT NULL,
    barangay VARCHAR(50),
    city VARCHAR(50),
    postal_code VARCHAR(50),
    region VARCHAR(50),
    country VARCHAR(30),
    contact_number VARCHAR(30)
);

CREATE TABLE Customers (
    customer_id INTEGER PRIMARY KEY UNIQUE AUTO_INCREMENT NOT NULL,
    first_name VARCHAR(30),
    last_name VARCHAR(30),
    contact_number VARCHAR(30),
    email_address VARCHAR(50),
    address_line1 VARCHAR(300),
    address_line2 VARCHAR(300),
    location_id INTEGER,
    FOREIGN KEY (location_id) REFERENCES Locations(location_id)
);

CREATE TABLE Transactions (
    transaction_id INTEGER PRIMARY KEY UNIQUE AUTO_INCREMENT NOT NULL,
    sender_id INTEGER,
    recipient_id INTEGER,
    package_id INTEGER,
    origin INTEGER,
    destination INTEGER,
    courier_id INTEGER,
    pickup_date TIMESTAMP,
    delivery_date TIMESTAMP,
    FOREIGN KEY (sender_id) REFERENCES Customers(customer_id),
    FOREIGN KEY (recipient_id) REFERENCES Customers(customer_id),
    FOREIGN KEY (package_id) REFERENCES Packages(package_id),
    FOREIGN KEY (origin) REFERENCES Locations(location_id),
    FOREIGN KEY (destination) REFERENCES Locations(location_id),
    FOREIGN KEY (courier_id) REFERENCES Couriers(courier_id)
);

CREATE TABLE TrackingEvents (
    event_id INTEGER PRIMARY KEY UNIQUE AUTO_INCREMENT NOT NULL,
    description VARCHAR(300),
    package_status VARCHAR(50),
    package_id INTEGER,
    pick_up INTEGER,
    drop_off INTEGER,
    FOREIGN KEY (package_id) REFERENCES Packages(package_id),
    FOREIGN KEY (pick_up) REFERENCES Locations(location_id),
    FOREIGN KEY (drop_off) REFERENCES Locations(location_id)
);

CREATE TABLE Packages (
    package_id INTEGER PRIMARY KEY UNIQUE AUTO_INCREMENT NOT NULL,
    package_type VARCHAR(300),
    weight FLOAT,
    contents_description VARCHAR(300)
);

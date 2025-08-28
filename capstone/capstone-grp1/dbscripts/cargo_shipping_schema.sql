CREATE SCHEMA `cargo_shipping`;

USE cargo_shipping;

CREATE TABLE user (
 id INTEGER PRIMARY KEY AUTO_INCREMENT,
    first_name VARCHAR(50) NOT NULL,
    last_name VARCHAR(50) NOT NULL,
    username VARCHAR(50) NOT NULL,
    email VARCHAR(50) UNIQUE NOT NULL,
    role VARCHAR(50) UNIQUE NOT NULL, 
    password VARCHAR(50) NOT NULL,
    contact_number VARCHAR(16) UNIQUE NOT NULL,
    created_at DATETIME DEFAULT NOW(),
    updated_at DATETIME   
);

CREATE TABLE port (
 id INTEGER PRIMARY KEY AUTO_INCREMENT,
    port_location VARCHAR(100) NOT NULL,
    port_code VARCHAR(50) UNIQUE NOT NULL,
    created_at DATETIME DEFAULT NOW(),
    updated_at DATETIME
);

CREATE TABLE status (
 id INTEGER PRIMARY KEY AUTO_INCREMENT,
    status_type VARCHAR(100) NOT NULL,
    status_code VARCHAR(50) UNIQUE NOT NULL,
    created_at DATETIME DEFAULT NOW(),
    updated_at DATETIME
);

CREATE TABLE cargo (
 id INTEGER PRIMARY KEY AUTO_INCREMENT,
    name VARCHAR(50) NOT NULL,
    descriptions VARCHAR(254),
    status_id INTEGER NOT NULL,
    destination INTEGER NOT NULL,
    origin INTEGER NOT NULL,
    created_by INTEGER NOT NULL,
    weight FLOAT(5) NOT NULL,
    created_at DATETIME DEFAULT NOW(),
    updated_at DATETIME,
    FOREIGN KEY (status_id) REFERENCES status(id),
    FOREIGN KEY (destination) REFERENCES port(id),
    FOREIGN KEY (origin) REFERENCES port(id),
    FOREIGN KEY (created_by) REFERENCES user(id)
);

CREATE TABLE tracking_event(
 id INTEGER PRIMARY KEY AUTO_INCREMENT,
    cargo_id INTEGER NOT NULL,
    status_id INTEGER NOT NULL,
    created_at DATETIME DEFAULT NOW(),
    updated_at DATETIME,
    FOREIGN KEY (cargo_id) REFERENCES cargo(id),
    FOREIGN KEY (status_id) REFERENCES status(id)
);



 
 
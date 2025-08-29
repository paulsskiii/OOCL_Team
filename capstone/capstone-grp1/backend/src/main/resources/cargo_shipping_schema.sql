CREATE SCHEMA `cargo_shipping`;

USE cargo_shipping;


CREATE TABLE role(
    name VARCHAR(20) PRIMARY KEY,
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP
);

CREATE TABLE user (
 id INTEGER PRIMARY KEY AUTO_INCREMENT,
    first_name VARCHAR(50) NOT NULL,
    last_name VARCHAR(50) NOT NULL,
    username VARCHAR(50) NOT NULL,
    email VARCHAR(50) UNIQUE NOT NULL,
    role VARCHAR(20) NOT NULL, -- "USER" / "ADMIN" / "COURIER" 
    password VARCHAR(50) NOT NULL,
    contact_number VARCHAR(16) UNIQUE NOT NULL,    
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
    FOREIGN KEY (role) REFERENCES role(name)
);


CREATE TABLE port (
 port_code VARCHAR(10) PRIMARY KEY NOT NULL,
    port_location VARCHAR(100) NOT NULL,    
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP
);

CREATE TABLE status (
    status_code VARCHAR(5) PRIMARY KEY NOT NULL,
    status_type VARCHAR(100) NOT NULL,
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP
);

CREATE TABLE cargo (
 id INTEGER PRIMARY KEY AUTO_INCREMENT,
 name VARCHAR(50) NOT NULL,
    descriptions VARCHAR(254),
    weight FLOAT(5) NOT NULL,
    status_code VARCHAR(5) NOT NULL,
    destination VARCHAR(10) NOT NULL,
    origin VARCHAR(10) NOT NULL,
    created_by INTEGER NOT NULL,
    consignee INTEGER NOT NULL,
    courier INTEGER NOT NULL,    
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
    FOREIGN KEY (status_code) REFERENCES status(status_code),
    FOREIGN KEY (destination) REFERENCES port(port_code),
    FOREIGN KEY (origin) REFERENCES port(port_code),
    FOREIGN KEY (created_by) REFERENCES user(id),
    FOREIGN KEY (consignee) REFERENCES user(id),
    FOREIGN KEY (courier) REFERENCES user(id),
    CONSTRAINT unique_cargo_name_user UNIQUE (name, created_by)
);

CREATE TABLE tracking_event(
 id INTEGER PRIMARY KEY AUTO_INCREMENT,
    cargo_id INTEGER NOT NULL,
    status_code VARCHAR(5) NOT NULL,
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
    FOREIGN KEY (cargo_id) REFERENCES cargo(id),
    FOREIGN KEY (status_code) REFERENCES status(status_code),
    CONSTRAINT unique_tracking_event UNIQUE (cargo_id, status_code)
);

-- INDEXES
-- USER
CREATE INDEX idx_user_email ON user(email);
CREATE INDEX idx_user_username ON user(username);
CREATE INDEX idx_user_contact_number ON user(contact_number);

-- PORT
CREATE INDEX idx_port_location ON port(port_location);

-- STATUS
CREATE INDEX idx_status_type ON status(status_type);

-- CARGO
CREATE INDEX idx_cargo_status_code ON cargo(status_code);
CREATE INDEX idx_cargo_destination ON cargo(destination);
CREATE INDEX idx_cargo_origin ON cargo(origin);
CREATE INDEX idx_cargo_created_by ON cargo(created_by);
CREATE INDEX idx_cargo_consignee ON cargo(consignee);
CREATE INDEX idx_cargo_courier ON cargo(courier);
CREATE INDEX idx_cargo_name ON cargo(name);
CREATE INDEX idx_cargo_created_at ON cargo(created_at);

-- TRACKING EVENT
CREATE INDEX idx_tracking_event_cargo_id ON tracking_event(cargo_id);
CREATE INDEX idx_tracking_event_status_code ON tracking_event(status_code);
CREATE INDEX idx_tracking_event_created_at ON tracking_event(created_at);

-- Composite indexes for query patterns
CREATE INDEX idx_cargo_status_destination ON cargo(status_code, destination);
CREATE INDEX idx_cargo_origin_destination ON cargo(origin, destination);
CREATE INDEX idx_tracking_event_cargo_created ON tracking_event(cargo_id, created_at);

 
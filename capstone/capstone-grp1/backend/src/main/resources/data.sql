-- Initial data seeding for cargo shipping system
-- This file will be executed automatically when the application starts

-- Insert default status values
INSERT INTO status (status_type, status_code, created_at, updated_at) VALUES
('PENDING', 'PENDING', NOW(), NOW()),
('IN_TRANSIT', 'IN_TRANSIT', NOW(), NOW()),
('DELIVERED', 'DELIVERED', NOW(), NOW()),
('CANCELLED', 'CANCELLED', NOW(), NOW()),
('DELAYED', 'DELAYED', NOW(), NOW()),
('CUSTOMS', 'CUSTOMS', NOW(), NOW()),
('WAREHOUSE', 'WAREHOUSE', NOW(), NOW());

-- Insert default admin user
INSERT INTO user (first_name, last_name, username, email, role, password, contact_number, created_at, updated_at) VALUES
('Admin', 'User', 'admin', 'admin@cargoshipping.com', 'ADMIN', 'admin123', '+1234567890', NOW(), NOW()),
('John', 'Doe', 'john.doe', 'john.doe@cargoshipping.com', 'MANAGER', 'password123', '+1234567891', NOW(), NOW()),
('Jane', 'Smith', 'jane.smith', 'jane.smith@cargoshipping.com', 'OPERATOR', 'password123', '+1234567892', NOW(), NOW());

-- Insert sample ports
INSERT INTO port (port_location, port_code, created_at, updated_at) VALUES
('Los Angeles, USA', 'LAX', NOW(), NOW()),
('New York, USA', 'NYC', NOW(), NOW()),
('Hamburg, Germany', 'HAM', NOW(), NOW()),
('Rotterdam, Netherlands', 'RTM', NOW(), NOW()),
('Singapore', 'SIN', NOW(), NOW()),
('Shanghai, China', 'SHA', NOW(), NOW()),
('Tokyo, Japan', 'TYO', NOW(), NOW()),
('Dubai, UAE', 'DXB', NOW(), NOW());

-- Insert sample cargo
INSERT INTO cargo (name, descriptions, status_id, destination, origin, created_by, weight, created_at, updated_at) VALUES
('Electronics Shipment', 'High-value electronics including laptops and tablets', 2, 1, 3, 1, 25.5, NOW(), NOW()),
('Clothing Container', 'Fashion items and textiles', 1, 2, 5, 2, 15.0, NOW(), NOW()),
('Automotive Parts', 'Car components and spare parts', 2, 4, 6, 1, 45.2, NOW(), NOW()),
('Food Products', 'Frozen food items', 3, 7, 1, 3, 12.8, NOW(), NOW()),
('Pharmaceuticals', 'Medical supplies and medicines', 2, 8, 2, 2, 8.5, NOW(), NOW()),
('Furniture', 'Office furniture and home decor', 1, 3, 4, 1, 35.0, NOW(), NOW()),
('Books and Media', 'Educational materials and books', 2, 5, 7, 3, 18.3, NOW(), NOW()),
('Machinery', 'Industrial equipment and tools', 4, 6, 8, 2, 75.5, NOW(), NOW());

-- Insert sample tracking events
INSERT INTO tracking_event (cargo_id, status_id, created_at, updated_at) VALUES
(1, 1, NOW() - INTERVAL 2 DAY, NOW() - INTERVAL 2 DAY),
(1, 2, NOW() - INTERVAL 1 DAY, NOW() - INTERVAL 1 DAY),
(2, 1, NOW() - INTERVAL 1 DAY, NOW() - INTERVAL 1 DAY),
(3, 1, NOW() - INTERVAL 3 DAY, NOW() - INTERVAL 3 DAY),
(3, 2, NOW() - INTERVAL 2 DAY, NOW() - INTERVAL 2 DAY),
(4, 1, NOW() - INTERVAL 1 DAY, NOW() - INTERVAL 1 DAY),
(4, 2, NOW() - INTERVAL 12 HOUR, NOW() - INTERVAL 12 HOUR),
(4, 3, NOW(), NOW()),
(5, 1, NOW() - INTERVAL 2 DAY, NOW() - INTERVAL 2 DAY),
(5, 2, NOW() - INTERVAL 1 DAY, NOW() - INTERVAL 1 DAY),
(6, 1, NOW() - INTERVAL 1 DAY, NOW() - INTERVAL 1 DAY),
(7, 1, NOW() - INTERVAL 3 DAY, NOW() - INTERVAL 3 DAY),
(7, 2, NOW() - INTERVAL 2 DAY, NOW() - INTERVAL 2 DAY),
(8, 1, NOW() - INTERVAL 1 DAY, NOW() - INTERVAL 1 DAY),
(8, 4, NOW(), NOW());

-- Create indexes for better performance
-- USER INDEXES
CREATE INDEX idx_user_email ON user(email);
CREATE INDEX idx_user_username ON user(username);
CREATE INDEX idx_user_role ON user(role);
CREATE INDEX idx_user_contact_number ON user(contact_number);

-- PORT INDEXES
CREATE INDEX idx_port_code ON port(port_code);
CREATE INDEX idx_port_location ON port(port_location);

-- STATUS INDEXES
CREATE INDEX idx_status_code ON status(status_code);
CREATE INDEX idx_status_type ON status(status_type);

-- CARGO INDEXES
CREATE INDEX idx_cargo_status_id ON cargo(status_id);
CREATE INDEX idx_cargo_destination ON cargo(destination);
CREATE INDEX idx_cargo_origin ON cargo(origin);
CREATE INDEX idx_cargo_created_by ON cargo(created_by);
CREATE INDEX idx_cargo_name ON cargo(name);
CREATE INDEX idx_cargo_created_at ON cargo(created_at);

-- TRACKING EVENT INDEXES
CREATE INDEX idx_tracking_event_cargo_id ON tracking_event(cargo_id);
CREATE INDEX idx_tracking_event_status_id ON tracking_event(status_id);
CREATE INDEX idx_tracking_event_created_at ON tracking_event(created_at);

-- COMPOSITE INDEXES FOR QUERY PATTERNS
CREATE INDEX idx_cargo_status_destination ON cargo(status_id, destination);
CREATE INDEX idx_cargo_origin_destination ON cargo(origin, destination);
CREATE INDEX idx_tracking_event_cargo_created ON tracking_event(cargo_id, created_at);

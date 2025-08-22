DROP DATABASE cargo_db;

CREATE DATABASE cargo_db;
USE cargo_db;

CREATE TABLE container (
 id INT PRIMARY KEY NOT NULL AUTO_INCREMENT,
    container_name VARCHAR(50),
    weight DOUBLE,
    origin VARCHAR(50),
    destination VARCHAR(50),
    created_at DATETIME DEFAULT now()
);

INSERT INTO container (container_name, weight, origin, destination) VALUES
 ('Container 1', '150.300', 'Philippines', 'Tokyo'),
    ('Container 2', '1558.20', 'Japan', 'Singapore'),
    ('Container 3', '180.46', 'Australia', 'Belgium'),
    ('Container 4', '192.20', 'China', 'Vietnam'),
    ('Container 5', '136.30', 'South Korea', 'North Korea'),
    ('Container 6', '1870.213', 'Canada', 'America'),
    ('Container 7', '9584.20', 'Cambodia', 'Thailand'),
    ('Container 8', '320.72', 'Taiwan', 'Russia'),
    ('Container 9', '120.25', 'Israel', 'Palestine'),
    ('Container 10', '152.36', 'New York', 'Zimbabwe');
    
SELECT * from Container;
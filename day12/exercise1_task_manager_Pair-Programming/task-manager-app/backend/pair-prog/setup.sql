CREATE DATABASE IF NOT EXISTS taskdb;
USE taskdb;
-- Test data (optional)
INSERT INTO task (title, description, completed) VALUES
('Learn Spring Boot', 'Complete the Spring Boot tutorial', false),
('Build React App', 'Create a React frontend application', false),
('Connect Frontend to Backend', 'Integrate React with Spring Boot API', false);
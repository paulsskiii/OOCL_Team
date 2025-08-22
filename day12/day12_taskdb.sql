CREATE DATABASE IF NOT EXISTS taskdb;

USE taskdb;

CREATE TABLE task(
	id INTEGER PRIMARY KEY AUTO_INCREMENT,
    title VARCHAR(64) NOT NULL,
    description VARCHAR(255) NOT NULL,
    completed boolean NOT NULL
);

-- Test data (optional)
INSERT INTO task (title, description, completed) VALUES
('Learn Spring Boot', 'Complete the Spring Boot tutorial', false),
('Build React App', 'Create a React frontend application', false),
('Connect Frontend to Backend', 'Integrate React with Spring Boot API', false);


SELECT * FROM TASK;


SELECT * FROM TASK WHERE title like '%build%';

SELECT * FROM TASK WHERE completed = 0;


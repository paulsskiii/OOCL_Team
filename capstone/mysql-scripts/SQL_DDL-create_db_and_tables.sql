DROP DATABASE IF EXISTS cargo_capstone;
CREATE DATABASE cargo_capstone;
USE cargo_capstone;

CREATE TABLE `user_credentials` (`id` INTEGER NOT NULL UNIQUE AUTO_INCREMENT,
`username` VARCHAR(255) NOT NULL UNIQUE,
`password` VARCHAR(255) NOT NULL,
`is_active` BOOL,
PRIMARY KEY (`id`)
);

CREATE TABLE `user_information` (`id` INTEGER NOT NULL UNIQUE AUTO_INCREMENT,
`email` VARCHAR(255) NOT NULL UNIQUE,
`contact_number` VARCHAR(63),
`user_credentials_id` INTEGER NOT NULL UNIQUE,
PRIMARY KEY (`id`),
FOREIGN KEY (`user_credentials_id`) REFERENCES `user_credentials`(`id`)
);

CREATE TABLE `ports` (`id` CHAR(5) NOT NULL UNIQUE,
`name` VARCHAR(255) NOT NULL,
`is_active` BOOL,
PRIMARY KEY (`id`)
);

CREATE TABLE `status` (`id` CHAR(2) NOT NULL UNIQUE,
`name` VARCHAR(255) NOT NULL,
PRIMARY KEY (`id`)
);

CREATE TABLE `containers` (`id` INTEGER NOT NULL UNIQUE AUTO_INCREMENT,
`name` VARCHAR(255) NOT NULL,
`origin` CHAR(5) NULL,
`destination` CHAR(5) NULL,
`status` CHAR(2) NOT NULL,
`weight` DOUBLE(11, 3) NULL,
`departure_date` DATETIME NULL,
`arrival_date` DATETIME NULL,
`booked_by` INTEGER NOT NULL,
PRIMARY KEY (`id`),
FOREIGN KEY (`origin`) REFERENCES `ports`(`id`),
FOREIGN KEY (`destination`) REFERENCES `ports`(`id`),
FOREIGN KEY (`status`) REFERENCES `status`(`id`),
FOREIGN KEY (`booked_by`) REFERENCES `user_information`(`id`)
);
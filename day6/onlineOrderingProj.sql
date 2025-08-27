CREATE SCHEMA IF NOT EXISTS `online_ordering_proj`;
USE `online_ordering_proj` ;

-- DROP SCHEMA `online_ordering_proj`;

-- customer
CREATE TABLE IF NOT EXISTS customer (
  `id` INT NOT NULL AUTO_INCREMENT UNIQUE,
  `firstName` VARCHAR(45) NOT NULL,
  `lastName` VARCHAR(45) NOT NULL,
  `contactNumber` VARCHAR(45) NOT NULL,
  `emailAddress` VARCHAR(45) NOT NULL,
  `addressLine1` VARCHAR(255) NOT NULL,
  `addressLine2` VARCHAR(255) NULL,
  `barangay` VARCHAR(45) NULL,
  `city` VARCHAR(45) NOT NULL,
  `postalCode` VARCHAR(45) NOT NULL,
  `region` VARCHAR(45) NOT NULL,
  `country` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`id`)
);


-- packageTypes
CREATE TABLE IF NOT EXISTS packageTypes (
  `id` INT NOT NULL AUTO_INCREMENT UNIQUE,
  `name` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`id`)
);


-- package
CREATE TABLE IF NOT EXISTS package (
  `id` INT NOT NULL AUTO_INCREMENT UNIQUE,
  `pickupDate` DATETIME NULL,
  `deliveryDate` DATETIME NULL,
  `weight` INT NOT NULL,
  `contentsDescription` VARCHAR(255) NULL,
  `senderId` INT NOT NULL,
  `packageTypesId` INT NOT NULL,
  `recepientId` INT NOT NULL,
  PRIMARY KEY (`id`),
  FOREIGN KEY (`packageTypesId`) REFERENCES packageTypes(`id`),
  FOREIGN KEY (`recepientId`) REFERENCES customer(`id`)
);


-- vehicleTypes
CREATE TABLE IF NOT EXISTS vehicleTypes (
  `id` INT NOT NULL AUTO_INCREMENT UNIQUE,
  `name` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`id`)
);


-- courier
CREATE TABLE IF NOT EXISTS courier(
  `id` INT NOT NULL AUTO_INCREMENT UNIQUE,
  `firstName` VARCHAR(45) NOT NULL,
  `lastName` VARCHAR(45) NOT NULL,
  `contactNumber` VARCHAR(45) NOT NULL,
  `licenseNumber` VARCHAR(45) NOT NULL,
  `vehicleTypesId` INT NOT NULL,
  PRIMARY KEY (`id`),
  FOREIGN KEY (`vehicleTypesId`) REFERENCES vehicleTypes(`id`)
);


-- location
CREATE TABLE IF NOT EXISTS location (
  `id` INT NOT NULL AUTO_INCREMENT UNIQUE,
  `locationName` VARCHAR(45) NOT NULL,
  `contactNumber` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`id`)
);


-- packageStatus
CREATE TABLE IF NOT EXISTS packageStatus (
  `id` INT NOT NULL AUTO_INCREMENT UNIQUE,
  `status` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`id`)
);


-- trackingEvent
CREATE TABLE IF NOT EXISTS trackingEvent (
  `id` INT NOT NULL AUTO_INCREMENT UNIQUE,
  `description` VARCHAR(255) NOT NULL,
  `packageId` INT NOT NULL,
  `locationId` INT NOT NULL,
  `packageStatusId` INT NOT NULL,
  `courierId` INT NOT NULL,
`update_ts` DATETIME NOT NULL,
  PRIMARY KEY (`id`),
  FOREIGN KEY (`locationId`) REFERENCES location(`id`),
  FOREIGN KEY (`packageStatusId`) REFERENCES packageStatus(`id`),
  FOREIGN KEY (`courierId`) REFERENCES courier(`id`)
);


SELECT * FROM courier a
JOIN trackingevent b on a.id = b.courierId
WHERE courierId = 20;
SELECT * FROM courier;
SELECT * FROM package;

CALL GetCustomerDeliveryHistory(1);
CALL GetActiveDeliveryCities();
CALL getPackageJourneyTracker(65);
CALL getCourierScorecard(1);




SELECT * FROM courier;
SELECT * FROM customer;
SELECT * FROM location;
SELECT * FROM package;
SELECT * FROM packageStatus;
SELECT * FROM packageTypes;
SELECT * FROM trackingEvent;
SELECT * FROM vehicleTypes;

-- CREATE PROCEDURE safe_insert()
-- BEGIN
-- 	DECLARE CONTINUE HANDLER FOR SQLEXCEPTION
--     BEGIN
-- 		SELECT * FROM pascs;
-- 	END;
-- END;




-- SELECT get_full_name(customer.firstName, customer.lastName) AS "Customer" FROM customer;

-- CREATE VIEW senders AS
-- SELECT customer.id AS `sender_id`, customer.firstName AS `sender_fname`, customer.lastName AS `sender_lname`
-- FROM customer, package
-- WHERE customer.id=package.senderId;

-- CREATE VIEW recepients AS
-- SELECT customer.id AS `recepient_id`, customer.firstName AS `recepient_fname`, customer.lastName AS `recepient_lname`
-- FROM customer, package
-- WHERE customer.id=package.recepientId;

-- CREATE VIEW courier_details AS
-- SELECT courier.id AS `courier_id`, courier.firstName AS `courier_fname`, courier.lastName AS `courier_lname`, vehicletypes.`name` AS `vehicle_name`
-- FROM courier, vehicletypes, trackingevent, package
-- WHERE trackingevent.packageid=package.id
-- AND vehicletypes.id=courier.vehicleTypesId;

-- DROP VIEW sender_name;

-- SELECT * FROM package;


-- SELECT sender_name.firstName FROM sender_name;

-- SELECT * FROM trackingevent, package WHERE trackingevent.packageid=package.id ORDER BY trackingevent.id DESC;
-- SELECT * FROM courier;

-- SELECT * FROM package;
-- SELECT * FROM customer WHERE id=;

-- SELECT package.*,
-- 	CONCAT(senders.sender_fname, " ", sender_lname) AS "Sender Name",
-- 	CONCAT(recepients.recepient_fname, " ", recepients.recepient_lname) AS "Recipient Name",
-- 	CONCAT(courier_details.courier_fname, " ", courier_details.courier_lname) AS "Courier Name",
--     courier_details.vehicle_name AS "Vehicle Type"
-- FROM package, senders, recepients, courier_details, trackingevent
-- 	INNER JOIN package.senderId=senders.sender_id
-- 	WHERE package.senderId=senders.sender_id
--     AND trackingevent.packageid=package.id
--     AND trackingevent.courierId=courier_details.courier_id
--     ;

-- 1

-- 2
SELECT get_full_name (customer.firstName, customer.lastName) AS "Non-sending Customers"
	FROM customer
    WHERE customer.id NOT IN (SELECT package.senderid FROM package);

SELECT * FROM package;




-- UPDATE PACKAGE
CALL get_package_of_sender(67);
UPDATE package SET package.deliveryDate=NULL WHERE package.id=81;

SHOW PROCEDURE STATUS;
CALL update_package_delivery (81);
SELECT * FROM package WHERE package.id=81;

SELECT * FROM package;

INSERT INTO package (pickupdate, weight, contentsDescription, senderid, packagetypesid, recepientid) VALUES ("2025-06-14", 500, "Extra Large Package", 67, 6, 49);




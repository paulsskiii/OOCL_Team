-- Exercise 1.2 Stored Procedure with Logic and Error Handling
CREATE PROCEDURE UpdateDelivery ()
BEGIN
	DECLARE delivery_date DATETIME;
    
    SELECT ps.status_name
    INTO status_of_delivery
    FROM package p
    JOIN trackingevent te ON p.package_id = te.package_id
    JOIN packagestatus ps ON te.package_status_id = ps.package_status_id;
    
    IF status_of_delivery = "DELIVERED" THEN
		SET delivery_date = DATE(NOW());
    END IF;
END
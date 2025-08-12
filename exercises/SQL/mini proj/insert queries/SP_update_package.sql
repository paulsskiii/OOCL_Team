DELIMITER //

CREATE PROCEDURE `update_package_delivery` (id int)
BEGIN
	-- DECLARE CONTINUE HANDLER FOR NOT FOUND
    BEGIN
		SET @packageId:=id;
        SET @delivDate:=(SELECT package.deliveryDate FROM package WHERE package.id=@packageid);
		IF (@delivDate IS NULL) THEN
			UPDATE package SET package.deliveryDate=NOW() WHERE package.id=@packageid;
		END IF;
	END;
    -- SELECT * FROM package WHERE package.id=67;
END //

DELIMITER ;

DROP PROCEDURE update_package_delivery;
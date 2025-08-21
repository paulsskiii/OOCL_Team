-- 1
DELIMITER //
CREATE PROCEDURE GetPackagesById(
	IN recipientID INT
)
BEGIN
	SELECT * 
 	FROM package
	WHERE recipient_id = recipientID;
END //
DELIMITER ;

CALL GetPackagesById(34);

-- 2
DELIMITER //
CREATE PROCEDURE UpdateDeliveryDate()
BEGIN
	DECLARE CONTINUE HANDLER FOR SQLEXCEPTION
	BEGIN
		SELECT 'Update Error'
	END;
		UPDATE delivery_date, IF 
END //

DELIMITER ;
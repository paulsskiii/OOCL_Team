DELIMITER //
CREATE PROCEDURE `getpackageByRecepientId` (in id integer)
BEGIN
	SELECT * FROM package WHERE recepientId = id;
END
//

DELIMITER //
CREATE PROCEDURE `checkDeliveryDate` (in newDeliveryDate datetime, in currDeliveryDate datetime,in id integer, in newstatus varchar(20))
BEGIN
	DECLARE CONTINUE HANDLER FOR SQLEXCEPTION
    BEGIN
		SELECT 'WRONG DATE FORMAT';
	END;
		UPDATE PACKAGE 
        SET deliveryDate = CASE 
        WHEN newStatus = 'Delivered' THEN newDeliveryDate
        ELSE currDeliveryDate
        END;
END
//
DELIMITER //


CALL getpackageByRecepientId(2);

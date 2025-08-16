DELIMITER $$
USE `group3_miniproject`$$

CREATE PROCEDURE getPackageRecords()
BEGIN
	SELECT CONCAT(r.first_name, ' ', r.last_name) AS 'Recipient', 
		p.contents_description AS 'Package Description' FROM packages p
	INNER JOIN DELIVERY_DETAILS d ON p.delivery_details_id = d.id
	INNER JOIN CUSTOMERS r on r.id = recipient_id;
END$$

DELIMITER ;

CALL getPackageRecords(8);
CREATE DEFINER=`root`@`localhost` PROCEDURE `update_dates`(IN new_delivery_date DATETIME)
BEGIN
	
	DECLARE CONTINUE HANDLER FOR SQLEXCEPTION
	BEGIN
		SELECT 'Update of Delivery Failed!';
    END;
		UPDATE PACKAGES p
		INNER JOIN tracking_events t ON p.id = t.package_id
		SET delivery_date = new_delivery_date
		WHERE t.package_status = 'Delivered';
END
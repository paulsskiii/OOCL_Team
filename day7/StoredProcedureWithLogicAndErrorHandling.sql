-- package
	-- deliveryDate
-- trackingevent
	-- packageid
    -- packagestatusid
-- packagestatus
	-- status
CREATE DEFINER=`root`@`localhost` PROCEDURE `update_delivery_date_if_not_delivered`(id int)
BEGIN
	DECLARE CONTINUE HANDLER FOR SQLEXCEPTION
    BEGIN
		SELECT 'Update failed';
	END;
    
	SET @today = now();
	
    SET @deliveryDate = (
		SELECT 
			deliveryDate 
		FROM 
			package p 
		WHERE 
			p.id = id
	);
    
    SET @deliveryStatus = (
		SELECT
			ps.status
		FROM
			packageStatus ps
		WHERE
			ps.id = (
				SELECT
					te.packagestatusid
				FROM
					trackingEvent te,
                    package p
				WHERE
					p.id = te.packageid
            )
    );
    
    SET @next15Days = DATE_ADD(@delivery_date, INTERVAL 15 day);
    
	IF @delivery_date = @today AND @deliveryStatus != 'Delivered' THEN 
		UPDATE 
			package
		SET
			deliveryDate = @next15Days;
	END IF;
END
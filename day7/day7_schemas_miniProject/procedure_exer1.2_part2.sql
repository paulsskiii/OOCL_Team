CREATE DEFINER=`root`@`localhost` PROCEDURE `logic_procedure`(IN currentDate DATETIME, IN trackingEvent_id int)
BEGIN
	DECLARE package_status VARCHAR(64);
    
	SELECT ps.status_name
		INTO package_status
    FROM packagestatus ps
		JOIN trackingevent t 
			ON  t.package_status_id = ps.package_status_id
    WHERE t.tracking_event_id = trackingEvent_id;
    
    
	IF package_status != 'DELIVERED' THEN
		UPDATE package SET delivery_date = currentDate
		WHERE package_id = (SELECT package_id FROM trackingevent WHERE tracking_event_id = trackingEvent_id);
    END IF;
END
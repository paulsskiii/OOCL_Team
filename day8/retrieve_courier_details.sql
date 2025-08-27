CREATE DEFINER=`root`@`localhost` PROCEDURE `retrieve_courier_details`(IN courier_id int)
BEGIN
	SELECT * FROM courier c WHERE c.courier_id = courier_id;
END
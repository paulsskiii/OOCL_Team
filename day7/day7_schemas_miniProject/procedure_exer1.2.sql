CREATE DEFINER=`root`@`localhost` PROCEDURE `new_procedure`(IN recipient_id int)
BEGIN
	SELECT * FROM package p 
	WHERE p.recipient_id = recipient_id;
END
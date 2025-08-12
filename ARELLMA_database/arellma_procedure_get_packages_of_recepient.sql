CREATE DEFINER=`root`@`localhost` PROCEDURE `get_packages_of_recipient`(IN customer_id INT)
BEGIN
SELECT CONCAT(s.first_name, ' ', s.last_name) AS 'Customer Name', p.contents_description FROM PACKAGES p
	INNER JOIN DELIVERY_DETAILS d ON d.id = p.delivery_details_id
	INNER JOIN CUSTOMERS s ON d.recipient_id = s.id
	WHERE d.recipient_id = customer_id;
END
-- Create a stored procedure that retrieves all packages for a given recipient
SET @recipientId = 54;

CALL retrieve_all_packages_for_recipient(@recipientId);


--
SET @packageId = 1;
CALL update_delivery_date_if_not_delivered(@packageId);
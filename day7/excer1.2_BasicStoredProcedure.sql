-- Exercise 1.2 Basic Stored Procedure
CREATE PROCEDURE RecipientPackages (
	IN recipient_id_input INTEGER
)
BEGIN
	SELECT p.* 
    FROM package p
    INNER JOIN customer recipient ON p.recipient_id = recipient.customer_id
    WHERE recipient.customer_id = recipient_id_input;
END
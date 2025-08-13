DELIMITER $$
CREATE DEFINER=`root`@`localhost` PROCEDURE `get_packages_with_recipient`(IN recipient_id INT)
BEGIN
	SELECT t.recipient_id, p.*
    FROM PACKAGES p
    JOIN TRANSACTIONS t ON p.PACKAGE_ID = t.PACKAGE_ID
    WHERE t.RECIPIENT_ID = recipient_id;
END$$
DELIMITER ;

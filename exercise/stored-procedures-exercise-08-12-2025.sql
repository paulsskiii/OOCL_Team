use cargo_shipping_system;

-- 1. 
DELIMITER //
CREATE PROCEDURE `retrieve_package_of_recipient` (IN recipient_id int)
BEGIN
	SELECT 
		concat(cus.first_name, ' ', cus.last_name) AS 'Customer Full Name',
		pack.recipient_id
	FROM Customer cus
	INNER JOIN Package pack ON cus.customer_id = pack.recipient_id;
END //

CALL retrieve_package_of_recipient(7);

-- 2.
CREATE PROCEDURE UpdateEmployeeSalary(
    IN package_id INT,
    IN deliveryDate DECIMAL(10, 2),
    OUT errorMessage VARCHAR(255)
)
BEGIN
    DECLARE EXIT HANDLER FOR SQLEXCEPTION
    BEGIN
        SET errorMessage = 'Error, please try again.';
    END;

    UPDATE Employees
    SET deliveryDate = deliveryDate
    WHERE package_id = package_id;

END //

DELIMITER ;
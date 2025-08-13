CREATE DEFINER=`root`@`localhost` FUNCTION `getName`(id int) RETURNS varchar(100) CHARSET utf8mb4
    DETERMINISTIC
BEGIN
	SET @firstName = (SELECT c.firstName FROM customer c WHERE c.id = id);
	SET @lastName = (SELECT c.lastName FROM customer c WHERE c.id = id);
	RETURN CONCAT(@firstName, ' ', @lastName);
END
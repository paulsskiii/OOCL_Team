CREATE DEFINER=`root`@`localhost` PROCEDURE `retrieve_all_packages_for_recipient`(id int)
BEGIN
	SELECT
		p.id,
        p.pickupDate,
        p.deliveryDate,
        p.contentsDescription,
        pt.name
	FROM
		package p,
        packageTypes pt
	WHERE
		p.id = id AND
        p.packageTypesId = pt.id;
END
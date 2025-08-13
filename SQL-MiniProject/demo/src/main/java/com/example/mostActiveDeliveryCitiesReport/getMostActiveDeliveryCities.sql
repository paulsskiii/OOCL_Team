CREATE DEFINER=`root`@`localhost` PROCEDURE `getMostActiveDeliveryCities`()
BEGIN
	SELECT loc.locationname AS "Location Name",COUNT(te.locationId) AS "Frequency", getName(te.courierId) AS "Most Frequent Courier", ABS(AVG(DATEDIFF(p.pickupDate, p.deliveryDate))) as "Delivery Date Average" FROM trackingevent te 
	JOIN location loc 
	ON te.locationId = loc.id
	JOIN package P
	ON te.packageId = p.id
	GROUP BY LOC.locationname, getName(te.courierId)
    ORDER BY COUNT(te.locationId) DESC; 

END
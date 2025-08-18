DELIMITER $$
USE `group3_miniproject`$$
CREATE PROCEDURE getMostActiveDeliveryCities()
BEGIN
    SELECT custout.city AS "Active Delivery Cities",
 COUNT(pout.id) AS "No. of Packages Delivered",
    ( SELECT CONCAT(courin.first_name, ' ', courin.last_name)
  FROM COURIERS courin
  INNER JOIN PACKAGES pin ON courin.id = pin.courier_id
  INNER JOIN DELIVERY_DETAILS din ON pin.delivery_details_id = din.id
  INNER JOIN CUSTOMERS custin ON din.recipient_id = custin.id
  WHERE custin.city = custout.city
  AND pin.delivery_date >= CURDATE() - INTERVAL 30 DAY
  GROUP BY courin.id
  ORDER BY COUNT(pin.id) DESC
  LIMIT 1
 ) AS "Most Frequent Courier",
 ROUND(AVG(DATEDIFF(pout.delivery_date, pout.pickup_date)), 2) AS "Average Delivery Time"
 FROM PACKAGES pout
 INNER JOIN DELIVERY_DETAILS dout ON pout.delivery_details_id = dout.id
 INNER JOIN CUSTOMERS custout ON dout.recipient_id = custout.id
 WHERE pout.delivery_date >= CURDATE() - INTERVAL 30 DAY
 GROUP BY custout.city
 ORDER BY COUNT(pout.id) DESC;
END$$

DELIMITER ;

CALL getMostActiveDeliveryCities();
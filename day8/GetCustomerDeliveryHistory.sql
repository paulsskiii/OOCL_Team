CREATE DEFINER=`root`@`localhost` PROCEDURE `GetCustomerDeliveryHistory`(
    IN customer_id_input INTEGER
)
BEGIN
    DECLARE EXIT HANDLER FOR SQLEXCEPTION
    BEGIN
        SELECT 'An error occurred!' AS ErrorMessage;
    END;

    SELECT
  c.customer_id,
  CONCAT(c.first_name, ' ', c.last_name) AS customer_name,
  p.sender_id,
  p.recipient_id,
  p.package_id,
  p.pickup_date,
  p.delivery_date,
  ps.status_name,
  pt.classification_name,
  CONCAT(cr.first_name, ' ', cr.last_name) AS courier,
  (
   SELECT COUNT(p.package_id)
   FROM package p 
            JOIN customer c ON p.sender_id = c.customer_id
   WHERE c.customer_id = customer_id_input
  ) AS total_sent_packages,
  (
   SELECT COUNT(p.package_id)
   FROM package p 
            JOIN customer c ON p.recipient_id = c.customer_id
   WHERE c.customer_id = customer_id_input
  ) AS total_recieved_packages
 FROM customer c
 JOIN package p ON (p.sender_id = c.customer_id OR p.recipient_id = c.customer_id)
 JOIN courier cr ON p.courier_id = cr.courier_id
 JOIN packagetype pt ON p.package_type_id = pt.package_type_id
 JOIN trackingevent te ON p.package_id = te.package_id
 JOIN packagestatus ps ON te.package_status_id = ps.package_status_id
 WHERE c.customer_id = customer_id_input
 ORDER BY p.package_id;
END
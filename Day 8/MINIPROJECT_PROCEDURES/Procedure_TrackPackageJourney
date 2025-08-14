CREATE DEFINER=`root`@`localhost` PROCEDURE `TrackPackageJourney`(
 IN input_pkg_id INT, 
 OUT sender_name VARCHAR(60), 
    OUT recipient_name VARCHAR(60), 
    OUT courier_name VARCHAR(60), 
    OUT description VARCHAR(200),
    OUT location VARCHAR(150),
    OUT status VARCHAR(30),
    OUT event_timestamp TIMESTAMP
    )
BEGIN
 SELECT 
  CONCAT(send.FIRST_NAME, ' ', send.LAST_NAME),
  CONCAT(rec.FIRST_NAME, ' ', rec.LAST_NAME),
  CONCAT(cour.FIRST_NAME, ' ', cour.LAST_NAME),
  te.DESCRIPTION,
  CONCAT(l.BARANGAY, ', ', l.CITY, ', ', l.POSTAL_CODE, ', ', l.REGION, ', ', l.COUNTRY),
  te.PACKAGE_STATUS,
  te.EVENT_TIMESTAMP
 INTO sender_name, recipient_name, courier_name, description, location, status, event_timestamp
 FROM TRACKINGEVENTS te
 INNER JOIN PACKAGES p ON te.PACKAGE_ID = p.PACKAGE_ID
 INNER JOIN (
  SELECT * FROM TRANSACTIONS WHERE PACKAGE_ID = input_pkg_id LIMIT 1
 ) t ON t.PACKAGE_ID = p.PACKAGE_ID
 INNER JOIN CUSTOMERS send ON send.CUSTOMER_ID = t.SENDER_ID 
 INNER JOIN CUSTOMERS rec ON rec.CUSTOMER_ID = t.RECIPIENT_ID
 INNER JOIN COURIERS cour ON cour.COURIER_ID = t.COURIER_ID
 INNER JOIN LOCATIONS l ON l.location_id = te.PICK_UP
 WHERE p.PACKAGE_ID = input_pkg_id
 ORDER BY te.EVENT_TIMESTAMP ASC;
END
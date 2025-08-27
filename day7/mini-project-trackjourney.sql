CREATE DEFINER=`root`@`localhost` PROCEDURE `TrackPackageJourney`(
	IN PACKAGE_ID INT
)
BEGIN
	-- QUERY 1
	SELECT
		pack.id AS 'Package ID',
		CONCAT(sender.first_name, ' ', sender.last_name) AS 'Sender Name',
		CONCAT(recipient.first_name, ' ', recipient.last_name) AS 'Recipient Name',
		CONCAT(cour.first_name, ' ', cour.last_name) AS 'Courier Name'
	FROM packages pack
	JOIN delivery_details deli
		ON pack.delivery_details_id = deli.id
	JOIN customers sender
		ON deli.sender_id = sender.id
	JOIN customers recipient
		ON deli.recipient_id = recipient.id
	LEFT JOIN couriers cour
		ON pack.courier_id = cour.id
	WHERE pack.id = PACKAGE_ID;

    -- QUERY 2
    SELECT
		evnt.event_description AS 'Event Description',
		loc.location_name AS 'Location',
		evnt.package_status AS 'Status',
		evnt.created_at AS 'Event Timestamp'
	FROM tracking_events evnt
	JOIN locations loc
		ON evnt.location_id = loc.id
	WHERE evnt.package_id = PACKAGE_ID
	ORDER BY evnt.created_at ASC;
END
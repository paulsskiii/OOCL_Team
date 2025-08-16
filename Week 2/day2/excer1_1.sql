SELECT DISTINCT CONCAT(u.first_name, ' ', u.last_name) AS "Full Name", CONCAT(c.first_name, ' ', c.last_name) AS "Courier Name"
,p.package_type AS "Packages", c.vehicle_type AS "Vehicle Type"
FROM customers u
INNER JOIN delivery_details d ON u.id = d.recipient_id
INNER JOIN couriers c ON u.id = c.id
INNER JOIN packages p ON d.id = p.delivery_details_id
INNER JOIN tracking_events t ON p.id = t.package_id
WHERE u.id IN (
    SELECT sender_id FROM delivery_details
)
AND u.id IN (
    SELECT recipient_id FROM delivery_details
);

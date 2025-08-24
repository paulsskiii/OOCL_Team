 -- Exercise 1.1
-- 1. List all packages with sender and recipient full names, courier name, and vehicle type
SELECT p.packageId,
       CONCAT(s.firstName, ' ', s.lastName) AS senderName,
       CONCAT(r.firstName, ' ', r.lastName) AS recipientName,
       c.courierName,
       c.vehicleType
FROM Package_Tbl p
JOIN Customer_Tbl s ON p.senderId = s.customerId
JOIN Customer_Tbl r ON p.recipientId = r.customerId
JOIN Courier_Tbl c ON p.courierId = c.courierId;

-- 2. Find customers who have never sent a package 
 SELECT c.customerId, c.firstName, c.lastName
FROM Customer_Tbl c
LEFT JOIN Package_Tbl p ON c.customerId = p.senderId
WHERE p.senderId IS NULL;

-- 3. Use a recursive CTE to simulate a delivery chain
WITH RECURSIVE DeliveryChain AS (
    SELECT t.trackingId, t.packageId, t.eventTime, t.eventDesc, t.prevEventId
    FROM Tracking_Tbl t
    WHERE t.prevEventId IS NULL 
    
    UNION ALL
    
    SELECT t.trackingId, t.packageId, t.eventTime, t.eventDesc, t.prevEventId
    FROM Tracking_Tbl t
    INNER JOIN DeliveryChain dc ON t.prevEventId = dc.trackingId
)
SELECT *
FROM DeliveryChain
WHERE packageId = 1 
ORDER BY eventTime;

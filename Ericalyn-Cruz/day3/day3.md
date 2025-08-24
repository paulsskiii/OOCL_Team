# Cargo Tracking System

## Description
Tracks cargo information like type, tracking number, location, weight, and delivery status.

Status: Complete
---

## Java Code

```java
public class CargoTrackingSystem {
    public static void main(String[] args) {
        String cargoType = "Electronics";
        String trackingNumber = "TRK98765";
        String currentLocation = "At Sea";
        int estimatedDeliveryDays = 6;
        boolean isDelivered = false;
        double weightKg = 850.25;

        System.out.println("Cargo Info:");
        System.out.println("Tracking Number: " + trackingNumber);
        System.out.println("Cargo Type: " + cargoType);
        System.out.println("Location: " + currentLocation);
        System.out.println("Delivery (days): " + estimatedDeliveryDays);
        System.out.println("Weight: " + weightKg + " kg");
        System.out.println("Delivered: " + (isDelivered ? "Yes" : "No"));
    }
}

public class CargoTrackingSystem {
    public static void main(String[] args) {
        // 1 & 2. Declare and Initialize Variables
        String cargoType = "Electronics";
        String trackingNumber = "TRK98765";
        String currentLocation = "At Sea";
        int estimatedDeliveryDays = 6;
        boolean isDelivered = false;
        double weightKg = 850.25;

        // --- Add your code below this line ---

        // Display cargo info
        System.out.println("Cargo Tracking Information");
        System.out.println("--------------------------");
        System.out.println("Tracking Number: " + trackingNumber);
        System.out.println("Cargo Type: " + cargoType);
        System.out.println("Current Location: " + currentLocation);
        System.out.println("Estimated Delivery (days): " + estimatedDeliveryDays);
        System.out.println("Weight (kg): " + weightKg);
        System.out.println("Delivered: " + (isDelivered ? "Yes" : "No"));

        // Example: Update status when delivered
        if (!isDelivered) {
            System.out.println("\nUpdating delivery status...");
            isDelivered = true;
            System.out.println("Delivered: " + (isDelivered ? "Yes" : "No"));
        }
    }
}



public class CargoTrackingSystem {
    public static void main(String[] args) {
        // 1 & 2. Declare and Initialize Variables
        String cargoType = "Electronics";
        String trackingNumber = "TRK98765";
        String currentLocation = "At Sea";
        int estimatedDeliveryDays = 6;
        boolean isDelivered = false;
        double weightKg = 850.25;

        System.out.println(estimatedDeliveryDays(cargo));
    }
        // --- Add your code below this line ---
        public static String getDeliveryEstimate(Cargo cargo) {
        int days = cargo.getEstimatedDeliveryDays();
        if (days <= 3) {
            return "Expected in " + days + " days."; //For fast delivery
        } else if (days <= 7) {
            return "Expected in " + days + " days."; //For Standard delivery
        } else {
            return "Expected in " + days + " days."; // For International delivery
        }
    }
}

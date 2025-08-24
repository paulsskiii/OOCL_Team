package Java34.OOCL_Team;

public class CargoTrackingSystem {
    private static class Shipment {
        // 1 & 2. Declare and Initialize Variables
        String cargoType = "Electronics";
        String trackingNumber = "TRK98765";
        String currentLocation = "At Sea";
        int estimatedDeliveryDays = 6;
        boolean isDelivered = false;
        double weightKg = 850.25;

        public void checkEstimatedDeliveryDays() {
            if(estimatedDeliveryDays <= 3) {
                System.out.println("Express Delivery! Expected in " + estimatedDeliveryDays + " days.");
            } else if(estimatedDeliveryDays > 4 && estimatedDeliveryDays < 7) {
                System.out.println("Standard delivery. Expected in " + estimatedDeliveryDays + " days.");
            } else {
                System.out.println("Long haul delivery. Expected in " + estimatedDeliveryDays + " days.");
            }
        }
    }
    public static void main(String[] args) {
        // --- Add your code below this line --
        Shipment shipment = new Shipment();

        shipment.checkEstimatedDeliveryDays();
    }
}


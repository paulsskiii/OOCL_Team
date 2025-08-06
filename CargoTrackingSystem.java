package OOCL_Team;

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
        
        if ( estimatedDeliveryDays <= 3 ) {
            System.out.println("Express delivery! Expected in" + estimatedDeliveryDays  + "days");
        }
        else if ( estimatedDeliveryDays >= 4 && estimatedDeliveryDays <= 7 ) {
            System.out.println("Standard delivery. Expected in  " + estimatedDeliveryDays +" days");
        }
        else
            System.out.println("Long haul delviery. Expected in " + estimatedDeliveryDays +" days");
    }
}

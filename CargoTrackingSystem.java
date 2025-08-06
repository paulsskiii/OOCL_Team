package OOCL_Team;

public class CargoTrackingSystem {
    public static void main(String[] args) {
        Shipment shipment = new Shipment();
        // 1 & 2. Declare and Initialize Variables
        int estimatedDeliveryDays =  shipment.getEstimatedDeliveryDays();
        
        shipment.setCargoType("Electronics");
        // shipment.setTrackingNumber("TRK98765");
        shipment.setCurrentLocation("At Sea");
        shipment.setEstimatedDeliveryDays(6);
        shipment.setDelivered(false);
        // shipment.setWeightKg(860.25);
        
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

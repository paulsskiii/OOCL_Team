public class CargoTrackingSystem {
    public static void main(String[] args) {
//        // 1 & 2. Declare and Initialize Variables
//        String cargoType = "Electronics";
//        String trackingNumber = "TRK98765";
//        String currentLocation = "At Sea";
//        int estimatedDeliveryDays = 6;
//        boolean isDelivered = false;
//        double weightKg = 850.25;
//
//        // --- Add your code below this line ---
//        if (estimatedDeliveryDays <= 3) {
//            System.out.println("Express delivery! Expected in " + estimatedDeliveryDays + " days.");
//        } else if (estimatedDeliveryDays >= 4 && estimatedDeliveryDays <= 7) {
//            System.out.print("Standard delivery. Expected in " + estimatedDeliveryDays + " days.");
//        } else {
//            System.out.println("Long hail delivery. Expected in " + estimatedDeliveryDays + " days.");
//        }

        Ship ship = new Ship();

        ship.setShipname("OOCL");
        ship.setCaptainName("Paul");
        ship.setFuelLevelPercentage(90);
        ship.setSpeedKnots(90.00);

        System.out.println("Ship Name: " + ship.getShipname() + " " +
                " Captain Name: " + ship.getCaptainName() +
                " Fuel Level Percentage: " + ship.getFuelLevelPercentage() +
                " Speed Knots: " + ship.getSpeedKnots());

        Tanker tanker = new Tanker("S");

        System.out.println(tanker.getCargoTypeCarried());

    }
}

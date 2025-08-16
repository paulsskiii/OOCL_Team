public class CargoLoader {

    public void loadCargo(double currentWeight, double cargoWeight, double shipCapacity)
        throws ShipOverloadException, IllegalArgumentException {
        if (cargoWeight <= 0)
            throw new IllegalArgumentException("Invalid weight input. Received: " + cargoWeight);
        if (currentWeight + cargoWeight > shipCapacity)
            throw new ShipOverloadException ("Weight to be loaded will exceed capacity . Current Capacity: " + currentWeight + " | Weight after load: " +
            (currentWeight + cargoWeight));

        System.out.println ("Cargo has been loaded successfully");
    }

    public static void main(String[] args) {
        CargoLoader loader = new CargoLoader();

        try {
            // loader.loadCargo (500, -35, 525);    // IllegalArgumentException
            // loader.loadCargo (500, 0, 525);    // IllegalArgumentException
            // loader.loadCargo (500, 26, 525);    // ShipOverLoadException
            loader.loadCargo (500, 20, 525);    // Happy case
        } catch (ShipOverloadException | IllegalArgumentException e) {
            System.out.println (e.getMessage ());
        } catch (Exception e) {
            System.out.println ("Other error occurred. Please adivse");
            e.printStackTrace();
        } finally {
            System.out.println ("Now in finally block. Please review message above");
        }
        // Test cases here
    }
}
package excer2_1;

public class CargoLoader {

    public void loadCargo(double currentWeight, double cargoWeight, double shipCapacity)
        throws ShipOverloadException, IllegalArgumentException {
        // Validation and loading logic

        if(cargoWeight < 0) {
            throw new IllegalArgumentException("Invalid cargo weight!");
        } else if(currentWeight + cargoWeight > shipCapacity) {
            throw new ShipOverloadException("Current weight and cargo weight exceeds ship capacity!");
        } else {
            System.out.println("Cargo with current weight: " + currentWeight + " and cargo weight: " + cargoWeight + " has been successfully loaded!");
        }
    }

    public static void main(String[] args) {
        CargoLoader loader = new CargoLoader();

        // Test cases here
        try {
            loader.loadCargo(5, -1, 1);     // IllegalArgument
            loader.loadCargo(5, 2, 1);      // ShipOverload
            loader.loadCargo(5, 2, 10);     // HappyCase
        } catch(IllegalArgumentException e) {
            System.out.println(e.getMessage());
        } catch(ShipOverloadException e) {
            System.out.println(e.getMessage());
        } finally {
            System.out.println("Cargo safety check completed.");
        }
    }
}
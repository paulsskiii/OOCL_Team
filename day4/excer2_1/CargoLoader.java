package Exercise_2_1;

public class CargoLoader {
    public void loadCargo(double currentWeight, double cargoWeight, double shipCapacity)
            throws ShipOverloadException, IllegalArgumentException {
        // Validation and loading logic
        try {
            if (cargoWeight <= 0) {throw new IllegalArgumentException("You have an IllegalArgumentException: cargoWeight must be greater than zero.");}

            if ((currentWeight+cargoWeight) > shipCapacity) {throw new ShipOverloadException("You have an ShipOverloadException: currentWeight + cargoWeight is greater than shipCapacity.");}

        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        } catch (ShipOverloadException e) {
            System.out.println(e.getMessage());
        }
    }

    public static void main(String[] args) throws ShipOverloadException {
        CargoLoader loader = new CargoLoader();

        // Test cases here
        loader.loadCargo(10,-1,10); // IllegalArgumentException
        loader.loadCargo(5,5,9); // ShipOverloadException
    }
}

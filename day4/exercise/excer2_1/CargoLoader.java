public class CargoLoader {

    public static double loadCargo(double currentWeight, double cargoWeight, double shipCapacity)
        throws ShipOverloadException, IllegalArgumentException {
        // Validation and loading logic
        if (cargoWeight <= 0) {
            throw new ShipOverloadException("Cargo weight must be greater than 0.");
        }
        else if ((currentWeight + cargoWeight) > shipCapacity) {
            throw new ShipOverloadException("Ship capacity exceeded.");
        }
        return cargoWeight * 1.0;
    }

    public static void main(String[] args) throws IllegalArgumentException, ShipOverloadException {
        CargoLoader loader = new CargoLoader();


        // Test cases here
        System.out.println("1");
        loadCargo(1,1,10);
        System.out.println("2");
        loadCargo(6,5,10);
        System.out.println("3");
        loadCargo(1,0,10);
        System.out.println("---");
        // loadCargo(1,10,10);

    }
}
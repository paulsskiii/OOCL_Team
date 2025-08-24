public class CargoLoader {

    public static double loadCargo(double currentWeight, double cargoWeight, double shipCapacity)
            throws ShipOverloadException, IllegalArgumentException {
        
        if (cargoWeight <= 0) {
            throw new IllegalArgumentException("Cargo weight must be greater than 0.");
        } else if ((currentWeight + cargoWeight) > shipCapacity) {
            throw new ShipOverloadException("Ship capacity exceeded.");
        }
        
        System.out.println("Cargo loaded: " + cargoWeight + " tons");
        return cargoWeight;
    }

    public static void main(String[] args) {
        double shipCapacity = 10;

        // Test cases
        try {
            loadCargo(1, 1, shipCapacity);  // should succeed
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        try {
            loadCargo(6, 5, shipCapacity);  // exceeds capacity
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        try {
            loadCargo(1, 0, shipCapacity);  // invalid cargo weight
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        try {
            loadCargo(1, 10, shipCapacity); // exceeds capacity
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
public class CargoLoader {

    public void loadCargo(double currentWeight, double cargoWeight, double shipCapacity)
        throws ShipOverloadException, IllegalArgumentException {
            double totalWeight = currentWeight + cargoWeight;

            if (cargoWeight <= 0) {
                throw new IllegalArgumentException("Cargo weight should be greater than 0");
            }
            if (totalWeight > shipCapacity) {
                throw new ShipOverloadException("Total Weight exceeds Ship's Capacity");
            }
            System.out.println("Total Weight: " + totalWeight);
          
    }

    public static void main(String[] args) {
        CargoLoader loader = new CargoLoader();
        try {
            System.out.println("=== Ship 1 ===");
            loader.loadCargo(2, 1, 4);
            System.out.println("=== Ship 2 ===");
            loader.loadCargo(2, 7, 4);
        } catch (ShipOverloadException | IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }
}
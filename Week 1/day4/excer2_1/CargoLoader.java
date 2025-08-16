public class CargoLoader {

    public void loadCargo(double currentWeight, double cargoWeight, double shipCapacity)
        throws ShipOverloadException, IllegalArgumentException {
        // Validation and loading logic
        double totalWeight = currentWeight + cargoWeight;
        try {
            if (cargoWeight < 0) {
                System.out.print(totalWeight);
                throw new IllegalArgumentException(" - Cargo weight is invalid.");
            } else if (totalWeight > shipCapacity) {
                System.out.print(totalWeight);
                throw new ShipOverloadException(" - Total Weight Exceed the Ship Capacity of "+ shipCapacity);
            } else {
                System.out.println(totalWeight);
            }
        } catch (ShipOverloadException | IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }

    public static void main(String[] args) throws IllegalArgumentException, ShipOverloadException {
        CargoLoader loader = new CargoLoader();

        // Test cases here
        loader.loadCargo(1, 3, 26);
        loader.loadCargo(9, 2, 5);
        loader.loadCargo(2, -5, 12);
    }
}
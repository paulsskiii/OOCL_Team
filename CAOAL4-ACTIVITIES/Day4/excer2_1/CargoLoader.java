public class CargoLoader {

    public void loadCargo(double currentWeight, double cargoWeight, double shipCapacity)
        throws ShipOverloadException, IllegalArgumentException {

        // Validation and loading logic
        double totalWeight = currentWeight + cargoWeight;
        try {
            if (cargoWeight < 0) {
                System.out.println("------------------------");
                System.out.print(totalWeight);
                throw new IllegalArgumentException(" - Cargo must not be negative.");
            } else if (totalWeight > shipCapacity) {
                System.out.println("------------------------");
                System.out.print(totalWeight);
                throw new ShipOverloadException(" - Total Weight Exceed the Ship Capacity of "+ shipCapacity);
            } else {
                System.out.println("------------------------");
                System.out.println(totalWeight);
            }
        } catch (ShipOverloadException | IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }

    public static void main(String[] args) throws IllegalArgumentException, ShipOverloadException {
        CargoLoader loader = new CargoLoader();

        // Test cases here
        loader.loadCargo(5, 5, 24);
        loader.loadCargo(5, 5, 9);
        loader.loadCargo(5, -7, 11);
    }
}
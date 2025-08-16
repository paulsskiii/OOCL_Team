public class CargoLoader {

    public void loadCargo(double currentWeight, double cargoWeight, double shipCapacity)
        throws ShipOverloadException, IllegalArgumentException {
        // Validation and loading logic

            double totalWeight = currentWeight + cargoWeight;
            if(cargoWeight < 0){
                throw new IllegalArgumentException("Cargo must not be negative.");
            } else if (totalWeight > shipCapacity) {
                throw new ShipOverloadException("Total Weight Exceed the Ship Capacity.");
            } else {
                System.out.println(totalWeight);
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
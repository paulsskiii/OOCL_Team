public class CargoLoader {

    public void loadCargo(double currentWeight, double cargoWeight, double shipCapacity)
        throws ShipOverloadException, IllegalArgumentException {
        int totalWeight = (int) (currentWeight + cargoWeight);

        try {
            if (cargoWeight < 0) {
                System.out.print(totalWeight + " ");
                throw new IllegalArgumentException("Cargo weight is invalid. | Cargo weight is negative/IllegalArgumentException");
            } else if (totalWeight > shipCapacity) {
                System.out.println("Cargo overload");
                throw new ShipOverloadException("Cargo overload | Ship Overload Exception");
            } else if (totalWeight < shipCapacity) {
                System.out.println("Cargo successful");
            }
        } catch (IllegalArgumentException | ShipOverloadException e) {
            System.out.println(e.getMessage());
        }
    }

    public static void main(String[] args) throws ShipOverloadException {
        CargoLoader loader = new CargoLoader();
        loader.loadCargo(1, 3, 26);
        loader.loadCargo(9, 2, 5);
        loader.loadCargo(2, -5, 12);


        // Test cases here
    }
}
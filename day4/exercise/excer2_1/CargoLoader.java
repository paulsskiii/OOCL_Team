package exer2_1;

public class CargoLoader {
    public void loadCargo(double currentWeight, double cargoWeight, double shipCapacity) throws ShipOverloadException, IllegalArgumentException {
        if ((currentWeight + cargoWeight) > shipCapacity){
            throw new ShipOverloadException("Cargo Weight + Current weight exceeds Ship Capacity");
        } else if (currentWeight <= 0) {
            throw new IllegalArgumentException("Current weight could not be 0 or negative");
        }

        System.out.println(currentWeight + cargoWeight);
    }

    public static void main(String[] args) {
        CargoLoader loader = new CargoLoader();

        // Test cases here
        try {
            loader.loadCargo(90, 70, 200);
            loader.loadCargo(-90, 70, 200);
            loader.loadCargo(90, 70, 200);
        } catch (ShipOverloadException e) {
            e.getMessage();
        } catch (IllegalArgumentException e) {
            e.getMessage();
        }
    }
}

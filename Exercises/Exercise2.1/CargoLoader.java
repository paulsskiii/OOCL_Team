public class CargoLoader {

    public void loadCargo(double currentWeight, double cargoWeight, double shipCapacity)
        throws ShipOverloadException, IllegalArgumentException {
        // Validation and loading logic
        try {
            if(cargoWeight <= 0){
                throw new IllegalArgumentException("Cargo weight must not be negative or equal to zero.");
            }
            if((currentWeight + cargoWeight) > shipCapacity){
                throw new ShipOverloadException("Total weight exceeds ship capacity.");
            }

        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        } catch (ShipOverloadException e){
            System.out.println(e.getMessage());
        } 
    }

    public static void main(String[] args) throws  ShipOverloadException {
        CargoLoader loader = new CargoLoader();

        // Test cases here
        loader.loadCargo(10, -5, 30);
        loader.loadCargo(5, 5, 9);
    }
}
public class CargoLoader {

    public void loadCargo(double currentWeight, double cargoWeight, double shipCapacity) throws ShipOverloadException, IllegalArgumentException {
        // Validation and loading logic

        if(currentWeight <= 0){
            throw new IllegalArgumentException("Cargo weight must not be negative or zero");
        }else if((currentWeight + cargoWeight) > shipCapacity){
            throw new ShipOverloadException("Current weight + cargo weight exceeds the Ship's Capacity!");
        } else {
            System.out.println("You are good to go.");
        }


    }

    public static void main(String[] args) {
        CargoLoader loader = new CargoLoader();
        // Test cases here
        try {
            // loader.loadCargo(7500, 14000, 15000);  // overweight
            // loader.loadCargo(-7500, 14000, 15000); //negative
            loader.loadCargo(7500, 1400, 15000); //good
        } catch (IllegalArgumentException e) {
            System.err.println("Error: " + e.getMessage());
        } catch(ShipOverloadException e){
            System.err.println("Error: " + e.getMessage());
        } finally {
            System.out.println("Done.");
        }
        
    }
}
public class CargoLoader {

    public void loadCargo (double currentWeight, double cargoWeight, double shipCapacity)
        throws ShipOverloadException, IllegalArgumentException {
        // Validation and loading logic

        if(cargoWeight <= 0) {
            throw new IllegalArgumentException("Cargo Weight cannot be negative or 0.");
        }
        if((currentWeight + cargoWeight) > shipCapacity) {
            throw new ShipOverloadException("Current weight and Cargo Weight must not exceed Ship Capacity when added.");
        }
        System.out.println("Cargo has been loaded successfully");
    }

    public static void main(String[] args) {
        CargoLoader loader = new CargoLoader();
        try {
            // Test cases here
            // ShipOverloadException
            //loader.loadCargo(1500, 600, 2000);

            // IllegalArgumentException
            //loader.loadCargo(1500, -15, 2000);

            // IllegalArgumentException
            //loader.loadCargo(1500, 0, 2000);

            // Happy Path
            loader.loadCargo(1500, 300, 2000);
            
        } catch(IllegalArgumentException e) {
            System.err.println("Exception occured: "+e.getMessage());
        } catch(ShipOverloadException e) {
            System.err.println("Exception occured: "+e.getMessage());
        } catch(Exception e) {
            e.printStackTrace();
        }

    }
}
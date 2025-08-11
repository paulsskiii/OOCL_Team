public class CargoLoader {

    public void loadCargo(double currentWeight, double cargoWeight, double shipCapacity)
        throws ShipOverloadException, IllegalArgumentException {

        // Validation and loading logic
        if(currentWeight <= 0 || cargoWeight <=0){
            throw new IllegalArgumentException("You must enter values higher than 0.");
        }

        double currentCapacity = currentWeight + cargoWeight;
        
        if(currentCapacity != shipCapacity){
            throw new ShipOverloadException("Current weight and cargo weight must be equal to ship capacity!");
        }
    }

    public static void main(String[] args) {
        CargoLoader loader = new CargoLoader();
        
        // TEST CASES
        // TC1: Current Weight, Cargo Weight and Ship Capacity is positive and current capacity is equals to ship capacity
        try {
            loader.loadCargo(11, 11, 22);
        }catch(IllegalArgumentException e){
            System.out.println(e);
        }catch (ShipOverloadException e) {
            System.out.println(e);
        } catch (Exception e){
            System.out.println(e);
        } finally{
            System.out.println("Done");
        }

        // TC2: Either Current Weight, Cargo Weight and Ship Capacity is 0 
        try {
            loader.loadCargo(11.12, 0, 11.23);
        }catch(IllegalArgumentException e){
            System.out.println(e);
        }catch (ShipOverloadException e) {
            System.out.println(e);
        } catch (Exception e){
            System.out.println(e);
        } finally{
            System.out.println("Done");
        }

        // TC3: Either Current Weight, Cargo Weight and Ship Capacity is negative
        try {
            loader.loadCargo(11.12, -323, 11.23);
        }catch(IllegalArgumentException e){
            System.out.println(e);
        }catch (ShipOverloadException e) {
            System.out.println(e);
        } catch (Exception e){
            System.out.println(e);
        } finally{
            System.out.println("Done");
        }

        // TC4: Current weight and cargo weight is not equal to ship capacity
        try {
            loader.loadCargo(10, 10, 51);
        }catch(IllegalArgumentException e){
            System.out.println(e);
        }catch (ShipOverloadException e) {
            System.out.println(e);
        } catch (Exception e){
            System.out.println(e);
        } finally{
            System.out.println("Done");
        }
    }
}
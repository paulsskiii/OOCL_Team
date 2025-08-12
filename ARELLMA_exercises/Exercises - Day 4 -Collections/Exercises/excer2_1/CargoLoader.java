import java.util.Scanner;

import java.util.Scanner;

public class CargoLoader {

    public void loadCargo(double currentWeight, double cargoWeight, double shipCapacity)
        throws ShipOverloadException, IllegalArgumentException {

        // Validation and loading logic
        if (cargoWeight <= 0) {
            throw new IllegalArgumentException();
        }
        else if (cargoWeight + currentWeight > shipCapacity){
            throw new ShipOverloadException("Exceeds Ship Capacity");
        }
        else{
            System.out.println("Cargo loaded");
        }


    }

    public static void main(String[] args) throws ShipOverloadException {
        CargoLoader loader = new CargoLoader();

        // Test cases here

        //T1 Only numbers bigger than 0, shipCapacity should be bigger or equal to weights, should print Cargo Loaded
        try{
         loader.loadCargo(1, 1, 2);
        }
        catch (IllegalArgumentException e){
            System.out.println("Weights cannot be negative or 0");
        }

        //T2 Only negative numbers, should throw IllegalArgumentException
        try{
            loader.loadCargo(-1, -1, -1);
        }
        catch (IllegalArgumentException e){
            System.out.println("Weights cannot be negative or 0");
        }

        //T3 Current+Cargo Weight exceed capacity, should throw IllegalArgumentException
        try{
            loader.loadCargo(1, 1, 1);
        }
        catch (ShipOverloadException e){
            e.printStackTrace();
        }

    }
}
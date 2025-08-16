package excer1_1;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

public class CargoManifestManager {
    public static void main(String[] args) {
        List<CargoItem> manifest = new ArrayList<>();
        Iterator<excer1_1.CargoItem> iterator = manifest.iterator();
        Scanner input = new Scanner(System.in);

        // Add items to manifest
        manifest.add(new CargoItem(1, "Cargo 1", 123, "Manila"));
        manifest.add(new CargoItem(2, "Cargo 2", 321, "Hong Kong"));
        manifest.add(new CargoItem(3, "Cargo 3", 213, "Singapore"));
        manifest.add(new CargoItem(4, "Cargo 4", 432, "Dubai"));
        System.out.println("All cargo item OBJECTS: " + manifest);

        System.out.println("Enter a cargo ID to remove it: ");
        int inputCargoId = input.nextInt();

        for (CargoItem cargoItem : manifest) {
            if (cargoItem.getId() == inputCargoId) {
                manifest.remove(cargoItem);
            }
        }

        for (CargoItem cargoItem : manifest) {
            System.out.println("ID: " + cargoItem.getId() + " | Name: " + cargoItem.getName() + " | Weight: " + cargoItem.getWeight() + " | Destination: " + cargoItem.getDestination());
        }

        // Display manifest
        System.out.println("Remaining cargo items: " + manifest);

        input.close();
    }
}

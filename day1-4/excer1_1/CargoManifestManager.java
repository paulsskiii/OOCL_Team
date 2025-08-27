package excer1_1;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class CargoManifestManager {
    public static void main(String[] args) {
        List<CargoItem> manifest = new ArrayList<>();
        Scanner input = new Scanner(System.in);

        // Add items to manifest
        manifest.add(new CargoItem(1, "Cargo 1", 123, "Manila"));
        manifest.add(new CargoItem(2, "Cargo 2", 321, "Hong Kong"));
        manifest.add(new CargoItem(3, "Cargo 3", 213, "Singapore"));
        manifest.add(new CargoItem(4, "Cargo 4", 432, "Dubai"));

        System.out.println("All cargo items: ");
        manifest.stream().forEach(System.out::println);

        System.out.println("\nEnter a cargo ID to remove it: ");
        int inputCargoId = input.nextInt();

        // OPTION 1: Use iterator
        Iterator<CargoItem> iterator = manifest.iterator();
        while (iterator.hasNext()) {
            if (iterator.next().getId() == inputCargoId) {
                iterator.remove();
            }
        }
        // OPTION 2: Use removeIf()
        // manifest.removeIf(item -> item.getId() == inputCargoId);

        // Display manifest
        System.out.println("\nRemaining cargo items: ");
        manifest.stream().forEach(System.out::println);

        input.close();
    }
}

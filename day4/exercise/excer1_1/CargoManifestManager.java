package Java34.OOCL_Team.day4.exercise.excer1_1;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CargoManifestManager {
    public static void main(String[] args) {
        List<CargoItem> manifest = new ArrayList<>();
        // Add items to manifest
        manifest.add(new CargoItem(4, "Name1", 12.0, "Manila"));
        manifest.add(new CargoItem(3,"Name2", 13.0,"Singapore"));

        System.out.println("Initial Manifest:");
        printManifest(manifest);

        // Remove by ID
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the id of the Cargo you want to remove: ");
        int removeId = sc.nextInt();
        manifest.removeIf(item -> item.getId() == removeId);

        System.out.println("====================");
        System.out.print("Final Manifest:");
        printManifest(manifest);

        // Display manifest
    }

    private static void printManifest(List<CargoItem> manifest) {
        manifest.forEach(item -> {
            System.out.println("id: " + item.getId());
            System.out.println("name: " + item.getName());
            System.out.println("weight: " + item.getWeight());
            System.out.println("destination: " + item.getDestination());
            System.out.println();
        });
    }
}

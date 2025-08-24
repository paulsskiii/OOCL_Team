import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class CargoManifestManager {
    public static void main(String[] args) {
        List<CargoItem> manifest = new ArrayList<>();

        // Add 5 cargo items
        manifest.add(new CargoItem(1, "Apples", 100));
        manifest.add(new CargoItem(2, "Bananas", 50));
        manifest.add(new CargoItem(3, "Oranges", 75));
        manifest.add(new CargoItem(4, "Grapes", 60));
        manifest.add(new CargoItem(5, "Mangoes", 80));

        // Print all cargo items
        System.out.println("Initial Manifest:");
        displayManifest(manifest);

        // Remove a cargo item by ID
        int idToRemove = 3;
        removeItemById(manifest, idToRemove);

        // Print remaining cargo items
        System.out.println("\nManifest After Removing ID " + idToRemove + ":");
        displayManifest(manifest);
    }

    private static void displayManifest(List<CargoItem> manifest) {
        for (CargoItem item : manifest) {
            System.out.println(item);
        }
    }

    private static void removeItemById(List<CargoItem> manifest, int id) {
        Iterator<CargoItem> iterator = manifest.iterator();
        while (iterator.hasNext()) {
            if (iterator.next().getId() == id) {
                iterator.remove();
                System.out.println("Item with ID " + id + " removed.");
                return;
            }
        }
        System.out.println("Item with ID " + id + " not found.");
    }
}

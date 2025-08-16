import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class CargoManifestManager {
    public static void main(String[] args) {
        List<CargoItem> manifest = new ArrayList<>();

        // Add items to manifest
        manifest.add(new CargoItem(1,"cargoName1", 1.0, "Destination1"));
        manifest.add(new CargoItem(2,"cargoName2", 2.0, "Destination2"));
        manifest.add(new CargoItem(3,"cargoName3", 3.0, "Destination3"));
        manifest.add(new CargoItem(4,"cargoName4", 4.0, "Destination4"));
        manifest.add(new CargoItem(5,"cargoName5", 5.0, "Destination5"));

        System.out.println("Displaying 5 added cargo items");
        for(CargoItem cargoItem:manifest){
            System.out.println(cargoItem.id + " " + cargoItem.name + " " + cargoItem.weight + " " + cargoItem.destination);
        }

        // Remove by ID
        manifest.removeIf(cargoItem -> cargoItem.id == 3);

        // Display manifest
        System.out.println("Displaying the remaining cargo items");
        for(CargoItem cargoItem:manifest){
            System.out.println(cargoItem.id + " " + cargoItem.name + " " + cargoItem.weight + " " + cargoItem.destination);
        }

    }
}

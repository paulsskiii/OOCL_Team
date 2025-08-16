import java.util.ArrayList;
import java.util.List;

public class CargoManifestManager {
    public static void main(String[] args) {
        List<CargoItem> manifest = new ArrayList<>();

        // Add items to manifest
        manifest.add(new CargoItem(1, "cargo1", 100.0, "Manila"));
        manifest.add(new CargoItem(2, "cargo2", 101.0, "Japan"));
        manifest.add(new CargoItem(3, "cargo3", 102.0, "Singapore"));
        manifest.add(new CargoItem(4, "cargo4", 103.0, "China"));
        manifest.add(new CargoItem(5, "cargo5", 104.0, "Batangas"));

        // Remove by ID
        manifest.removeIf(cargoItem -> cargoItem.id == 1);

        // Display manifest
        for(CargoItem cargoItem:manifest){
            System.out.println(cargoItem.id + " " + cargoItem.name + " " + cargoItem.weight + " " + cargoItem.destination);
        }
    }
}

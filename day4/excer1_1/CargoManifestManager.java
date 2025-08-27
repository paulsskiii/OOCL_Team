package Exercise_1_1;

import java.util.ArrayList;
import java.util.List;

public class CargoManifestManager {
    public static void main(String[] args) {
        List<CargoItem> manifest = new ArrayList<>();

        // Add items to manifest
        CargoItem cargo1 = new CargoItem(10, "cargo1", 5, "Manila");
        CargoItem cargo2 = new CargoItem(20, "cargo2", 5, "China");
        CargoItem cargo3 = new CargoItem(30, "cargo3", 5, "Qatar");
        CargoItem cargo4 = new CargoItem(40, "cargo4", 5, "Florida");
        CargoItem cargo5 = new CargoItem(50, "cargo5", 5, "Cebu");

        manifest.add(cargo1);
        manifest.add(cargo2);
        manifest.add(cargo3);
        manifest.add(cargo4);
        manifest.add(cargo5);

//        System.out.println(manifest);

        // Remove by ID
        long removeId = 3;

        for (int i=0; i<manifest.toArray().length; i++) {
            CargoItem cargoItem = manifest.get(i);
            if (cargoItem.id == removeId) {
                System.out.println(manifest.get(i));
                manifest.remove(cargoItem);
            }
        }

//        manifest.remove(3);


        // Display manifest
        System.out.println(manifest);
    }
}

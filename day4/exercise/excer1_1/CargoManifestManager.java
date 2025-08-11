

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CargoManifestManager {
    public static void main(String[] args) {
        List<CargoItem> manifest = new ArrayList<>();

        // Add items to manifest
        CargoItem firstCargo = new CargoItem(11, "OOCU123YU",56, "Japan");
        CargoItem secondCargo = new CargoItem(13, "FEUS1235U",56, "China");
        CargoItem thirdCargo = new CargoItem(14, "OOCIS1235U",58, "China");
        CargoItem fourthCargo = new CargoItem(15, "OOCIS14565U",58, "China");
        CargoItem fifthCargo = new CargoItem(16, "OOCIS14565U",58, "China");

        manifest.add(firstCargo);
        manifest.add(secondCargo);
        manifest.add(thirdCargo);
        manifest.add(fourthCargo);
        manifest.add(fifthCargo);

        // Remove by ID
        for (CargoItem cargoItem : manifest) {
            if (cargoItem.getId() == 11){
                manifest.remove(cargoItem);
                break;
            }
        }
        
        // Display manifest

        for (CargoItem cargoItem : manifest) {
            cargoItem.getCargoDetails();
        }

    }
}

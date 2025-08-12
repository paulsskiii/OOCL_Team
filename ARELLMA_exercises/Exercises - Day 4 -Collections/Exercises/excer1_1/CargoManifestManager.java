import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class CargoManifestManager {
    public static void main(String[] args) {
        List<CargoItem> manifest = new ArrayList<>();
        boolean itemFound = false;
        long removeId = 2;
        int i = 0;

        // Add items to manifest
        manifest.add(new CargoItem(1, "HKG Cargo", 3.5, "HKG"));
        manifest.add(new CargoItem(2, "SIN Cargo", 3.2, "SIN"));
        manifest.add(new CargoItem(3, "US Cargo", 3.3, "US"));
        manifest.add(new CargoItem(4, "PH Cargo", 3.1, "PH"));
        manifest.add(new CargoItem(5, "TKY Cargo", 3.4, "TKY"));

        System.out.println("All Cargoes in manifest");

        for(CargoItem item : manifest) {
            System.out.println(item.name + "- id: " + item.id + " Weight: " + item.weight + " Destination: " + item.destination);
        }

        // Remove by ID
        while(!itemFound){
            CargoItem item = manifest.get(i);
            if(item.id == removeId){
                manifest.remove(item);
                itemFound = true;
            }
            i++;
        }

        // Display manifest
        System.out.println("Updated manifest");

        for(CargoItem item : manifest) {
            System.out.println(item.name + "- id: " + item.id +  "Weight: " + item.weight + " Destination: " + item.destination);
        }
    }


}

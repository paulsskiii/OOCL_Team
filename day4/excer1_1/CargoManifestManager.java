import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class CargoManifestManager {
    public static void main(String[] args) {
        List<CargoItem> manifest = new ArrayList<>();
        int cargoCount = 5;
        int i = -1;

        // Add items to manifest
        manifest.add (new CargoItem (i += 1, "Food", 100, "Manila"));
        manifest.add (new CargoItem (i += 1, "Clothing", 102, "Philhipehsns"));
        manifest.add (new CargoItem (i += 1, "Spices", 200, "Spain"));
        manifest.add (new CargoItem (i += 1, "Electronics", 250, "Krea"));
        manifest.add (new CargoItem (i += 1, "Plastic Containers", 50, "Jakarta"));

        for (CargoItem cargo : manifest)
            System.out.println (cargo);
        
        // Remove by ID
        long removeId = 3;
        System.out.println ("\nRemoving id " + removeId);
        for (i = 0; i < manifest.size (); i++) {
            if (manifest.get (i).getId () == removeId) {
                manifest.remove (i);
                i = manifest.size() + 1; // or use break;
            }
        }

        // Display manifest
        System.out.println ("\nManifest after remove");
        for (CargoItem cargo : manifest)
            System.out.println (cargo);
    }
}
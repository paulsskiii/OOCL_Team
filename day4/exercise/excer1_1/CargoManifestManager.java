import java.util.ArrayList;
import java.util.List;

public class CargoManifestManager {
    public static void main(String[] args) {
        List<CargoItem1> manifest = new ArrayList<>();

        // Add items to manifest

        manifest.add(new CargoItem1(12, "OOCL", 14520, "MNL01"));
        manifest.add(new CargoItem1(11, "MSC", 28921, "SHA82"));
        manifest.add(new CargoItem1(13, "MAERSK", 15500, "HKG21"));
        manifest.add(new CargoItem1(121, "CGM", 10587, "NYK12"));
        manifest.add(new CargoItem1(198, "COS", 20548, "BRK01"));

        for (CargoItem1 cargoItem : manifest) {
            System.out.println(cargoItem);
        }
        
        long removeId = 13;
        // Remove by ID
        for (CargoItem1 cargoItem : manifest) {
            if(cargoItem.getId() == removeId){
                manifest.remove(cargoItem.getId());
            }
        }
        // Display manifest
    }
}

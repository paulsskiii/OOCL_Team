
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CargoManifestManager {
    public static void main(String[] args) {

        // Add items to manifest
        List<CargoItem> manifest = new ArrayList<>(
            Arrays.asList(
                new CargoItem(0, "MCL60", 702.12, "Silverstone"),
                new CargoItem(1, "Ferrari SF-25", 703.20, "Sao Paulo"),
                new CargoItem(2, "RB19", 700, "Monaco"),
                new CargoItem(3, "W16", 701.98, "Monza"),
                new CargoItem(4, "FW47", 702.49, "Bahrain")
                )
        );
        System.out.println("---Before removing an ID---");
        for(CargoItem cargoItem : manifest){
            System.out.println(cargoItem.toString());
        }
        // Remove by ID | ID to remove is 3
        Long filteredId = manifest.stream()
                .filter(cargoItem -> cargoItem.getId() == 3).map(CargoItem::getId).findFirst().get();
        manifest.removeIf(cargoItem -> cargoItem.getId() == filteredId);
        // Display manifest
        
        System.out.println("---After removing an ID---");
        for (CargoItem cargoItem : manifest) {
            System.out.println(cargoItem.toString());
        }
    }
}

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class CargoManifestManager {
    public static void main(String[] args) {
        List<CargoItem> manifest = new ArrayList<>();

        // Add items to manifest
        CargoItem cargoItem1 = new CargoItem(1, "Phone", 5, "Mnl");
        CargoItem cargoItem2 = new CargoItem(2, "Laptop", 10, "Ceb");
        CargoItem cargoItem3 = new CargoItem(3, "Mac", 15, "Tok");
        CargoItem cargoItem4 = new CargoItem(4, "Coffee", 3, "Nav");
        CargoItem cargoItem5 = new CargoItem(5, "Wallet", 2, "DD");

        manifest.add(cargoItem1);
        manifest.add(cargoItem5);
        // Remove by ID
        // manifest.remove("241");

        // Display manifest

        for (CargoItem cargoItem : manifest) {
            System.out.println(cargoItem.id+cargoItem.name+cargoItem.weight+cargoItem.destination);
        }
        
        System.out.println(cargoItem1.id);
        System.out.println(cargoItem1.name);
        System.out.println(cargoItem1.weight);
        System.out.println(cargoItem1.destination);
    }
}

package OOCL_Team.day4.excercise.excer1_1;

import java.util.ArrayList;
import java.util.List;

public class CargoManifestManager {
    public static void main(String[] args) {
        List<CargoItem> manifest = new ArrayList<>();

        manifest.add(new CargoItem(1, "Furniture", 100.35, "Tokyo"));
        manifest.add(new CargoItem(2, "Hazardous", 20.88, "Tokyo"));
        manifest.add(new CargoItem(3, "Perishable", 34.56, "Tokyo"));
        manifest.add(new CargoItem(4, "General", 78.9, "Tokyo"));
        manifest.add(new CargoItem(5, "Electronics ", 55.10, "Manila"));

        for (CargoItem cargo : manifest) {
            System.out.println(cargo.toString());
        }

        manifest.removeIf(cargoItem -> cargoItem.getId()==3);
        System.out.println("=======================================" + "\nList size with removed item by ID: " + manifest.size());
        
        for (CargoItem cargo : manifest) {
            System.out.println(cargo.toString());
        }
    }
}

import java.util.ArrayList;
import java.util.List;

public class CargoManifestManager {
    public static void main(String[] args) {
        List<CargoItem> cargo = new ArrayList<>();

        // Adding items to cargo
        cargo.add(new CargoItem(1,"cargoName1", 1.0, "Destination1"));
        cargo.add(new CargoItem(2,"cargoName2", 2.0, "Destination2"));
        cargo.add(new CargoItem(3,"cargoName3", 3.0, "Destination3"));
        cargo.add(new CargoItem(4,"cargoName4", 4.0, "Destination4"));
        cargo.add(new CargoItem(5,"cargoName5", 5.0, "Destination5"));

        // Displaying all cargo
        System.out.println("Displaying "+ cargo.size() +" added cargo items");
        for(CargoItem cargoItem:cargo){
            System.out.println(cargoItem.id + " " + cargoItem.name + " " + cargoItem.weight + " " + cargoItem.destination);
        }

        System.out.println("=======================================");
        // Removing cargo by ID
        cargo.removeIf(cargoItem -> cargoItem.id == 3);

        // Display remaining cargo
        System.out.println("Displaying the remaining cargo items");
        for(CargoItem cargoItem:cargo){
            System.out.println(cargoItem.id + " " + cargoItem.name + " " + cargoItem.weight + " " + cargoItem.destination);
        }

    }
}

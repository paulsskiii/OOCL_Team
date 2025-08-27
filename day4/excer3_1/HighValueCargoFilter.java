package Exercise_3_1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class HighValueCargoFilter {
    public static void main(String[] args) {
        List<CargoItem> allCargo = Arrays.asList(
                new CargoItem(10, "Electronics", 100,100),
                new CargoItem(20, "Perishables", 200,10000.1),
                new CargoItem(30, "Machinery", 300,300),
                new CargoItem(40, "Textiles", 400,40000.0)
        );

        double threshold = 10000.0;

        // Filter and display logic
        List<CargoItem> filteredCargoThreshold = allCargo.stream()
                .filter(cargo -> cargo.value > threshold)
                .toList();

        System.out.print("Filtered cargo items with greater value than threshold: ");
        System.out.println(filteredCargoThreshold);
        for (CargoItem cargoItem : filteredCargoThreshold) {
            System.out.println("Cargo Name: " + cargoItem.name + " - Cargo Value: " + cargoItem.value);
        }
    }
}

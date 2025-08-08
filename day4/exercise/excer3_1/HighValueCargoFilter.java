import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class HighValueCargoFilter {
    public static void main(String[] args) {
        List<CargoItem> allCargo = Arrays.asList(
            // Cargo items
            new CargoItem(201, "Gold Bars", 100.0, 500000.0),
            new CargoItem(202, "Luxury Cars", 5000.0, 150000.0),
            new CargoItem(203, "General Goods", 2000.0, 8000.0),
            new CargoItem(204, "Art Collection", 50.0, 25000.0),
            new CargoItem(205, "Building Materials", 10000.0, 5000.0),
            new CargoItem(206, "Rare Manuscripts", 10.0, 12000.0)
        );

        double threshold = 10000.0;

        // Filter and display logic
        List<CargoItem> highValueCargo = allCargo.stream()
            .filter(item -> item.value > threshold)
            .collect(Collectors.toList());

        // System.out.println("High-value cargo items (value > $10,000):");
        // highValueCargo.forEach(System.out::println);

        for (CargoItem cargoItem : highValueCargo) {
            System.out.println("Cargo ID: " + cargoItem.id);
            System.out.println("Cargo Name: " + cargoItem.name);
            System.out.println("Cargo Weight: " + cargoItem.weight);
            System.out.println("Cargo Value: " + cargoItem.value);
            System.out.println("-----------------------------");
        }
    }
}

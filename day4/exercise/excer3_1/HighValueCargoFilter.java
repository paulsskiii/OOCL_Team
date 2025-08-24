package excer3_1;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class HighValueCargoFilter {
    public static void main(String[] args) {
        List<CargoItem> allCargo = Arrays.asList(
                // Cargo items
                new CargoItem(1, "Yes", 12.0, 5000),
                new CargoItem(2, "Yes", 12.0, 6000),
                new CargoItem(3, "No", 12.0, 1110000));

        double threshold = 10000.0;

        List<CargoItem> highValueCargo = allCargo.stream()
                .filter(cargoItem -> cargoItem.getValue() > threshold)
                .collect(Collectors.toList());

        System.out.println("High Value Cargo Items (value > " + threshold + "):");
        for (CargoItem item : highValueCargo) {
            System.out.println(item);
        }

    }
}

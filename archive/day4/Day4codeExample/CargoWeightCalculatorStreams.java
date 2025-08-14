// Calculating Total Cargo Weight (Stream Map & Reduce) Code Example
import java.util.Arrays;
import java.util.List;

class Cargo {
    String name;
    double weight; // in tons

    public Cargo(String name, double weight) {
        this.name = name;
        this.weight = weight;
    }

    public double getWeight() {
        return weight;
    }
}

public class CargoWeightCalculatorStreams {
    public static void main(String[] args) {
        List<Cargo> cargoList = Arrays.asList(
            new Cargo("Electronics", 50.5),
            new Cargo("Perishables", 20.0),
            new Cargo("Machinery", 150.75),
            new Cargo("Textiles", 30.25)
        );

        // Calculate total weight using streams
        double totalWeight = cargoList.stream()
                                    .mapToDouble(Cargo::getWeight) // Map to double stream
                                    .sum(); // Sum all weights

        System.out.println("Total Cargo Weight: " + totalWeight + " tons");
    }
}

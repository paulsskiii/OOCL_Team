import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.TreeSet; // For sorted unique elements
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class UniquePortExtractor {
    public static void main(String[] args) {
        List<String> cargoRoutes = Arrays.asList(
            "Manila -> Singapore",
            "Singapore -> Tokyo",
            "Manila -> Busan",
            "Busan -> Singapore",
            "Tokyo -> Hong Kong",
            "Manila -> Tokyo" // Duplicate port combinations, but new origin/destination ports
        );

        // Extract all unique port names
        cargoRoutes.stream()
        .flatMap(route -> Arrays.stream(route.split(" -> ")))
        .collect(Collectors.toSet())
        .forEach(System.out::println);
    }
}


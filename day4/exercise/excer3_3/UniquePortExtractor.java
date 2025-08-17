import java.util.Arrays;
import java.util.List;
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
        List<String> uniqueRoutes = cargoRoutes.stream()
        .flatMap(cargoRoute -> Arrays.stream(cargoRoute.split(" -> ")))
        .sorted()
        .distinct()
        .collect(Collectors.toList());

        uniqueRoutes.forEach(System.out::println);
    }
}


import java.util.*;
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
        List<String> uniquePort = cargoRoutes.stream()
                .flatMap(cargoRoute -> Arrays.stream(cargoRoute.split("->")))
                .map(String::trim)
                .distinct()
                .sorted()
                .toList();
        System.out.println(uniquePort);
    }
}


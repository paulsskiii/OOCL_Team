package excer3_3;

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

        List<String> uniquePorts = new ArrayList<>();

        cargoRoutes.stream()
                .flatMap(route -> Arrays.stream(route.split(" -> ")))
                .distinct()
                .sorted()
                .forEach(uniquePorts::add);

        System.out.println("Unique Ports: " + uniquePorts);
    }
}


import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.TreeSet; // For sorted unique elements
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
        
        List<String> uniquePortList = cargoRoutes.stream()
                                                .flatMap(route -> Arrays.stream(route.split(" -> ")))
                                                .sorted()
                                                .distinct()
                                                .collect(Collectors.toList());

        System.out.println("Unique Port List");
        for (String cargoRoute : uniquePortList) {
            System.out.println(cargoRoute);
        }
        
    }
}


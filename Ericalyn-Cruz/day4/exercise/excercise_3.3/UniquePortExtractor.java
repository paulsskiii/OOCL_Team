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

        List<String> uniquePortNames = cargoRoutes.stream().flatMap(route -> Arrays.stream(route.split(" -> "))).distinct().sorted().collect(Collectors.toList());

        uniquePortNames.forEach(System.out::println);
    
    }
}


import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors; // For sorted unique elements

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
        Set<String> uniquePorts = cargoRoutes.stream()
            .flatMap(port ->
                    Arrays.stream(port.split("->"))
                            .map(split -> split.replaceAll("\\s+","")))
            .sorted(Comparator.naturalOrder())
            .collect(Collectors.toCollection(LinkedHashSet::new));

        uniquePorts.forEach(System.out::println);
 
    }
}
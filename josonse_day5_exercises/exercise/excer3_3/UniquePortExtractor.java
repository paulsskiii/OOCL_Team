import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class UniquePortExtractor {
    public static void main(String[] args) {
        List<String> cargoRoutes = Arrays.asList(
                "Manila -> Singapore",
                "Singapore -> Tokyo",
                "Manila -> Busan",
                "Busan -> Singapore",
                "Tokyo -> Hong Kong",
                "Manila -> Tokyo"
        );

        Set<String> uniquePorts = cargoRoutes.stream()
                .flatMap(route -> Stream.of(route.split(" -> ")))
                .collect(Collectors.toSet());

        List<String> sortedPorts = new ArrayList<>(uniquePorts);
        Collections.sort(sortedPorts);

        System.out.println("Unique port names in alphabetical order:");
        for (String port : sortedPorts) {
            System.out.println(port);
        }
    }
//        String formattedOutput = String.format("%s", String.join(" | ", sortedPorts));
//        System.out.println(formattedOutput);
}

//    public static void main(String[] args) {
//        List<String> cargoRoutes = Arrays.asList(
//            "Manila -> Singapore",
//            "Singapore -> Tokyo",
//            "Manila -> Busan",
//            "Busan -> Singapore",
//            "Tokyo -> Hong Kong",
//            "Manila -> Tokyo" // Duplicate port combinations, but new origin/destination ports
//        );
//
//        // Extract all unique port names
//
//    }


package Exercise_3_3;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
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
                "Manila -> Tokyo" // Duplicate port combinations, but new origin/destination ports
        );

        // Extract all unique port names
        List<String[]> uniquePortLists = cargoRoutes.stream()
                .map(string -> string.split(" -> "))
//                .sorted()
//                .distinct()
                .toList();

        System.out.println(uniquePortLists);

//        List<String> uniquePorts = uniquePortLists.stream()
//                        .flatMap(Arrays::stream);
//
//        System.out.println(uniquePortLists);
    }
}

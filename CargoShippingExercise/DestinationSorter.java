// Sorting and Limiting Destination (Stream Sorted & Limit) Code Example
import java.util.Arrays;
import java.util.List;
import java.util.Comparator;
import java.util.stream.Collectors;

public class DestinationSorter {
    public static void main(String[] args) {
        List<String> destinations = Arrays.asList(
            "Manila", "Singapore", "Tokyo", "Hong Kong", "Busan", "Shanghai"
        );

        // Sort destinations alphabetically and get the first 3
        List<String> top3Destinations = destinations.stream()
                                                    .sorted(Comparator.naturalOrder()) // Sort alphabetically
                                                    .limit(3) // Take the first 3
                                                    .collect(Collectors.toList());

        System.out.println("Top 3 Destinations (Alphabetical):");
        top3Destinations.forEach(System.out::println);
    }
}

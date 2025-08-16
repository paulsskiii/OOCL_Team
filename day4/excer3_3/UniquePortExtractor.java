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

        Set<String> uniquePorts = new TreeSet<> ();

        uniquePorts = cargoRoutes.stream ()
            .flatMap (route -> Arrays.stream (route.split ("->")))
            .map (port -> port.trim ())
            .collect(Collectors.toSet ());

        System.out.println ("Unique ports from cargo routes: ");
        System.out.println (uniquePorts);


 
    }
}


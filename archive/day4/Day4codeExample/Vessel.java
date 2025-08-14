// Filtering Ships by Status (Lambda & Stream Filter) Code Example
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

class Vessel {
    String name;
    String status; // e.g., "Docked", "En Route", "Maintenance"

    public Vessel(String name, String status) {
        this.name = name;
        this.status = status;
    }

    public String getStatus() {
        return status;
    }

    @Override
    public String toString() {
        return "Vessel{" + "name='" + name + '\'' + ", status='" + status + '\'' + '}';
    }
}

public class ShipStatusFilter {
    public static void main(String[] args) {
        List<Vessel> vessels = Arrays.asList(
            new Vessel("Sea Serpent", "Docked"),
            new Vessel("Ocean Drifter", "En Route"),
            new Vessel("Star Gazer", "Maintenance"),
            new Vessel("Pacific Pearl", "Docked")
        );

        // Using stream to filter docked vessels
        List<Vessel> dockedVessels = vessels.stream()
                                            .filter(v -> v.getStatus().equals("Docked"))
                                            .collect(Collectors.toList());

        System.out.println("Docked Vessels:");
        dockedVessels.forEach(System.out::println); // Using method reference
    }
}

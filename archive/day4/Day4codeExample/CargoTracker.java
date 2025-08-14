// Tracking Unique Cargo IDs (HashSet)

import java.util.HashSet;
import java.util.Set;

public class CargoTracker {
    public static void main(String[] args) {
        Set<String> cargoTrackingNumbers = new HashSet<>();
        cargoTrackingNumbers.add("TRK12345");
        cargoTrackingNumbers.add("TRK67890");
        cargoTrackingNumbers.add("TRK12345"); // Duplicate, will not be added

        System.out.println("Unique Tracking Numbers:");
        for (String trackingNumber : cargoTrackingNumbers) {
            System.out.println(trackingNumber);
        }

        System.out.println("Contains TRK67890? " + cargoTrackingNumbers.contains("TRK67890"));
        System.out.println("Contains TRK99999? " + cargoTrackingNumbers.contains("TRK99999"));
    }
}

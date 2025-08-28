import java.util.Arrays;
import java.util.List;
import java.util.OptionalDouble;

public class AverageShipSpeed {
    public static void main(String[] args) {
        List<Ship> ships = Arrays.asList(
            new Ship("Sea Serpent", 25.5),
            new Ship("Ocean Drifter", 22.0),
            new Ship("Star Gazer", 18.0),
            new Ship("Pacific Pearl", 30.0)
            // ,new Ship("Pacific Pearl", -2230.0)
        );

        // Calculate average max speed
        try {
            double avgSpeed = ships.stream ()
                .mapToDouble (ship -> ship.getMaxSpeedKnot ())
                .average ()
                .orElse(0.0);

            if (avgSpeed == 0.0) throw new IllegalArgumentException ("Ship List is empty");
            else if (avgSpeed < 0) throw new IllegalArgumentException ("Ship average is negative. Please recheck values");
            System.out.println ("Average speed of ships (in knots): " + avgSpeed);
        } catch (IllegalArgumentException e) {
            System.out.println (e.getMessage ());
        } finally {
            System.out.println ("\nProgram has ended.");
        }
        // Test with an empty list
    }
}
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class PortCapacityTracker {
    public static void main(String[] args) {
        Map<String, Port> ports = new HashMap<>();
        Scanner input = new Scanner(System.in);

        ports.put("Manila", new Port("Manila", 5,
                "Titanic"));
        ports.put("Singapore", new Port("Singapore", 6,
                "Kopitiam"));
        ports.put("Tokyo", new Port("Tokyo", 4,
                "Monkey Ship", "Going Merry", "Shinigami", "Shinkansen"));  // port w/ max capacity
        ports.put("India", new Port("India", 2));     // port not occupied

        // Simulation logic here
        System.out.println("Choose a port: ");
        ports.keySet().forEach(System.out::println);
        Port selectedPort = ports.get(input.nextLine());

        System.out.println("\nCurrent ships in selected port: ");
        System.out.println(selectedPort.getCurrentShips());

        System.out.println("\nChoose whether to add or remove a ship to/from port: ");
        String inputAddRemove = input.nextLine().toLowerCase();

        if("add".equals(inputAddRemove)) {
            System.out.println("Input name of ship to add: ");
            selectedPort.addShip(input.nextLine());

        } else if ("remove".equals(inputAddRemove)) {
            System.out.println("Input name of ship to remove: ");
            selectedPort.removeShip(input.nextLine());
        }

        input.close();
    }
}

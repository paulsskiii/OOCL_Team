package excer1_2;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class DispatchedShipTracker {
    public static void main(String[] args) {
        Set<String> dispatchedShips = new HashSet<>();
        Scanner input = new Scanner(System.in);

        // Add ship names
        dispatchedShips.add("Going Merry");
        dispatchedShips.add("Titanic");
        dispatchedShips.add("Going Merry");
        dispatchedShips.add("Monkey Ship");

        // Check for ship presence
        System.out.println("Dispatched Ships: ");
        dispatchedShips.stream().forEach(System.out::println);
        System.out.println();
        System.out.println("Enter a ship name to check if it is dispatched: ");
        String inputShipName = input.nextLine();

        dispatchedShips.stream()
                .filter(s -> s.equals(inputShipName))
                .findFirst()
                .ifPresentOrElse(ship -> System.out.println(ship + " has been dispatched"), () -> System.out.println("Ship not found"));

        input.close();
    }
}

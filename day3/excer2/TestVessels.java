package OOCL_Team.day3.excer2;

import java.util.ArrayList;
import java.util.List;

public class TestVessels {
    public static void main(String[] args) {
        // Starting code for testing ships
        List<Ship> shipList = new ArrayList<>();
        shipList.add(new Ship("The Wanderer", "Alice Smith", 15.0, 75));
        shipList.add(new Tanker("Ocean Giant", "Bob Johnson", 12.5, 90, "Crude Oil"));
        shipList.add(new ContainerShip("Maersk Mc-Kinney Møller", "Charlie Brown", 20.0, 80, 18000));

        for (Ship ship : shipList) {
            System.out.println("======= Ship Info =======");
            ship.displayShipInfo();
        }
    }
}

package Java34.OOCL_Team;

import Java34.OOCL_Team.Ship;

public class TestVessels {

    public static void main(String[] args) {

        Ship[] ships = new Ship[3];

        // Add instances to the array
        ships[0] = new ContainerShip("Downtown", "Caoal", 1.01, 89, 21);
        ships[1] = new Tanker("Downtown", "Cao", 1.01, 50, "Dangerous");
        ships[2] = new Ship("Downtown","Alexis",25.0,100);

        for (Ship ship : ships) {
            ship.displayShipInfo();
        }

    }
}
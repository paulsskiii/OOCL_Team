public class TestVessels {
    public static void main(String[] args) {
        ShipRepository repo = new ShipRepository();

        Ship genericShip = new Ship("The Wanderer", "Alice Smith", 15.0, 75);
        Tanker oilTanker = new Tanker("Ocean Giant", "Bob Johnson", 12.5, 90, "Crude Oil");
        ContainerShip maerskTripleE = new ContainerShip("Maersk Mc-Kinney Møller", "Charlie Brown", 20.0, 80, 18000);

        repo.addShip(genericShip);
        repo.addShip(oilTanker);
        repo.addShip(maerskTripleE);

        for (Ship ship : repo.getAllShips()) {
            System.out.println("------------");
            ship.displayShipInfo();
        }
    }
}

package Exercise2;
import Java34.OOCL_Team.Exercise2.ShipWorker;

public class ShipCaller {
    public static void main (String[] args) {
        ShipWorker ship = new ShipWorker("OOP Ship", "Captain Ship", 14, 50);
        ship.displayShipInfo ();

        Tanker tanker = new Tanker("OOP Java34.OOCL_Team.Exercise2.Tanker", "Captain Tank", 20, 76, "Oil");
        tanker.displayShipInfo();
    }
}

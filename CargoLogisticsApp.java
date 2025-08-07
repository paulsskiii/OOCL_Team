package Java34.OOCL_Team;

import Java34.OOCL_Team.model.Ship;
import Java34.OOCL_Team.model.Shipment;

public class CargoLogisticsApp {
    public static void main(String[] args) {

        Ship c1 = new Ship("1234", "Manila", "China", "Pending",
                "Dangerous", 10);

        Ship c2 = new Ship("4562", "Manila", "China", "Delivered",
                "Awkward", 20);

        System.out.println("Initial Details");
        System.out.println(c1.getShipmentDetails());

        c1.setShipName("ESA");
        System.out.println("Loading to CargoShip");
        c1.loadCargo(c1);

        c2.setShipName("CMA");
        c1.setStatus("In-transit");
        System.out.println("Shipment Status: In-transit" + c1.getStatus());

        System.out.println("Unloading to Destination ");
        c2.unloadCargo(c2);

        c1.setStatus("Delivered");
        System.out.println("Shipment Status: Delivered" + c1.getStatus());
        System.out.println(c1.getShipmentDetails());

        System.out.println();
        if (c1.getStatus().equals("Delivered")) {
            System.out.println("ShipmentID: " +  c1.getShipmentId() + " is successfully delivered." );
        }else  {
            System.out.println("ShipmentID: " +  c1.getShipmentId() + " currently " + c1.getStatus());
        }
    }
}

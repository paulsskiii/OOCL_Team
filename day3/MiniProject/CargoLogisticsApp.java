package Java34.OOCL_Team.MiniProject;

public class CargoLogisticsApp {
    public static void main(String[] args) {
        Shipment shipment1 = new Shipment("BKG7224022430", "Port of Manila", "Piraeus Port", "Pending", "20 Packages of Gundam Plastic Models", 220.75);
        Shipment shipment2 = new Shipment("BKG7224022434", "Port of Singapore", "Port of Vegas", "Pending", "Laptop Delivery", 100.50);

        CargoShip cargoShip1 = new CargoShip("MS STAR 25", "Capt. Joel Joseph", 30.0, 80);
        CargoShip cargoShip2 = new CargoShip("MV PHOENIX 1", "Capt. Barry", 30.0, 90);

        System.out.println(shipment1.getShipmentDetails());
        cargoShip1.loadCargo(shipment1);
        shipment1.setStatus("In Transit");
        cargoShip1.unloadCargo(shipment1);
        shipment1.setStatus("Delivered");
        System.out.println("\n" + shipment1.getShipmentDetails() + "\n");

        if (shipment1.getStatus().equals("Delivered"))
            System.out.println("Shipment ID: " + shipment1.getShipmentId() + " is currently Delivered.");
        else
            System.out.println("Shipment ID: " + shipment1.getShipmentId() + " is currently " + shipment1.getStatus() + ".");

        System.out.println(shipment2.getShipmentDetails());
        cargoShip2.loadCargo(shipment2);
        shipment2.setStatus("In Transit");
        cargoShip2.unloadCargo(shipment1);
        shipment2.setStatus("Delivered");
        System.out.println("\n" + shipment2.getShipmentDetails() + "\n"); 
    }
}

package Java34.OOCL_Team.miniproject;

public class CargoLogisticsApp {
    public static void main(String[] args) {
        Shipment shipment = new Shipment("Laptop delivery", "Manila", "China", "Pending", "test", 1000.50);

        System.out.println(shipment.getShipmentId());
        System.out.println(shipment.getOriginPort());
        System.out.println(shipment.getDestinationPort());
        System.out.println(shipment.getStatus());
        System.out.println(shipment.getCargoDescription());
        System.out.println(shipment.getDeclaredValue());

        shipment.setStatus("In Transit");
        System.out.println(shipment.getStatus());
        System.out.println(shipment.getShipmentDetails());
    }
}

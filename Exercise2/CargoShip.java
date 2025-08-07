package Java34.OOCL_Team.Exercise2;

import Java34.OOCL_Team.MiniProject.Shipment;

public class CargoShip extends ShipWorker {
    public CargoShip(String shipName, String captainName, double speedKnots, int fuelLevelPercentage) {
        super(shipName, captainName, speedKnots, fuelLevelPercentage);
    }

    public void loadCargo(Shipment shipment) {
        System.out.println("Loading Shipment " + shipment.getShipmentId() + " to " + getShipName());
    }

    public void unloadCargo(Shipment shipment) {
        System.out.println("Unloading Shipment " + shipment.getShipmentId() + " from " + getShipName());
    }
}
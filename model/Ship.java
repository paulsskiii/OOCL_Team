package Java34.OOCL_Team.model;

public class Ship extends Shipment{
    private String shipName;
    private String captainName;
    private double speedKnots;
    private int fuelLevelPercentage;

    public Ship(String shipmentId, String originPort, String destinationPort, String status) {
        super(shipmentId, originPort, destinationPort, status);
    }

    public String getShipName() {
        return shipName;
    }
    public void setShipName(String shipName) {
        this.shipName = shipName;
    }
    public String getCaptainName() {
        return captainName;
    }
    public void setCaptainName(String captainName) {
        this.captainName = captainName;
    }
    public double getSpeedKnots() {
        return speedKnots;
    }
    public void setSpeedKnots(double speedKnots) {
        this.speedKnots = speedKnots;
    }
    public int getFuelLevelPercentage() {
        return fuelLevelPercentage;
    }
    public void setFuelLevelPercentage(int fuelLevelPercentage) {
        if (fuelLevelPercentage > 0 && fuelLevelPercentage < 100)
            this.fuelLevelPercentage = fuelLevelPercentage;
        else
            System.out.println("Error: Fuel level must be between 0 and 100 percent.");
    }

    public void loadCargo(Shipment shipment){
        System.out.println("Loading Shipment " + shipment.getShipmentId() + " to " + this.shipName);
    }

    public void unloadCargo(Shipment shipment){
        System.out.println("Unloading Shipment " + shipment.getShipmentId() + " to " + this.shipName);
    }
}

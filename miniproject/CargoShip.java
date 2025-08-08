package Java34.OOCL_Team.miniproject;

public class CargoShip extends Shipment {

    private String shipName;
    private String captainName;
    private double speedKnots;
    private int fuelLevelPercentage;

    public CargoShip(String shipmentId,
                     String originPort,
                     String destinationPort,
                     String status,
                     String cargoDescription,
                     double declaredValue) {
        super(shipmentId, originPort, destinationPort, status, cargoDescription, declaredValue);
    }

    public String getShipname(){
        return this.shipName;
    }

    public void setShipname(String shipName){
        this.shipName = shipName;
    }

    public void setCaptainName(String captainName){
        this.captainName = captainName;
    }

    public String getCaptainName(){
        return this.captainName;
    }

    public void setSpeedKnots(double speedKnots){
        this.speedKnots = speedKnots;
    }

    public double getSpeedKnots(){
        return this.speedKnots;
    }

    public void setFuelLevelPercentage(int fuelLevelPercentage){
        this.fuelLevelPercentage = fuelLevelPercentage;
    }

    public int getFuelLevelPercentage(){
        return this.fuelLevelPercentage;
    }

//    public void displayShipInfo(){
//        System.out.println("hello world");
//    }

    public void loadCargo(Shipment shipment) {
        System.out.println("Loading Shipment " + shipment.getShipmentId() + " to " + getShipname());
    }

    public void unloadCargo(Shipment shipment) {
        System.out.println("Unloading Shipment " + shipment.getShipmentId() + " from " + getShipname());
    }

}

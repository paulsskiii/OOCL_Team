public class CargoLogisticsApp {
    public static void main(String[] args){
        Shipment shipment1 = new Shipment("1", "Manila", "Busan", "Pending", "Electronics delivery", 10000.0);
        Shipment shipment2 = new Shipment("2", "Tokyo", "Hong Kong", "Pending", "Furniture delivery", 5000.0);

        CargoShip cargoShip1 = new CargoShip("Cargo Ship 1", "Captain Hook", 20, 80);
        CargoShip cargoShip2 = new CargoShip("Cargo Ship 2", "Captain Jack", 200, 40);

        Shipment laptopShipment = new Shipment("3", "Singapore", "Manila", "Pending", "Laptop delivery", 100.0);

        cargoShip1.loadCargo(laptopShipment);
        laptopShipment.setStatus("In Transit");
        System.out.println(laptopShipment.getShipmentDetails());

        cargoShip1.unloadCargo(laptopShipment);
        laptopShipment.setStatus("Delivered");
        System.out.println(laptopShipment.getShipmentDetails());

        if(laptopShipment.getStatus().equals("Delivered")){
            System.out.println("Shipment ID: " + laptopShipment.getShipmentId() + " is currently " +  laptopShipment.getStatus());
        } else if(laptopShipment.getStatus().equals("Pending")){
            System.out.println("Shipment ID: " + laptopShipment.getShipmentId() + " is currently " +  laptopShipment.getStatus());
        } else if(laptopShipment.getStatus().equals("In Transit")){
            System.out.println("Shipment ID: " + laptopShipment.getShipmentId() + " is currently " +  laptopShipment.getStatus());
        }
    }
}

public class CargoShip extends Ship {

    public CargoShip(String shipName, String captainName, double speedKnots, int fuelLevelPercentage) {
        super(shipName, captainName, speedKnots, fuelLevelPercentage);
    }

    public void loadCargo(Shipment shipment) {
        System.out.println("Loading Shipment " + shipment.getShipmentId() + " to " + getShipName());
        shipment.setStatus("Loaded on " + getShipName());
    }

    public void unloadCargo(Shipment shipment) {
        System.out.println("Unloading Shipment " + shipment.getShipmentId() + " from " + getShipName());
        shipment.setStatus("Unloaded from " + getShipName());
    }
}

public class Ship {
    private String shipName;
    private String captainName;
    private double speedKnots;
    private int fuelLevelPercentage;

    public Ship(String shipName, String captainName, double speedKnots, int fuelLevelPercentage) {
        this.shipName = shipName;
        this.captainName = captainName;
        this.speedKnots = speedKnots;
        setFuelLevelPercentage(fuelLevelPercentage);
    }

    public String getShipName() {
        return this.shipName;
    }

    public void setFuelLevelPercentage(int fuelLevelPercentage) {
        if(fuelLevelPercentage < 0 || fuelLevelPercentage > 100) {
            throw new IllegalArgumentException("Fuel level percentage must be between 0 and 100");
        }
        this.fuelLevelPercentage = fuelLevelPercentage;
    }

    public void displayShipInfo () {
        System.out.println("Ship Name: " + this.shipName);
        System.out.println("Captain Name: " + this.captainName);
        System.out.println("Speed Knots: " + this.speedKnots);
        System.out.println("Fuel Level Percentage: " + this.fuelLevelPercentage);
    }
}

public class Shipment{
    private String shipmentId; //should be read-only
    private String originPort;
    private String destinationPort;
    private String status;
    private String cargoDescription;
    private double declaredValue;

    public Shipment(String shipmentId, String originPort, String destinationPort, String status, String cargoDescription, double declaredValue){
        this.shipmentId = shipmentId;
        this.originPort = originPort;
        this.destinationPort = destinationPort;
        this.status = status;
        this.cargoDescription = cargoDescription;
        this.declaredValue = declaredValue;
    }

    public String getShipmentId(){
        return shipmentId;
    }

    public String getOriginPort(){
        return originPort;
    }

    public String getDestinationPort(){
        return destinationPort;
    }

    public String getStatus(){
        return status;
    }

    public String getCargoDescription(){
        return cargoDescription;
    }

    public double getDeclaredValue(){
        return declaredValue;
    }

    public void setStatus(String status){
        this.status = status;
    }
    
    public String getShipmentDetails(){
        String shipmentDetails = String.format(
            """
            Shipment ID: %s%n
            Origin Port: %s%n
            Destination Port: %s%n
            Status: %s%n
            Cargo Description: %s%n
            Declared Value: %f%n
            """,
            getShipmentId(), getOriginPort(), getDestinationPort(), getStatus(), getCargoDescription(), getDeclaredValue()
        );

        return shipmentDetails;
    } 

 

    /*
     * 
     * use this if no need for a return function
     * 
     * 
        public void getShipmentDetails(){

            System.out.printf(
                """
                Shipment ID: %s%n
                Origin Port: %s%n
                Destination Port: %s%n
                Status: %s%n
                Cargo Description: %s%n
                Declared Value: %f%n
                """,
                getShipmentId(), getOriginPort(), getDestinationPort(), getStatus(), getCargoDescription(), getDeclaredValue());
            } 
     */
}
package Java34.OOCL_Team.MiniProject;

public class Shipment {
    private final String shipmentId;
    private String origin;
    private String destinationPort;
    private String status;
    private String cargoDescription;
    private double declaredValue;

    public Shipment(String shipmentId) {
        this.shipmentId = shipmentId;
    }

    public Shipment(String shipmentId, String origin, String destinationPort, String status, String cargoDescription, double declaredValue) {
        this.shipmentId = shipmentId;
        this.origin = origin;
        this.destinationPort = destinationPort;
        this.status = status;
        this.cargoDescription = cargoDescription;
        this.declaredValue = declaredValue;
    }

    //getters
    public String getShipmentId() {
        return this.shipmentId;
    }

    public String getOriginPort() {
        return this.origin;
    }

    public String getDestinationPort() {
        return this.destinationPort;
    }

    public String getStatus() {
        return this.status;
    }

    public String getCargoDescription(){
        return this.cargoDescription;
    }

    public double getDeclaredValue(){
        return this.declaredValue;
    }

    //setters
    private void setOrigin (String origin) {
        this.origin = origin;
    }

    private void setDestinationPort (String destinationPort) {
        this.destinationPort = destinationPort;
    }

    public void setStatus (String status) {
        this.status = status;
    }

    private void setCargoDescription (String cargoDescription) {
        this.cargoDescription = cargoDescription;
    }

    private void setDeclaredValue (int declaredValue) {
        this.declaredValue = declaredValue;
    }

    public String getShipmentDetails () {
        String shipmentDetails = "";

        shipmentDetails = "Shipment ID: " + getShipmentId () + " | Origin Port: " + getOriginPort () + " | Destination Port: " + getDestinationPort () +
        " | Status: " + getStatus () + " | Cargo Desc: " + getCargoDescription () + " | Declared Value: " + getDeclaredValue ();

        return shipmentDetails;
    }
}

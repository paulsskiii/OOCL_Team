public class Shipment {
    private final String shipmentId; // read-only after creation
    private String originPort;
    private String destinationPort;
    private String status;
    private String cargoDescription;
    private double declaredValue;

    // Constructor to initialize all attributes
    public Shipment(String shipmentId, String originPort, String destinationPort, String status, String cargoDescription, double declaredValue) {
        this.shipmentId = shipmentId;
        this.originPort = originPort;
        this.destinationPort = destinationPort;
        this.status = status;
        this.cargoDescription = cargoDescription;
        this.declaredValue = declaredValue;
    }

    // Public getter methods for all attributes
    public String getShipmentId() {
        return shipmentId;
    }
    public String getOriginPort() {
        return originPort;
    }
    public String getDestinationPort() {
        return destinationPort;
    }
    public String getStatus() {
        return status;
    }
    public String getCargoDescription() {
        return cargoDescription;
    }
    public double getDeclaredValue() {
        return declaredValue;
    }

    // Public setter for status only
    public void setStatus(String status) {
        this.status = status;
    }

    // Method to return formatted shipment details
    public String getShipmentDetails() {
        return String.format(
            "Shipment ID: %s\nOrigin Port: %s\nDestination Port: %s\nStatus: %s\nCargo Description: %s\nDeclared Value: %.2f",
            shipmentId, originPort, destinationPort, status, cargoDescription, declaredValue
        );
    }
}
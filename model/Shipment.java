package Java34.OOCL_Team.model;

public class Shipment {
    private String shipmentId;
    private String originPort;
    private String destinationPort;
    private String status;
    private String cargoDescription;
    private double declaredValue;

    public Shipment() {
    }

    public Shipment(String shipmentId, String originPort, String destinationPort, String status,String cargoDescription,double declaredValue) {
        this.shipmentId = shipmentId;
        this.originPort = originPort;
        this.destinationPort = destinationPort;
        this.status = status;
        this.cargoDescription = cargoDescription;
        this.declaredValue = declaredValue;
    }

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

    private String getCargoDescription() {
        return cargoDescription;
    }

    private double getDeclaredValue() {
        return declaredValue;
    }

    private void setShipmentId(String shipmentId) {
        this.shipmentId = shipmentId;
    }

    private void setOriginPort(String originPort) {
        this.originPort = originPort;
    }

    private void setDestinationPort(String destinationPort) {
        this.destinationPort = destinationPort;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    private void setCargoDescription(String cargoDescription) {
        this.cargoDescription = cargoDescription;
    }

    private void setDeclaredValue(double declaredValue) {
        this.declaredValue = declaredValue;
    }

    public String getShipmentDetails() {
        return String.format("Shipment ID: %s, Origin Port: %s, Destination Port: %s, Status: %s, Cargo Description: %s, Declared Value: %.2f "
                ,shipmentId,originPort,destinationPort,status,cargoDescription,declaredValue);
    }
}

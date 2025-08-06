package Java34.OOCL_Team;

public class Shipment {
    private String shipmentId;
    private String originPort;
    private String destinationPort;
    private String status;

    public Shipment(String shipmentId, String originPort, String destinationPort, String status) {
        this.shipmentId = shipmentId;
        this.originPort = originPort;
        this.destinationPort = destinationPort;
        this.status = status;
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

    public void getShipmentDetails(String shipmentId, String originPort, String destinationPort, String status) {
        System.out.println("Shipment ID: {shipmentId}, Origin Port: {originPort}, Destination Port: {destinationPort}, Status: {status}");
    }
}

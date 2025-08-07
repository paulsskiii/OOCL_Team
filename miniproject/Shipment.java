package Java34.OOCL_Team.miniproject;

public class Shipment {
    private final  String shipmentId;
    private  String originPort;
    private  String destinationPort;
    private  String status;
    private  String cargoDescription;
    private  double declaredValue;

    public Shipment (String shipmentId, String originPort, String destinationPort, String status, String cargoDescription, double declaredValue){
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

    public String getCargoDescription() {
        return cargoDescription;
    }

    public double getDeclaredValue() {
        return declaredValue;
    }

//    private void setShipmentId(String shipmentId) {
//        this.shipmentId = shipmentId;
//    }

    private void setOriginPort(String originPort) {
        this.originPort = originPort;
    }

    private void setDestinationPort (String destinationPort) {
        this.destinationPort= destinationPort;
    }

    public void setStatus(String status) {
        this.status= status;
    }

    private void setCargoDescription (String cargoDescription) {
        this.cargoDescription= cargoDescription;
    }

    private void setDeclaredValue (Double declaredValue) {
        this.declaredValue = declaredValue;
    }

    public String getShipmentDetails () {
        return "Shipment ID: " + getShipmentId() + "\n" +
                "Origin Port: " + getOriginPort() + "\n" +
                "Destination Port: " + getDestinationPort() + "\n" +
                "Status: " + getStatus() + "\n" +
                "Cargo Description: " + getCargoDescription() + "\n" +
                "Declared Value: " + getDeclaredValue() + "\n";
    }
}

package Java34.OOCL_Team.Exercise3;

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
}

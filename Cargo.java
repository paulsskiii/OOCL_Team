
public class Cargo {
    private String cargoType;
    private String trackingNumber;
    private String currentLocation;
    private int estimatedDeliveryDays;
    private boolean isDelivered;
    private double weightKg;

    public Cargo() {}

    public Cargo(String cargoType, String trackingNumber, String currentLocation, int estimatedDeliveryDays, boolean isDelivered, double weightKg) {
        this.cargoType = cargoType;
        this.trackingNumber = trackingNumber;
        this.currentLocation = currentLocation;
        this.estimatedDeliveryDays = estimatedDeliveryDays;
        this.isDelivered = isDelivered;
        this.weightKg = weightKg;
    }
}

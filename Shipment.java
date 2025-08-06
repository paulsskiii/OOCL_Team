package OOCL_Team;

public class Shipment {
    private String cargoType;
    private long trackingNumber;
    private String currentLocation;
    private int estimatedDeliveryDays;
    private boolean isDelivered;
    
    public String getCargoType() {
        return cargoType;
    }
    public void setCargoType(String cargoType) {
        this.cargoType = cargoType;
    }
    public long getTrackingNumber() {
        return trackingNumber;
    }
    public void setTrackingNumber(long trackingNumber) {
        this.trackingNumber = trackingNumber;
    }
    public String getCurrentLocation() {
        return currentLocation;
    }
    public void setCurrentLocation(String currentLocation) {
        this.currentLocation = currentLocation;
    }
    public int getEstimatedDeliveryDays() {
        return estimatedDeliveryDays;
    }
    public void setEstimatedDeliveryDays(int estimatedDeliveryDays) {
        this.estimatedDeliveryDays = estimatedDeliveryDays;
    }
    public boolean isDelivered() {
        return isDelivered;
    }
    public void setDelivered(boolean isDelivered) {
        this.isDelivered = isDelivered;
    }

    
}

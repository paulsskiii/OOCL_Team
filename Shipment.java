public class Shipment {
    private String cargoType;
    private String trackingNumber;
    private String currentLocation;
    private int estimatedDeliveryDays;
    private boolean isDelivered;
    private double weightKg;
    
    public String getCargoType() {
        return cargoType;
    }
    public void setCargoType(String cargoType) {
        this.cargoType = cargoType;
    }
    public String getTrackingNumber() {
        return trackingNumber;
    }
    public void setTrackingNumber(String trackingNumber) {
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
    public double getWeightKg() {
        return weightKg;
    }
    public void setWeightKg(double weightKg) {
        this.weightKg = weightKg;
    }

    

    
}

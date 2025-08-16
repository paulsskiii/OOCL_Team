package Java34.OOCL_Team;

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

    public void setCargoType(String cargoType){
        this.cargoType = cargoType;
    }

    public String getCargoType(){
        return this.cargoType;
    }

    public void setTrackingNumber(String trackingNumber){
        this.trackingNumber = trackingNumber;
    }

    public String getTrackingNumber(){
        return this.trackingNumber;
    }

    public void setCurrentLocation(String currentLocation){
        this.currentLocation = currentLocation;
    }

    public String getCurrentLocation(){
        return this.currentLocation;
    }

    public void setEstimatedDeliveryDays(int estimatedDeliveryDays){
        this.estimatedDeliveryDays = estimatedDeliveryDays;
    }

    public int getEstimatedDeliveryDays(){
        return this.estimatedDeliveryDays;
    }

    public void setDelivered (boolean isDelivered){
        this.isDelivered = isDelivered;
    }

    public boolean isDelivered(){
        return this.isDelivered;
    }

    public void setWeightKg (double weightKg){
        this.weightKg = weightKg;
    }

    public double getWeightKg(){
        return this.weightKg;
    }
}

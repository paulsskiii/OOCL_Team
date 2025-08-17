public class Cargo {
    private String cargoType;
    private String trackingNumber;
    private String currentLocation;
    private int estimatedDeliveryDays;
    private boolean isDelivered;
    private double weight;

    public void setCargoType(String cargoType){
        this.cargoType = cargoType;
    }

    public String getCargoType(){
        return cargoType;
    }

    public void setTrackingNumber(String trackingNumber){
        this.trackingNumber = trackingNumber;
    }

    public String getTrackingNumber(){
        return trackingNumber;
    }

    public void setCurrentLocation(String currentLocation){
        this.currentLocation = currentLocation;
    }

    public String getCurrentLocation(){
        return currentLocation;
    }

    public void setEstimatedDeliveryDays(int estimatedDeliveryDays){
        this.estimatedDeliveryDays = estimatedDeliveryDays;
    }

    public int getEstimatedDeliveryDays(){
        return estimatedDeliveryDays;
    }

    public void setDelivered (boolean isDelivered){
        this.isDelivered = isDelivered;
    }

    public boolean isDelivered(){
        return isDelivered;
    }

    public void setWeight (double weight){
        this.weight = weight;
    }

    public double getWeight(){
        return weight;
    }
}
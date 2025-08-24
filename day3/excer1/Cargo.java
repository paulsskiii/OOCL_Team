package day3.excer1;


public class Cargo {
    private int id;
    private String cargoType;
    private Long cargoNumber;
    private String currentLocation;
    private int estimatedDeliveryDays;
    private Boolean isDelivered;
    private float weightKg;
     
    public Cargo(int id, String cargoType, Long cargoNumber, String currentLocation, int estimatedDeliveryDays, Boolean isDelivered, float weightKg) {
        this.id = id;
        this.cargoType = cargoType;
        this.cargoNumber = cargoNumber;
        this.currentLocation = currentLocation;
        this.estimatedDeliveryDays = estimatedDeliveryDays;
        this.isDelivered = isDelivered;
        this.weightKg = weightKg;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCargoType() {
        return cargoType;
    }

    public void setCargoType(String cargoType) {
        this.cargoType = cargoType;
    }

    public Long getCargoNumber() {
        return cargoNumber;
    }

    public void setCargoNumber(Long cargoNumber) {
        this.cargoNumber = cargoNumber;
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

    public Boolean getIsDelivered() {
        return isDelivered;
    }

    public void setIsDelivered(Boolean isDelivered) {
        this.isDelivered = isDelivered;
    }

    public float getWeightKg() {
        return weightKg;
    }

    public void setWeightKg(float weightKg) {
        this.weightKg = weightKg;
    }

    public String checkEstimatedDays(){
        if(estimatedDeliveryDays >= 3){
            return "Express delivery! Expected in " +estimatedDeliveryDays+ " days";
        }
        if(estimatedDeliveryDays < 4 && estimatedDeliveryDays > 7){
           return "Express delivery! Expected in " +estimatedDeliveryDays+ " days";
        }
        return "Long haul delivery. Expected "+estimatedDeliveryDays+" days";
    }
}

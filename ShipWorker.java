public class ShipWorker {
    private String shipName;
    private String captainName;
    private double speedKnots;
    private int fuelLevelPercentage;

    // setter
    public void setShipName(String shipName) {
        this.shipName = shipName;
    }

    public void setCaptainName(String captainName) {
        this.captainName = captainName;
    }
    public void setSpeedKnots(double speedKnots) {
        this.speedKnots = speedKnots;
    }
    public void setFuelLevelPercentage(int fuelLevelPercentage) {
        this.fuelLevelPercentage = fuelLevelPercentage;
    }

    // getter
    public String getShipName() {
        return this.shipName;
    }

    public String getCaptainName() {
        return this.captainName;
    }

    public double getSpeedKnots() {
        return this.speedKnots;
    }

    public int getFuelLevelPercentage() {
        return this.fuelLevelPercentage;
    }
    
}

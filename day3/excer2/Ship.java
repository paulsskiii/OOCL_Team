public class Ship {
    private String shipName;
    private String captainName;
    private double speedKnots;
    private int fuelLevelPercentage;

    public Ship(String shipName, String captainName, double speedKnots, int fuelLevelPercentage) {
        this.shipName = shipName;
        this.captainName = captainName;
        this.speedKnots = speedKnots;
        setFuelLevelPercentage(fuelLevelPercentage); // Use setter for validation
    }

    public String getShipName() {
        return shipName;
    }

    public void setShipName(String shipName) {
        this.shipName = shipName;
    }

    public String getCaptainName() {
        return captainName;
    }

    public void setCaptainName(String captainName) {
        this.captainName = captainName;
    }

    public double getSpeedKnots() {
        return speedKnots;
    }

    public void setSpeedKnots(double speedKnots) {
        this.speedKnots = speedKnots;
    }

    public int getFuelLevelPercentage() {
        return fuelLevelPercentage;
    }

    public void setFuelLevelPercentage(int fuelLevelPercentage) {
        if(fuelLevelPercentage < 0 || fuelLevelPercentage > 100){
            System.err.println("Fuel level cannot be less than 0 or greater than 100");
        }
        this.fuelLevelPercentage = fuelLevelPercentage;
    }

    public String displayShipInfo(){
        return "Ship shipName=" + this.shipName + ", captainName=" + this.captainName + ", speedKnots=" + this.speedKnots
                + ", fuelLevelPercentage=" + this.fuelLevelPercentage;
    }
}
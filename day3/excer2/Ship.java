public class Ship {
    protected String shipName;
    protected String captainName;
    protected double speedKnots;
    protected int fuelLevelPercentage;

    public Ship(String shipName, String captainName, double speedKnots, int fuelLevelPercentage) {
        this.shipName = shipName;
        this.captainName = captainName;
        this.speedKnots = speedKnots;
        setFuelLevelPercentage(fuelLevelPercentage); // Use setter for validation
    }

    //Getters
    public String getShipName() {
        return shipName;
    }

     public String getCaptainName() {
        return captainName;
    }

    public double getSpeedKnots() {
        return speedKnots;
    }
    
    public int getFuelLevelPercentage() {
        return fuelLevelPercentage;
    }

    //Setters
    
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
        if(fuelLevelPercentage > 0 && fuelLevelPercentage < 100){
            this.fuelLevelPercentage = fuelLevelPercentage;
        }
        // System.out.println("Error! Value should be between 0 and 100");
        // this.fuelLevelPercentage = fuelLevelPercentage;
    }

    public String displayShipInfo(){
        return String.format("Ship Name: %s, Captain Name: %s, Speed Knots: %f, Fuel Level Percentage: %d", shipName,captainName,speedKnots,fuelLevelPercentage);
    }
    
}
public class Ship {
    private String shipName;
    private String captainName;
    private double speedKnots;
    private int fuelLevelPercentage;

    public Ship(String shipName, String captainName, double speedKnots, int fuelLevelPercentage) {
        this.shipName = shipName;
        this.captainName = captainName;
        this.speedKnots = speedKnots;
        setFuelLevelPercentage(fuelLevelPercentage);
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
        if(fuelLevelPercentage < 0 || fuelLevelPercentage > 100) {
            throw new IllegalArgumentException("Fuel level percentage must be between 0 and 100");
        }
        this.fuelLevelPercentage = fuelLevelPercentage;
    }

    public void displayShipInfo () {
        System.out.println("Ship Name: " + this.shipName);
        System.out.println("Captain Name: " + this.captainName);
        System.out.println("Speed Knots: " + this.speedKnots);
        System.out.println("Fuel Level Percentage: " + this.fuelLevelPercentage);
    }
}
public class ShipWorker {
    private String shipName;
    private String captainName;
    private double speedKnots;
    private int fuelLevelPercentage;

    public ShipWorker () {}

    public ShipWorker (String shipName, String captainName, double speedKnots, int fuelLevelPercentage) {
        this.shipName = shipName;
        this.captainName = captainName;
        this.speedKnots = speedKnots;
        this.fuelLevelPercentage = fuelLevelPercentage;
    }
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

    public void displayShipInfo () {
        System.out.println ("Ship name: " + getShipName () + "=============");
        System.out.println ("Ship captain: " + getCaptainName () + "=============");
        System.out.println ("Ship Speed: " + getSpeedKnots () + " knots");
        System.out.println ("Ship Fuel: " + getFuelLevelPercentage ()+ "%");
    }
    
}

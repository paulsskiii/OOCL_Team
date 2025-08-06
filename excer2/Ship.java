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

    private void displayShipInfo() {
        System.out.println("Ship Name: " + shipName);
        System.out.println("Captain Name: " + captainName);
        System.out.println("Speed: " + speedKnots + " knots");
        System.out.println("Fuel Level: " + fuelLevelPercentage + "%");
    }

    private void setFuelLevelPercentage(int fuelLevelPercentage2) {
        if (fuelLevelPercentage > 0 || fuelLevelPercentage < 100)
            this.fuelLevelPercentage = fuelLevelPercentage;
        else
            System.out.println("Error: Fuel level must be between 0 and 100 percent.");
    }

    public String getCargoTypeCarried() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getCargoTypeCarried'");
    }
}
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
        if (fuelLevelPercentage < 0 || fuelLevelPercentage > 100) {
        System.out.println(fuelLevelPercentage + " is Invalid! Please enter a valid Fuel Level Percentage between 0 and 100.");
        } else {
        this.fuelLevelPercentage = fuelLevelPercentage;
        }
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
        System.out.println ("Ship name: " + getShipName());
        System.out.println ("Ship captain: " + getCaptainName());
        System.out.println ("Ship Speed: " + getSpeedKnots() + " knots");
        System.out.println ("Ship Fuel: " + getFuelLevelPercentage()+ "%");
    }
    @Override
    public String toString() {
        return "Ship name: " + getShipName() + "\n" +
               "Ship captain: " + getCaptainName() + "\n" +
               "Ship Speed: " + getSpeedKnots() + " knots\n" +
               "Ship Fuel: " + getFuelLevelPercentage() + "%";
    }

}
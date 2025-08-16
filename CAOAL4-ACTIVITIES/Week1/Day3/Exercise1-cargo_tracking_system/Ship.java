package Java34.OOCL_Team;

public class Ship {
    private String shipName;
    private String captainName;
    private double speedKnots;
    private int fuelLevelPercentage;

    public Ship() {}

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
        if(fuelLevelPercentage < 0 || fuelLevelPercentage > 100) {
            System.out.println(fuelLevelPercentage + " Invalid! Enter a valid value for Fuel Level Percentage.");
            this.fuelLevelPercentage = Integer.parseInt(fuelLevelPercentage + " Invalid! Enter a valid value for Fuel Level Percentage.");
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
        System.out.println ("=================================================");
    }

}

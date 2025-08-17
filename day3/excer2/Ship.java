package Java34.OOCL_Team.excer2;

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

    public String getCaptainName() {
        return captainName;
    }

    public double getSpeedKnots() {
        return speedKnots;
    }

    public int getFuelLevelPercentage() {
        return fuelLevelPercentage;
    }

    private void setFuelLevelPercentage(int fuelLevelPercentage) {
        if (fuelLevelPercentage < 0) {
            System.out.println("Fuel level should be not be less than 0");
        } else if(fuelLevelPercentage > 100) {
            System.out.println("Fuel level should be less than 100");
        } else{
            this.fuelLevelPercentage = fuelLevelPercentage;
        }
    }

    public void displayShipInfo(){
        System.out.println("Ship Name: " + shipName);
        System.out.println("Captain Name: " + captainName);
        System.out.println("Speed Knots: " + speedKnots);
        System.out.println("Fuel Level Percentage: " + fuelLevelPercentage);
    }

}
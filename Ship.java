public class Ship {
    private String shipName;
    private String captainName;
    private double speedKnots;
    private int fuelLevelPercentage;

    public Ship(String shipName, String captainName, double speedKnots, int fuelLevelPercentage){
        this.shipName = shipName;
        this.captainName = captainName;
        this.speedKnots = speedKnots;
        this.fuelLevelPercentage = fuelLevelPercentage;
    }
}

public class ContainerShip extends Ship {
    private int numberOfTEU;

    public ContainerShip(String shipName, String captainName, double speedKnots, int fuelLevelPercentage, int numberOfTEU) {
        super(shipName, captainName, speedKnots, fuelLevelPercentage);
        this.numberOfTEU = numberOfTEU;
    }

    @Override
    public String displayShipInfo(){
        return String.format("Ship Name: %s, Captain Name: %s, Speed Knots: %f, Fuel Level Percentage: %d , TEU: %d", 
        this.shipName,this.captainName, this.speedKnots, this.fuelLevelPercentage,numberOfTEU);
    }
}

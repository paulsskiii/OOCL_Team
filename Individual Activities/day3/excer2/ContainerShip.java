public class ContainerShip extends ShipRepository {
    private int numberOfTEU;

    public ContainerShip(String shipName, String captainName, double speedKnots, int fuelLevelPercentage, int numberOfTEU) {
        super(shipName, captainName, speedKnots, fuelLevelPercentage);
        this.numberOfTEU = numberOfTEU;
    }
}

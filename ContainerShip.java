public class ContainerShip extends ShipWorker{

    private int numberOfTEU;

    public ContainerShip(String shipName, String captainName,
                         double speedKnots, int fuelLevelPercentage, int numberOfTEU){
            super(shipName, captainName, speedKnots, fuelLevelPercentage);
            this.numberOfTEU = numberOfTEU;
    }

    public void displayShipInfo(){
        System.out.println("print the numberOfTeu" + numberOfTEU);
    }

}

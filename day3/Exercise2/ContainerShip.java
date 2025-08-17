package Exercise2;
import Java34.OOCL_Team.Exercise2.ShipWorker;

public class ContainerShip extends ShipWorker {

    private int numberOfTEU;

    public ContainerShip(String shipName, String captainName,
                         double speedKnots, int fuelLevelPercentage, int numberOfTEU){
            super(shipName, captainName, speedKnots, fuelLevelPercentage);
            this.numberOfTEU = numberOfTEU;
    }

    @Override
    public void displayShipInfo(){
        System.out.println("Number of TEU: " + numberOfTEU);
    }

}

package Java34.OOCL_Team;

public class ContainerShip extends Ship{

    private int numberOfTEU;

    public ContainerShip(String shipName, String captainName,
                         double speedKnots, int fuelLevelPercentage, int numberOfTEU){
            super(shipName, captainName, speedKnots, fuelLevelPercentage);
            this.numberOfTEU = numberOfTEU;
    }

    @Override
    public void displayShipInfo(){
        System.out.println ("Container Ship name: " + getShipName());
        System.out.println ("Container Ship captain: " + getCaptainName());
        System.out.println ("Container Ship Speed: " + getSpeedKnots() + " knots");
        System.out.println ("Container Ship Fuel: " + getFuelLevelPercentage()+ "%");
        System.out.println ("Container Ship number of TEU" + numberOfTEU);
        System.out.println ("=================================================");
    }

}

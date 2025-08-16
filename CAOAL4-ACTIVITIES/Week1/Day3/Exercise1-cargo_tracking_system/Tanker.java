package Java34.OOCL_Team;

public class Tanker extends Ship {
    
    private String cargoTypeCarried;

    public Tanker(String shipName, String captainName, double speedKnots, int fuelLevelPercentage, String cargoTypeCarried){
        super(shipName, captainName, speedKnots, fuelLevelPercentage);
        this.cargoTypeCarried = cargoTypeCarried;
    }

    @Override
    public void displayShipInfo(){
        System.out.println ("Tanker Ship name: " + getShipName());
        System.out.println ("Tanker Ship captain: " + getCaptainName());
        System.out.println ("Tanker Ship Speed: " + getSpeedKnots() + " knots");
        System.out.println ("Tanker Ship Fuel: " + getFuelLevelPercentage()+ "%");
        System.out.println ("Tanker Cargo Type Carried: " + cargoTypeCarried);
        System.out.println ("=================================================");
    }

}

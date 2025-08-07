package Exercise2;
import Java34.OOCL_Team.Exercise2.ShipWorker;

public class Tanker extends ShipWorker {
    
    private String cargoTypeCarrierId;

    public Tanker(String shipName, String captainName, double speedKnots, int fuelLevelPercentage, String cargoTypeCarrierId){
        super(shipName, captainName, speedKnots, fuelLevelPercentage);
        this.cargoTypeCarrierId = cargoTypeCarrierId;
    }

    @Override
    public void displayShipInfo(){
        System.out.println("Cargo Type Carrier ID: " + cargoTypeCarrierId);
    }

}

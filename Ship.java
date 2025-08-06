public class Ship {

    private String shipName;
    private String captainName;
    private double speedKnots;
    private int fuelLevelPercentage;

    public void setShipname(String shipName){
        this.shipName = shipName;
    }

    public String getShipname(){
        return this.shipName;
    }

    public void setCaptainName(String captainName){
        this.captainName = captainName;
    }

    public String getCaptainName(){
        return this.captainName;
    }

    public void setSpeedKnots(double speedKnots){
        this.speedKnots = speedKnots;
    }

    public double getSpeedKnots(){
        return this.speedKnots;
    }

    public void setFuelLevelPercentage(int fuelLevelPercentage){
        this.fuelLevelPercentage = fuelLevelPercentage;
    }

    public int getFuelLevelPercentage(){
        return this.fuelLevelPercentage;
    }

//    public void displayShipInfo(){
//        System.out.println("hello world");
//    }
}

public class Ship {
    private String name;
    private int maxSpeedKnot;

    public Ship(String name, int maxSpeedKnot){
        this.name = name;
        this.maxSpeedKnot = maxSpeedKnot;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getMaxSpeedKnot() {
        return maxSpeedKnot;
    }

    public void setMaxSpeedKnot(int maxSpeedKnot) {
        this.maxSpeedKnot = maxSpeedKnot;
    }
}
 
package Exercise_3_2;

public class Ship {
    String name;
    double maxSpeedKnot; // in knots

    public Ship(String name, double maxSpeedKnot) {
        this.name = name;
        this.maxSpeedKnot = maxSpeedKnot;
    }

    public String getName() { return name; }
    public double getMaxSpeedKnot() { return maxSpeedKnot; }

    @Override
    public String toString() {
        return "Ship{" +
                "name='" + name + '\'' +
                ", maxSpeedKnot=" + maxSpeedKnot +
                '}';
    }
}

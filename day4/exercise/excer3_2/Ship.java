public class Ship {
    String name;
    double maxSpeedKnot; // in knots

    public Ship(String name, double maxSpeedKnot) {
        this.name = name;
        this.maxSpeedKnot = maxSpeedKnot;
    }

    public String getName() { return this.name; }
    public double getMaxSpeedKnot() { return this.maxSpeedKnot; }

    @Override
    public String toString() {
        return "Ship{" +
               "name='" + getName() + '\'' +
               ", maxSpeedKnot=" + getMaxSpeedKnot() +
               '}';
    }
}

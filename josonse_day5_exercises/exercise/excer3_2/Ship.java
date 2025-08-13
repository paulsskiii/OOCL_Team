class Ship {
    private String name;
    private double maxSpeedKnot;

    public Ship(String name, double maxSpeedKnot) {
        this.name = name;
        this.maxSpeedKnot = maxSpeedKnot;
    }

    public String getName() { return name; }
    public double getMaxSpeedKnot() { return maxSpeedKnot; }

    @Override
    public String toString() {
        return String.format("Ship --> Name: %s | maxSpeedKnot: %s", name, maxSpeedKnot);
    }
}
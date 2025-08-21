public class CargoItem {
    long id;
    String name;
    double weight;
    String destination;

    public CargoItem(long id, String name, double weight, String destination) {
        this.id = id;
        this.name = name;
        this.weight = weight;
        this.destination = destination;
    }

    // Getters and toString / equals / hashCode
    public long getId() {
        return id;
    }
    public String getName() {
        return name;
    }
    public double getWeight() {
        return weight;
    }
    public String getDestination() {
        return destination;
    }

    @Override
    public String toString() {
        return "id:" + getId() + " " + "name:" + getName() + " " + "weight:" + getWeight() + " " + "destination:" + getDestination();
    }
}
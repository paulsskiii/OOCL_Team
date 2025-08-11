

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

    public long getId(){
        return this.id;
    }

    public String getName(){
        return this.name;
    }

    public double getWeight(){
        return this.weight;
    }

    public String getDestination(){
        return this.destination;
    }

    @Override
    public String toString(){
        return "ID: " + getId() + " Name: " + getName() + " Weight: " + getWeight() + " Destination: " + getDestination();
    }


}
import java.util.Objects;

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
        return "CargoItem{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", weight=" + weight +
                ", destination='" + destination + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        CargoItem cargoItem = (CargoItem) o;
        return getId() == cargoItem.getId() && Doubl
            .compare(getWeight(), cargoItem.getWeight()) == 0 && Objects.equals(getName(), cargoItem.getName()) && Objects.equals(getDestination(), cargoItem.getDestination());
    }

                
                
    @Override
    public int hashCode() {
        return Objects.hash(getId(), getName(), getWeight(), getDestination());
    }
}
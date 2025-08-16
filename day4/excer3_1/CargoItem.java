package excer3_1;

class CargoItem {
    long id;
    String name;
    double weight;
    double value;

    public CargoItem(long id, String name, double weight, double value) {
        this.id = id;
        this.name = name;
        this.weight = weight;
        this.value = value;
    }

    // Getters and toString
    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public double getWeight() {
        return weight;
    }

    public double getValue() {
        return value;
    }

    @Override
    public String toString() {
        return "CargoItem: " +
                "id=" + id +
                ", name='" + name + "\'" +
                ", weight=" + weight +
                ", value=" + value;
    }
}



// // Vars
// CargoItem(201, "Gold Bars", 100.0, 500000.0)
// CargoItem(202, "Luxury Cars", 5000.0, 150000.0)
// CargoItem(203, "General Goods", 2000.0, 8000.0)
// CargoItem(204, "Art Collection", 50.0, 25000.0)
// CargoItem(205, "Building Materials", 10000.0, 5000.0)
// CargoItem(206, "Rare Manuscripts", 10.0, 12000.0)

// threshold = 10000.0

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

    @Override
    public String toString() {
        return "CargoItem{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", weight=" + weight +
                ", value=" + value +
                '}';
    }
}
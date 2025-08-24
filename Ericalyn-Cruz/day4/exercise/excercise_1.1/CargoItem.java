class CargoItem {
    private int id;
    private String name;
    private double weight;

    public CargoItem(int id, String name, double weight) {
        this.id = id;
        this.name = name;
        this.weight = weight;
    }

    public int getId() {
        return id;
    }

    @Override
    public String toString() {
        return "CargoItem{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", weight=" + weight +
                '}';
    }
}
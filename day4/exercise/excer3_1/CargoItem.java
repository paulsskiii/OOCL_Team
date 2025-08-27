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
        return "=== Cargo ID " + this.id + " ==="
                            + "\nName: " + this.name 
                            + "\nWeight: " + this.weight
                            + "\nValue: " + this.value + "\n";
    }
    
}
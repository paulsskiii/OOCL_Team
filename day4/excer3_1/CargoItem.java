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
    public double getValue(){
        return value;
    }

    public String toString(){
        return "CargoItem{id = " + id + ",name = " + name + ",value = " + value + "}";
    }
}



// // Vars


// threshold = 10000.0

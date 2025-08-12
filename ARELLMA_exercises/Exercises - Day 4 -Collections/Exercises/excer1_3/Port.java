class Port {
    String name;
    int capacity; // maximum ships
    int currentOccupancy;

    public Port(String name, int capacity, int currentOccupancy) {
        this.name = name;
        this.capacity = capacity;
        this.currentOccupancy = currentOccupancy;
    }

    // Getters and add/remove ship methods
}
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
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public int getCurrentOccupancy() {
        return currentOccupancy;
    }

    public void setCurrentOccupancy(int currentOccupancy) {
        this.currentOccupancy = currentOccupancy;
    }
}
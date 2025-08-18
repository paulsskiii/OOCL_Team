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

    public boolean isFull() {
        return currentOccupancy >= capacity;
    }

    public boolean isEmpty() {
        return currentOccupancy == 0;
    }

    public void addShip() {
        if (isFull()) {
            System.out.println("Port " + name + " is full! Cannot add more ships.");
        } else {
            currentOccupancy++;
            System.out.println("Ship added to " + name + ". Current occupancy: " + currentOccupancy + "/" + capacity);
        }
    }

    public void removeShip() {
        if (isEmpty()) {
            System.out.println("Port " + name + " is empty! No ships to remove.");
        } else {
            currentOccupancy--;
            System.out.println("Ship departed from " + name + ". Current occupancy: " + currentOccupancy + "/" + capacity);
        }
    }

    @Override
    public String toString() {
        return "Port: " + name + " | Capacity: " + capacity + " | Current Occupancy: " + currentOccupancy;
    }
}
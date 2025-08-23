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
    public String getName() { return name;}

    public void setName(String name) { this.name = name;}

    public int getCapacity() { return capacity;}

    public void setCapacity(int capacity) { this.capacity = capacity;}

    public int getCurrentOccupancy() { return currentOccupancy;}

    public void setCurrentOccupancy(int currentOccupancy) { this.currentOccupancy = currentOccupancy;}

    //add ship method
    public void shipArrives() {
        if (currentOccupancy < capacity) {
            currentOccupancy++;
            System.out.println("Ship arrived at " + name + " port. Port Current occupancy: " + currentOccupancy);
        } else {
            System.out.println(name + " port is already full.");
        }
    }

    //remove ship method
    public void shipDeparts() {
        currentOccupancy--;
        System.out.println("Ship departs at " + name + " port. Port Current occupancy: " + currentOccupancy);
    }

}
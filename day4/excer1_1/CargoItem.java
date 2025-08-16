class CargoItem {
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

    public long getId () {
        return this.id;
    }

    public String getName () {
        return this.name;
    }

    public double getWeight () {
        return this.weight;
    }

    public String getDestination () {
        return this.destination;
    }

    @Override
    public String toString () {
        String defaultString = "Cargo id: " + getId () + " | Cargo name: " + getName () + " | Cargo weight: " + getWeight ()+
        " | Destination: " + getDestination ();

        return defaultString;
    }

    @Override
    public boolean equals (Object o) {
        if (!(o instanceof CargoItem))
            return false;
        
        CargoItem newO = (CargoItem) o;
        
        return newO.getId () == this.getId ();
    }
}
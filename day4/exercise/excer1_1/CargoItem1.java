class CargoItem1 {
    long id;
    String name;
    double weight;
    String destination;

    public CargoItem1(long id, String name, double weight, String destination) {
        this.id = id;
        this.name = name;
        this.weight = weight;
        this.destination = destination;
    }

    // Getters and toString / equals / hashCode
    public long getId(){
        return id;
    }

    public String getName(){
        return name;
    }

    public double getWeight(){
        return weight;
    }

    public String getDestination(){
        return destination;
    }

    @Override
    public String toString(){
        return "ID: " + getId() + "\nName: " + getName() + "\nWeight: " + getWeight() + "\nDestination: " + getDestination() + "\n";
    }


    // public void displayCargoItems () {
    //     System.out.println("ID: " + getId());
    //     System.out.println("Name: " + getName());
    //     System.out.println("Weight: " + getWeight());
    //     System.out.println("Destination: " + getDestination());
    // }
}
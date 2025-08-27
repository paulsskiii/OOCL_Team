/**
 * A basic model class for a Ship.
 */
public class Ship {
    // TODO: Declare private fields (id, name, capacity, currentPort)
    private long id;
    private String name;
    private String capacity;
    private String currentPort;

    // TODO: Add default constructor
    public Ship() {
        // Default constructor
    }

    // TODO: Add constructor with all fields
    public Ship(long id, String name, double capacity, String currentPort) {
        this.id = id;
        this.name = name;
        this.capacity = capacity;
        this.currentPort = currentPort;
    }

    // TODO: Add getters and setters
    public long getId(){
        return id;
    }

    public String getName() {
        return name;
    }

    public double getCapacity(){
        return capacity;
    }

    public String getCurrentPort(){
        return currentPort;
    }

    public void setId(long id){
        this.id = id;
    }

    public void setName(String name){
        this.name = name;
    }

    public void setCapacity(double capacity){
        this.capacity = capacity;
    }

    public void setCurrentPort(String currentPort){
        this.currentPort = currentPort;
    }

    // TODO: Override toString() to return formatted ship data
    public String toString() {
        return String.format("Ship --> ID: %d | Name: %s | Capacity: %s | Current Port: %s", id, name, capacity, currentPort);
    }
}

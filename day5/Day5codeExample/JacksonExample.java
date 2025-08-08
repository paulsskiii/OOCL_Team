import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.core.JsonProcessingException;

// This is the Java object we want to serialize to JSON.
// Jackson automatically maps the fields to JSON key-value pairs.
class User {
    private int id;
    private String name;

    // A default constructor is required for deserialization.
    public User() {
    }

    public User(int id, String name) {
        this.id = id;
        this.name = name;
    }

    // Getters and setters are required for Jackson to access the fields.
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "User{id=" + id + ", name='" + name + "'}";
    }
}

public class JacksonExample {

    public static void main(String[] args) throws JsonProcessingException {
        // 1. Create a new instance of Jackson's ObjectMapper.
        // This is the main class for all serialization/deserialization.
        ObjectMapper objectMapper = new ObjectMapper();

        // --- SERIALIZATION (Java Object to JSON String) ---
        System.out.println("--- Serialization: Java Object to JSON String ---");
        
        // Create a new Java object instance.
        User user = new User(1, "Jane Doe");

        // Use the objectMapper to convert the 'user' object into a JSON string.
        String jsonString = objectMapper.writeValueAsString(user);
        
        // Print the resulting JSON string.
        System.out.println("Java Object: " + user);
        System.out.println("JSON String: " + jsonString);

        System.out.println("\n-----------------------------------\n");

        // --- DESERIALIZATION (JSON String to Java Object) ---
        System.out.println("--- Deserialization: JSON String to Java Object ---");

        // Imagine this JSON string was received from another microservice.
        String newJsonString = "{\"id\":2,\"name\":\"John Smith\"}";

        // Use the objectMapper to convert the JSON string back into a Java 'User' object.
        User newUser = objectMapper.readValue(newJsonString, User.class);
        
        // Print the resulting Java object.
        System.out.println("JSON String: " + newJsonString);
        System.out.println("Java Object: " + newUser);
    }
}

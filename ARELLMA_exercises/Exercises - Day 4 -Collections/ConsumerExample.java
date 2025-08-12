import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;

public class ConsumerExample {

    public static void main(String[] args) {
        // Line 1: Create a list of strings
        List<String> names = Arrays.asList("Alice", "Bob", "Charlie");

        // Line 2: Define a Consumer to print a string
        Consumer<String> printName = name -> System.out.println("Hello, " + name + "!");

        // Line 3: Use the Consumer to process each element in the list
        for (String name : names) {
            printName.accept(name); // Line 4
        }
    }
}
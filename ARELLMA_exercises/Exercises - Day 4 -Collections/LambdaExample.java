import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class LambdaExample {

    public static void main(String[] args) {
        List<String> names = Arrays.asList("Alice", "Bob", "Charlie", "David"); // Line 1

        // Before Java 8: Using an anonymous inner class
        Collections.sort(names, new java.util.Comparator<String>() { // Line 2
            @Override
            public int compare(String a, String b) {
                return a.length() - b.length();
            }
        });

        // With Java 8: Using a lambda expression
        Collections.sort(names, (a, b) -> a.length() - b.length()); // Line 3

        System.out.println(names); // Line 4
    }
}
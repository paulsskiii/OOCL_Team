import java.util.InputMismatchException; // Line 1
import java.util.Scanner;

public class MultipleCatchExample {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in); // Line 2

        try { // Line 3
            System.out.println("Enter a number:");
            int num = scanner.nextInt(); // Line 4
            int result = 10 / num;       // Line 5
            System.out.println("Result: " + result);
        } catch (InputMismatchException e) { // Line 6
            System.out.println("Invalid input. Please enter a valid number.");
        } catch (ArithmeticException e) { // Line 7
            System.out.println("Cannot divide by zero.");
        } finally { // Line 8
            scanner.close(); // Line 9
            System.out.println("Scanner closed.");
        }
    }
}
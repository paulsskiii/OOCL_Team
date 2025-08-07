// Handling Invalid Cargo Weight (ArithmeticException/Custom) Code Example
public class CargoWeightCalculator {

    public double calculateShippingCost(double weightKg) {
        if (weightKg <= 0) {
            throw new IllegalArgumentException("Cargo weight must be positive.");
        }
        // Simulate some calculation that might cause an error, e.g., division by a factor
        // For demonstration, let's just return a simple cost
        return weightKg * 5.0;
    }

    public static void main(String[] args) {
        CargoWeightCalculator calculator = new CargoWeightCalculator();
        try {
            double cost1 = calculator.calculateShippingCost(100.0);
            System.out.println("Cost for 100kg: $" + cost1);

            double cost2 = calculator.calculateShippingCost(-5.0); // This will throw an exception
            System.out.println("Cost for -5kg: $" + cost2); // This line won't be reached
        } catch (IllegalArgumentException e) {
            System.err.println("Error: " + e.getMessage());
        } finally {
            System.out.println("Calculation attempt finished.");
        }
    }
}

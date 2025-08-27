import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class TransactionLog {
    private static final String LOG_FILE = "financial_transactions.log";
    private static final DateTimeFormatter FORMATTER = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

    public void recordTransaction(double amount, String description) {
        // File writing logic
        try(BufferedWriter writer = new BufferedWriter(new FileWriter(LOG_FILE, true))) {
            writer.write("[" + FORMATTER.format(LocalDateTime.now()) + "] Amount: " + amount + " | Description: " + description + "\n");
            writer.close();
        } catch(IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        TransactionLog logger = new TransactionLog();

        // Test cases
        logger.recordTransaction(1500.75, "Shipping fee for TRK123");
        logger.recordTransaction(-250.00, "Refund for cancelled cargo");
        logger.recordTransaction(50.00, "Small payment for port services");

        // logger.recordTransaction(1200.00, "This is a transaction.");
        // logger.recordTransaction(420.45, "This is another transaction.");
        // logger.recordTransaction(54300.99, "This is the next transaction.");
    }
}




// test casses
// LOG_FILE = "financial_transactions.log";
// FORMATTER = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

// // Test Case 1
// amount = 1500.75;
// description = "Shipping fee for TRK123";

// // Test Case 2
// amount = -250.00;
// description = "Refund for cancelled cargo";

// // Test Case 3
// amount = 50.00;
// description = "Small payment for port services";

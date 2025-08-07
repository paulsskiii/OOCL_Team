import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class TransactionLog {
    private static final String LOG_FILE = "financial_transactions.log";
    private static final DateTimeFormatter FORMATTER = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

    public void recordTransaction(double amount, String description) {
        // File writing logic
    }

    public static void main(String[] args) {
        TransactionLog logger = new TransactionLog();

        // Test cases
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

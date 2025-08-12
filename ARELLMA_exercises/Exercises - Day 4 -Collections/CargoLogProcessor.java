//Handling File Operations for Cargo Logs (IOException) Code Example
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class CargoLogProcessor {

    public void writeLog(String filename, String logEntry) {
        try (PrintWriter writer = new PrintWriter(new FileWriter(filename, true))) { // true for append mode
            writer.println(logEntry);
            System.out.println("Log entry written to " + filename);
        } catch (IOException e) {
            System.err.println("Error writing to log file: " + e.getMessage());
        }
    }

    public void readLog(String filename) {
        try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {
            String line;
            System.out.println("\n--- Content of " + filename + " ---");
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }
            System.out.println("-------------------------");
        } catch (IOException e) {
            System.err.println("Error reading from log file: " + e.getMessage());
        }
    }

    public static void main(String[] args) {
        CargoLogProcessor logProcessor = new CargoLogProcessor();
        String logFile = "cargo_events.log";

        logProcessor.writeLog(logFile, "Cargo TRK001 departed from Manila.");
        logProcessor.writeLog(logFile, "Ship Sea Serpent arrived at Singapore.");
        logProcessor.readLog(logFile);
        logProcessor.readLog("non_existent_log.log"); // This will cause an IOException
    }
}

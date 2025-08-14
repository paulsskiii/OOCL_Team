// File Handling: BufferedReader and BufferedWritter

// BufferedIO.java
import java.io.*;

public class BufferedIO {
    public static void main(String[] args) throws IOException {
        BufferedWriter writer = new BufferedWriter(new FileWriter("buffered.txt"));
        writer.write("BufferedWriter is faster for large texts.");
        writer.newLine();
        writer.write("It buffers the data.");
        writer.close();

        BufferedReader reader = new BufferedReader(new FileReader("buffered.txt"));
        String line;
        while ((line = reader.readLine()) != null) {
            System.out.println(line);
        }
        reader.close();
    }
}
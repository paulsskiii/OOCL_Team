import java.io.File;
import java.io.IOException;

public class CreateFileExample {
 public static void main(String[] args) {
 try {
 File myFile = new File("example.txt");
 if (myFile.createNewFile()) {
 System.out.println("File created: " + myFile.getName());
 } else {
 System.out.println("File already exists.");
 }
 } catch (IOException e) {
 e.printStackTrace();
 }
 }
}

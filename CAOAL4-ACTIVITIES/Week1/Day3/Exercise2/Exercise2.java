import java.util.Scanner;

public class Exercise2 {
    public static void main(String[] args) {
    
		Scanner input = new Scanner(System.in);

		String firstName = args[0];
		String middleName = args[1];
		String lastName = args[2];
		
		System.out.println("Hello " + firstName);

		System.out.println("Team Name: ");
		String teamName = input.nextLine();
		
		String greetings = args[3];
		System.out.println(greetings + "! Welcome " + firstName + " " + middleName + " " + lastName + " from " + teamName + " team.");
		input.close();
		
    }
}
import java.util.Scanner;

public class Slambook {
    public static void main(String[] args) {
    
		Scanner input = new Scanner(System.in);

		System.out.println("---CAOAL4 SLAMBOOK---");

		System.out.println("What is your First Name: ");
		String firstName = input.nextLine();

		System.out.println("What is your Middle Name: ");
		String middleName = input.nextLine();
		
		System.out.println("What is your Last Name: ");
		String lastName = input.nextLine();

		System.out.print("Your name is " + firstName + middleName + lastName + ".");
		input.close();
    }
}
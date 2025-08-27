import java.util.Scanner;

public class Exercise1{
	public static void main(String[] args){
		Scanner input = new Scanner(System.in);
		System.out.println("Enter your first name: ");
		String firstName = input.nextLine();
		
		System.out.println("Enter your middle name: ");
		String middleName = input.nextLine();	

		System.out.println("Enter your last name: ");
		String lastName = input.nextLine();

		System.out.println("Name: " + firstName + " " + middleName + " " + lastName);

		input.close();
	}	
}
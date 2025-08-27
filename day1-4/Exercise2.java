import java.util.Scanner;

public class Exercise2{
	public static void main(String[] args){
		String firstName = args[0];
		String middleName = args[1];
		String lastName = args[2];
		String hello = args[4] + " " + args[5];

		

		Scanner input = new Scanner(System.in);

		System.out.print("Enter your team name: ");
		String teamName = input.nextLine();
		input.close();

		System.out.println("I am " + firstName + " " + middleName + " " + lastName + " " + "and my team name is " + teamName + " " + hello);

		

	}	
}
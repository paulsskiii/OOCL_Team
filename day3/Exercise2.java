import java.util.Scanner;

public class Exercise2 {
	
	public static void main(String[] args){

	String firstName = args[0];
	String teamName;
	String helloWorld = args[4];
	
	System.out.println("Enter team name: ");
	Scanner firstNameInput = new Scanner(System.in);
	teamName = firstNameInput.nextLine();
	
	System.out.println("FN: " + firstName);
	System.out.println("TN: " + teamName);
	System.out.println("helloWord: " + helloWorld);
	
	firstNameInput.close();
	}
}
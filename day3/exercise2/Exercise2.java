import java.util.Scanner;

class Exercise2{

    public static void main(String[] args){

        // First output is the name using args
        // 2nd output is the team name - scanner
        // Third output is "hello world" - using args for the fifth element

        String name = args[0];
        String statement = args[4];
        Scanner in = new Scanner(System.in);

        System.out.print("Enter your team name:");
        String teamName = in.nextLine();

        System.out.println("My Name: " + name );
        System.out.println("My Team: " + teamName );
        System.out.println(statement);

        in.close();
    }
}
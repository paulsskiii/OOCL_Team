import java.util.Scanner;

public class Exercise1 {
    public static void main (String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.print("Enter your name: ");
        String name = input.nextLine();

        System.out.print("Enter you team: ");
        String team = input.nextLine();

        System.out.print("enter you age: ");
        int age = input.nextInt();


        System.out.println("Hi my name is " + name + " I am from team " + team + " and my age is " + age + ".");
    }

}
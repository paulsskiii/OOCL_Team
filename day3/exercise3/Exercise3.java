import java.util.Scanner;
public class Exercise3{
    public static void main(String[] args){

        System.out.println("Enter limit:");
        Scanner in = new Scanner(System.in);
        int limit= in.nextInt();

        System.out.println("-----FOR LOOP------");
        System.out.println("Example Pattern:");

        int counter = 1;

        for(int i=1; i <= limit; i++){
            for(int x=1; x <= limit; x++){
                if(x >= counter){
                    System.out.print(x);
                }else{
                    System.out.print("*");
                }
            }
            System.out.println();
            counter++;
        }

        System.out.println("-----WHILE LOOP------");

        System.out.println("Example Pattern:");
        int i = 1;
        int wcounter = 1;
        while(i <= limit){
            int x = 1;
            while(x <= limit){
                if(x >= wcounter){
                    System.out.print(x);
                }else{
                    System.out.print("*");
                }
                x++;
            }
            i++;
            System.out.println();
            wcounter++;
        }


    }
}
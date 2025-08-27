import java.util.Scanner;

public class TrianglePattern {
   public static void main(String[] args) {
       Scanner input = new Scanner(System.in);

       System.out.print("Enter triangle size: ");
       int size = input.nextInt();


       // FOR LOOP
	System.out.println("FOR LOOP");
       for (int i = 0; i < size; i++) {
           for (int star = 0; star < i; star++) {
               System.out.print("*");
           }
           for (int num = i + 1; num < size; num++) {
               System.out.print(num);
           }
           if (i == size - 1) {
               System.out.print("*");
           }
           System.out.println();
       }


       // WHILE LOOP
      System.out.println("While LOOP");
       int i = 0;
       while (i < size) {
           int star = 0;
           while (star < i) {
               System.out.print("*");
               star++;
           }
           int num = i + 1;
           while (num < size) {
               System.out.print(num);
               num++;
           }
           if (i == size - 1) {
               System.out.print("*");
           }
           System.out.println();
           i++;
       }


       // DO-WHILE LOOP
  	System.out.println("DO-WHILE LOOP");
       int j = 0;
       do {
           int star = 0;
           while (star < j) {
               System.out.print("*");
               star++;
           }
           int num = j + 1;
           while (num < size) {
               System.out.print(num);
               num++;
           }
           if (j == size - 1) {
               System.out.print("*");
           }
           System.out.println();
           j++;
       } while (j < size);




       input.close();
   }
}

import java.util.Scanner;

public class TrianglePattern {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);

	      System.out.println("Enter your Triangle Size: ");
        	int TriangleSize = in.nextInt();


		//NESTED FOR LOOP with IF-ELSE
        	/*for (int i = 0; i <= TriangleSize; i++) {
			System.out.println();
            
			for (int j = 0; j < TriangleSize; j++) {
			
				if(j < i){
					System.out.print("*");
				} else {
					System.out.print(j+1);
				}
            	}
        	}*/


		//NESTED FOR LOOP
		/*for (int i = 0; i <= TriangleSize; i++) {
			for (int j = 0; j < i; j++) {
				System.out.print("*");
			}
			for (int k = i + 1; k <= TriangleSize; k++) {
				System.out.print(k);
			}
			System.out.println();
		}*/
	

		in.close();
    }

}
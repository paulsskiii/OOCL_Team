import java.util.Scanner;

public class Exercise3{
	public static void main(String[] args){
		Scanner input = new Scanner(System.in);

		System.out.print("Enter triangle size: ");
		int size = input.nextInt();
		input.close();

// ----------------- NESTED FOR LOOP ------------------
		for (int i = 0; i <= size; i++){
			
			for (int j = 1; j <= size; j++){
				if (j < i + 1){
					System.out.print("*");
				} else {				
					System.out.print(j);
				}
			}

			System.out.println("");
		}

// ----------------- WHILE LOOP ------------------
		int i = 0;
		while (i <= size){
			int num = 1;
			while (num <= size){
				if (num < i + 1){
					System.out.print("*");
				} else {				
					System.out.print(num);
				}
				num++;
			}
			System.out.println("");
			i++;
		}	

	}	
}

/*
12345
*2345
**345
***45
****5
*****
*/

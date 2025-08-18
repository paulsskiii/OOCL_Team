import java.util.*;

public class TrianglePattern{
    public static void main(String [] args) {
	

	Scanner scan = new Scanner(System.in);
	System.out.print("Enter team name: ");
	int times = scan.nextInt();

	for(int i = 1; i <= times + 1; i++){

		for (int j = 1; j <= times; j++){

			if(i > j){

				System.out.print("*");
			}else{
				System.out.print(j);
				
			}
		}
		System.out.println("");
	}
	
	}
}
import java.util.*;

public class TrianglePattern{
    public static void main(String [] args) {
	

	Scanner scan = new Scanner(System.in);
	System.out.print("Enter triangle size: ");
	int times = scan.nextInt();
	
	System.out.println("For-Loop");
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

	int i = 1;
	
	System.out.println("While-Loop");
	while(i <= times + 1){
		int j = 1;
		while (j <= times){

			if(i > j){

				System.out.print("*");
			}else{
				System.out.print(j);
				
			}
		j++;
		}
		i++;
		System.out.println("");
	}
	i = 1;
	System.out.println("Do-While-Loop");
	do{
	int j = 1;
		do{
			if(i > j){

				System.out.print("*");
			}else{
				System.out.print(j);
				
			}
			j++;
		}while(j <= times);
		i++;
		System.out.println("");
	}while(i <= times + 1);
	
	}
}
import java.util.Scanner;

public class Exercise3 {
	
	public static void main(String[] args){
	
	Scanner in = new Scanner(System.in);
	int length = in.nextInt();	
	
	System.out.println("FOR LOOP");
	for(int i = 0; i < length+1; i++){
	
		for(int j = 0; j < length; j++){
			if(j <= i-1){
			System.out.print("*");
			}
			else{
			System.out.print(j+1);
			}
		}
		System.out.println();
	};
	
	System.out.println("WHILE LOOP");
	int whileCounter = 0;
	while(whileCounter < length+1){
		int innerWhileCounter = 0;	
		while(innerWhileCounter < length){
			if(innerWhileCounter <= whileCounter-1){
			System.out.print("*");
			}
			else{
			System.out.print(innerWhileCounter+1);
			}
		innerWhileCounter++;
		}
		System.out.println();
		whileCounter++;
	}

	System.out.println("DO WHILE LOOP");
	int doWhileCounter = 0;

	do{
		int innerDoCounter = 0;
		do{
			if(innerDoCounter < doWhileCounter){
			System.out.print("*");
			}
			else{
			System.out.print(innerDoCounter+1);
			}
		innerDoCounter++;
		}while(innerDoCounter < length);
	
	doWhileCounter++;
	System.out.println();

	}
	while(doWhileCounter < length);
}
}
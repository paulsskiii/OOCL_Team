import java.util.List;
import java.util.ArrayList;
import java.util.Scanner;

public class WorkerList {
	
	public void setNames(List s) {
		List<String> names = new ArrayList<>();
		Scanner scanner=new Scanner(System.in);
		
		System.out.println("Enter a name");
			
			for (int i=0; i<5; i++ ){
					String s2 = scanner.nextLine();
					names.add(s2);
					s=names;
			}
			System.out.println(getNames(s));
	}

	public List getNames(List s) {
		return s;

	}
}
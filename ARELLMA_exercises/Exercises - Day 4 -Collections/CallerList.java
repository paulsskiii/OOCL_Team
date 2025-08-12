import java.util.List;
import java.util.ArrayList;
import java.util.Scanner;
//Only import the utils you will use.
public class CallerList {
	public static void main(String args[]) {
	
		List<String> names = new ArrayList<>();
		//List is an interface
		//ArrayList is an abstract class, list impementation of Arrays
		//names is a List of Strings 
		// <> signifies you are instantiating an empty ArrayList
		WorkerList wl = new WorkerList();
		wl.setNames(names);
		//Accepts a List of Strings
	}
}
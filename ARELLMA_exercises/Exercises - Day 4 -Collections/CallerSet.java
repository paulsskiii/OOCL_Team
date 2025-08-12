import java.util.Set;
import java.util.HashSet;
import java.util.Scanner;

public class CallerSet {
	public static void main(String args[]) {
	
		Set<String> names = new HashSet<>();
		WorkerSet wl = new WorkerSet();
		wl.setNames(names);
	}
}
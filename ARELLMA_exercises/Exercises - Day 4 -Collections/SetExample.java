import java.util.Set;
import java.util.HashSet;
import java.util.Scanner;

public class SetExample {
    public static void mian(String args[]){
        Set<String> names = new HashSet<>();

        Scanner s = new Scanner(System.in);

        System.out.println("Enter a name");
        
        for (int i=0; i<5; i++){
            names.add(s.nextLine());
        }

        System.out.println(names);
    
    }
}
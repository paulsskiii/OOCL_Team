import java.util.HashMap;
import java.util.TreeMap;
import java.util.LinkedHashMap;
import java.util.Map;


public class SampleMap {
	
	public static void main(String args[]) {

		Map<String, String> hashMap = new HashMap<>();

		hashMap.put("Apple", "Fruit");
		hashMap.put("Carrot", "Vegetable");
		hashMap.put("Banana", "Fruit");
		System.out.println(" HashMap :"+ hashMap);

		Map<String, String> treeMap = new TreeMap<>();
		treeMap.put("Apple", "Fruit");
		treeMap.put("Carrot", "Vegetable");
		treeMap.put("Banana", "Fruit");
		System.out.println(" TreeMap :"+ treeMap);


		Map<String, String> linkedHashMap = new LinkedHashMap<>();
		linkedHashMap.put("Apple", "Fruit");
		linkedHashMap.put("Carrot", "Vegetable");
		linkedHashMap.put("Banana", "Fruit");
		System.out.println("LinkedHashMap :"+ linkedHashMap);
	}
}
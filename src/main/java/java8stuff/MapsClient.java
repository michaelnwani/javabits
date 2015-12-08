import java.util.Map;
import java.util.HashMap;

public class MapsClient {
	public static void main(String[] args) {
		
		Map<Integer, String> map = new HashMap<>();
		
		for (int i = 0; i < 10; i++) {
			// don't need to write additional 'if null' checks
			map.putIfAbsent(i, "val" + i);
		}
		
		// accepts a consumer to perform operations for each entry in the map
		map.forEach((id, val) -> System.out.println(val));
		
		map.computeIfPresent(3, (num, val) -> val + num);
		System.out.println(map.get(3));	// 'val33'
		
		map.computeIfPresent(9, (num, val) -> null);
		System.out.println(map.containsKey(9));	// false
		
		// optional parentheses
		map.computeIfAbsent(23, num -> "val" + num);
		System.out.println(map.containsKey(23));	// true
		
		map.computeIfAbsent(3, num -> "bam");
		System.out.println(map.get(3));
		
		// remove entries for a given key, only if it's currently mapped to a given value
		map.remove(3, "val3");
		System.out.println(map.get(3)); // 'val33'
		
		map.remove(3, "val33");
		System.out.println(map.get(3));	// null
		
		// useful shortcut
		System.out.println(map.getOrDefault(42, "not found"));	// not found
		
		// merging entries; either puts the key/value into the map if no entry for the
		// key exists, or the merging function will be called to change the existing value
		map.merge(9, "val9", (value, newValue) -> value.concat(newValue));
		System.out.println(map.get(9));	// 'val9'
		
		map.merge(9, "concat", (value, newValue) -> value.concat(newValue));
		System.out.println(map.get(9)); // 'val9concat'
	}
}
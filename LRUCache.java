// Design and implement a data structure for Least Recently Used (LRU) cache. It should support the following operations: get and set.
//
// get(key) - Get the value (will always be positive) of the key if the key exists in the cache, otherwise return -1.
// set(key, value) - Set or insert the value if the key is not already present. When the cache reached its capacity, it should invalidate the least recently used item before inserting a new item.
import java.util.*;
public class LRUCache {

    // private static ArrayDeque<Integer> deque;
   // private static int size;
    private static LinkedHashMap<Integer,Integer> map;

    
    public LRUCache(int capacity) {

        //this.size = 0;
        // this.deque = new ArrayDeque<Integer>();
		//true - access ordering
        this.map = new LinkedHashMap<Integer,Integer>(capacity, 1.1f, true){
			@Override
			protected boolean removeEldestEntry(Map.Entry<Integer,Integer> eldest){
				return size() > capacity;
			}
        };

    }
    
    public int get(int key) {
		if (map.get(key) == null)
			return -1;
		else
			return map.get(key);
    }
	
	
    
    public void set(int key, int value) {
        // if (!map.containsKey(key)){
//             if (size == N){
//                 //System.out.println("deque.size() == N");
//                 //map.remove(deque.removeLast());
//                 //map.
//             }
//         }
        map.put(key, value);
        // deque.offerFirst(key);
        //size++;
         
    }
}
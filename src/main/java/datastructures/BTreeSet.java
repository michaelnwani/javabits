// B-tree (multiway Balanced tree) set implementation (1970 Bayer & McCreight)
// a search or an insertion in a B-tree of order M with N items (nodes)
// requires between log_M(N) and log_M/2(N) probes - constant number
// search cost is O(1) for all practical purposes
// ex. when M is 1000, height of the tree is less than 4 for N < 62.5 billion
// in practice the primary challenge to developing an implementation is ensuring
// that space is available for the B-tree nodes, which is becoming increasingly
// easier to address
public class BTreeSet<Key extends Comparable<Key>> {
	// create and open a Page (a contiguous block of data)
	// can think of a page as an internal/external node
	// Internal nodes: associate copies of keys with pages
	// External nodes: have references to the actual data
	private Page root = new Page(true); 
	
	public BTreeSet(Key sentinel) {
		add(sentinel);
	}
	
	public boolean contains(Key key) {
		return contains(root, key);
	}
	
	private boolean contains(Page h, Key key) {
		// upon reaching the first external node??
		if (h.isExternal()) {
			return h.contains(key);
		}
		return contains(h.next(key), key);
	}
	
	public void add(Key key) {
		add(root, key);
		if (root.isFull()) {
			Page leftHalf = root;
			Page rightHalf = root.split();
			root = new Page(false);
			root.add(leftHalf);
			root.add(rightHalf);
		}
	}
	
	public void add(Page h, Key key) {
		if (h.isExternal()) {
			h.add(key);
			return;
		}
		
		Page next = h.next(key);
		add(next, key);
		if (next.isFull()) {
			// add the key to a newly created page that contains the latter 
			// M/2 higher ranking keys from the original page
			h.add(next.split());
		}
		next.close(); // close the page (write its contents back out into memory)
	}
	
}
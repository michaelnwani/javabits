package main.java.datastructures;
public class BST<Key extends Comparable<Key>, Value>
{
	private Node root;	//root of BST
	
	private class Node
	{
		private Key key;			//key
		private Value val;			//associated value
		private Node left, right;	//links to subtrees
		private int N;				//# nodes in subtree rooted here
		
		public Node(Key key, Value val, int N)
		{
			this.key = key; this.val = val; this.N = N;
		}
	}
	
	public int size()
	{
		return size(root);
	}
	
	private int size(Node x)
	{
		if (x == null) 	return 0;
		else			return x.N;
	}
	
	public Value get(Key key)
	{
		return get(root, key);
	}
	
	private Value get(Node x, Key key)
	{
		//Return value associated with key in the subtree rooted at x;
		//return null if key is not present in subtree rooted at x.
		if (x == null) return null;
		int cmp = key.compareTo(x.key);
		if 		(cmp < 0) 	return get(x.left, key);
		else if (cmp > 0) 		return get(x.right, key);
		else return x.val;
	}
	
	public void put(Key key, Value val)
	{
		//Search for key. Update value if found; grow table if new.
		root = put(root, key, val);
	}
	
	private Node put(Node x, Key key, Value val)
	{
		//Change key's value to val if key in subtree rooted at x.
		//Otherwise, add new node to subtree associating key with val.
		if (x == null) return new Node(key, val, 1);
		int cmp = key.compareTo(x.key);
		if 		(cmp < 0) x.left  = put(x.left, key, val);
		else if (cmp > 0) x.right = put(x.right, key, val);
		else x.val = val;
		x.N = size(x.left) + size(x.right) + 1;
		return x;
	}
	
	public Key min()
	{
		return min(root).key;
	}
	
	private Node min(Node x)
	{
		if (x.left == null) return x;
		return min(x.left);
	}
	
	//the largest key less than this key
	public Key floor(Key key)
	{
		Node x = floor(root, key);
		if (x == null) return null;
		return x.key;
	}
	
	private Node floor(Node x, Key key)
	{
		if (x == null) return null;
		int cmp = key.compareTo(x.key);
		if (cmp == 0) 	return x;
		if (cmp < 0 )  	return floor(x.left, key);
		Node t = floor(x.right, key);
		if (t != null) 	return t; 
		else			return x;
		//if t==null, could imply that every node's key in the tree is
		//greater than the key param that we're running floor() on
	}
	
	public Key select(int k)
	{
		return select(root, k).key;
	}
	
	private Node select(Node x, int k)
	{
		//Return Node containing key of rank k.
		if (x == null) return null;
		int t = size(x.left);
		if 		(t > k) return select(x.left, k);
		else if (t < k) return select(x.right, k-t-1);
		else			return x;
	}
	
	public int rank(Key key)
	{
		return rank(key, root);
	}
	
	private int rank(Key key, Node x)
	{
		//Return number of keys less than key in the current subtree rooted at x.
		if (x == null) return 0;
		int cmp = key.compareTo(x.key);
		if 		(cmp < 0) 	return rank(key, x.left);
		else if (cmp > 0) 	return 1 + size(x.left) + rank(key, x.right); //+1 to include root of subtree
		else				return size(x.left);
	}
	
	//Eager T. Hibbard deletion (1962)
	public void deleteMin()
	{
		root = deleteMin(root);
	}
	
	private Node deleteMin(Node x)
	{
		if (x.left == null) return x.right;
		x.left = deleteMin(x.left);
		x.N = size(x.left) + size(x.right) + 1;
		return x;
	}
	
	public void delete(Key key)
	{
		root = delete(root, key);
	}
	
	private Node delete(Node x, Key key)
	{
		if (x == null) return null;
		int cmp = key.compareTo(x.key);
		if 		(cmp < 0) x.left = delete(x.left, key);
		else if (cmp > 0) x.right = delete(x.right, key);
		else
		{
			if (x.right == null) 	return x.left;
			if (x.left == null) 	return x.right;
			Node t = x;
			x = min(t.right);
			x.right = deleteMin(t.right);
			x.left = t.left;
		}
		x.N = size(x.left) + size(x.right) + 1;
		return x;
	}
	
	public Iterable<Key> keys()
	{
		return keys(min(), max());
	}
	
	public Iterable<Key> keys(Key lo, Key hi)
	{
		Queue<Key> queue = new Queue<Key>();
		keys(root, queue, lo, hi);
		return queue;
	}
	
	private void keys(Node x, Queue<Key> queue, Key lo, Key hi)
	{
		if (x == null) return;
		int cmplo = lo.compareTo(x.key);
		int cmphi = hi.compareTo(x.key);
		if (cmplo < 0) keys(x.left, queue, lo, hi);
		if (cmplo <= 0 && cmphi >= 0) queue.enqueue(x.key);
		if (cmphi > 0) keys(x.right, queue, lo, hi);
	}
	
	
	//Page 407 for max(), and ceiling().
	//Page 411 for deleteMax().
	//Page 413 for keys().
}







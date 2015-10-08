//Trie symbol table
import java.util.HashSet;
public class TrieST<Value>
{
	private static int R = 256;		//radix
	private Node root = new Node();	//root of trie
	
	//has to be a static nested class to have access to its enclosing class's static members (like R)
	private static class Node
	{
		//java does not support arrays of generics (no objects within arrays that have
		//instance members that are generics, basically)
		private Object val;	
		private Node[] next = new Node[R];
	}
	
	public Value get(String key)
	{
		Node x = get(root, key, 0);
		if (x == null) return null;
		return (Value) x.val;
	}
	
	private Node get(Node x, String key, int d)
	{
		//Return node associated with key in the subtrie rooted at x.
		if (x == null) return null;
		if (d == key.length()) return x;
		char c = key.charAt(d);	//Use dth key char to identify subtrie
		return get(x.next[c], key, d+1);
	}
	
	public void put(String key, Value val)
	{
		root = put(root, key, val, 0);
	}
	
	private Node put(Node x, String key, Value val, int d)
	{
		//Change value associated with key if in subtrie rooted at x.
		if (x == null) x = new Node();
		if (d == key.length()) { x.val = val; return x;}
		char c = key.charAt(d);	//Use dth key char to identify subtrie.
		x.next[c] = put(x.next[c], key, val, d+1);
		return x;	//the original 'root' is returned. smart
	}
	
	public Iterable<String> keys()
	{
		return keysWithPrefix("");
	}
	
	public Iterable<String> keysWithPrefix(String pre)
	{
		HashSet<String> q = new HashSet<String>();
		collect(get(root, pre, 0), pre, q);
		return q;
	}
	
	private void collect(Node x, String pre, HashSet<String> q)
	{
		if (x == null) return;
		if (x.val != null) q.add(pre);	//val is only not null when we hit a node that represents a word
		for (char c = 0; c < R; c++)
			collect(x.next[c], pre + c, q);
	}
	
	public Iterable<String> keysThatMatch(String pat)
	{
		HashSet<String> q = new HashSet<String>();
		collect(root, "", pat, q);
		return q;
	}
	
	private void collect(Node x, String pre, String pat, HashSet<String> q)
	{
		int d = pre.length();	//building up the prefix to match the pattern
		if (x == null) return;
		if (d == pat.length() && x.val != null) q.add(pre);
		if (d == pat.length()) return;
		
		char next = pat.charAt(d);
		for (char c = 0; c < R; c++)
			if (next == '.' || next == c)
				collect(x.next[c], pre + c, pat, q);
	}
	
	public String longestPrefixOf(String s)
	{
		int length = search(root, s, 0, 0);
		return s.substring(0, length);
	}
	
	private int search(Node x, String s, int d, int length)
	{
		if (x == null) return length;
		if (x.val != null) length = d;
		if (d == s.length()) return length;
		char c = s.charAt(d);
		return search(x.next[c], s, d+1, length);
	}
	
	public void delete(String key)
	{
		root = delete(root, key, 0);
	}
	
	private Node delete(Node x, String key, int d)
	{
		if (x == null) return null;
		if (d == key.length())
			x.val = null;
		else
		{
			char c = key.charAt(d);
			x.next[c] = delete(x.next[c], key, d+1);
		}
		
		if (x.val != null) return x;	//think of this as x.next[c]; if there's another key down the path..
		
		for (char c = 0; c < R; c++)
			if (x.next[c] != null) return x;
		return null;					//We get here if all of the nodes links are null, a.k.a its at the end
	}
	
	public static void main(String[] args)
	{
		TrieST<Integer> trie = new TrieST<Integer>();
		trie.put("Seashell", 1);
		trie.put("Sea", 2);
		trie.put("Season", 3);
		
		System.out.println(trie.longestPrefixOf("Seasonsss"));
		
	}
}









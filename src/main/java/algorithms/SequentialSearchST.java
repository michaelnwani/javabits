package main.java.algorithms;
public class SequentialSearchST<Key, Value>
{
	//uses a linked list implementation
	private Node first; //first node in the linked list
	
	private class Node
	{
		//linked-list node
		Key key;
		Value val;
		Node next;
		public Node(Key key, Value val, Node next)
		{
			this.key = key;
			this.val = val;
			this.next = next;
		}
	}
	
	public Value get(Key key)
	{
		//Search for key, return associated value.
		for (Node x = first; x != null; x = x.next)
		{
			if (key.equals(x.key))
			{
				return x.val;	//search hit
			}
		}
		return null;	//search miss
	}
	
	public void put(Key key, Value val)
	{
		//Search for key. Update value if found; grow table if new.
		for (Node x = first; x != null; x = x.next)
		{
			if (key.equals(x.key))
			{	//Search hit: update val.
				x.val = val; 
				return;
			}
		}
		first = new Node(key, val, first);	//Search miss: add new node to the LL.
	}
	
	//size(), keys() and eager delete() are left for exercises.
}
import java.util.Iterator;
public class Stack<Item> implements Iterable<Item>
{
	private Node first;
	private int N;
	
	private class Node
	{	//nested class to define nodes
		Item item;
		Node next;
	}
	
	public boolean isEmpty() {return N == 0;}
	public int size() {return N;}
	
	public void push(Item item)
	{
		//Add item to top of stack.
		Node oldfirst = first;
		first = new Node();
		first.item = item;
		first.next = oldfirst;
		N++;
	}
	
	public Item pop()
	{
		//Remove item from top of stack.
		Item item = first.item;
		first = first.next;
		N--;
		return item;
	}
	
	//See page 155 for iterator() implementation.
	
	public static void main(String[] args)
	{
		Stack<String> s = new Stack<String>();
		while (!StdIn.isEmpty())
		{
			String item = StdIn.readString();
			if (!item.equals("-"))
			{
				s.push(item);
			}
			else if (!s.isEmpty()) StdOut.print(s.pop() + " ");
		}
		StdOut.println("(" + s.size() + " left on stack)");
	}
	
	public Iterator<Item> iterator()
	{
		return new StackIterator();
	}
	
	private class StackIterator implements Iterator<Item>
	{
		private Node current = first;
		
		private int i = N;
		public boolean hasNext() 	{ return current != null; }
		public Item next() 			{ Item item = current.item; current = current.next; return item; }
		public void remove() 		{ 				}
	}
}
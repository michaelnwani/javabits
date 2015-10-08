public class Queue<Item>
{
	private Node first; //link to least recently added node
	private Node last;	//link to most recently added node
	private int N;	//number of items on the queue
	
	private class Node
	{	//nested class to define nodes
		Item item;
		Node next;
	}
	
	public boolean isEmpty(){return first == null;}
	public int size(){return N;}
	
	public void enqueue(Item item)
	{
		//Add item to the end of the list
		Node oldlast = last;
		last = new Node();
		last.item = item;
		last.next = null;
		if (isEmpty()) first = last;
		else		   oldlast.next = last;
		N++;
	}
	
	public Item dequeue()
	{
		//Remove item from the beginning of the list.
		Item item = first.item;
		first = first.next;
		N--;
		if (isEmpty())	last = null;
		return item;
	}
	
	//See page 155 for iterator() implementation
	public static void main(String[] args)
	{
		Queue<String> q = new Queue<String>();
		while (!StdIn.isEmpty())
		{
			String item = StdIn.readString();
			if (!item.equals("-"))
			{
				q.enqueue(item);
			}
			else if (!q.isEmpty()) StdOut.print(q.dequeue() + " ");
		}
		StdOut.println("(" + q.size() + " left on queue)");
	}
}
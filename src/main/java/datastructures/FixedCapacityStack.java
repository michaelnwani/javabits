package main.java.datastructures;
import java.util.Iterator;

public class FixedCapacityStack<Item>
{
	private Item[] a; //stack entries
	private int N;
	
	public FixedCapacityStack(int cap)
	{
		a = (Item[]) new Object[cap];
	}
	
	public boolean isEmpty()
	{
		return N == 0;
	}
	
	public int size()
	{
		return N;
	}
	
	public void push(Item item)
	{
		if (N == a.length) resize(2*a.length);
		a[N++] = item;
	}
	
	public Item pop()
	{
		Item item = a[--N];
		a[N] = null; //Avoid loitering (holding a reference to an item that is no longer needed)
		//while we couldn't access that index anymore, the array still had a reference to it
		//the compiler didn't know that it was an orphan until that memory address gets overwritten
		if (N > 0 && N == a.length/4) resize(a.length/2);
		return a[--N];
	}
	
	public void resize(int max)
	{
		//Move stack of size N <= max to a new array of size max
		Item[] temp = (Item[]) new Object[max];
		for (int i = 0; i < N; i++){
			temp[i] = a[i];
		}
		a = temp;
	}
	
	
	public static void main(String[] args)
	{
		FixedCapacityStack<String> s;
		s = new FixedCapacityStack<String>(100);
		while (!StdIn.isEmpty())
		{
			String item = StdIn.readString();
			if (!item.equals("-"))
				s.push(item);
			else if (!s.isEmpty()) StdOut.print(s.pop() + " ");
		}
		
		StdOut.println("(" + s.size() + " left on stack)");
	}
}
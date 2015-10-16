package main.java.algorithms;
public class Quick3string
{
	private static int charAt(String s, int d)
	{
		if (d < s.length()) return s.charAt(d); 
		else return -1;
	}
	
	public static void sort(String[] a)
	{
		sort(a, 0, a.length-1, 0);
	}
	
	private static void sort(String[] a, int lo, int hi, int d)
	{
		if (hi <= lo) return;
		
		int lt = lo, gt = hi;
		int v = charAt(a[lo], d);
		int i = lo + 1;
		while (i <= gt)
		{
			int t = charAt(a[i], d);
			if 		(t < v) exch(a, lt++, i++);
			else if (t > v) exch(a, i, gt--);
			else			i++;
		}
		
		// a[lo..lt-1] < v = a[lt..gt] < a[gt+1..hi]
		
		sort(a, lo, lt-1, d);
		if (v >= 0) sort(a, lt, gt, d+1);
		sort(a, gt+1, hi, d);
	}
	
	private static void exch(String[] a, int i, int j)
	{
		String t = a[i]; a[i] = a[j]; a[j] = t;
	}
	
	public static void main(String[] arg)
	{
		String[] a = {
			"4PGC938",
			"2IYE230",
			"3CI0720",
			"1ICK750",
			"1OHV845",
			"4JZY524",
			"1ICK750",
			"3CI0720",
			"1OHV845",
			"1OHV845",
			"2RLA629",
			"2RLA629",
			"3ATW723",
								
		};
		
		for (String s : a)
		{
			System.out.println(s + " ");
		}
		
		System.out.println("\nSorted: \n");
		
		sort(a);
		
		for (String s : a)
		{
			System.out.println(s + " ");
		}
	}
}
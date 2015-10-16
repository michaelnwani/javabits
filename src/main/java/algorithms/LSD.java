package main.java.algorithms;
public class LSD
{
	public static void sort(String[] a, int W)
	{
		//Sort a[] on leading W characters.
		int N = a.length;
		int R = 256;
		String[] aux = new String[N];
		
		for (int d = W-1; d >= 0; d--)
		{
			//Sort by key-indexed counting on dth char.
			//(character-based indexing, a.k.a the char is the key)
			int[] count = new int[R+1];		//Compute frequency counts.
			for (int i = 0; i < N; i++)
				count[a[i].charAt(d) + 1]++; //We do + 1 to keep in line with the next step (think of key 0 as becoming 1)
											//There's nothing at count[0]
											
			for (int r = 0; r < R; r++)		//Transform counts to indices (starting index becomes sum of prev. indices)
				count[r+1] += count[r];		//count index 1 gives back count[0], it's right in front of you damn it.
			
			for (int i = 0; i < N; i++)		//Distribute the data
				aux[count[a[i].charAt(d)]++] = a[i]; //Remember: charAt('0') = index 0. index 0 in count is 0. that's fine
			
			//Put, at this index, this string (++ doesn't happen on aux)
			//we increment here because count[r] is the index of the position in aux[] where the next item
			//with key value r (if any) should be placed.
			
			for (int i = 0; i < N; i++)		//Copy back (we're constantly rewriting it, like quicksort)
				a[i] = aux[i];				
			
		}
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
		
		sort(a, 7);
		
		for (String s : a)
		{
			System.out.println(s + " ");
		}
	}
}
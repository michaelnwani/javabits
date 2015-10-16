package main.java.algorithms;
import java.util.Arrays;

public class TwoSumFast
{
	//Linearithmic solution
	public static int count(int[] a)
	{
		//Count pairs that sum to 0.
		Arrays.sort(a);
		int N = a.length;
		int cnt = 0;
		for (int i = 0; i < N; i++)
		{
			if (BinarySearch.rank(-a[i],a) > i)
				cnt++;
		}
		return cnt;
	}
	
	public static void main(String[] args)
	{
		In in = new In(args[0]);
		int[] a = in.readAllInts();
		StdOut.println(count(a));
	}
}
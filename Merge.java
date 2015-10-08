public class Merge
{
	private static Comparable[] aux; 	//auxiliary array for merges
	
	private static boolean less(Comparable v, Comparable w)
	{
		return v.compareTo(w) < 0;
	}
	
	public static void sort(Comparable[] a)
	{
		aux = new Comparable[a.length]; //Allocate space just once.
		sort(a, 0, a.length -1);
	}
	
	public static void sort(Comparable[] a, int lo, int hi)
	{
		//Sort a[lo..hi].
		//hi <= lo + M; the cutoff M is system-dependent, optimum value between 5 and 15
		if (hi <= lo) return;
		int mid = lo + (hi - lo)/2;
		sort(a, lo, mid);	//Sort left half.
		sort(a, mid+1, hi);	//Sort right half.
		merge(a, lo, mid, hi);	//Merge results
	}
	
	private static void merge(Comparable[] a, int lo, int mid, int hi)
	{
		//Merge a[lo..mid] with a[mid+1..hi].
		int i = lo, j = mid+1;
		for (int k = lo; k <= hi; k++) //Copy a[lo..hi] to aux[lo..hi].
		{
			aux[k] = a[k];
		}
		
		for (int k = lo; k <= hi; k++) //Merge back to a[lo..hi].
		{
			if 		(i > mid)				a[k] = aux[j++];
			else if (j > hi )				a[k] = aux[i++];
			else if (less(aux[j], aux[i])) 	a[k] = aux[j++];
			else							a[k] = aux[i++];
		}
	}
}
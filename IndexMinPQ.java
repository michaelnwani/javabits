public class IndexMinPQ<Key extends Comparable<Key>>
{
	private int N;		//number of elements on PQ
	private int[] pq;	//binary heap using 1-based indexing
	private int[] qp;	//inverse: qp[pq[i]] = pq[qp[i]] = i
	private Key[] keys;	//items with priorities
	public IndexMinPQ(int maxN)
	{
		keys = (Key[]) new Comparable[maxN + 1];
		pq = new int[maxN + 1];
		qp = new int[maxN + 1];
		for (int i = 0; i <= maxN; i++) qp[i] = -1;
		
	}
	
	public boolean isEmpty()
	{
		return N == 0;
	}
	
	public boolean contains(int i)
	{
		//use qp to try and see if this element exists in the queue (inside pq)
		return qp[i] != -1;
	}
	
	public void insert(int i, Key key)
	{
		N++;
		qp[i] = N;
		pq[N] = i;
		keys[i] = key;
		swim(N);
	}
	
	public Key minKey()
	{
		return keys[pq[1]];
	}
	
	public int delMin()
	{
		int indexOfMin = pq[1];
		exch(1, N--);
		sink(1);
		keys[pq[N+1]] = null;
		qp[pq[N+1]] = -1;
		return indexOfMin;
	}
	
	public int minIndex()
	{
		return pq[1];
	}
	
	public void changeKey(int i, Key key)
	{
		keys[i] = key;
		swim(qp[i]);
		sink(qp[i]);
	}
	
	public void delete(int i)
	{
		int index = qp[i];
		exch(index, N--);
		swim(index);
		sink(index);
		keys[i] = null;
		qp[i] = -1;
	}
	
	//needs to be modified
	private boolean less(int i, int j)
	{
		// return pq[i].compareTo(pq[j]) < 0;
		return pq[i] == pq[j];
	}
	
	//needs to be modified
	private void exch(int i, int j)
	{
		// Key t = pq[i]; pq[i] = pq[j]; pq[j] = t;
		int t = pq[i]; pq[i] = pq[j]; pq[j] = t;
	}
	
	private void swim(int k)
	{
		while (k > 1 && less(k/2, k))
		{
			exch(k/2, k);
			k = k/2;
		}
	}
	
	private void sink(int k)
	{
		while (2*k <= N)
		{
			int j = 2*k;
			if (j < N && less(j, j+1)) j++;
			if (!less(k, j)) break;
			exch(k, j);
			k = j;
		}
	}
	
}
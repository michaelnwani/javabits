package main.java.algorithms;
//Union-find implementation
public class UF
{
	private int[] id; //access to component id (site indexed)
	private int count; //number of components
	
	public UF(int N)
	{	//Initialize component id array.
		count = N;	
		id = new int[N];
		for (int i = 0; i < N; i++)
			id[i] = i;
	}
	
	public int count()
	{
		return count;
	}
	
	public boolean connected(int p, int q)
	{
		return find(p) == find(q);
	}
	
	public int find(int p)
	{
		//Find component name.
		while (p != id[p]) p = id[p];
		return p;
	}
	public void union(int p, int q)
	{	
		//Give p and q the same root. (In this way, they are connected)
		int i = find(p);
		int j = find(q);
		if (i == j) return;
		
		id[i] = j;
		
		count--;
	}
		
	
	public static void main(String[] args)
	{
		//Solve dynamic connectivity problem on StdIn.
		int N = StdIn.readInt(); //Read number of sites.
		UF uf = new UF(N);	//Initialize N components.
		while (!StdIn.isEmpty())
		{
			int p = StdIn.readInt();
			int q = StdIn.readInt();	//Read pair to connect
			if (uf.connected(p, q)) continue;	//Ignore if already connected/
			uf.union(p, q);	//Combine components (equivalent classes; pairs)
			StdOut.println(p + " " + q); //and print connection.
		}
		StdOut.println(uf.count() + " components");
	}
}
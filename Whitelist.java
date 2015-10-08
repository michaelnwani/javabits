public class Whitelist
{
	public static void main(String[] args)
	{
		In in = new In(args[0]);
		int[] w = in.readAllInts();
		StaticSETofInts set = new StaticSETofInts(w);
		while (!StdIn.isEmpty())
		{
			//Read key, print if not in whitelist.
			int key = StdIn.readInt();
			if (!set.contains(key))
			{
				StdOut.println(key);
			}
		}
	}
}
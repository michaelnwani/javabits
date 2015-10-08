import java.util.HashMap;
import java.util.Set;
import java.util.HashSet;
import java.util.Queue;

public class LookupIndex
{
	public static void main(String[] args)
	{
		In in = new In(args[0]); //index database
		String sp = args[1];
		HashMap<String, HashSet<String>> st = new HashMap<String, HashSet<String>>();
		// HashMap<String, HashSet<String>> ts = new HashMap<String, HashSet<String>>();
		
		while (in.hasNextLine())
		{
			String blah = in.readLine();
			StdOut.println("blah: " + blah);
			
			String[] a = blah.split(sp);
			StdOut.println("a :" + a);
			String key = a[0];
			StdOut.println("key: " + key);
			for (int i = 1; i < a.length; i++)
			{
				String val = a[i];
				
				if (st.get(key) == null) st.put(key, new HashSet<String>());
				// if (ts.get(key) == null) ts.put(key, new HashSet<String>());
				st.get(key).add(val);
				// ts.get(key).add(val);
			}
			StdOut.println("ST size: " + st.size());
		}
		
		while (!StdIn.isEmpty())
		{
			String query = StdIn.readLine();
			Set<String> keys = st.keySet();
			StdOut.println("You entered: " + query);
			for (String q : keys)
			{
				if (st.get(q).contains(query))
				{
					StdOut.println(" " + q);
				}

			}
						//
			// Set<String> keysts = ts.keySet();
			// for (String q : keysts)
			// {
			// 	if (ts.get(q).contains(query))
			// 	{
			// 		StdOut.println(" " + q);
			// 	}
			// }
			
			
		}
		
	}
}
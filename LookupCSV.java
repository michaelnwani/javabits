import java.util.HashMap;
public class LookupCSV
{
	public static void main(String[] args)
	{
		In in = new In(args[0]);
		int keyField = Integer.parseInt(args[1]);
		int valField = Integer.parseInt(args[2]);
		
		HashMap<String, String> st = new HashMap<String, String>();
		while (in.hasNextLine())
		{
			String line = in.readLine();
			String[] tokens = line.split(",");
			String key = tokens[keyField];
			String val = tokens[valField];
			st.put(key, val);
		}
		while (!StdIn.isEmpty())
		{
			String query = StdIn.readString();
			if (st.get(query) != null)
			{
				StdOut.println(st.get(query));
			}
		}
	}
}
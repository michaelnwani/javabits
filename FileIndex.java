import java.io.File;
import java.util.HashSet;
import java.util.HashMap;
public class FileIndex
{
	public static void main(String[] args)
	{
		HashMap<String, HashSet<File>> st = new HashMap<String, HashSet<File>>();
		for (String filename : args)
		{
			File file = new File(filename);
			In in = new In(file);
			while (!in.isEmpty())
			{
				String word = in.readString();
				if (st.get(word) == null) st.put(word, new HashSet<File>());
				HashSet<File> set = st.get(word);
				set.add(file);
			}
		}
		
		while (!StdIn.isEmpty())
		{
			String query = StdIn.readString();
			if (st.get(query) != null)
			{
				for (File file : st.get(query))
				{
					StdOut.println(" " + file.getName());
				}
			}
		}
	}
}
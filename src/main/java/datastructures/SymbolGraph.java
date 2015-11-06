// Symbol graph data type

public class SymbolGraph {
	private ST<String, Integer> st;	// String -> index
	private String[] keys;			// index -> String
	private Graph G;				// the graph

	public SymbolGraph(String stream, String sp) {
		st = new ST<String, Integer>();				// First pass
		In in = new In(stream);						//	builds the index
		while (in.hasNextLine()) {
			String[] a = in.readLine().split(sp);	// by reading strings
			for (int i = 0; i < a.length; i++) {	// to associate each
				if (!st.contains(a[i])) {			// distinct string
					st.put(a[i], st.size());		// with an index.
				}
			}
		}

		keys = new String[st.size()];				// Inverted index
		for (String name : st.keys()) {				// 	to get string keys
			keys[st.get(name)] = name;				// 	is an array.
		}

		G = new Graph(st.size());
		in = new In(stream);						// Second pass
		while (in.hasNextLine()) {					//	builds the graph
			String[] a = in.readLine().split(sp);	//	by connecting the
			int v = st.get(a[0]);					//	first vertex
			for (int i = 1; i < a.length; i++) {	// 	on each line
				G.addEdge(v, st.get(a[i]));			//	to all the others.
			}
		}
	}

	public boolean contains(String s) {
		return st.contains(s);
	}

	public int index(String s) {
		return st.get(s);
	}

	public String name(int v) {
		return keys[v];
	}

	public Graph G() {
		return G;
	}

	public static void main(String[] args) {
		String filename = args[0];
		String delim = args[1];
		SymbolGraph sg = new SymbolGraph(filename, delim);

		Graph G = sg.G();

		while (StdIn.hasNextLine()) {
			String source = StdIn.readLine();
			for (int v : G.adj(sg.index(source))) {
				StdOut.println("	" + sg.name(v));
			}
		}
	}
}



// Graph data type
public class Graph {
	private final int V;		// number of vertices
	private int E;				// number of edges
	private Bag<Integer>[] adj;	// adjacency lists

	public Graph(int V) {
		this.V = V;
		this.E = 0;
		adj = (Bag<Integer>[]) new Bag[V];	// Create array of lists.
		for (int v = 0; v < V; v++) {		// Initialize all lists
			adj[v] = new Bag<Integer>();	// 	to empty.
		}
	}

	public Graph(In in) {
		this(in.readInt());		// Read V and construct this graph.
		int E = in.readInt();	// Read E.
		for (int i = 0; i < E; i++) {
			// Add an edge.
			int v = in.readInt();	// Read a vertex,
			int w = in.readInt();	//	read another vertex,
			addEdge(v, w);			//	and add edge connecting them.
		}
	}

	public int V() {
		return V;
	}

	public int E() {
		return E;
	}

	// undirected graph, so the link is mutual
	public void addEdge(int v, int w) {
		adj[v].add(w);	// Add w to v's list.
		adj[w].add(v);	// Add v to w's list.
		E++;
	}

	public Iterable<Integer> adj(int v) {
		return adj[v];
	}

	// Compute the degree of v
	public static int degree(Graph G, int v) {
		int degree = 0;
		for (int w : G.adj(v)) {
			degree++;
		}

		return degree;
	}

	// Compute maximum degree in the graph
	public static int maxDegree(Graph G) {

		int max = 0;
		for (int v = 0; v < G.V(); v++) {
			int degree = degree(G, v);
			if (degree > max) {
				max = degree;
			}

		}

		return max;
	}

	// Compute average degree
	public static double averageDegree(Graph G) {
		return 2.0 * G.E() / G.V();
	}

	// Count self-loops
	public static int numberOfSelfLoops(Graph G) {
		int count = 0;
		for (int v = 0; v < G.V(); v++) {
			for (int w : G.adj(v)) {
				if (v == w) {
					count++;
				}
			}
		}
		return count/2;	// each edge counted twice
	}

	@Override
	public String toString() {
		String s = V + " vertices, " + E + " edges\n";
		for (int v = 0; v < V; v++) {
			s += v + ": ";
			for (int w : this.adj(v)) {
				s += w + " ";
			}
			s += "\n";
		}
		return s;
	}

	public static void main(String[] args) {

		Graph g = new Graph(new In(args[0]));
		System.out.println(g);
	}
}






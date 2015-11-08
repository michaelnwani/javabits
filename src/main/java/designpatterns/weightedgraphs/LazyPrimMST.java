// Lazy version of Prim's MST algorithm
// space proportional to E
// time proportional to ElogE in the worst case
public class LazyPrimMST {
	private boolean[] marked;	// MST vertices
	private Queue<Edge> mst;	// MST edges
	private MinPQ<Edge> pq;		// crossing (and ineligible) edges

	public LazyPrimMST(EdgeWeightedGraph G) {
		pq = new MinPQ<Edge>();
		marked = new boolean[G.V()];
		mst = new Queue<Edge>();

		visit(G, 0);	// assumes G is connected (see ex. 4.3.22)
		while (!pq.isEmpty()) {
			Edge e = pq.delMin();		// Get lowest-weight from pq.
			int v = e.either();			
			int w = e.other(v);
			if (marked[v] && marked[w]) {
				continue;				// Skip if ineligible
			}
			mst.enqueue(e);				// Add edge to tree
			if (!marked[v]) {			// Add vertex to tree (either v or w).
				visit(G, v);
			}

			if (!marked[w]) {
				visit(G, w);
			}
		}

	}

	private void visit(EdgeWeightedGraph G, int v) {
		// Mark v and add to pq all edges from v to unmarked vertices.
		marked[v] = true;
		for (Edge e : G.adj(v)) {
			if (!marked[e.other(v)]) {
				pq.insert(e);
			}
		}
	}

	public Iterable<Edge> edges() {
		return mst;
	}

	public double weight() {
		// Ex. 4.3.31
	}
}
// Prim's MST algorithm (eager version)
// Keeps eligible crossing edges on an index priority queue
// constructs the MST of an EWG in time prop. to ElogV
// and space proportional to V (big improvement from the lazy version)
public class PrimMST {
	private Edge[] edgeTo;			// shortest edge from tree vertex
	private double[] distTo;		// distTo[w] = edgeTo[w].weight()
	private boolean[] marked;		// true if v on tree
	private IndexMinPQ<Double> pq;	// eligible crossing edges

	public PrimMST(EdgeWeightedGraph G) {
		edgeTo = new Edge[G.V()];
		distTo = new double[G.V()];
		marked = new boolean[G.V()];
		for (int v = 0; v < G.V(); v++) {
			distTo[v] = Double.POSITIVE_INFINITY;
		}
		pq = new IndexMinPQ<Double>(G.V());

		distTo[0] = 0.0;
		pq.insert(0, 0.0);			// Initialize pq with 0, weight 0.
		while (!pq.isEmpty()) {		// delMin() here returns its index
			visit(G, pq.delMin());	// Add closest vertex to tree
		}
	}

	private void visit(EdgeWeightedGraph G, int v) {
		// Add v to tree; update data structures.
		marked[v] = true;
		for (Edge e : G.adj(v)) {
			int w = e.other(v);
			if (marked[w]) {
				continue;	// v-w is an ineligible edge
			}

			if (e.weight() < distTo[w]) {
				// Edge e is new best connection from tree to w.
				edgeTo[w] = e;
				distTo[w] = e.weight();
				if (pq.contains(w)) {
					pq.changeKey(w, distTo[w]);
				} else {
					pq.insert(w, distTo[w]);
				}
			}
		}
	}

	public Iterable<Edge> edges() {
		// Ex. 4.3.21
	}

	public double weight() {
		// Ex. 4.3.31
	}
}
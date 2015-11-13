// Kruskal's MST algorithm
// space proportional to E, time proportional to ElogE

public class KruskalMST{
	private Queue<Edge> mst;

	public KruskalMST(EdgeWeightedGraph G) {
		mst = new Queue<Edge>();
		MinPQ<Edge> pq = new MinPQ<Edge>();
		for (Edge e : G.edges()) {
			pq.insert(e);
		}
		UF uf = new UF(G.V());

		while (!pq.isEmpty() && mst.size() < G.V()-1) {
			Edge e = pq.delMin();		// Get min weight edge on pq and its vertices.
			int v = e.either();		
			int w = e.other(v);
			if (uf.connected(v, w)) { 	// Ignore ineligible edges.
				continue;
			}
			uf.union(v, w);				// Merge components.
			mst.enqueue(e);
		}
	}

	public Iterable<Edge> edges() {
		return mst;
	}

	public double weight() {
		// Ex. 4.3.31
	}
}
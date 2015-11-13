// Dijkstra's shortest-paths (SPT) algorithm

public class DijkstraSP {

	// our tree is essentially this DirectedEdge[] and the double[]
	private DirectedEdge[] edgeTo;
	private double[] distTo;
	private IndexMinPQ<Double> pq;

	public DijkstraSP(EdgeWeightedDigraph G, int s) {
		edgeTo = new DirectedEdge[G.V()];
		distTo = new double[G.V()];
		pq = new IndexMinPQ<Double>(G.V());

		for (int v = 0; v < G.V(); v++) {
			distTo[v] = Double.POSITIVE_INFINITY;
		}

		distTo[s] = 0.0;
		pq.insert(s, 0.0);
		while (!pq.isEmpty()) {
			relax(G, pq.delMin());
		}
	}

	private void relax(EdgeWeightedDigraph G, int v) {
		for (DirectedEdge e : G.adj(v)) {
			int w = e.to();
			if (distTo[w] > distTo[v] + e.weight()) {
				// needs to be relaxed
				distTo[w] = distTo[v] + e.weight();
				edgeTo[w] = e;
				if (pq.contains(w)) {
					pq.changeKey(w, distTo[w]);
				} else {
					pq.insert(w, distTo[w]);
				}
			} // else this path we're looking at is 'ineligible'
		}
	}

	// standard client query methods
	// for SPT implementations
	public double distTo(int v) {
		return distTo[v];
	}

	public boolean hasPathTo(int v) {
		return distTo[v] < Double.POSITIVE_INFINITY;
	}

	public Iterable<DirectedEdge> pathTo(int v) {
		if (!hasPathTo(v)) {
			return null;
		}

		Stack<DirectedEdge> path = new Stack<DirectedEdge>();
		for (DirectedEdge e = edgeTo[v]; e != null; e = edgeTo[e.from()]) {
			path.push(e);
		}
		return path;
	}

	public static void main(String[] args) {
		EdgeWeightedDigraph G;
		G = new EdgeWeightedDigraph(new In(args[0]));
		int s = Integer.parseInt(args[1]);
		DijkstraSP sp = new DijkstraSP(G, s);

		for (int t = 0; t < G.V(); t++) {
			System.out.print(s + " to " + t);
			System.out.printf(" (%4.2f): ", sp.distTo(t));
			if (sp.hasPathTo(t)) {
				for (DirectedEdge e : sp.pathTo(t)) {
					System.out.print(e + "  ");
				}
			}
			System.out.println();
		}
	}

}




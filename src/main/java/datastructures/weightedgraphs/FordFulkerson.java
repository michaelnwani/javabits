// Ford-Fulkerson shortest-augmenting path maxflow algorithm
// augmenting path -- we can add more flow

// Proposition: the # of augmenting paths needed in the shortest-augmenting-path
// implementation of the Ford-Fulkerson maxflow algorithm for a flow network
// with V vertices and E edges is at most EV/2 (much less usually)

// worst-case time proportional to O(V(E^2))
public class FordFulkerson {
	private boolean[] marked;	// Is s->v path in residual graph?
	private FlowEdge[] edgeTo;	// last edge on shortest s->v path
	private double value;		// current value of maxflow
	
	public FordFulkerson(FlowNetwork G, int s, int t) {
		// Find maxflow in flow network G from s to t (source to sink)
		
		while (hasAugmentingPath(G, s, t)) {
			// While there exists an augmenting path, use it.
			
			// Compute bottleneck capacity.
			double bottle = Double.POSITIVE_INFINITY;
			for (int v = t; v != s; v = edgeTo[v].other(v)) {
				bottle = Math.min(bottle, edgeTo[v].residualCapacityTo(v));
			}
			
			// Augment flow (by the smallest unit increase throughout the network)
			for (int v = t; v != s; v = edgeTo[v].other(v)) {
				edgeTo[v].addResidualFlowTo(v, bottle);
			}
			
			value += bottle;
		}
	}
	
	// finding an augmenting path in the residual network via breadth-first search
	private boolean hasAugmentingPath(FlowNetwork G, int s, int t) {
		marked = new boolean[G.V()];	// Is path to this vertex known?
		edgeTo = new FlowEdge[G.V()];	// last edge on path
		Queue<Integer> q = new Queue<Integer>();
		
		marked[s] = true;				// Mark the source
		q.enqueue(s);					//	and put it on the queue.
		while (!q.isEmpty()) {
			int v = q.dequeue();
			// 'undirected' implementation, to look at it from a forward & backward
			// perspective.
			for (FlowEdge e : G.adj(v)) {
				int w = e.other(v);
				// this is set up to always lookup remaining capacity (forward edge, BFS)
				if (e.residualCapacityTo(w) > 0 && !marked[w]) {
					// For every edge to an unmarked vertex (in residual network)
					edgeTo[w] = e;		// Save the last edge on a path.
					marked[w] = true;	// Mark w because a path is known
					q.enqueue(w);		//	and add it to the queue.
				}
			}
		}
		// can only return true if there's a remaining capacity to the sink 
		// that hasn't been filled (there's an augmenting path)
		return marked[t];
	}
	
	public double value() {
		return value;
	}
	
	public boolean inCut(int v) {
		return marked[v];
	}
	
	public static void main(String[] args) {
		FlowNetwork G = new FlowNetwork(new In(args[0]));
		int s = 0;
		int t = G.V() - 1;
		FordFulkerson maxflow = new FordFulkerson(G, s, t);
		
		StdOut.println("Max flow from " + s + " to " + t);
		for (int v = 0; v < G.V(); v++) {
			for (FlowEdge e : G.adj(v)) {
				if ((v == e.from()) && e.flow() > 0) {
					StdOut.println("  " + e);
				}
			}
		}
		StdOut.println("Max flow value = " + maxflow.value());
	}
}
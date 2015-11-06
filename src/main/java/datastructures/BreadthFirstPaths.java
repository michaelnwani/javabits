// Breadth-first search to find paths in a graph
import java.util.Queue;
import java.util.ArrayDeque;
public class BreadthFirstPaths {

	private boolean[] marked;	// is a shortest path to this vertex known?
	private int[] edgeTo;		// last vertex on known path to this vertex	
	private final int s;		// source vertex

	public BreadthFirstPaths(Graph G, int s) {
		// vSize = G.V();
		marked = new boolean[G.V()];
		edgeTo = new int[G.V()];
		this.s = s;
		bfs(G, s);
	}

	private void bfs(Graph G, int s) {
		ArrayDeque<Integer> queue = new ArrayDeque<Integer>();
		marked[s] = true;	// mark the source
		queue.add(s);	//	and put it on the queue.
		while (!queue.isEmpty()) {
			int v = queue.poll();	// remove next vertex from the queue.
			for (int w : G.adj(v)) {
				if (!marked[w]) {
					edgeTo[w] = v;		// save last edge on a shortest path,
					marked[w] = true;	// mark it because path is known,
					queue.add(w);	// and add it to the queue.
				}
			}
		}
	}

	public boolean hasPathTo(int v) {
		return marked[v];
	}

	public Iterable<Integer> pathTo(int v) {
		if (!hasPathTo(v)) {
			return null;
		}

		// edgeTo[x] is 'another vertex that's adjacent to x'
		ArrayDeque<Integer> queue = new ArrayDeque<Integer>();
		for (int x = v; x != s; x = edgeTo[x]) {
			queue.add(x);
		}
		queue.add(s);

		return queue;
	}
}
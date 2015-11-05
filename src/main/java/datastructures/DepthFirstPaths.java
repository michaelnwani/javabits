import java.util.Stack;
import java.util.Iterator;
import java.util.ListIterator;
// Depth-first search to find paths in a graph
public class DepthFirstPaths {
	private boolean[] marked;	// Has dfs() been called for this vertex?
	private int[] edgeTo;		// last vertex to known path to this vertex
	private final int s;		// source

	public DepthFirstPaths(Graph G, int s) {
		marked = new boolean[G.V()];
		edgeTo = new int[G.V()];
		this.s = s;
		dfs(G, s);
	}

	private void dfs(Graph G, int v) {
		marked[v] = true;
		for (int w : G.adj(v)) {
			if (!marked[w]) {
				// edgeTo[w] = v means that v-w was the edge used to access w
				// for the first time.
				edgeTo[w] = v;
				dfs(G, w);
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

		Stack<Integer> path = new Stack<Integer>();
		// edgeTo[x] is 'another vertex that's adjacent to x'
		for (int x = v; x != s; x = edgeTo[x]) {
			path.push(x);
		}
		path.push(s);
		return path;
	}

	public static void main(String[] args) {
		Graph G = new Graph(new In(args[0]));
		int s = Integer.parseInt(args[1]);
		DepthFirstPaths search = new DepthFirstPaths(G, s);
		for (int v = 0; v < G.V(); v++) {
			System.out.print(s + " to " + v + ": ");
			if (search.hasPathTo(v)) {
				// default behavior was not as expected with the built-in Stack...
				Stack<Integer> eh = (Stack<Integer>)search.pathTo(v);
				ListIterator<Integer> iter = eh.listIterator();
				while (iter.hasNext()) {
					iter.next();
				}
				while (iter.hasPrevious()) {
					int x = iter.previous();
					if (x == s) {
						System.out.print(x);
					} else {
						System.out.print("-"+x);
					}
				}
				// for (int x : search.pathTo(v)) {
					
				// 	if (x == s) {
				// 		System.out.print(x);
				// 	} else {
				// 		System.out.print("-"+x);
				// 	}
				// }
			}
			System.out.println();
		}
	}
}
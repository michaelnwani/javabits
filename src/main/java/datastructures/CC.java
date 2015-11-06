// Depth-first search to find connected components in a graph
import java.util.Queue;
import java.util.ArrayDeque;
public class CC {

	private boolean[] marked;
	private int[] id;
	private int count;

	public CC(Graph G) {
		marked = new boolean[G.V()];
		id = new int[G.V()];
		for (int s = 0; s < G.V(); s++) {
			if (!marked[s]) {
				dfs(G, s);
				count++;
			}
		}
	}

	public void dfs(Graph G, int v) {
		marked[v] = true;
		// all vertices in the same CC end up with the same component id
		id[v] = count;
		for (int w : G.adj(v)) {
			if (!marked[w]) {
				dfs(G, w);
			}
		}
	}

	public boolean connected(int v, int w) {
		return id[v] == id[w];
	}

	public int id(int v) {
		return id[v];
	}

	public int count() {
		return count;
	}

	// Test client for connected components API
	public static void main(String[] args) {
		Graph G = new Graph(new In(args[0]));
		CC cc = new CC(G);

		int M = cc.count();
		StdOut.println(M + " components");

		ArrayDeque<Integer>[] components;
		components = (ArrayDeque<Integer>[]) new ArrayDeque[M];
		for (int i = 0; i < M; i++) {
			components[i] = new ArrayDeque<Integer>();
		}

		for (int v = 0; v < G.V(); v++) {
			components[cc.id(v)].add(v);
		}

		for (int i = 0; i < M; i++) {
			for (int v : components[i]) {
				System.out.print(v + " ");
			}
			System.out.println();
		}
	}
}




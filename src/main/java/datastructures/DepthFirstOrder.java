// Depth-first search vertex ordering in a digraph

public class DepthFirstOrder {
	private boolean[] marked;

	private Queue<Integer> pre;			// vertices in preorder
	private Queue<Integer> post;		// vertices in postorder
	private Stack<Integer> reversePost;	// vertices in reverse postorder

	public DepthFirstOrder(Digraph G) {
		pre = new Queue<Integer>();
		post = new Queue<Integer>();
		reversePost = new Stack<Integer>();
		marked = new boolean[G.V()];

		for (int v = 0; v < G.V(); v++) {
			if (!marked[v]) {
				dfs(G, v);
			}
		}
	}

	private void dfs(Digraph G, int v) {
		pre.enqueue(v);

		marked[v] = true;
		for (int w : G.adj(v)) {
			if (!marked[w]) {
				dfs(G, w);
			}
		}

		post.enqueue(v);
		reversePost.push(v);
	}

	public Iterable<Integer> preorder() {
		return pre;
	}

	public Iterable<Integer> postorder() {
		return post;
	}

	public Iterable<Integer> reversePostorder() {
		return reversePost;
	}
}
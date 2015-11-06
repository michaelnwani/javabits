// Topological sort (Reverse postorder in a DAG)

public class Topological {

	private Iterable<Integer> order;	// topological order

	public Topological(Digraph G) {
		DirectedCycle cyclefinder = new DirectedCycle(G);
		if (!cyclefinder.hasCycle()) {
			DepthFirstOrder dfs = new DepthFirstOrder(G);
			order = dfs.reversePostorder();
		}
	}

	public Iterable<Integer> order() {
		return order;
	}

	public boolean isDAG() {
		return order != null;
	}

	public static void main(String[] args) {
		String filename = args[0];
		String seperator = args[1];
		// SymbolDigraph
		SymbolDigraph sg = new SymbolDigraph(filename, seperator);

		Topological top = new Topological(sg.G());

		for (int v : top.order()) {
			System.out.println(sg.name(v));
		}
	}
}
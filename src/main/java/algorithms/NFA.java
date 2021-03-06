package main.java.algorithms;

// Regular expression pattern matching (grep)
public class NFA {

	private char[] re; 	// match transitions
	private Digraph G; 	// epsilon transitions
	private int M;		// number of states

	// builds an NFA (Non-deterministic Finite state Automaton) corresponding to
	// a given RE by creating a digraph of empty-string transitions
	// Proposition: Building the NFA corresponding to an M-character RE takes time
	// and space proportional to M in the worse case.
	public NFA(String regexp) {
		// Create the NFA for the given regular expression.
		Stack<Integer> ops = new Stack<Integer>();
		re = regexp.toCharArray();
		M = re.length();
		G = new Digraph(M+1);

		for (int i = 0; i < M ; i++) {
			int lp = i;
			if (re[i] == '(' || re[i] == '|') {
				ops.push(i);
			}
			else if (re[i] == ')') {
				int or = ops.pop();
				if (re[or] == '|') {
					lp = ops.pop();
					G.addEdge(lp, or+1);
					G.addEdge(or, i);
				} else {
					lp = or;
				}

			}

			if (i < M-1 && re[i+1] == '*') { // lookahead
				G.addEdge(lp, i+1);
				G.addEdge(i+1, lp);
			}

			if (re[i] == '(' || re[i] == '*' || re[i] == ')') {
				G.addEdge(i, i+1);
			}
		}
	}

	public boolean recognizes(String txt) {
		// Does the NFA recognize txt?
		Bag<Integer> pc = new Bag<Integer>();
		DirectedDFS dfs = new DirectedDFS(G, 0);
		for (int v = 0; v < G.V(); v++) {
			if (dfs.marked(v)) {
				pc.add(v);
			}
		}
		for (int i = 0; i < txt.length(); i++) {
			// Compute possible NFA states for txt[i+1].
			Bag<Integer> states = new Bag<Integer>();
			for (int v : pc) {
				if (v < M) {
					if (re[v] == txt.charAt(i) || re[v] == '.') {
						states.add(v+1);
					}
				}
			}

			pc = new Bag<Integer>();
			dfs = new DirectedDFS(G, states);
			for (int v = 0; v < G.V(); v++) {
				if (dfs.marked(v)) {
					pc.add(v);
				}
			}
		}
		for (int v : pc) {
			if (v == M) {
				return true;
			}
		}

		return false;
	}
	
}





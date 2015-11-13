// Directed weighted edge data type
public class DirectedEdge {
	private final int v;			// edge tail
	private final int w;			// edge head
	private final double weight;	// edge weight

	public DirectedEdge(int v, int w, double weight) {
		this.v = v;
		this.w = w;
		this.weight = weight;
	}

	public double weight() {
		return weight;
	}

	public int from() {
		return v;
	}

	public int to() {
		return w;
	}

	@Override
	public String toString() {
		return String.format("%d-%d %.2f", v, w, weight);
	}
}
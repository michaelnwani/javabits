// Flow-edge data type (residual network)

public class FlowEdge {
	private final int v;			// edge source
	private final int w;			// edge target
	private final double capacity;	// capacity
	private double flow;			// flow
	
	public FlowEdge(int v, int w, double capacity) {
		this.v = v;
		this.w = w;
		this.capacity = capacity;
		this.flow = 0.0;
	}
	
	public int from() {
		return v;
	}
	
	public int to() {
		return w;
	}
	
	public double capacity() {
		return capacity;
	}
	
	public double flow() {
		return flow;
	}
	
	public int other(int vertex) {
		if (vertex == v) {
			return w;
		} else if (vertex == w) {
			return v;
		} else throw new RuntimeException("Inconsistent edge");
	}
	
	public double residualCapacityTo(int vertex) {
		if (vertex == v) {
			return flow;
		} else if (vertex == w) {
			return capacity - flow;
		} else throw new RuntimeException("Inconsistent edge");
	}
	
	public void addResidualFlowTo(int vertex, double delta) {
		// not doing checks for preconditions/postconditions/invariants..
		if (vertex == v) {
			flow -= delta;
		} else if (vertex == w) {
			flow += delta;
		} else throw new RuntimeException("Inconsistent edge");
	}
	
	@Override
	public String toString() {
		return String.format("%d->%d %.2f %.2f", v, w, capacity, flow);
	}
	
}
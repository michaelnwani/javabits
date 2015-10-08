public class Stats
{
	public static void main(String[] args) {
		Bag<Double> numbers = new Bag<Double>();
		
		while (!StdIn.isEmpty()) {
			numbers.add(StdIn.readDouble());
		}
		int N = numbers.size();
		
		double sum = 0.0;
		for (double x : numbers){ //auto-unboxing
			sum += x;
		}
		double mean = sum/N;
		
		sum = 0.0;
		for (double x : numbers){
			sum += ((x - mean) * (x - mean)); //sample variance is this div. by N-1
		}
		double std = Math.sqrt(sum/(N-1)); //standard dev.: sample variance divided by N-1
		
		StdOut.printf("Mean: %.2f\n", mean);
		StdOut.printf("Std dev: %.2f\n", std);
	}
}
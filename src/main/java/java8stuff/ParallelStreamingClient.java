import java.util.stream.*;
import java.util.List;
import java.util.ArrayList;
import java.util.Optional;
import java.util.UUID;
import java.util.concurrent.*;
public class ParallelStreamingClient {
	public static void main(String[] args) {
		
		int max = 1000000;
		List<String> values = new ArrayList<>(max);
		for (int i = 0; i < max; i++) {
			UUID uuid = UUID.randomUUID();
			values.add(uuid.toString());
		}
		
		long t0 = System.nanoTime();
		
		// Sequential Sort:
		long count = values.stream().sorted().count();
		System.out.println(count);
		
		long t1 = System.nanoTime();
		
		//nanoseconds to milliseconds
		long millis = TimeUnit.NANOSECONDS.toMillis(t1 - t0);
		
		System.out.println(String.format("sequential sort took: %d ms", millis));
		
		System.out.println();
		
		// Parallel Sort (over 50% faster):
		t0 = System.nanoTime();
		
		count = values.parallelStream().sorted().count();
		System.out.println(count);
		
		t1 = System.nanoTime();
		millis = TimeUnit.NANOSECONDS.toMillis(t1 - t0);
		System.out.println(String.format("parallel sort took: %d ms", millis));
	}
}
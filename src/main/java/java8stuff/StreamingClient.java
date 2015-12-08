import java.util.stream.*;
import java.util.List;
import java.util.ArrayList;
import java.util.Optional;
// java.util.stream.Stream represents a sequence of elements on which one or more operations
// can be performed. Stream operations are either 'intermediate' or 'terminal'
// (intermediate you can chain)
public class StreamingClient {
	public static void main(String[] args) {
		
		// Collections in Java 8 are extended so you can simply create streams
		// either by calling Collection.stream() or Collection.parallelStream()
		List<String> stringCollection = new ArrayList<>();
		stringCollection.add("ddd2");
		stringCollection.add("aaa2");
		stringCollection.add("bbb1");
		stringCollection.add("aaa1");
		stringCollection.add("bbb3");
		stringCollection.add("ccc");
		stringCollection.add("bbb2");
		stringCollection.add("ddd1");
		
		// filter() accepts a predicate (boolean-valued function) 
		// to filter all elements of the stream
		// it's intermediate which enables us to call forEach, which is terminal
		// forEach() accepts a consumer to be executed for each element in the filtered stream
		// Predicate<T>: Functional Interface (implicitly defining its 1 abstract method)
		stringCollection.stream().filter((s) -> s.startsWith("a"))
			.forEach(System.out::println);
		
		System.out.println();
		
		// sorted() - intermediate operation which returns a sorted view of the stream
		// in natural order unless you pass a custom Comparator.
		stringCollection.stream().sorted().forEach(System.out::println);
		
		System.out.println();
		
		// map() - intermediate that converts each element into another object via a given function
		stringCollection.stream().map(String::toUpperCase).sorted()
			.forEach(System.out::println);
		
		System.out.println();
		
		// anyMatch(), allMatch(), noneMatch() - predicate terminal operations
		boolean anyStartsWithA = 
			stringCollection.stream().anyMatch((s) -> s.startsWith("a"));
		
		System.out.println(anyStartsWithA);
		
		boolean allStartsWithA = 
			stringCollection.stream().allMatch((s) -> s.startsWith("a"));
		
		System.out.println(allStartsWithA);
		
		boolean nonStartsWithZ = 
			stringCollection.stream().noneMatch((s) -> s.startsWith("z"));
		
		System.out.println(nonStartsWithZ);
		
		System.out.println();
		
		// count() - terminal operation, returns number of elements in the stream
		// as a long
		long startsWithB = 
			stringCollection.stream().filter((s) -> s.startsWith("b")).count();
		System.out.println(startsWithB); // 3
		
		System.out.println();
		
		// reduce() - terminal operation that performs a reduction on the elements
		// of the stream with the given function, and returns an Optional
		Optional<String> reduced = 
			stringCollection.stream().sorted().reduce((s1, s2) -> s1 + "#" + s2);
		reduced.ifPresent(System.out::println);
	}
}
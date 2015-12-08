// JDK 1.8 brought these in
import java.util.Objects;
import java.util.Comparator;
import java.util.Optional;
import java.util.function.*;
class Person {
	String firstName;
	String lastName;
	
	Person() {
	}
		
	Person(String firstName, String lastName) {
		this.firstName = firstName;
		this.lastName = lastName;
	}
}
public class FunctionalInterfaces {
	public static void main(String[] args) {
		// Predicates are boolean-valued functions of one argument.
		// the interface contains various default methods for composing
		// predicates to complex logical terms (and, or, negate)
		Predicate<String> predicate = (s) -> s.length() > 0;
		System.out.println(predicate.test("foo"));	// true
		System.out.println(predicate.negate().test("foo"));	// false
		
		Predicate<Boolean> nonNull = Objects::nonNull;
		Predicate<Boolean> isNull = Objects::isNull;
		
		Predicate<String> isEmpty = String::isEmpty;
		Predicate<String> isNotEmpty = isEmpty.negate();
		
		// Functions accept one argument and produce a result. Default methods
		// can be used to chain multiple functions together ('compose', 'andThen').
		Function<String, Integer> toInteger = Integer::valueOf;
		
		// jdk 1.8: String.valueOf overloaded method that'll return an object of type object
		// which is the superclass for Function
		Function<String, String> backToString = toInteger.andThen(String::valueOf);
		System.out.println(backToString.apply("123")); // "123"
		
		// Suppliers produce a result of a given generic type. They don't accept arg's.
		Supplier<Person> personSupplier = Person::new;
		personSupplier.get();	// new Person
		
		// Consumers represent operations to be performed on a single input arg.
		Consumer<Person> greeter = (p) -> System.out.println("Hello " + p.firstName);
		greeter.accept(new Person("Luke", "Skywalker"));
		
		// Comparators: Java 8 adds various default methods to the functional interface 
		Comparator<Person> comparator = (p1, p2) -> p1.firstName.compareTo(p2.firstName);
		Person p1 = new Person("John", "Doe");
		Person p2 = new Person("Alice", "Wonderland");
		
		System.out.println(comparator.compare(p1, p2));
		System.out.println(comparator.reversed().compare(p1, p2));
		
		// Optionals: not functional interfaces, but nifty utilities to prevent NullPointerException
		Optional<String> optional = Optional.of("bam");
		System.out.println(optional.isPresent());					// "true"
		System.out.println(optional.get());							// "bam"
		System.out.println(optional.orElse("fallback"));			// "true"
		
		optional.ifPresent((s) -> System.out.println(s.charAt(0)));	// "b"
	}
}
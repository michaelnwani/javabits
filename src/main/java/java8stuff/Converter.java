// an interface with one abstract method (can have default methods)
// can use lambda expression with it
@FunctionalInterface
interface Converter<F, T> {
	T convert(F from);
}
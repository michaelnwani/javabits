class Lambda4 {
	static int outerStaticNum;
	int outerNum;
	
	void testScopes() {
		// read and write access to instance fields and static variables
		// from within lambda expressions
		Converter<Integer, String> stringConverter1 = (from) -> {
			outerNum = 23;
			return String.valueOf(from);
		};
		
		Converter<Integer, String> stringConverter2 = (from) -> {
			outerStaticNum = 72;
			return String.valueOf(from);
		};
	}
}
class Something {
	String startsWith(String s) {
		return String.valueOf(s.charAt(0));
	}
}

public class ConverterClient {
	public static void main(String[] args) {
		// argument in paren. matches the argument(s) in the interface abst. method
		// the one line after the '->' matches the methods body
		// automagically creates a converter object, and defines the method.
		Converter<String, Integer> converter = (from) -> Integer.valueOf(from);
		
		Integer converted = converter.convert("123");
		System.out.println(converted);
		
		// can pass references of methods or constructors via the :: keyword
		Something something = new Something();
		// this method's argument list would have to match the data type(s)
		// in the abstract method's signature in the interface
		Converter<String, String> converter2 = something::startsWith;
		String converted2 = converter2.convert("Java");
		System.out.println(converted2);
		
		// can access outer scope local variables (can delete the 'final'
		// but num has to only be defined once)
		final int num = 1;
		Converter<Integer, String> converter3 = 
			(from) -> String.valueOf(from + num);
		System.out.println(converter3.convert(2));
	}
}
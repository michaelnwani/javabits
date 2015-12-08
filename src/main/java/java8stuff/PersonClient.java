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

public class PersonClient {
	
	public static void main(String[] args) {
		// passing a constructor with the :: keyword
		// the java compiler automatically chooses the right constructor
		// by matching the signature
		PersonFactory<Person> personFactory = Person::new;
		Person person = personFactory.create("Peter", "Parker");
	}
}
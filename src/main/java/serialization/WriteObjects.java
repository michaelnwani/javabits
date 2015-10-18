package main.java.serialization;

import java.util.List;
import java.util.Arrays;
import java.util.ArrayList;
import java.io.IOException;
import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.io.FileNotFoundException;

// Serialization: basically turning that object(s) into binary data
// De-Serializing: getting it back
public class WriteObjects {
	
	public static void main(String[] args) {
		System.out.println("Writing objects...");
		
		// Person[] people =
// 			{	new Person(1,"Sue"),
// 				new Person(99, "Mike"),
// 				new Person(7, "Bob")};
//
// 		@SuppressWarnings("unchecked")
// 		ArrayList<Person> peopleList = new ArrayList<Person>(Arrays.asList(people));
		
		// Person mike = new Person(543, "Mike");
// 		Person sue = new Person(123, "Sue");
//
// 		System.out.println(mike);
// 		System.out.println(sue);
		
		// let's us stream data to a file.
		// .bin because it'll be a binary file.
		// gets added to the working directory
		// Java 7 syntax (try-with-resources. automatically closes the stream after)
		try(ObjectOutputStream os = new ObjectOutputStream(new FileOutputStream("test.ser"))) {
			
			// os.writeObject(mike);
// 			os.writeObject(sue);
			
			// os.writeObject(people);
//
// 			os.writeObject(peopleList);
//
// 			os.writeInt(peopleList.size());
//
// 			for (Person person : peopleList) {
// 				os.writeObject(person);
// 			}
			
			Person person = new Person(7, "Bob");
			Person.setCount(88);
			os.writeObject(person);
			
			
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
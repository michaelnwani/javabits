package main.java.serialization;

import java.io.IOException;
import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.io.FileNotFoundException;

// Serialization: basically turning that object(s) into binary data
// De-Serializing: getting it back
public class WriteObjects {
	
	public static void main(String[] args) {
		System.out.println("Writing objects...");
		
		Person mike = new Person(543, "Mike");
		Person sue = new Person(123, "Sue");
		
		System.out.println(mike);
		System.out.println(sue);
		
		// let's us stream data to a file.
		// .bin because it'll be a binary file.
		// gets added to the working directory
		// Java 7 syntax (try-with-resources. automatically closes the stream after)
		try(FileOutputStream fs = new FileOutputStream("people.bin")) {
			
			ObjectOutputStream os = new ObjectOutputStream(fs);
			
			os.writeObject(mike);
			os.writeObject(sue);
			
			os.close();
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
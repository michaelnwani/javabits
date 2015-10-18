package main.java.serialization;
import java.io.IOException;
import java.io.FileInputStream;
import java.util.List;
import java.util.ArrayList;
import java.io.ObjectInputStream;
import java.io.FileNotFoundException;
public class ReadObjects {
		
	public static void main(String[] args) {
		System.out.println("Reading objects...");
		
		try(ObjectInputStream os = new ObjectInputStream(new FileInputStream("test.ser"))) {
			
			// We know what we wrote (in bad coding style,
			// readObject could even read an object that doesn't exist
			// in this program)
			
			// Impl. 1
			// Person person1 = (Person) os.readObject();
// 			Person person2 = (Person) os.readObject();
			
			// Impl. 2
			// Person[] people = (Person[])os.readObject();
//			// Impl. 3
// 			ArrayList<Person> peopleList = (ArrayList<Person>)os.readObject();
//			
// 			for (Person person : people) {
// 				System.out.println(person);
// 			}
//
// 			for (Person person : peopleList) {
// 				System.out.println(person);
// 			}
//			// Impl. 4
// 			int num = os.readInt();
//
// 			for (int i = 0; i < num; i++) {
// 				Person person = (Person) os.readObject();
// 				System.out.println(person);
// 			}

			// Impl. 5
			Person person = (Person)os.readObject();
			System.out.println(person);
			
			
			
			// System.out.println(person1);
// 			System.out.println(person2);
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
}
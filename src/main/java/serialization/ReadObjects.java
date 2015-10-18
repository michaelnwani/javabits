package main.java.serialization;
import java.io.IOException;
import java.io.FileInputStream;
import java.io.ObjectInputStream;
import java.io.FileNotFoundException;
public class ReadObjects {
		
	public static void main(String[] args) {
		System.out.println("Reading objects...");
		
		try(FileInputStream fi = new FileInputStream("people.bin")) {
			
			ObjectInputStream os = new ObjectInputStream(fi);
			// We know what we wrote (in bad coding style,
			// readObject could even read an object that doesn't exist
			// in this program)
			Person person1 = (Person) os.readObject();
			Person person2 = (Person) os.readObject();
			
			os.close();
			
			System.out.println(person1);
			System.out.println(person2);
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
}
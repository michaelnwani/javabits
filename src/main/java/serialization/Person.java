package main.java.serialization;
// Serialization: basically turning that object(s) into binary data
// De-Serializing: getting it back
// 'transient' kw would mark a member variable as not to be serialized (e.g. password)
import java.io.Serializable;
public class Person implements Serializable{
	
	// Reading safety; we'd need to have the idential serialVersionUID
	// that the objects were serialized with, otherwise InvalidClassException
	// gets thrown.
	private static final long serialVersionUID = 4801633306273802062L;
	private int id;
	private String name;
	
	public Person(int id, String name) {
		this.id = id;
		this.name = name;
	}
	
	@Override
	public String toString() {
		return "Person [id=" + id + ", name=" + name + "]";
	}
}
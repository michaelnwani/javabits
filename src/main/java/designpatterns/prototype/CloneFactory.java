package designpatterns.prototype;

public class CloneFactory {
	
	// We don't know anything except that the cloned object
	// will be at some point a subclass of the Animal interface
	public Animal getClone(Animal animalSample) {
		
		return animalSample.makeCopy();
	}
}

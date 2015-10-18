package main.java.threading;

// Another example of wait() and notify()
import java.util.List;
import java.util.Random;
import java.util.LinkedList;
public class Processor2 {
	
	private LinkedList<Integer> list = new LinkedList<Integer>();
	private final int LIMIT = 10;
	private Object lock = new Object();
	
	public void produce() throws InterruptedException {
		
		int value = 0;
		
		while (true) {
			
			synchronized (lock) {
				// the while is for insurance
				while (list.size() == LIMIT) {
					// has to be called on the object you're locking on
					lock.wait(); 
				}
				list.add(value++);
				lock.notify();
			}
			
		}
	}
	
	public void consume() throws InterruptedException {
		Random random = new Random();
		while (true) {
			
			synchronized (lock) {
				
				while (list.size() == 0) {
					lock.wait();
				}
				System.out.print("List size is: " + list.size());
				int value = list.poll(); // removeFirst()
				System.out.println("; value is: "+value);
				lock.notify();
			}
			
			// Thread.sleep(random.nextInt(1000));
			
		}
	}
	
	
}
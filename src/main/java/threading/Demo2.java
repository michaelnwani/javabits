package main.java.threading;
// Option 2) Implement Runnable and pass it to the constructor of the Thread class

class Runner implements Runnable {
	// interface with just one method: the run() method
	@Override
	public void run() {
		// runs in its own separate thread
		for (int i = 0; i < 10; i++) {
			System.out.println("Hello "+i);
			
			// class (static) method pauses the program
			// for number of msecs.
			try {
				Thread.sleep(100); 
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			
		}
	}
}
public class Demo2 {
	public static void main(String[] args) {
		Thread t1 = new Thread(new Runner());
		Thread t2 = new Thread(new Runner());
		
		t1.start();
		t2.start();
	}
}
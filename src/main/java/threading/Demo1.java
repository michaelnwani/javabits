package main.java.threading;
// Option 1) Extend the Thread class (override run)

class Runner extends Thread {
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

public class Demo1 {
	
	public static void main(String[] args) {
		// calling run() would run the code in the main thread;
		// use start() instead
		Runner runner1 = new Runner();
		runner1.start(); 
		//running concurrently
		Runner runner2 = new Runner();
		runner2.start(); 
	}
	
}
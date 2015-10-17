package main.java.threading;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
class Processor implements Runnable {
	private CountDownLatch latch; // Thread-safe class
	
	public Processor(CountDownLatch latch) {
		this.latch = latch;
	}
	
	@Override
	public void run() {
		System.out.println("Started.");
		
		try {
			Thread.sleep(3000);
		}
		catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		latch.countDown();
	}
}
public class Demo6 {
	
	public static void main(String[] args) {
		// Let's you countdown from a number you specify
		// let's one of more threads wait until the latch equals 0
		// (via latch.await()); when it equals 0, 
		// one or more threads waiting on the latch (like the main thread)
		// can carry on.
		CountDownLatch latch = new CountDownLatch(3);
		
		ExecutorService executor = Executors.newFixedThreadPool(3);
		
		for (int i = 0; i < 3; i++) {
			executor.submit(new Processor(latch));
		}
		
		try {
			// occurs in the main thread;
			// don't continue program execution until latch equals 0
			latch.await(); 
		}
		catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		System.out.println("Completed.");
		
	}
}
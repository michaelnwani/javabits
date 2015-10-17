package main.java.threading;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
class Processor implements Runnable {
	
	private int id;
	
	public Processor(int id) {
		this.id = id;
	}
	
	@Override
	public void run() {
		System.out.println("Starting: " + id);
		
		try {
			Thread.sleep(5000);
		}
		catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		
		System.out.println("Completed: " + id);
	}
	
}

public class Demo5 {
	
	public static void main(String[] args) {
		// a thread pool is like having a set number of workers
		// work on tasks, then move on to new tasks, etc.
		ExecutorService executor = Executors.newFixedThreadPool(2);
		
		for(int i = 0; i < 5; i++) {
			// would only accept two workers at a time (fixed pool)
			// waits for one to finish, become idle, then uses it again
			executor.submit(new Processor(i));
		}
		
		
		// waits for all the workers to complete what they're doing
		// and then terminate (for them to all be idle)
		executor.shutdown(); 
		
		System.out.println("All tasks submitted.");
		
		try {
			executor.awaitTermination(1, TimeUnit.DAYS);
		}
		catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		System.out.println("All tasks completed.");
		
	}
}







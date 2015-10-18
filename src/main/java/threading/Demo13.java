package main.java.threading;


import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Callable;
import java.util.concurrent.Future;
import java.util.concurrent.FutureTask;
import java.util.concurrent.TimeUnit;
import java.io.IOException;
import java.util.Random;

// Callable and Future (get return results from your threads
// and allows your thread results to throw exceptions)
// can cancel your thread, know when your thread is finished, etc.
public class Demo13 {
	
	public static void main(String[] args) {
		ExecutorService executor = Executors.newCachedThreadPool();
		
		// Callable's type is the type you want to return from the thread
		// returns the value to Future
		// if you want to use callable but don't care for a return value
		// use Future<?> and Callable<Void>, return null
		Future<Integer> future = executor.submit(new Callable<Integer>(){
			@Override
			public Integer call() throws Exception {
				Random random = new Random();
				int duration = random.nextInt(4000);
				
				if (duration > 2000) {
					// gets thrown through ExecutionException
					throw new IOException("Sleeping for too long.");
				}
				
				System.out.println("Starting ....");
				
				try {
					Thread.sleep(duration);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				
				System.out.println("Finished.");
				
				return duration;
			}
		});
		
		executor.shutdown();
		
		
		
		try { 
			// get() blocks until the thread associated with the future 
			// terminates
			System.out.println("Result is: "+future.get());
		} catch (InterruptedException e) {
			e.printStackTrace();
		} catch (ExecutionException e) {
			IOException ex = (IOException) e.getCause();
			System.out.println(e.getMessage());
		}
		
		
	}
}
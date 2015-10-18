package main.java.threading;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.Semaphore;
// Semaphores
public class Demo12 {
	public static void main(String[] args) throws Exception{
		// An object that maintains a count which we call 'permits'
		// A semaphore with 1 permit is basically a lock.
		// but with a lock you'd have to unlock on the same thread
		// you originally got the lock. With the semaphore you could
		// 'unlock' from another thread.
		// Semaphore sem = new Semaphore(1);
		
		// increases the number of available permits
		// sem.release(); 
		
		// decrements the number of available permits
		// waits until a permit is available if the number is 0
		// sem.acquire();
		
		// Connection.getInstance().connect();
		
		// cachedThreadPool: every time we call submit(),
		// it would create a new thread, and would try to reuse threads
		// that become idle.
		ExecutorService executor = Executors.newCachedThreadPool();
		
		for (int i = 0; i < 200; i++) {
			executor.submit(new Runnable(){
				@Override
				public void run() {
					Connection.getInstance().connect();
				}
			});
		}
		
		executor.shutdown();
		
		executor.awaitTermination(1, TimeUnit.DAYS);
	}
}
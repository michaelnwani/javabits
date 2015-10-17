package main.java.threading;

public class Demo4{
	
	private int count = 0;
	
	// Every object in Java has an instrinsic lock/key (a MUTual EXclusion object) 
	// a method marked synchronized can only be called behind the scenes
	// by acquiring this instrinsic lock; else the thread has to wait.
	// (don't need volatile in this case)
	// mutex is a locking mechanism(locked/unlocked); semaphore is a signaling mechanism
	// synchronized kw is like saying 'handle the locking/unlocking of this method'
	public synchronized void increment() {
		count++;
	}
		
	public static void main(String[] args) {
		
		Demo4 app = new Demo4();
		app.doWork();
	}
	
	public void doWork() {
		// fix the interleaving
		Thread t1 = new Thread(new Runnable(){
			@Override
			public void run() {
				for (int i = 0; i < 10000; i++) {
					increment();
				}
			}
		});
		
		Thread t2 = new Thread(new Runnable(){
			@Override
			public void run() {
				for (int i = 0; i < 10000; i++) {
					increment();
				}
			}
		});
		
		// always returns to the main thread immediately, after spawning a new thread
		t1.start(); 
		t2.start();
		
		
		try {
			// join(): pauses execution of the thread that its called in 
			// (main thread here) until its newly spawned thread is finished
			t1.join(); 
			t2.join();
		}
		catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		System.out.println("Count is: "+count);
	}
}
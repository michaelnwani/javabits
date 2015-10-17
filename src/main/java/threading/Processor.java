package main.java.threading;
import java.util.Scanner;
//Notify and wait
public class Processor {
	
	public void produce() throws InterruptedException {
		// using the instrinsic lock of the specific processor object itself
		synchronized (this) {
			System.out.println("Producer thread running ....");
			// from Object class (also a version where you specify timeout)
			// can only call it within synchronized code blocks
			// another thread would have to call notify()
			wait(); //gets the lock back when the other block finishes
			System.out.println("Resumed.");
		}
		
	}
	
	public void consume() throws InterruptedException {
		Scanner scanner = new Scanner(System.in);
		Thread.sleep(2000);
		
		// same intrinsic lock (receives it when wait() is called on other thread)
		synchronized (this) {
			System.out.println("Waiting for return key.");
			scanner.nextLine();
			System.out.println("Return key pressed.");
			// notify() can only be called within a synchronized code block.
			// call it to let the other thread where wait() came from resume
			notify();
			Thread.sleep(5000);
		}
	}
}
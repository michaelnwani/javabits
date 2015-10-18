package main.java.threading;

import java.util.Scanner;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;
public class Runner2 {
	

	private int count = 0;
	// when a thread acquires this lock, it can lock it again if it wants to.
	// thread keeps count of how many times its been locked.
	// then unlock the same number of times.
	private Lock lock = new ReentrantLock();
	private Condition cond = lock.newCondition(); //like wait and notify usage.
	
	private void increment() {
		for (int i = 0; i < 10000; i++) {
			count++;
		}
	}
	
	public void firstThread() throws InterruptedException {
		lock.lock();
		System.out.println("Waiting ....");
		cond.await(); //same as wait() within a synchronized block
		
		System.out.println("Woken up!");
		try {
			increment();
		}
		finally {
			lock.unlock();
		}
		
		
	}
	
	public void secondThread() throws InterruptedException {
		
		Thread.sleep(1000);
		lock.lock();
		
		System.out.println("Press the return key!");
		new Scanner(System.in).nextLine();
		System.out.println("Got return key!");
		
		// wakes up one thread
		// also signalAll() for waking up all threads
		
		cond.signal(); // should unlock around the same time.
		try {
			increment();
		}
		finally {
			lock.unlock();
		}
	}
	
	public void finished() {
		System.out.println("Count is: "+count);
	}
	
}
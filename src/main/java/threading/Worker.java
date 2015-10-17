package main.java.threading;

import java.util.List;
import java.util.ArrayList;
import java.util.Random;

public class Worker {
		
	private Random random = new Random();
	
	// good practice to create separate lock objects
	private Object lock1 = new Object();
	private Object lock2 = new Object();
	
	static private List<Integer> list1 = new ArrayList<Integer>();
	static private List<Integer> list2 = new ArrayList<Integer>();
	
	
	// this is on a per-object basis
	public void stageOne() {
		
		// second thread would have to wait for other thread
		// to release lock1 object's instrinsic lock
		synchronized (lock1) { 
			try {
				Thread.sleep(1);
			}
			catch (InterruptedException e) {
				e.printStackTrace();
			}
		
			list1.add(random.nextInt(100));
		}
		
	}
	
	public void stageTwo() {
		
		// second thread would have to wait for other thread
		// to release lock2 object's instrinsic lock
		synchronized (lock2) {
			try {
				Thread.sleep(1);
			}
			catch (InterruptedException e) {
				e.printStackTrace();
			}
		
			list2.add(random.nextInt(100));
		}
		
	}
	
	public void process() {
		for (int i = 0; i < 1000; i++) {
			stageOne();
			stageTwo();
		}
	}
	public static void main(String[] args) {
		System.out.println("Starting ...");
		Worker worker = new Worker();
		long start = System.currentTimeMillis();
		// thread interleaving can cause problems
		Thread t1 = new Thread(new Runnable(){
			@Override
			public void run() {
				worker.process();
			}
		});
		t1.start();
		
		Thread t2 = new Thread(new Runnable(){
			@Override
			public void run() {
				worker.process();
			}
		});
		t2.start();
		try {
			
			t1.join();
			t2.join();
		}
		catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		
		long end = System.currentTimeMillis();
		
		System.out.println("Time taken: "+(end-start));
		
		System.out.println("List1: "+list1.size() + "; list2: "+list2.size());
	}
}
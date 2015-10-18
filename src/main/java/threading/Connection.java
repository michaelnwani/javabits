package main.java.threading;

import java.util.concurrent.Semaphore;
// Singleton class
public class Connection {
	
	private static Connection instance = new Connection();
	
	// only 10 connections at a given time (i.e. batches of roughly 10)
	// true makes it so that the first thread that seeks a permit gets the first
	// available permit (might be a performance hit but more secure)
	private Semaphore sem = new Semaphore(10, true);
	private int connections = 0;
	
	private Connection() {
		
	}
	
	public static Connection getInstance() {
		return instance;
	}
	
	public void connect() {
		try {
			sem.acquire();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		try {
			doConnect();
		} finally {
			sem.release();
		}
	}
	
	public void doConnect() {
		
		synchronized(this) {
			connections++;
			System.out.println("Current connections: "+connections);
		}
		
		try {
			Thread.sleep(2000);
		}
		catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		
		synchronized(this) {
			connections--;
		}
		
	}
}
package main.java.threading;
import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;
class Processor extends Thread {
	
	
	private volatile boolean running = true;
	
	@Override
	public void run() {
		// JVM might cache this running value...
		// might not expect another thread to change its values.
		// volatile kw makes it so the value of this variable will
		// never be cached thread-locally: all reads and writes will go
		// straight to "main memory"
		while (running) {
			System.out.println("Hello");
			try {
				Thread.sleep(100);
			}
			catch (InterruptedException e) {
				e.printStackTrace();
			}
			
		}
	}
	
	public void shutdown() {
		running = false;
	}
}
public class App {
	public static void main(String[] args) {
		Processor proc1 = new Processor();
		proc1.start();
		
		System.out.println("Press return to stop ...");
		Scanner scanner = new Scanner(System.in);
		scanner.nextLine();
		
		proc1.shutdown();
	}
}
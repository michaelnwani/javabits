package main.java.threading;
import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.Callable;
import java.util.concurrent.Future;
import java.util.concurrent.FutureTask;
// Interrupting threads in Java
public class Demo14 {
	
	public static void main(String[] args) throws InterruptedException{
		
		System.out.println("Starting.");
		
		ExecutorService exec = Executors.newCachedThreadPool();
		
		Future<?> fu = exec.submit(new Callable<Void>(){
			@Override
			public Void call() throws Exception {
				Random ran = new Random();
				for (int i = 0; i < 1E8; i++) {

					if (Thread.currentThread().isInterrupted()) {
						System.out.println("Interrupted!");
						break;
					}

					// try {
// 						Thread.sleep(1);
// 					}catch (InterruptedException e) {
// 						System.out.println("We've been interrupted");
// 						break;
// 					}

					Math.sin(ran.nextDouble());
				}
				
				return null;
			}
		});
		
		exec.shutdown();
		
		Thread.sleep(500);
		
		// same effect as thread interrupt
		// false cancels the thread if it hasn't already run
		// but if it is already running it wont.
		// fu.cancel(true);
		
		// alternative to fu.cancel
		exec.shutdownNow();
		
		exec.awaitTermination(1, TimeUnit.DAYS);
		
		// Thread t = new Thread(new Runnable(){
//
// 			@Override
// 			public void run() {
// 				Random ran = new Random();
// 				for (int i = 0; i < 1E8; i++) {
//
// 					// if (Thread.currentThread().isInterrupted()) {
// // 						System.out.println("Interrupted!");
// // 						break;
// // 					}
//
// 					// try {
// // 						Thread.sleep(1);
// // 					}catch (InterruptedException e) {
// // 						System.out.println("We've been interrupted");
// // 						break;
// // 					}
//
// 					Math.sin(ran.nextDouble());
// 				}
// 			}
// 		});
//
// 		t.start();
//
// 		Thread.sleep(500);
//
// 		// Attempts to interrupt the thread (does not kill the thread)
// 		// could use a volatile boolean flag or something
// 		// (that's sort've what interrupt() does behind the scenes)
// 		t.interrupt();
//
// 		t.join();
		
		
		System.out.println("Finished.");
	}
}









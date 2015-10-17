package main.java.threading;
// Option 3
public class Demo3 {
	public static void main(String[] args) {
		Thread t1 = new Thread(new Runnable(){
			@Override
			public void run() {
				// runs in its own separate thread
				for (int i = 0; i < 10; i++) {
					System.out.println("Hello "+i);
			
					// class (static) method pauses the program
					// for number of msecs.
					try {
						Thread.sleep(100); 
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
			
				}
			}
		});
		
		t1.start();
	}
}
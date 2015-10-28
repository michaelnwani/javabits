package designpatterns.singleton;

public class ScrabbleTestThreads {
	
	public static void main(String[] args) {
		
		Runnable getTiles = new GetTheTiles();
		
		Runnable getTilesAgain = new GetTheTiles();
		
		Thread t1 = new Thread(getTiles);
		Thread t2 = new Thread(getTilesAgain);
		t1.start();
		t2.start();
		
	}
}

package designpatterns.singleton;

import java.util.List;
import java.util.LinkedList;

public class GetTheTiles implements Runnable {
	
	@Override
	public void run() {
		Singleton newInstance = Singleton.getInstance();
		
		// if (newInstance == null) {
		// 	System.out.println("null");
		// }
		
		System.out.println("Instance ID: " + System.identityHashCode(newInstance));
		
		System.out.println(newInstance.getLetterList());
		
		LinkedList<String> playerOneTiles = newInstance.getTiles(7);
		
		System.out.println("Player: " + playerOneTiles);
		
		System.out.println("Got Tiles");
			
	}
}
package designpatterns.singleton;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.LinkedList;

public final class Singleton {
	
	private static volatile Singleton _instance = null;
	
	// Holds all my scrabble letters in an array
	
	String[] scrabbleLetters = 
		{"a", "a", "a", "a", "a", "a", "a", "a", "a",
		"b", "b", "c", "c", "d", "d", "d", "d", "e", "e", "e", "e", "e", "e", 
		"e", "e", "e", "e","e", "e", "f", "f", "g", "g", "g", "h", "h", 
		"i", "i", "i", "i", "i", "i", "i", "i", "i", "j", "k", "l",
		"l", "l", "l", "m", "m", "n", "n", "n", "n", "n", "n",
		"o", "o", "o", "o", "o", "o", "o", "o", "p", "p",
		"q", "r", "r", "r", "r", "r", "r", "s", "s", "s", "s",
		"t", "t", "t", "t", "t", "t", "u", "u", "u", "u",
		"v", "v", "w", "w", "x", "y", "y", "z",};
	
	private LinkedList<String> letterList = 
		new LinkedList<String>(Arrays.asList(scrabbleLetters));
	
	static boolean firstThread = true;
	
	private Singleton() {
		
	}
	
	public static Singleton getInstance() {
		// We use a local variable to ensure that the volatile field
		// is only accessed once, which can improve a method's overall
		// performance by as much as 25%.
		Singleton newInstance = _instance;
		// lazy instantiation
		if (newInstance == null) {
			
			if (firstThread) {
				firstThread = false;
				
				Thread.currentThread();
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				
			}
			
			// "Double-Checked Locking" idiom; bad without the use of volatile
			// on the necessary variables. 
			synchronized (this) {
				newInstance = _instance;
				if (newInstance == null) {
					newInstance = _instance = new Singleton();
			
					Collections.shuffle(_instance.letterList);
				}
				
				return newInstance;
			}
			
		} 
		
		return newInstance;
	}
	
	public LinkedList<String> getLetterList() {
		return _instance.letterList;
	}
	
	public LinkedList<String> getTiles(int howManyTiles) {
		
		LinkedList<String> tilesToSend = new LinkedList<String>();
		for (int i = 0; i <= howManyTiles; i++) {
			// does automatic shifting
			tilesToSend.add(_instance.letterList.remove(0));
		}
		
		return tilesToSend;
	}
}






package designpatterns.iterator;

import java.util.List;
import java.util.Iterator;
import java.util.Hashtable;

public class SongsOfThe90s implements SongIterator{
	
	Hashtable<Integer, SongInfo> bestSongs = new Hashtable<Integer, SongInfo>();
	
	int hashKey = 0;
	
	public SongsOfThe90s() {
		
		
		addSong("Losing My Religion", "REM", 1991);
		addSong("Creep", "Radiohead", 1993);
		addSong("Walk on the Ocean", "Toad the Wet Sprocket", 1991);
	}
	
	public void addSong(String songName, String bandName, int yearReleased) {
		SongInfo songInfo = new SongInfo(songName, bandName, yearReleased);
		bestSongs.put(hashKey, songInfo);
		hashKey++;
	}
	
	// public Hashtable<Integer, SongInfo> getBestSongs() {
// 		return bestSongs;
// 	}
	
	@Override
	public Iterator createIterator() {
		// Collection<K> interface
		return bestSongs.values().iterator();
	}
}
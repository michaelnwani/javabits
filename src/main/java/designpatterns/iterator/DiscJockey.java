package designpatterns.iterator;

import java.util.List;
import java.util.ArrayList;
import java.util.Hashtable;
import java.util.Iterator;

public class DiscJockey {
	
	SongsOfThe70s songs70s;
	SongsOfThe80s songs80s;
	SongsOfThe90s songs90s;
	
	SongIterator iter70sSongs;
	SongIterator iter80sSongs;
	SongIterator iter90sSongs;
	
	public DiscJockey(SongIterator songs70s, SongIterator songs80s, 
	SongIterator songs90s) {
		this.iter70sSongs = songs70s;
		this.iter80sSongs = songs80s;
		this.iter90sSongs = songs90s;
	}
	
	// Bad version.
	// public void showTheSongs() {
//
// 		ArrayList<SongInfo> al70sSongs = songs70s.getBestSongs();
//
// 		System.out.println("Songs of the 70s\n");
// 		for (int i = 0; i < al70sSongs.size(); i++) {
// 			SongInfo bestSongs = al70sSongs.get(i);
// 			System.out.println(bestSongs.getSongName());
// 			System.out.println(bestSongs.getBandName());
// 			System.out.println(bestSongs.getYearReleased());
// 		}
//
// 		SongInfo[] array80sSongs = songs80s.getBestSongs();
// 		System.out.println("Songs of the 80s\n");
// 		for (int i = 0; i < array80sSongs.length; i++) {
// 			SongInfo bestSongs = array80sSongs[i];
// 			System.out.println(bestSongs.getSongName());
// 			System.out.println(bestSongs.getBandName());
// 			System.out.println(bestSongs.getYearReleased());
// 		}
//
// 		Hashtable<Integer, SongInfo> ht90sSongs = songs90s.getBestSongs();
// 		System.out.println("Songs of the 90s\n");
// 		for (int i = 0; i < ht90sSongs.size(); i++) {
// 			SongInfo bestSongs = ht90sSongs.get(i);
// 			System.out.println(bestSongs.getSongName());
// 			System.out.println(bestSongs.getBandName());
// 			System.out.println(bestSongs.getYearReleased());
// 		}
// 	}
	
	// Good version.
	@SuppressWarnings("unchecked")
	public void showTheSongs2() {
		Iterator<SongInfo> iterSongs70s = iter70sSongs.createIterator();
		Iterator<SongInfo> iterSongs80s = iter80sSongs.createIterator();
		Iterator<SongInfo> iterSongs90s = iter90sSongs.createIterator();
		
		System.out.println("Songs of the 70s\n");
		printTheSongs(iterSongs70s);
		
		System.out.println("Songs of the 80s\n");
		printTheSongs(iterSongs80s);
		
		System.out.println("Songs of the 90s\n");
		printTheSongs(iterSongs90s);
	}
	
	@SuppressWarnings("unchecked")
	public void printTheSongs(Iterator<SongInfo> iterator) {
		
		while (iterator.hasNext()) {
			SongInfo songInfo = iterator.next();
			System.out.println(songInfo.getSongName());
			System.out.println(songInfo.getBandName());
			System.out.println(songInfo.getYearReleased());
		}
	}
}





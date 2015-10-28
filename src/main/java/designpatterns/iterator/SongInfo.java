package designpatterns.iterator;

public class SongInfo {
	String songName;
	String bandName;
	int yearReleased;
	
	public SongInfo(String newSongName, String newBandName, int newYearReleased) {
		this.songName = newSongName;
		this.bandName = newBandName;
		this.yearReleased = newYearReleased;
	}
	
	public String getSongName() {
		return songName;
	}
	
	public String getBandName() {
		return bandName;
	}
	
	public int getYearReleased() {
		return yearReleased;
	}
}
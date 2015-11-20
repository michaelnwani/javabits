// Suffix array (elementary implementation)
// suffix sort running time can be O(n)
import java.util.Arrays;

public class SuffixArray {
	
	private Suffix[] suffixes;	// array of suffixes
	
	public SuffixArray(String text) {
		int N = text.length();
		this.suffixes = new Suffix[N];
		for (int i = 0; i < N; i++) {
			suffixes[i] = new Suffix(text, i);
		}
		Arrays.sort(suffixes);
	}
	
	private static class Suffix implements Comparable<Suffix> {
		
		private final String text;	// reference to text string
		private final int index;	// index of suffix's first character
		
		private Suffix(String text, int index) {
			this.text = text;
			this.index = index;
		}
		
		private int length() {
			return text.length() - index;
		}
		
		private char charAt(int i) {
			return text.charAt(index + i);
		}
		
		@Override
		public String toString() {
			return text.substring(index);
		}
		
		@Override
		public int compareTo(Suffix that) {
			if (this == that) {
				return 0;
			}
			
			int N = Math.min(this.length(), that.length());
			for (int i = 0; i < N; i++) {
				if (this.charAt(i) < that.charAt(i)) {
					return -1;
				}
				
				if (this.charAt(i) > that.charAt(i)) {
					return 1;
				}
			}
			
			return this.length() - that.length();
		}
	}
	
	public int index(int i) {
		return suffixes[i].index;
	}
	
	public int length() {
		return suffixes.length;
	}
	
	public String select(int i) {
		return suffixes[i].toString();
	}
	
	public int lcp(int i) {
		// Ex 6.28
	}
	
	public int rank(String key) {
		// Ex. 6.28
	}
}
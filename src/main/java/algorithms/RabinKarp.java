package main.java.algorithms;

// Rabin-Karp substring search ('fingerprint' (hashing) search)
public class RabinKarp {

	private String pat;		// pattern (only needed for Las Vegas)
	private long patHash;	// pattern hash value
	private int M;			// pattern length
	private long Q;			// a large prime
	private int R = 256;	// alphabet size
	private long RM;		// R^(M-1) % Q

	public RabinKarp(String pat) {
		this.pat = pat;
		M = pat.length();
		Q = longRandomPrime();	// Ex. 5.3.33
		RM = 1;
		for (int i = 1; i <= M-1; i++) {	// Compute R^(M-1) % Q for use
			RM = (R * RM) % Q;				// in removing leading digit.
		}
		patHash = hash(pat, M);
	}

	public boolean check(int i) {		// Monte Carlo
		return true;					// For Las Vegas, check pat vs. txt(i..i-M+1)
	}

	public long longRandomPrime() {
		long num = 0;
		Random rand = new Random();
		num = rand.nextLong();

		while (!isPrime(num)) {
			num = rand.nextLong();
		} 
	}

	// http://stackoverflow.com/questions/24006143/
	// generating-a-random-prime-number-in-java
	private boolean isPrime(long inputNum) {

		if (inputNum <= 3 || inputNum % 2 == 0) {
			return inputNum == 2 || inputNum == 3;
		}

		long divisor = 3;
		while ((divisor <= Math.sqrt(inputNum)) && (inputNum % divisor != 0)) {
			divisor += 2;
		}

		return inputNum % divisor != 0;	// returns true/false

	}

	// Horner's method
	private long hash(String key, int M) {
		// Compute hash for key[0..M-1]
		long h = 0;
		for (int j = 0; j < M; j++) {
			h = (R * h + key.charAt(j)) % Q;
		}
		return h;
	}

	private int search(String txt) {
		// Search for hash match in text.
		int N = txt.length();
		long txtHash = hash(txt, M);
		if (patHash == txtHash && check(0)) {
			return 0;
		}
		for (int i = M; i < N; i++) {
			// Remove leading digit, add trailing digit, check for match.
			txtHash = (txtHash + Q - RM*txt.charAt(i-M) % Q) % Q;
			txtHash = (txtHash*R + txt.charAt(i)) % Q;
			if (patHash == txtHash) {
				if (check(i - M + 1)) {	// match.
					return i - M + 1;
				}
			}
		}

		return N;	// no match.
	}

	public static void main(String[] args) {
		
	}
}
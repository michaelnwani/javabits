
public class Genome {
	
	// Compression method for genomic data
	public static void compress() {
		Alphabet DNA = Alphabet.DNA;
		String s = BinaryStdIn.readString();
		int N = s.length();
		BinaryStdOut.write(N);
		for (int i = 0; i < N; i++) {
			// Write two-bit code for char.
			int d = DNA.toIndex(s.charAt(i));
			BinaryStdOut.write(d, DNA.lgR());
		}
		BinaryStdOut.close();
	}

	public static void expand() {
		Alphabet DNA = Alphabet.DNA;
		int w = DNA.lgR();
		int N = BinaryStdIn.readInt();
		for (int i = 0; i < N; i++) {
			// Read 2 bits; write char.
			char c = BinaryStdIn.readChar(w);
			BinaryStdOut.write(DNA.toChar(c), 8);
		}
		BinaryStdOut.close();
	}

	public static void main(String[] args) {

		if (args[0].equals("-")) {
			compress();
		}
		if (args[0].equals("+")) {
			expand();
		}
	}
}
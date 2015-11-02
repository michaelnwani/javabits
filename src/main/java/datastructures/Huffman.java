// Huffman compression algorithm
// Builds an explicit coding trie
public class Huffman {
	
	private static final int R = 256; // ASCII alphabet
	
	// Trie node representation
	private static class Node implements Comparable<Node> {
		// Huffman trie node
		private char ch;	// unused for internal nodes
		private int freq;	// unused for expand
		private final Node left, right;
		
		Node(char ch, int freq, Node left, Node right) {
			this.ch = ch;
			this.freq = freq;
			this.left = left;
			this.right = right;
		}
		
		public boolean isLeaf() {
			return left == null && right == null;
		}
		
		@Override
		public int compareTo(Node that) {
			return this.freq - that.freq;
		}	
	}
	
	// Building an encoding table from a (prefix-free) code trie
	private static String[] buildCode(Node root) {
		// Make a lookup table from trie.
		String[] st = new String[R];
		buildCode(st, root, "");
		return st;
	}
	
	private static void buildCode(String[] st, Node x, String s) {
		// Make a lookup table from trie (recursive).
		if (x.isLeaf()) {
			st[x.ch] = s;
			return;
		}
		buildCode(st, x.left, s + '0');
		buildCode(st, x.right, s + '1');
	}
	
	private static Node buildTrie(int[] freq) {
		// Initialize priority queue with singleton trees.
		MinPQ<Node> pq = new MinPQ<Node>();
		for (char c = 0; c < R; c++) {
			if (freq[c] > 0) {
				pq.insert(new Node(c, freq[c], null, null));
			}
		}
		
		while (pq.size() > 1) {
			// Merge two smallest trees.
			Node x = pq.delMin();
			Node y = pq.delMin();
			Node parent = new Node('\0', x.freq + y.freq, x, y);
			pq.insert(parent);
		}
		return pq.delMin();
	}
	
	private static void writeTrie(Node x) {
		// Write bitstring-encoded trie.
		if (x.isLeaf()) {
			BinaryStdOut.write(true);
			BinaryStdOut.write(x.ch, 8);
			return;
		}
		BinaryStdOut.write(false);
		writeTrie(x.left);
		writeTrie(x.right);
	}
	
	private static Node readTrie() {
		if (BinaryStdIn.readBoolean()) {
			return new Node(BinaryStdIn.readChar(), 0, null, null);
		}
		return new Node('\0', 0, readTrie(), readTrie());
	}
	
	public static void compress() {
		// Read input.
		String s = BinaryStdIn.readString();
		char[] input = s.toCharArray();
		
		// Tabulate frequency counts.
		int[] freq = new int[R];
		for (int i = 0; i < input.length; i++) {
			freq[input[i]]++;
		}
		
		// Build Huffman code trie.
		Node root = buildTrie(freq);
		
		// Build code table (recursive).
		String[] st = new String[R];
		buildCode(st, root, "");
		
		// Print trie for decoder (recursive).
		writeTrie(root);
		
		// Print number of chars.
		BinaryStdOut.write(input.length);
		
		// Use Huffman code to encode input.
		for (int i = 0; i < input.length; i++) {
			String code = st[input[i]];
			for (int j = 0; j < code.length(); j++) {
				if (code.charAt(j) == '1') {
					BinaryStdOut.write(true);
				} else {
					BinaryStdOut.write(false);
				}
			}
		}
		BinaryStdOut.close();
	}
	
	// Prefix-free code expansion(decoding)
	public static void expand() {
		Node root = readTrie();
		int N = BinaryStdIn.readInt();
		for (int i = 0; i < N; i++) {
			// Expand ith codeword.
			Node x = root;
			while (!x.isLeaf()) {
				if (BinaryStdIn.readBoolean()) {
					x = x.right;
				} else {
					x = x.left;
				}
			}
			BinaryStdOut.write(x.ch, 8);
		}
		BinaryStdOut.close();
	}
}




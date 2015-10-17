package main.java.algorithms;
/*
 * A sequence of numbers is called a zig-zag sequence if the differences between successive numbers  * strictly alternate between positive and negative. The first difference (if one exists) may be     * either positive or negative. A sequence with fewer than two elements is trivially a zig-zag       * sequence.

 * For example, 1,7,4,9,2,5 is a zig-zag sequence because the differences (6,-3,5,-7,3) are          * alternately positive and negative. In contrast, 1,4,7,2,5 and 1,7,4,5,5 are not zig-zag           * sequences, the first because its first two differences are positive and the second because its    * last difference is zero.

 * Given a sequence of integers, sequence, return the length of the longest subsequence of sequence  * that is a zig-zag sequence. A subsequence is obtained by deleting some number of elements         * (possibly zero) from the original sequence, leaving the remaining elements in their original      * order.
 *
 */

public class ZigZag {	
	public static int longestZigZag(int[] sequence) {
		// Preconditions
		assert sequence != null : "int[] can't be null";
		assert sequence.length >= 1 : "1 <= sequence.length <= 50";
		assert sequence.length <= 50 : "1 <= sequence.length <= 50";
		
		if (sequence.length == 1) {
			return 1;
		}
		
		if (sequence.length == 2) {
			if ((sequence[0] - sequence[1]) != 0) {
				return 2;
			} else {
				return 1;
			}
		}
		
		int longestZigZag = 0;
		if ((sequence[1] - sequence[0]) != 0) {
			longestZigZag = 1; // would be 1 at the least.
		} 
		
		int previous = sequence[0] - sequence[1];		
		int current = 1;
		for (int i = 1; i < sequence.length-1; i++){
			
			int num = sequence[i] - sequence[i+1];
			if (num < 0) { // new zig is negative
				// check previous result
				if (previous > 0){ 
					previous = num;
					longestZigZag++;
					
				} else {
					previous = num;
				}
			} else if (num > 0) { // new zig is positive
				if (previous < 0) { // previous zag should be negative
					previous = num;
					longestZigZag++;
				} else {
					previous = num;
				}
			} 
		}
		
		return longestZigZag+1;
	}
	public static void main(String[] args) {
		int[] seq = {1, 17, 5, 10, 13, 15, 10, 5, 16, 8};
		System.out.println(longestZigZag(seq));
	}
}
package main.java.algorithms;

import java.util.Map;
import java.util.HashMap;
public class PermMissingElem {
	
	public int solution(int[] A) {
	        // write your code in Java SE 8
	        if (A.length > 100000) {
	            throw new IllegalArgumentException("A.length: [0..100,000]");
	        }
			
			// Java arrays can be of length 0
			if (A.length == 0) {
				return 1;
			}
        
	        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
	        for (int i = 0; i < A.length; i++) {
	            map.put(A[i], A[i]);
	        }
        
	        for (int i = 1; i < A.length+1; i++) {
	            if (!map.containsKey(i)) {
	                return i;
	            }
	        }
        
	        // shouldn't reach here by the rules of this question.
	        return 0;
	}
	
	public static void main(String[] args) {
		PermMissingElem answer = new PermMissingElem();
		int[] A = new int[0];
		System.out.println(answer.solution(A));
	}
}
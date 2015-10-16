package main.java.algorithms;
public class EditDistance {
	
	public static int minDistance(String word1, String word2) {
	        assert word1 != null;
	        assert word2 != null;
        
	        if ("".equals(word2)) {
	            return word1.length(); // # necessary deletions
	        }
	        if ("".equals(word1)) {
	            return word2.length(); // # necessary insertions
	        }
			
        
	        int word2Length = word2.length();
			if (word1.length() == 1 && word2Length == 1) {
				if (word1.charAt(0) != word2.charAt(0)) {
					return 1;
				} else {
					return 0;
				}
			}
	        int operations = 0;
	        StringBuilder builder = new StringBuilder(word1);
       
	        while (!builder.toString().equals(word2)) {
	            System.out.println("word1: "+builder+", word2: "+word2);
	            operations += minDistanceHelper(builder, word2, word2Length);
	        }
        
        
	        return operations;
	    }
    
	    public static int minDistanceHelper(StringBuilder builder, String word2, int word2Length) {
	        int word1Length = builder.length();
	        if (word1Length >= word2Length) {
	            for (int i = 0; i < word1Length; i++) {
	                if (i < word2Length) {
	                    if (builder.charAt(i) != word2.charAt(i)) { // deletions
	                        builder.deleteCharAt(i);
	                        return 1;
	                    }
	                } else if (i >= word2Length) {
	                    builder.deleteCharAt(i); // deletions
	                    return 1;
	                }
                
	            }
	        } else {
	            for (int i = 0; i < word2Length; i++) {
	                if (i < word1Length) {
	                    if (builder.charAt(i) != word2.charAt(i)) { // deletions
	                        builder.deleteCharAt(i);
	                        return 1;
	                    }
	                }
	                if (i >= word1Length) {
	                    // we're passed word1's length; need to insert
	                    builder.append(word2.charAt(i));
	                    return 1;
	                }
                
	            }
	        }
        	return 0;
	    }
		
		public static void main(String[] args) {
			int min = minDistance("a","b");
			System.out.println(min);
		}
}
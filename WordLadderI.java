import java.util.*;

public class WordLadderI{
	
	static class WordNode{
		String word;
		int steps;
		
		public WordNode(String word, int steps){
			this.word = word;
			this.steps = steps;
		}
	}
	
	//Breadth-First Search
	public static int ladderLength(String beginWord, String endWord, Set<String> wordDict){
		wordDict.add(endWord);
		// wordDict.remove(beginWord);
		ArrayDeque<WordNode> linkedList = new ArrayDeque<WordNode>();
		linkedList.add(new WordNode(beginWord, 1));
		
		
		while (!linkedList.isEmpty()){
			WordNode top = linkedList.remove();
			
			
			if (top.word.equals(endWord)){
				return top.steps;
			}
			
			char[] characters = top.word.toCharArray();
			
			for (int i = 0; i < characters.length; i++){
				for (char c = 'a'; c <= 'z'; c++){
					// if (characters[i] == c){
// 						continue;
// 					}
					char original = characters[i];
					
					characters[i] = c;
					String tempString = new String(characters);
					if (wordDict.contains(tempString)){
						
						// WordNode newTop = new WordNode(tempString, top.steps+1);
						// characters = newTop.word.toCharArray();
						// System.out.println(tempString + ", newTop.steps = "+(newTop.steps));
						linkedList.add(new WordNode(tempString, top.steps+1));
						// if (tempString.equals(endWord)){
// 							return newTop.steps;
// 						}
						wordDict.remove(tempString);
						
					}
						characters[i] = original;
					
				}
			}
		}
		
		return 0;
	}
	
	public static void main(String[] args){
		Set<String> wordDict = new HashSet<String>();
		// wordDict.add("hot");
// 		wordDict.add("dot");
// 		wordDict.add("dog");
// 		wordDict.add("lot");
// 		wordDict.add("log");
		// hit to cog

// wordDict.add("a");
// wordDict.add("b");
// wordDict.add("c");
// a to c

// wordDict.add("hot");
// wordDict.add("cog");
// hot to cog

// wordDict.add("peale");
// wordDict.add("wilts");
// wordDict.add("place");
// wordDict.add("fetch");
// wordDict.add("purer");
// wordDict.add("pooch");
// wordDict.add("peace");
// wordDict.add("poach");
// wordDict.add("berra");
// wordDict.add("teach");
// wordDict.add("rheum");
// wordDict.add("peach");
//teach to place

wordDict.add("hot");
wordDict.add("dog");
wordDict.add("dot");
//hot to dog
		System.out.println(ladderLength("hot","dog",wordDict));
	}
}
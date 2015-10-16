package main.java.algorithms;
import java.util.HashMap;

// Given two strings s and t, determine if they are isomorphic.
//
// Two strings are isomorphic if the characters in s can be replaced to get t.
//
// All occurrences of a character must be replaced with another character while preserving the order of characters. No two characters may map to the same character but a character may map to itself.
public class IsomorphicStrings{
	
	public static boolean isIsomorphic(String s, String t){
		if (s == null || t == null){
					throw new IllegalArgumentException("String can't be null");
				}
				if (s.length() != t.length()){
					return false;
				}

				HashMap<Character,Character> mapping = new HashMap<Character,Character>();
				int[] sFreqTable = new int[256];
				int[] tFreqTable = new int[256];
		
		
				for (int i = 0; i < s.length(); i++){
					sFreqTable[s.charAt(i) - 0]++;
					tFreqTable[t.charAt(i) - 0]++;
					if(mapping.get(s.charAt(i)) == null){
					    mapping.put(s.charAt(i), t.charAt(i));
					}
				}
		
				for (int i = 0; i < s.length(); i++){
					if (sFreqTable[s.charAt(i) - 0] != tFreqTable[t.charAt(i) - 0]){
						return false;
					}
					if (mapping.get(s.charAt(i)) != t.charAt(i)){
					    return false;
					}
				}
		
				return true;
		
	}
	public static void main(String[] args){
		System.out.println(isIsomorphic("paper","title"));
	}
}
package main.java.algorithms;
import java.util.regex.*;

public class RegEx1{
	public static void main(String[] args){

	String longString = " Derek Banas CA 12345 PA (412)555-1212 johnsmith@hotmail.com 412-555-1234 412 555-1234";
	String strangeString = " 1Z aaa **** *** {{{ {{ { ";
	
	//Word that is 2 to 20 characters in length
	//[A-Za-z]{2,20}
	
	regexChecker("\\s[A-Za-z]{2,20}\\s",longString);
	
	//2 characters that start with a C or A (looking for states)
	//A[KLRZ]|C[AOT]
	regexChecker("A[KLRZ]|C[AOT]", longString);
	}
	
	public static void regexChecker(String theRegex, String str2Check){
		Pattern checkRegex = Pattern.compile(theRegex);
		
		Matcher regexMatcher = checkRegex.matcher(str2Check);
		
		//will kick out all the matches for me
		while (regexMatcher.find()){
			if (regexMatcher.group().length() != 0){
				System.out.println(regexMatcher.group().trim());
			}
			
			System.out.println("Start index: " + regexMatcher.start());
			System.out.println("End index: " + regexMatcher.end());
		}
	}
}
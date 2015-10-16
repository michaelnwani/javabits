package main.java.algorithms;
import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class PalindromeIndex {
    
    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner in = new Scanner(System.in);
       
        try{
            int times = in.nextInt();
            int sLength;
            boolean flag = false;
            boolean oddFlag = false;
			String temp = "";
            in.nextLine();
            for (int t = 0; t < times; t++){
                String s = in.nextLine();
                sLength = s.length();
                
                if (sLength == 1){
                    System.out.println(-1);
                    continue;
                }
                
                if (sLength == 2){ //removing one or the other would make a one length palindrome
                    if (s.charAt(0) == s.charAt(1)){
                        System.out.println(-1);
                    }
                    else{
                        System.out.println(0);
                    }
                    
                    continue;
                }
				
                for (int i = 0; i < sLength/2; i++){
					if (s.charAt(i) != s.charAt(sLength-i-1)){
						flag = true;
						break;
					}                    
                }
				
				if (flag == false){
					System.out.println(-1);
					continue;
				}

                
                // if (s.charAt(0) != s.charAt(sLength-1)){
//                     if (s.charAt(1) == s.charAt(sLength-1)){
//                         // System.out.println("Hello? s is: "+s);
//                         if (isPalindrome(s, 0)){
//                             // System.out.println("Hello?");
//                             System.out.println(0);
//                             continue;
//                         }
//                     }
//                     else if (s.charAt(0) == s.charAt(sLength-2)){
//                         if (isPalindrome(s, sLength-1)){
//                             System.out.println(sLength-1);
//                             continue;
//                         }
//                     }
//                 }
                
                
                for (int i = 0; i < sLength/2; i++){
					if (s.charAt(i) != s.charAt(sLength-i-1)){
                        
                        if (isPalindrome(s, sLength-i-1)){
                            
	                        System.out.println(sLength-i-1);
	                        break;
						}
                        
						if (isPalindrome(s, i)){
                            
	                        System.out.println(i);
	                        break;
						}
						
						
					}
                    if ((i+1) == sLength/2){ //assume all chars were equal
                        System.out.println(-1);
						break;
                    }
                } 
            }
        }
        catch(Exception e){
            e.printStackTrace();
        }
        finally{
          in.close();  
        }
    }
    
    public static boolean isPalindrome(String s, int index){
        int[] freqTable = new int[26];
		
        boolean oddFlag = false;
        
        for (int i = 0; i < s.length(); i++){
            if (i == index){
                continue;
            }else{
                freqTable[s.charAt(i) - 97]++;
            }
            
        }
        
        if ((s.length()-1) % 2 == 1){ //odd
            for (int i = 0; i < freqTable.length; i++){
                if (freqTable[i] % 2 == 1){
                    if (oddFlag == true){ //there should be one and only one char with an odd count
                        return false;
                    }
                    oddFlag = true;
                }
            }
			return true;
        } else{ //even
            // System.out.println("Even for: "+s+" (excluding a char)");
            for (int i = 0; i < freqTable.length; i++){
                if (freqTable[i] % 2 != 0){
                    return false;   //they should all have an even count
                }
            }
			return true;
        }
        
        
    }
}

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class AnagramPalindrome {
	
	// Game of Thrones - I
	// The king has a string composed of lowercase English letters. 
	// Help him figure out whether any anagram of the string can be a palindrome or not.

    public static void main(String[] args) {
        Scanner myScan = new Scanner(System.in);
        String inputString = myScan.nextLine();
        HashMap<Character, Integer> map = new HashMap<Character, Integer>();
        String ans = "";
        boolean flag = false;
        
        for (int i = 0; i < inputString.length(); i++){
           if (!map.containsKey(inputString.charAt(i))){
             map.put(inputString.charAt(i), 1); 
           } else{
             map.put(inputString.charAt(i), map.get(inputString.charAt(i)) + 1);   
           }
           
        }
        Set<Character> keys = map.keySet();
        if (inputString.length() % 2 == 1){ //odd; only one character should have an odd count
            for (char key : keys){
                if (map.get(key) % 2 == 1){
                    if (flag == true){
                        ans = "NO";
                        break;
                    }
                    else{
                        flag = true;
                    }
                }
                if (flag == true){
                    ans = "YES";
                }
            }
        }
        else { //even; every character should have an even count
            for (char key : keys){
                if (map.get(key) % 2 == 1){
                    ans = "NO";
                    break;
                }
                ans = "YES";
            }
            
        }
        // Assign ans a value of YES or NO, depending on whether or not inputString satisfies the required condition
        System.out.println(ans);
        myScan.close();
    }
}
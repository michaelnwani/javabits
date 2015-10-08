import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class SherlockAndAnagrams {

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        // Given a string S, find the number of unordered anagramic pairs of substrings.
        Scanner in = new Scanner(System.in);
        try{
            int times = in.nextInt();
            int count = 0;
            int firstIndex = 0;
            int secondIndex = 1;
            String substr1 = "";
            String substr2 = "";
            int charcnt1 = 0;
            int charcnt2 = 0;
            in.nextLine();
            
            
            for (int t = 0; t < times; t++){
                
                String S = in.nextLine();
                
                //check for length 0
                
                while (secondIndex <= S.length()){
                    substr1 = S.substring(firstIndex, secondIndex);
                    
                    
                    for (int c = 0; c < substr1.length(); c++){
                        charcnt1 += (substr1.charAt(c) - 0); 
                        
                    }
                    
                    for (int i = firstIndex+1; (i+substr1.length()) <= S.length() ; i++){
                        
                        substr2 = S.substring(i, substr1.length()+i);
                            
                        for (int c = 0; c < substr2.length(); c++){
                            charcnt2 += (substr2.charAt(c) - 0); 
                            
                        }
                        
                        if (charcnt1 == charcnt2){
                            // System.out.println("substr1: "+substr1+" - substr2: "+substr2);
											
							char[] char1 = substr1.toCharArray();
							char[] char2 = substr2.toCharArray();
							Arrays.sort(char1);
							Arrays.sort(char2);

							String tempString1 = new String(char1);
							String tempString2 = new String(char2);
							
							if (tempString1.compareTo(tempString2) == 0){
								count++;								
							}
                            
                        }
                        
                        charcnt2 = 0;
                        
                    }
                               
                    if (secondIndex == S.length() && (firstIndex+1 < S.length())){
                        
                        firstIndex++;
                        secondIndex = firstIndex + 1;
                        charcnt1 = 0;
                        charcnt2 = 0;
                    }else{
                        secondIndex++;
                        charcnt1 = 0;
                        charcnt2 = 0;
                    }
                    
                }
                
                // System.out.println(count);
				System.out.println(count);
                charcnt1 = 0;
                charcnt2 = 0;
                count = 0;
                firstIndex = 0;
                secondIndex = 1;
                
            }
        }
        catch (Exception e){
            e.printStackTrace();
        }
        finally{
            in.close();
        }
    }
}
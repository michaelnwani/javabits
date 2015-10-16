package main.java.algorithms;
import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class ReverseShuffleMerge {

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner in = new Scanner(System.in);
        ArrayList<Character> charList;
        Iterator<Character> iter;
        try{
            String s = in.nextLine();
            String a = "";
            int sLength = s.length();
            //charList = new ArrayList<Character>(sLength);
            int[] freqTable = new int[26];
            for (int i = 0; i < sLength; i++){
                freqTable[s.charAt(i)-97]++;
                //System.out.println("s.charAt(i)="+s.charAt(i)+", current count: "+freqTable[s.charAt(i)-97]);
            }
            //for (int i = 0; i < sLength; i++){
              //  charList.add(s.charAt(i));
            //}
            
            char[] charArray = s.toCharArray();
            // Arrays.sort(charArray);
                        
            //charArray/2 now contains A in lexicographically smallest order.
            for (int i = 0; i < sLength; i++){
                if ((freqTable[charArray[i]-97]) != 0){
                    //System.out.println("freqTable[charArray[i]-97]:"+freqTable[charArray[i]-97]);
                    a += charArray[i];
                    freqTable[charArray[i]-97] -= 2;
                }

            }


			// for (int i = 0; i < sLength; i++){
// 				if (i % 2 != 0){
// 					a += charArray[i];
// 				}
// 			}
            // iter = charSet.iterator();
            //while (iter.hasNext()){
              //  a += iter.next();
            //}
            
            System.out.println(a);
            
            
        }
        catch(Exception e){
            e.printStackTrace();
        }
        finally{
            in.close();
        }
    }
}
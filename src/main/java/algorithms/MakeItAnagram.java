package main.java.algorithms;
import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class MakeItAnagram {

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        //  make them have the same character set
        //  make them have the same character length
        Scanner in = new Scanner(System.in);
        try{
            String a = in.nextLine();
            String b = in.nextLine();
            
            int[] aCharFreq = new int[26];
            int[] bCharFreq = new int[26];
            
            int aLength = a.length();
            int bLength = b.length();
            int deletions = 0;
            
            for (int i = 0; i < Math.max(aLength, bLength); i++){
                if (i >= aLength){
                    bCharFreq[b.charAt(i)-97]++;
                }
                else if (i >= bLength){
                    aCharFreq[a.charAt(i)-97]++;
                }
                else{
                    aCharFreq[a.charAt(i)-97]++;
                    bCharFreq[b.charAt(i)-97]++;
                }
            }
            
            for (int i = 0; i <= 25; i++){
                if (aCharFreq[i] != bCharFreq[i]){
                    if (aCharFreq[i] > bCharFreq[i]){
                        int diff = aCharFreq[i] - bCharFreq[i];
                        
                        deletions += diff;
                    }
                    else{
                        int diff = bCharFreq[i] - aCharFreq[i];
                        
                        deletions += diff;
                    }
                }
                
            }
            
            System.out.println(deletions);
        }
        catch (Exception e){
            e.printStackTrace();
        }
        finally{
            in.close();
        }
    }
}
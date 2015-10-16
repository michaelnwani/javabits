package main.java.algorithms;
import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Gemstones {

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
		Scanner in = new Scanner(System.in);
        try{
            HashSet<Character> set = new HashSet<Character>();
            int times = in.nextInt();
            int[] a = new int[26];
            int count = 0;
            in.nextLine();
            for (int i = 0; i < times; i++){
                String str = in.nextLine();
                for (int k = 0; k < str.length(); k++){
                    if (!set.contains(str.charAt(k))){
                        set.add(str.charAt(k));
                       int index = str.charAt(k) - 97;
                       a[index]++; 
                    }
            
                }
                set = new HashSet<Character>();

            }
    
            for (int i = 0; i < a.length; i++){
                if (a[i] >= times){
                    count++;
                }
        
            }
            System.out.println(count);
        }
        catch (Exception e){
            e.printStackTrace();
        }
        finally{
            in.close();
        }
		        
		        
    }
}
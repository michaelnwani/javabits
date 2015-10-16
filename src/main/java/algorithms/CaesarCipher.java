package main.java.algorithms;
import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class CaesarCipher {

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner in = new Scanner(System.in);
        try{
            int N = in.nextInt();
            in.nextLine();
            char[] sCharArray = in.nextLine().toCharArray();
            int K = in.nextInt();
            
            for (int i = 0; i < N; i++){
				//Lowercase ASCII
                if ((sCharArray[i] - 0) >= 97 && (sCharArray[i] - 0) <= 122){
					if (sCharArray[i] + (K%26) > 122){
						sCharArray[i] = (char)((sCharArray[i] + (K%26))-26);
					}
					else{
						sCharArray[i] = (char)(sCharArray[i] + (K%26));
					}
                    
                }	//Uppercase ASCII
                else if ((sCharArray[i] - 0) >= 65 && (sCharArray[i] - 0) <= 90){
                    if ((sCharArray[i] + (K%26)) > 90){
                        sCharArray[i] = (char)((sCharArray[i] + (K%26))-26);
                    }
                    else{
                        sCharArray[i] = (char)(sCharArray[i] + (K%26));
                    }
                }
            }
            
            System.out.println(new String(sCharArray));
        }
        catch (Exception e){
            e.printStackTrace();
        }
        finally{
            in.close();
        }
    }
}
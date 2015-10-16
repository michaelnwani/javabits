package main.java.algorithms;
import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;
//Solution
//SherlockAndTheBeast
public class SherlockAndTheBeast {

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner in = new Scanner(System.in);
        try{
            int times = in.nextInt();
            int N;
            String output = "";
            in.nextLine();
            for (int t = 0; t < times; t++){
                N = in.nextInt();
                // if (N < 3){
//                     System.out.println(-1);
//                     if(in.hasNextLine()){
//                         in.nextLine();
//                     }
//                     continue;
//                 }
				
				
				output = "";
				int i = getPivot(N);
				if (i < 0){
					System.out.println(-1);
					if (in.hasNextLine()){
						in.nextLine();
					}
					continue;
				}
				else{
					int repeat = i/3;
					while ((repeat--) != 0)
						System.out.print("555");
					repeat = (N-i)/5;
					while ((repeat--) != 0)
						System.out.print("33333");
					
					System.out.println();
				}
				
                // for (int i = N; i >= 0; i--){
//                 	if (i%3==0 && (N-i)%5==0){
//                 		for (int k = 0; k < i;k++){
//                 			output += "5";
//                 		}
//                 		for (int k = 0; k < (N-i);k++){
//                 			output += "3";
//                 		}
// 						break;
//
//                 	}
//                 }
//
//                 if (output==""){
//                 	System.out.println(-1);
// 					continue;
//                 }
//                 System.out.println(output);
//                 output = "";
                
            }
        }
        catch (Exception e){
            e.printStackTrace();
        }
        finally{
            in.close();
        }
    }
	
	// return negative number if not found 
	// otherwise pivot is returned.
	// caller can print 5 x pivot + 3 x (n-pivot)
	public static int getPivot(int n) {
	    while(n > 0) {
	        if(n%3 == 0)
	            break;
	        else
	            n -= 5;
	    }
	    return n;
	}
}


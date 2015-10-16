package main.java.algorithms;
import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class BiggerIsGreater {


	
    
    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        
        try{
			Scanner in = new Scanner(System.in);
            int times = in.nextInt();
			String s = "";
			String w = "";
            in.nextLine();
			boolean flag = false;
            for (int t = 0; t < times; t++){
                w = in.nextLine();
				if (w.length() == 1){
					System.out.println("no answer");
					continue;
				}
				if (w.length() == 2){
					if (w.charAt(1) > w.charAt(0)){
						System.out.println(w.charAt(1) + "" + w.charAt(0));
						continue;
					} else if (w.charAt(1) == w.charAt(0)){
						System.out.println("no answer");
						continue;
					}
					else{
						System.out.println("no answer");
						continue;
					}
				}
				if (w.length() == 3){
					if (w.charAt(0) == w.charAt(1) && w.charAt(0) == w.charAt(2)){
						System.out.println("no answer");
						continue;
					}
				}
                char[] c = w.toCharArray();
                // Arrays.sort(c);
                
                flag = false;
				
                
                while (true){
					
                    int i = c.length - 1;
		            while (i > 0 && c[i-1] >= c[i])
			            i--;
                    
                    if (i <= 0)
			            break;
                    
                    int j = c.length - 1;
		            while (c[j] <= c[i-1])
			            j--;
                    
                    char temp = c[i-1]; //pivot
		            c[i-1] = c[j];
		            c[j] = temp;
                    
                    
                    j = c.length - 1;
					
		            while (i < j){
			             temp = c[i];
			             c[i] = c[j];
			             c[j] = temp;
			             i++;
			             j--;
		            }
                    
                    s = new String(c);
                    
                    if (s.compareTo(w) > 0){
                        System.out.println(s);
                        flag = true;
						
                        break;
                    }
                    
                }
                
                if (flag == false){
                    System.out.println("no answer");
                }
                
            }
        }
        catch (Exception e){
            e.printStackTrace();
        }
        
            
    }
    

}




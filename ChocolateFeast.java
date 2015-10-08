import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

//ChocolateFeast
public class ChocolateFeast {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        try{
            int t = in.nextInt();
            for(int i = 0; i < t; i++){
                System.out.println(Solve(in.nextInt(), in.nextInt(), in.nextInt()));
                
                
            }
        }
        catch(Exception e){
            e.printStackTrace();
        }
        finally{
            in.close();
        }
        
    }
    
    private static long Solve(int N, int C, int M){
        
         //Write code to solve each of the test over here
        long numWrappers = 0;
        long totalChocolateBars = 0;
        while (N >= C){
            N -= C;
            numWrappers++;
            totalChocolateBars++;
            if (numWrappers == M){
                totalChocolateBars++;
                numWrappers = 1;
            }
        }
        
        return totalChocolateBars;
    }
    
    
}

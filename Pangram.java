import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Pangram {

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
		
		try{
            Scanner in = new Scanner(System.in);
            String sentence = in.nextLine().toLowerCase();
            HashSet<Integer> set = new HashSet<Integer>();
    
            for (int i = 0; i < sentence.length(); i++){
                set.add(sentence.charAt(i) - 0);
            }
    
    
            for (int i = 97; i <= 122; i++){
                if (!set.contains(i)){
                    System.out.println("not pangram");
                    break;
                }
                if (i == 122){
                    System.out.println("pangram");
                    break;
                }
            }
		}
		catch (Exception e){
			e.printStackTrace();
		}
    }
}
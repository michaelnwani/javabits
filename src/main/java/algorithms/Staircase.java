package main.java.algorithms;
import java.util.*;

public class Staircase {

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        try{
            Scanner in = new Scanner(System.in);
            StringBuilder builder = new StringBuilder();
            int staircaseSize = in.nextInt();
            int i = 1;
            int k = staircaseSize - i;
            int count = i;
            while (i <= staircaseSize){

                while (k > 0){
                    builder.append(" ");
                    k--;
                }
                while (count > 0){
                    builder.append("#");
                    count--;
                }

                builder.append("\n");
                i++;
                k = staircaseSize - i;
                count = i;
            }

            System.out.println(builder.toString());

        }
        catch (Exception e){
            e.printStackTrace();
        }

		// String space = " ";
//         String hash = "#";
//         Scanner sc = new Scanner(System.in);
//         int t = sc.nextInt();
//         StringBuilder sb = new StringBuilder();
//
//         for (int i = 0; i < t; i++) {
//
// 			//\0 'control character' in Java is very different from the type in C or C++.
// 			//default value of a char in java is \0. created an array out of them. put them in the strings
// 			//even though if you printed the strings it's a non-printable value
//             int timesPadding = t - i - 1 ;
//             int timesHash = i+1;
//             String spaceStr = new String(new char[timesPadding]).replace("\0", space);
//             String hashStr = new String (new char[timesHash]).replace("\0", hash);
//
//
//             System.out.println(spaceStr+hashStr);
//
//         }
    }
}
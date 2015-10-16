package main.java.algorithms;
import java.util.Scanner;
public class DiagonalDifference {

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        
        try{
            Scanner in = new Scanner(System.in);
            int N = in.nextInt();
            
            //in a squared matrix, the number of main diagonals shall always be two.
            int firstDiagonal = 0;
            int secondDiagonal = 0;
            in.nextLine();
            int[][] matrix = new int[N][N];
            for (int row = 0; row < N; row++){
                for (int col = 0; col < N; col++){
                    matrix[row][col] = in.nextInt();
                    
                }
                if (in.hasNextLine()){
                   in.nextLine(); 
                }
            }
            
            for (int row = 0; row < N; row++){
                firstDiagonal   += matrix[row][row];
                secondDiagonal  += matrix[N - row - 1][row];
            }
           
            System.out.println(Math.abs(firstDiagonal - secondDiagonal));
            
            
            
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }
}
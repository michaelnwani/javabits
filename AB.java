// Problem Statement
// You are given two s: N and K. Lun the dog is interested in strings that satisfy the following conditions:
//
// The string has exactly N characters, each of which is either 'A' or 'B'.
// The string s has exactly K pairs (i, j) (0 <= i < j <= N-1) such that s[i] = 'A' and s[j] = 'B'.
// If there exists a string that satisfies the conditions, find and return any such string. Otherwise, return an empty string.

// Constraints
// - N will be between 2 and 50, inclusive.
// - K will be between 0 and N(N-1)/2, inclusive.
	
import java.util.Arrays;
public class AB{
    public String createString(int N, int K){
        // N characters, each of which is either 'A' or 'B'.
        // has exactly K pairs (i,j) (0 <= i < j <= N-1) such that s[i] = 'A' and s[j]='B'.
        // Constraints:
        // N will be between 2 and 50, inclusive.
        // K will be between 0 and N(N-1)/2, inclusive.
        if (N > 50 || N < 2){
            return "";
        }
        if (K < 0 || K > (N*N/4)){
            return "";
        }
        
        char[] s_char = new char[N];
        Arrays.fill(s_char,'B');
        if (K == 0){
         	return new String(s_char);   
        }
        s_char[s_char.length-1] = 'A';
        
        int pairs = 0;
        // int numAs = 1;
        int stop = 0;
        for (int i = N-2; i >= 0; i--){
            s_char[i] = 'A';
            s_char[i+1] = 'B';
            pairs++;
            if (pairs == K){
                break;
            }
            if (i == stop){
                i = N-2;
                stop++;
            }
        }
        
        return new String(s_char);
    }
}
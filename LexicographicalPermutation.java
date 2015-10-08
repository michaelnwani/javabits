// from http://www.nayuki.io/page/next-lexicographical-permutation-algorithm
import java.util.Arrays;
public class LexicographicalPermutation{
	
	public static boolean nextPermutation(int[] array){
		// Find longest non-increasing suffix
		int i = array.length - 1;
		while (i > 0 && array[i-1] >= array[i])
			i--;
		
		
		// Now i is the head of the suffix
		
		// Are we at the last permutation already?
		if (i <= 0)
			return false;
		
		// Let array[i-1] be the pivot
		// Find rightmost element that exceeds the pivot.
		int j = array.length - 1;
		while (array[j] <= array[i-1])
			j--;
		// Now the value array[j] will become the new pivot
		// Assertion: j >= i
		
		// Swap the pivot with j (j is the smallest element in
		// the suffix that is greater than the pivot)
		int temp = array[i-1]; //pivot
		array[i-1] = array[j];
		array[j] = temp;
		
		// Reverse the suffix (make it non-increasing a.k.a. weakly increasing)
		j = array.length - 1;
		while (i < j){
			temp = array[i];
			array[i] = array[j];
			array[j] = temp;
			i++;
			j--;
		}
		
		// Successfully computed the next permutation
		return true;
	}
	
	public static void main(String[] args){
		// Print all the permutations of (0,1,1,1,4):
		// MUST start at lowest permutation (sort it first if necessary)
		int[] array = {0,1,1,1,4}; 
		do{
			System.out.println(Arrays.toString(array));
		} while (nextPermutation(array));
		
	}
}
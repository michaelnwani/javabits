import java.util.*;

// Problem: Rotate an array of n elements to the right by k steps. For example, with n = 7 and k = 3, the array [1,2,3,4,5,6,7] is rotated to [5,6,7,1,2,3,4]. How many different ways do you know to solve this problem?
	
public class RotateArray{
	
	public static int[] rotateKSteps(int[] arr, int k){
		//Pass by ref.
		assert k > 0;
		assert arr != null;
		assert arr.length > 0;
		if (k > arr.length){
			k = k%arr.length;
		}
		
		int[] retArray = new int[arr.length];
		
		for (int i = 0; i < retArray.length; i++){
			retArray[i] = arr[(i+k+1)%arr.length];
		}
		
		return retArray;
	}
	public static void main(String[] args){
		int[] array = {1,2,3,4,5,6,7};
		
		for (int i : rotateKSteps(array,3)){
			System.out.print(i + " ");
		}

	}
}
package main.java.algorithms;
// Given an array nums, there is a sliding window of size k which is moving from the very left of the array to the very right. You can only see the k numbers in the window. Each time the sliding window moves right by one position.
//
// For example,
// Given nums = [1,3,-1,-3,5,3,6,7], and k = 3.
// 	Window position                Max
// 	---------------               -----
// 	[1  3  -1] -3  5  3  6  7       3
// 	 1 [3  -1  -3] 5  3  6  7       3
// 	 1  3 [-1  -3  5] 3  6  7       5
// 	 1  3  -1 [-3  5  3] 6  7       5
// 	 1  3  -1  -3 [5  3  6] 7       6
// 	 1  3  -1  -3  5 [3  6  7]      7

// 	Therefore, return the max sliding window as [3,3,5,5,6,7].
//	Linear-time result
import java.util.*;	 
public class MaxSlidingWindow{
	
	public static int[] maxSlidingWindow(int[] nums, int k) {
			assert nums != null;
		    if (k < 1 || k > nums.length){
		        return new int[0];
		    }
			PriorityQueue<Integer> queue = new PriorityQueue<Integer>(6, 
				new Comparator<Integer>(){
					public int compare(Integer a, Integer b){
						if (a > b) return -1;
						else if (a < b) return 1;
						else return 0;
					}
				}
			);
			for (int i = 0; i < k; i++){
				queue.add(nums[i]);
			}
			
			int[] window = new int[nums.length-(k-1)];
			window[0] = queue.peek();
			
			int removeElement = nums[0];
			int startIndex = 1;
			int endIndex = k;
			while (endIndex < nums.length){
				queue.remove(removeElement);
				queue.add(nums[endIndex]);
				window[startIndex] = queue.peek();
				removeElement = nums[startIndex];
				startIndex++;
				endIndex++;
			}

        
	        return window;
	}
	
	
	public static void main(String[] args){
		
		int[] nums = {1,-1};
		int[] window = maxSlidingWindow(nums, 1);
		for (int i : window){
			System.out.print(i + " ");
		}
	}
}
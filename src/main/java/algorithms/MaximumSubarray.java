package main.java.algorithms;

// TODO: Fix/finish this
public class MaximumSubarray {
	
	public int maxSubArray(int[] nums) {
	        int currentMax = nums[0];
	        // int startIndex = 0;
	        // int endIndex = 0;
	        int currentSum = nums[0];
	        for (int i = 1; i < nums.length; i++) {
				
				if (currentSum < 0) {
					currentSum = nums[i];
				} else {
					currentSum += nums[i];
				}
				
				if (currentSum >= currentMax) {
					currentMax = currentSum;
				}
				
	            
	        }
        
	        return currentMax;
	 }
	
	public static void main(String[] args) {
		int[] arr = new int[args.length];

		for (int i = 0; i < arr.length; i++) {
			arr[i] = Integer.parseInt(args[i]);
		}
		MaximumSubarray solution = new MaximumSubarray();
		// int[] arr = {-2,1,-3,4,-1,2,1,-5,4};
		System.out.println(solution.maxSubArray(arr));
	}
}
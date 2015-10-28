package main.java.algorithms;

// Given a binary tree, find the maximum path sum.

class TreeNode {
    int val;
    public TreeNode left;
    public TreeNode right;
    public TreeNode(int x) {
        val = x;
    }
}

// TODO: Don't believe this is correct, need to go back and fix it.
public class MaximumPathSum {
	
		public int maxPathSum(TreeNode root) {
	        if (root == null) {
	            return 0;
	        } 
        	
			int maxSum = 0;
			maxSum = maxPathSumHelper(root.left, root.val);
			System.out.println("After left subtree: "+maxSum);
			maxSum = maxPathSumHelper(root.right, maxSum);
	        return maxSum;
       
	    }
    
	    public int maxPathSumHelper(TreeNode root, int maxSum) {
			if (root == null) {
				return maxSum;
			}
        	System.out.println("at the top: maxSum: "+maxSum);
	        // check against your edge cases in live coding
			// adding goes here
			
            if (maxSum < 0 && (root.val > 0)) {
                maxSum = root.val;
            } else if (maxSum < 0 && (root.val < 0)){
                if (maxSum < root.val) {
                    maxSum = root.val;
                }
            } else {
                int newMaxSum = root.val + maxSum;
				System.out.println("newMaxSum: "+newMaxSum);
                if (newMaxSum > maxSum) {
					maxSum = newMaxSum;
                } 
            }
			
			if (root.left != null) {
				maxSum = maxPathSumHelper(root.left, maxSum);
			}
			if (root.right != null) {
				maxSum = maxPathSumHelper(root.right, maxSum);
			}
			
			
            
            // We have completely traversed the tree and gathered the max.
			
	        return maxSum;
	}
	
	public static void main(String[] args) {
		TreeNode root  = new TreeNode(1);
		TreeNode node2 = new TreeNode(2);
		TreeNode node3 = new TreeNode(3);
		TreeNode node4 = new TreeNode(4);
		TreeNode node5 = new TreeNode(5);
		
		root.left = node2;
		root.right = node3;
		
		// node2.left = node3;
// 		node2.right = null;
//
// 		node3.left = node4;
// 		node3.right = null;
//
// 		node4.left = node5;
// 		node4.right = null;
		
		MaximumPathSum solution = new MaximumPathSum();
		System.out.println(solution.maxPathSum(root));
	}
	
	// public int maxPathSum(TreeNode root) {
// 		int max[] = new int[1];
// 		max[0] = Integer.MIN_VALUE;
// 		calculateSum(root, max);
// 		return max[0];
// 	}
//
// 	public int calculateSum(TreeNode root, int[] max) {
// 		if (root == null)
// 			return 0;
//
// 		int left = calculateSum(root.left, max);
// 		int right = calculateSum(root.right, max);
//
// 		int current = Math.max(root.val, Math.max(root.val + left, root.val + right));
//
// 		max[0] = Math.max(max[0], Math.max(current, left + root.val + right));
//
// 		return current;
// 	}
}
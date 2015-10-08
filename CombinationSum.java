// Given a set of candidate numbers (C) and a target number (T), find all unique combinations
// in C where the candidate numbers sums to T. The same repeated number may be chosen from C
// unlimited number of times.
import java.util.*;
public class CombinationSum{
	//Depth First Search (DFS) problem:
	
	public static ArrayList<ArrayList<Integer>> combinationSum(int[] candidates, int target){
		ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
		
		if (candidates == null || candidates.length == 0) return result;
		
		ArrayList<Integer> current = new ArrayList<Integer>();
		Arrays.sort(candidates);
		
		combinationSum(candidates, target, 0, current, result);
		
		return result;
	}
	
	public static void combinationSum(int[] candidates, int target, int j, ArrayList<Integer> curr, ArrayList<ArrayList<Integer>> result){
		if (target == 0){ //this is all that matters; the others are discarded
			ArrayList<Integer> temp = new ArrayList<Integer>(curr);
			result.add(temp);
			return;
		}
		
		for (int i = j; i < candidates.length; i++){
			if (target < candidates[i])
				return;
			
			curr.add(candidates[i]);
			combinationSum(candidates, target - candidates[i], i, curr, result);
			// this combinationSum returns from the stack when the above (if target < candidates[i])
			// returns, in which case the last added int to the list makes it too large
			// so we remove it from circulation.
			System.out.println("curr last index is currently: "+curr.get(curr.size()-1));
			curr.remove(curr.size()-1);
		}
	}
	
	public static void main(String[] args){
		int[] possibleValues = {2,2,3,7};
		ArrayList<ArrayList<Integer>> combinations = combinationSum(possibleValues, 7);
		for (ArrayList<Integer> list : combinations){
			for (int i : list){
				System.out.print(i + " ");
			}
			System.out.println();
		}
	}
}
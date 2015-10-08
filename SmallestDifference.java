import java.util.*;
public class SmallestDifference{
	public static String minDifference(int len, String s){
		int[] arr = new int[len];
		String[] sArr = s.split(" ");
		StringBuilder stringBuilder = new StringBuilder();
		for (int i = 0; i < len; i++){
			arr[i] = Integer.parseInt(sArr[i]);
		}
		
		Arrays.sort(arr);	//O(N log N)
		int minDiff = Integer.MAX_VALUE;
		
		List<int[]> pairs = new ArrayList<int[]>();
		for (int i = 0; i < len-1; i++){
			int diff = Math.abs(arr[i+1] - arr[i]);
			if (diff < minDiff){
				pairs.clear();
				minDiff = diff;
			}
			
			if (diff == minDiff)
				pairs.add(Arrays.copyOfRange(arr,i,i+2));
		}
		
		for (int i = 0; i < pairs.size(); i++){
			stringBuilder.append(pairs.get(i)[0] + " " + pairs.get(i)[1] + " ");
		}
		
		return stringBuilder.toString();
		
		
	}
	public static void main(String[] args){
		System.out.println(minDifference(10, "-20 -36423 -343243 30 -24344 10 -40 -80 -10000 -90"));
	}
}
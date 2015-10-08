import java.util.Arrays;

class StringPermutationTest{
	public static void main(String[] args){
		String moon = "moon    ";
		String noom = "noom";
		
		System.out.print(isPermutation(moon, noom));
	}
	
	public static boolean isPermutation(String str1, String str2){
		char[] chars1 = str1.trim().toLowerCase().toCharArray();
		Arrays.sort(chars1);
		str1 = new String(chars1);
		
		char[] chars2 = str2.trim().toLowerCase().toCharArray();
		Arrays.sort(chars2);
		str2 = new String(chars2);
		
		if (str1.compareTo(str2) == 0){
			return true;
		}
		else{
			return false;
		}
	
	}
}
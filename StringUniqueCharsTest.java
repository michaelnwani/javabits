import java.util.ArrayList;

public class StringUniqueCharsTest
{
	public static void main(String[] args)
	{
		String hello = "helo";
		System.out.print(validateUniqueString(hello));
	}
	
	public static boolean validateUniqueString(String str){
		ArrayList<Character> list = new ArrayList<Character>();
		for (int i = 0; i < str.length(); ++i){
			if (list.contains(str.charAt(i))){
				return false;
			}
			else{
				list.add(str.charAt(i));
			}
		}
		
		return true;
	}
}

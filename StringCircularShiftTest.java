public class StringCircularShiftTest
{
	public static void main(String[] args)
	{
		//strings entered at command line
		String string1 = args[0];
		String string2 = args[1];
		circularShiftTest(string1, string2);
	}
	
	public static void circularShiftTest(String s, String t)
	{
		StdOut.println((s.length() == t.length()) && (s.concat(s).indexOf(t) >= 0));
	}
}
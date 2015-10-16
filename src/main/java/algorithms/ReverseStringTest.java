package main.java.algorithms;
public class ReverseStringTest
{
	public static void main(String[] args)
	{
		StdOut.println(mystery(args[0]));
	}
	
	public static String mystery(String s)
	{
		int N = s.length();
		if (N <= 1) return s;
		String a = s.substring(0, N/2);
		String b = s.substring(N/2, N);
		return mystery(b) + mystery(a);
	}
}
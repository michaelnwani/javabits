public class Count
{
	public static void main(String[] args)
	{
		//create a new alphabet from the provided chars.
		Alphabet alpha = new Alphabet(args[0]);
		int R = alpha.R(); //radix(number of characters in alphabet)
		int[] count = new int[R];
		
		String s = StdIn.readAll();
		int N = s.length();
		for (int i = 0; i < N; i++)
		{
			//if the char ('c') is in the alphabet?
			if (alpha.contains(s.charAt(i)))
			{	//convert the char ('c') to an index between 0 and R-1
				count[alpha.toIndex(s.charAt(i))]++;
			}
		}
		
		for (int c = 0; c < R; c++)
		{	//convert the int index to its backing char form
			StdOut.println(alpha.toChar(c) + " " + count[c]);
		}
		
	}
}
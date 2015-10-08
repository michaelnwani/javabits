import java.util.Arrays;

public class BinarySearch
{
	//takes the name of a whitelist file (a sequence of integers) as argument
	//and filters any entry that is on the whitelist from standard input,
	//leaving only integers that are not on the whitelist on standard output
	public static void main(String[] args){
		// In in = new In(args[0]);
// 		int[] whitelist = in.readAllInts();
//
// 		Arrays.sort(whitelist);
// 		while (!StdIn.isEmpty()){
// 			int key = StdIn.readInt();
// 			if (rank(key, whitelist) == -1)
// 				StdOut.println(key);
// 		}
		
		// int f = 0;
// 		int g = 1;
// 		for (int i = 0; i <= 15; i++){
// 			System.out.println(f);
// 			f = f + g;
// 			g = f - g;
// 		}
// 		System.out.println();
// 		double t = 9.0;
// 		while (Math.abs(t - 9.0/t) > .001){
// 			t = (9.0/t + t) / 2.0;
// 		}
// 		StdOut.printf("%.5f\n", t);
// 		System.out.println('b' + 'c');
// 		System.out.println((char)('a' + 4));

//Puts the binary representation of a positive integer N into a String s
		String s = "";
		for (int n = 16; n > 0; n /= 2)
		{
			s = (n % 2) + s;
		}
		System.out.println(s);
		
		//Print the contents of a 2D boolean array, using * to represent true and a space to represent false
		
			
		System.out.println(F(5));
		//F(5): (can just plug in the mathematical formula)
		//expecting returned value of 3 + 2
		//F(N-2) = 3.
		//F(N-1) = 4. this creates offsprings 3 and 2. F(N-1) = 3. This creates offsprings 2 and 1. F(N-1) = 2. This creates offsprings 1 and 0. The 1 returns 1, and the 0 returns 0. So that equals 1. This 1 gets added with F(N-1) = 3's offspring of 1 F(N-2), which also returns 1. So as of F(N-1) = 3 we have 2. Now F(N-1) = 4's offspring of 2 is F(N-2) = 2. F(N-2) = 2's offsprings are 1 and 0, which return 1 back to it. Fo that gets added with F(N-1) = 3's value of 2 to make 3. F(N-4) gives us 3. Now on to F(N-2) = 3. We already know going down that recursive path gets us a return value of 2. Therefore F(5) = F(4) + F(3) = 3 + 2 = 5 is correct.
		
		//My approach with an array was superior
		for (int N = 0; N < 90; N++)
		{
			StdOut.print(N + " " + F(N) + " ");
		}
		System.out.println();
//natural log is log base e(2.718)
	// System.out.println(Math.E);
// 	System.out.println(Math.pow(Math.E,3));
// 	System.out.println(Math.log(20.0855369));
	}
	
	public static int rank(int key, int[] a){
		int lo = 0;
		int hi = a.length - 1;
		while (lo <= hi){
			int mid = lo + (hi - lo) / 2;
			if (key < a[mid]) hi = mid - 1;
			else if (key > a[mid]) lo = mid + 1;
			else 					return mid;
		}
		
		return -1;
	}
	
	public static long F(int N)
	{
		if (N == 0) return 0;
		if (N == 1) return 1;
		return F(N-1) + F(N-2);
	}
}
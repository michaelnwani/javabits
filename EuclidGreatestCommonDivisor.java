
public class EuclidGreatestCommonDivisor
{
	public static void main(String args[]){
		StdOut.println("Gcd: 1000 and 60 = " + gcd(1000, 60));
	}
	
	public static int gcd(int p, int q){

		if (q == 0) return p;
		int r = p % q; 
		return gcd(q, r); //the value known as q is the old r
	} 
	
}

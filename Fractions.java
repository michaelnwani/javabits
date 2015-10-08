public class Fractions{
	//Multiply two fractions. In each array is a 2-element pair
	//the first element is the numerator, the second is the denominator
	public static int[] multiplyFractions(int[] a, int[] b){
		int[] c = {a[0]*b[0], a[1]*b[1]};
		
		return c;
	}
	
	public static int[] addFractions(int[] a, int[] b){
		int denom = lcm(a[1], b[1]);
		int[] c = {(denom/a[1])*a[0] + (denom/b[1])*b[0], denom};
		return c;
	}
	
	public void reduceFraction(int[] a){
		int b = gcd(a[0], a[1]);
		a[0] /= b;
		a[1] /= b;
	}
	
	public static int lcm(int a, int b){
		return a*b/gcd(a, b);
	}
	
	public static int gcd(int a, int b){
		if (b == 0) return a;
		return gcd(b, a%b);
	}
	
	public static void main(String[] args){
		
	}
}
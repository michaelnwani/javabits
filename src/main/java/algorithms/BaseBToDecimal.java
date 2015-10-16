package main.java.algorithms;
public class BaseBToDecimal{
	public static int toDecimal(int n, int b){
		// int result = 0;
// 		int multiplier = 1;
//
// 		//math checks out
// 		while (n > 0){
// 			result += n%10*multiplier;
// 			multiplier*=b;
// 			n /= 10;
// 		}
		
		return Integer.parseInt(""+n,b);
	}
	public static void main(String[] args){
		System.out.println("Base 8 1011 to decimal:");
		System.out.println(toDecimal(1011,8));
	}
}
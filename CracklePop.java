import java.util.*;

/*Write a program that prints out the numbers 1 to 100 (inclusive). If the number is divisible by 3, print Crackle instead of the number. If it's divisible by 5, print Pop. If it's divisible by both 3 and 5, print CracklePop. You can use any language.*/

public class CracklePop{
	
	public static void main(String[] args){
		for (int i = 1; i <= 100; i++){
			if ((i%3 == 0) && (i%5 == 0)){
				System.out.println("CracklePop");
			} else if (i%5 == 0){
				System.out.println("Pop");
			} else if (i%3 == 0){
				System.out.println("Crackle");
			} else {
				System.out.println(i);
			}
			
		}
	}
}
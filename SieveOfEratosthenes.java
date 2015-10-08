import java.util.Arrays;
public class SieveOfEratosthenes{
	public static boolean[] sieve(int n){
		boolean[] prime = new boolean[n+1];
		Arrays.fill(prime, true);
		prime[0] = false;
		prime[1] = false;
		int m = (int)Math.sqrt(n);
		
		for (int i = 2; i <= m; i++){
			if (prime[i]){
				for (int k = i*i; k <= n; k+= i){
					prime[k] = false;
				}
			}
		}
		
		return prime;
	}
	
	public static void main(String[] args){
		System.out.println("All the primes from 1 to 10000:");
		boolean[] primes = sieve(10000);
		for (int i = 0; i < primes.length; i++){
			if (primes[i]){
				System.out.println(i);
			}
		}
	}
	
	
}
// package main.java.algorithms;

// By Michael Nwani - 10/20/2015.

// Problem Statement:
// At Quora, we have aggregate graphs that track the number of upvotes we get each day.
//
// As we looked at patterns across windows of certain sizes, we thought about ways to track trends such as non-decreasing and non-increasing subranges as efficiently as possible.
//
// For this problem, you are given N days of upvote count data, and a fixed window size K. For each window of K days, from left to right, find the number of non-decreasing subranges within the window minus the number of non-increasing subranges within the window.
//
// A window of days is defined as contiguous range of days. Thus, there are exactly N−K+1 windows where this metric needs to be computed. A non-decreasing subrange is defined as a contiguous range of indices [a,b], [math]a, where each element is at least as large as the previous element. A non-increasing subrange is similarly defined, except each element is at least as large as the next. There are up to K(K−1)/2 of these respective subranges within a window, so the metric is bounded by [−K(K−1)/2,K(K−1)/2].

// Sample Input
// 5 1
// 1 2 3 1 1
//
// Sample Output
// 3
// 0
// -2
		
// TODO: Ran out of interest. Need to make it more efficient
import java.util.Scanner;
import java.util.InputMismatchException;
import java.util.NoSuchElementException;
import java.util.Map;
import java.util.Map.Entry;
import java.util.LinkedHashMap;
public class Upvotes {
	
	int nonDecreasingSubranges = 0;
	int nonIncreasingSubranges = 0;
	boolean nonDecreasingFlag;
	boolean nonIncreasingFlag;
	public static Map<Integer, Integer> windowMap;
	
	// number of non-decreasing subranges within the window 
	// minus the number of non-increasing subranges within the window.
	public int numOfSubRangesDifference(Map<Integer, Integer> windowMap, int startIndex) {
		nonDecreasingSubranges = 0;
		nonIncreasingSubranges = 0;
		
		for (int i = startIndex; i < ((windowMap.size()-1)+startIndex); i++) {
			for (int k = i+1; k < ((windowMap.size())+startIndex); k++) {
				if (windowMap.get(i) < windowMap.get(k)) {
					if (nonIncreasingFlag == true) {
						nonIncreasingFlag = false;
						break;
					}
					nonDecreasingFlag = true;
					nonDecreasingSubranges++;
				} else if (windowMap.get(i) > windowMap.get(k)) {
					if (nonDecreasingFlag == true) {
						nonDecreasingFlag = false;
						break;
					}
					nonIncreasingFlag = true;
					nonIncreasingSubranges++;
				} else {
					nonIncreasingSubranges++;
					nonDecreasingSubranges++;
				}
			}
		}
		nonDecreasingFlag = false;
		nonIncreasingFlag = false;
		return nonDecreasingSubranges - nonIncreasingSubranges;
	}
	
	public static void main(String[] args) {
		
		// handles closing the input stream afterwards
		try(Scanner input = new Scanner(System.in)) {
			int N = input.nextInt();
			if (N < 1 || N > 100000) {
				throw new IllegalArgumentException("1 <= N <= 100000");
			}
			
			int K = input.nextInt();
			if (K < 1 || K > N) {
				throw new IllegalArgumentException("1 <= K <= N");
			}
			
			// save ourselves a lot of computation here.
			// for a window size of 1, 
			// nonDecreasingSubrange count is itself - 1,
			// nonIncreasingSubrange count is itself - 1,
			// nonDecreasingSubrange - nonIncreasingSubrange = 0;
			if (K == 1) {
				for (int i = 0; i < N; i++) {
					System.out.println(0);
				}
				return;
			}
			
			input.nextLine();
			
			Upvotes solution = new Upvotes();
			
			windowMap = new LinkedHashMap<Integer, Integer>(K, 1.1f, true){
				@Override
				protected boolean removeEldestEntry(Map.Entry<Integer,Integer> eldest) {
					return size() > K;
				}
			};
			
			int i = 0;
			while (i < K-1) {
				windowMap.put(i, input.nextInt());
				i++;
			}
			
			int j = 0;
			for (; i < N; i++) {
				windowMap.put(i, input.nextInt());
				System.out.println(solution.numOfSubRangesDifference(windowMap, j));
				j++;
			}
			
			
		} catch (InputMismatchException e) {
			e.getMessage();
			
		} catch (NoSuchElementException e) {
			e.getMessage();
		} catch (IllegalStateException e) {
			e.getMessage();
		}
		
		
	}
}
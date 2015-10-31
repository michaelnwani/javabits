package main.java.algorithms;

public class FrogJmp {
	
	public int solution(int X, int Y, int D) {
        // write your code in Java SE 8
        if (X > Y) {
            throw new IllegalArgumentException("X <= Y");
        }
    
        if (X < 1 || X > 1000000000 || Y < 1 
        || Y > 1000000000 ||  D < 1 || D > 1000000000) {
            throw new IllegalArgumentException("Values have to be within the range [1..1B]");
        }
    
        if (X == Y) {
            return 0;
        }
    
		int jumps = 0;
		
        double value = ((double)(Y-X)/D);
		double temp = (int)value;
		if (temp != value) { // e.g. value was 2.5
			jumps = (int)Math.ceil(value);
		} else {
			jumps = (int)temp;
		}
		
        return jumps;
	}
	
	public static void main(String[] args) {
		FrogJmp frogJmp = new FrogJmp();
		System.out.println(frogJmp.solution(1,5,2));
	}
}
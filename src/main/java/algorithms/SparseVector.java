package main.java.algorithms;
import java.util.HashMap;
import java.util.Set;
//Sparse vector with dot product.
public class SparseVector
{
	//private HashST<Integer, Double> st;
	private HashMap<Integer, Double> st;
	
	public SparseVector()
	{
		st = new HashMap<Integer,Double>();
	}
	
	public int size()
	{
		return st.size();
	}
	
	public void put(int i, double x)
	{
		st.put(i, x);
	}
	
	public double get(int i)
	{
		if (st.get(i) == null) 	return 0.0;
		else					return st.get(i);
	}
	
	public double dot(double[] that)
	{
		double sum = 0.0;
		Set<Integer> keys = st.keySet();
		
		//represents a column
		for (int i : keys)
		{
			sum += that[i] * this.get(i);
		}
		
		return sum;
	}
	
	public String toString()
	{
		return st.toString();
	}
	
	public static void main(String[] args)
	{
		//Sparse matrix-vector multiplication:
		
		SparseVector[] a;
		a = new SparseVector[5];
		double[] x = new double[5];
		double[] b = new double[5];
		for (int i = 0; i < 5; i++)
		{
			a[i] = new SparseVector();
		}
		
		a[0].put(1,.90);
		a[1].put(2,.36);
		a[1].put(3,.36);
		a[1].put(4,.18);
		a[2].put(3,.90);
		a[3].put(0,.90);
		a[4].put(0,.47);
		a[4].put(2,.47);
		
		System.out.println("SparseVectors: \n");
		for (int i = 0; i < 5; i++)
		{
			System.out.println(a[i]);
		}
		x[0] = .05;
		x[1] = .04;
		x[2] = .36;
		x[3] = .37;
		x[4] = .19;
		
		for (int i = 0; i < 5; i++)
		{
			b[i] = a[i].dot(x);
		}
		
		System.out.println("result vector: \n");
		for (int i = 0; i < 5; i++)
		{
			System.out.println(b[i]);
		}
	}
}

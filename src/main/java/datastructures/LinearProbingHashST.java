package main.java.datastructures;
// Algorithm 3.6
public class LinearProbingHashST<Key, Value>
{
	private int N;			// number of key-value pairs in the table
	private int M = 16;		// size of linear-probing table
	private Key[] keys;		// the keys
	private Value[] vals;	// the values
	
	public LinearProbingHashST()
	{
		keys = (Key[]) new Object[M];
		vals = (Value[]) new Object[M];
	}
	
	public LinearProbingHashST(int cap)
	{
		M = cap;
		keys = (Key[]) new Object[cap];
		vals = (Value[]) new Object[cap];
	}
	
	private int hash(Key key)
	{
		return (key.hashCode() & 0x7fffffff) % M;
	}
	
	private void resize(int cap)
	{
		LinearProbingHashST<Key, Value> t;
		t = new LinearProbingHashST<Key, Value>(cap);
		for (int i = 0; i < M; i++)
		{
			if (keys[i] != null)
				t.put(keys[i], vals[i]);
		}
		keys = t.keys;
		vals = t.vals;
		M = t.M;
	}

	public void put(Key key, Value val)
	{
		if (N >= M/2) resize(2*M);	//double M (see text)
		
		int i;	
		//linear probe (% M is so we can wrap around):
		for (i = hash(key); keys[i] != null; i = (i + 1) % M)
		{
			if (keys[i].equals(key)) {
				vals[i] = val;
				return;
			}	
		}
		
		keys[i] = key;
		vals[i] = val;
		N++;
		
	}
	
	public Value get(Key key)
	{
		for (int i = hash(key); keys[i] != null; i = (i + 1) % M)
		{
			if (keys[i].equals(key))
			{
				return vals[i];
			}
		}
		
		return null;
	}
	
	public boolean contains(Key key)
	{
		
		for (int i = hash(key); keys[i] != null; i = (i + 1) % M)
		{
			if (keys[i].equals(key))
			{
				return true;
			}
		}
		
		return false;
	}
	
	public void delete(Key key)
	{
		//We have to re-insert every key-value pair in the table 
		//whose position was after the key-value pair we're deleting...
		//that can't be even remotely cheap.
		if (!contains(key)) return;
		int i = hash(key);
		while (!key.equals(keys[i]))
		{
			i = (i + 1) % M;
		}
		keys[i] = null;
		vals[i] = null;
		i = (i + 1) % M;
		while (keys[i] != null)
		{
			Key 	keyToRedo = keys[i];
			Value 	valToRedo = vals[i];
			keys[i] = null;
			vals[i] = null;
			N--;
			put(keyToRedo, valToRedo);
			i = (i + 1) % M;
		}
		N--;
		if (N > 0 && N <= M/8)
			resize(M/2);
	}
	
	
}





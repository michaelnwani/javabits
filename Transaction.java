public class Transaction implements Comparable<Transaction>
{
	private final double amount;
	private final Date date;
	private final String who;
	private final String transaction;
	
	public Transaction(String who, Date when, double amount)
	{
		this.who = who;
		this.date = when;
		this.amount = amount;
		this.transaction = "";
	}
	
	public Transaction(String transaction)
	{
		this.transaction = transaction;
		this.amount = 0.0;
		this.date = null;
		this.who = "";
	}
	
	public String who()
	{
		//customer name
		return who;
	}
	
	public Date when()
	{
		//date
		return date;
	}
	
	public double amount()
	{
		//amount
		return amount;
	}
	
	public String toString()
	{
		//string representation
		return transaction;
	}
	
	public boolean equals(Object that)
	{
		//is this the same transaction as that?
		return this == that;
	}
	
	public int compareTo(Transaction that)
	{
		//compare this transaction to that
		if (this.amount > that.amount) return +1;
		if (this.amount < that.amount) return -1;
		return 0;
	}
	
	public int hashCode()
	{
		//Horner's method: hash = R (a prime number) * hash + user-defined type's hashcode's.
		//or, % M (a bigger prime number)
		int hash = 17;
		hash = 31 * hash + who.hashCode();
		hash = 31 * hash + when.hashCode();
		hash = 31 * hash + ((Double) amount).hashCode();
		return hash;
	}
	
}
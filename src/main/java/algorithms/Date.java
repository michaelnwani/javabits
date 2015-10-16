package main.java.algorithms;
public class Date
{
	private int month, day, year;
	
	public Date(String date)
	{
		String[] fields = date.split("/");
		month = Integer.parseInt(fields[0]);
		day = Integer.parseInt(fields[1]);
		year = Integer.parseInt(fields[2]);
	}
}
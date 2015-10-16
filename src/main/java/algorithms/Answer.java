package main.java.algorithms;
public class Answer
{	
	private static String[] ipAddressArray;
	private static String[] portNumberArray;
	private static int addressByteInt;
	private static String addressByteString;
	
	public static boolean isValidSocket(String address)
	{
		if (address == null)
		{
			return false;
		}
		
		if (address.length() < 9)
		{
			return false;
		}
		
		return isValidSocketHelper(address);
	}
	
	private static boolean isValidSocketHelper(String address)
	{
		ipAddressArray = address.split("\\.");
		
		if (ipAddressArray.length != 4)
		{
			return false;
		}
		
		for (int i = 0; i < 2; i++)
		{
			addressByteString = ipAddressArray[i];
			try
			{
				addressByteInt = Integer.parseInt(addressByteString);
			}
			catch (Exception e)
			{
				return false;
			}
			
			if (addressByteInt < 0 || addressByteInt > 255)
			{
				return false;
			}
		}
		
		portNumberArray = ipAddressArray[3].split(":");
		addressByteString = portNumberArray[0];
		try
		{
			addressByteInt = Integer.parseInt(addressByteString);	
		}
		catch (Exception e)
		{
			return false;
		}
		
		if (addressByteInt < 0 || addressByteInt > 255)
		{
			return false;
		}
		
		addressByteString = portNumberArray[1];
		try
		{
			addressByteInt = Integer.parseInt(addressByteString);	
		}
		catch (Exception e)
		{
			return false;
		}
		
		if (addressByteInt < 1 || addressByteInt > 65535)
		{
			return false;
		}
		
		return true;
	}
	
	public static void main(String[] args)
	{
		String[] addresses = {"127.12.23.43:5000", "127.A:-12"};
		for (String address : addresses)
		{
		    System.out.println(isValidSocket(address));
		}
	}
}
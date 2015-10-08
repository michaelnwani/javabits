public class NormalizePhoneNumbers
{
	private static String phoneNumberHelperStr;
	
	public static String standardizePhoneNumber(String phoneNumber)
	{
	    // Write your implementation here
		if (phoneNumber == null)
		{
			return "";
		}
		
		if (phoneNumber.length() < 10)
		{
			return "";
		}
	    
		return standardizePhoneNumberHelper(phoneNumber);
	}
	
	private static String standardizePhoneNumberHelper(String phoneNumber)
	{
		phoneNumberHelperStr = phoneNumber.replaceAll("[^\\d]", "");
		
		if (phoneNumberHelperStr.length() != 10)
		{
			return "";
		}
		
		return phoneNumberHelperStr.substring(0, 3) + "-" 
			+ phoneNumberHelperStr.substring(3, 6) + "-" 
				+ phoneNumberHelperStr.substring(6);		
	}
	
    // This tests your code with the examples given in the question, 
    // and is provided only for your convenience.
    public static void main(String[] args)
    {
        String[] phoneNumbers = {"(650) 555-1234", "65.0555.1234",
                                 "65/05/5512/34", "(650) 555-1234 x111",
                                 "(650) 555-123"};
        for (String phoneNumber : phoneNumbers)
        {
            System.out.println(standardizePhoneNumber(phoneNumber));
        }
    }

	
}
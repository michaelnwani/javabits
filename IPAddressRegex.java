import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.Scanner;
public class IPAddressRegex{
	public static String pattern = "(0([0-9]{0,2})|1([0-9]{1,2})|2([0-5]{1,2})|24([0-9]{1})|[3-9]([0-9]{1})).(0([0-9]{0,2})|1([0-9]{1,2})|2([0-5]{1,2})|24([0-9]{1})|[3-9]([0-9]{1})).(0([0-9]{0,2})|1([0-9]{1,2})|2([0-5]{1,2})|24([0-9]{1})|[3-9]([0-9]{1})).(0([0-9]{0,2})|1([0-9]{1,2})|2([0-5]{1,2})|24([0-9]{1})|[3-9]([0-9]{1}))";
	
	public static void main(String[] args)
	{
		Scanner in = new Scanner(System.in);
		        while(in.hasNext())
		        {
		            String IP = in.next();
		            System.out.println(IP.matches(pattern));
		        }
	}
}
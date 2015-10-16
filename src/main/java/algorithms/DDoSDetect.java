package main.java.algorithms;
import java.io.*;
import java.util.Map;
import java.util.HashMap;
import java.util.Set;
import java.util.HashSet;

//Parses through log files of this format:
/*
220.233.136.94 - 6079 [05/Jan/2015:16:53:25 -0800] "PUT /account/withdraw HTTP/1.0" 200 2895
23.108.181.138 - 7073 [05/Jan/2015:16:53:25 -0800] "GET /login.html HTTP/1.0" 200 3306
163.24.94.132 - 7734 [05/Jan/2015:16:53:25 -0800] "PUT /account/information HTTP/1.0" 401 7953
163.24.94.132 - 7734 [05/Jan/2015:16:53:25 -0800] "PUT /account/information HTTP/1.0" 401 7953
163.24.94.132 - 7734 [05/Jan/2015:16:53:25 -0800] "PUT /account/information HTTP/1.0" 401 7953
105.118.169.3 - 9277 [05/Jan/2015:16:53:26 -0800] "POST /account/withdraw HTTP/1.0" 200 1575
241.78.197.101 - 6734 [05/Jan/2015:16:53:26 -0800] "PUT /account/transfer HTTP/1.0" 200 427
28.252.89.140 - 7584 [05/Jan/2015:16:53:26 -0800] "GET /account/information HTTP/1.0" 401 543
28.252.89.140 - 7584 [05/Jan/2015:16:53:26 -0800] "GET /account/information HTTP/1.0" 403 543
28.252.89.140 - 7584 [05/Jan/2015:16:53:27 -0800] "GET /account/information HTTP/1.0" 403 543
5.61.113.127 - 8758 [05/Jan/2015:16:53:27 -0800] "POST /account/information HTTP/1.0" 200 9499
132.155.146.207 - 2400 [05/Jan/2015:16:53:27 -0800] "GET /account/information HTTP/1.0" 200 3137
*/
public class DDoSDetect
{
	private static BufferedReader bufferedReader;
	private static String readLogEntryString;
	private static HashMap<String, Integer> suspiciousIpsMap;
	private static HashSet<String> suspiciousIpsSet;
	private static String[] parsedLogEntryArray;
	private static int currentSec;
	private static int currentSecHelper;
	private static int httpRequestCode;
	
	public static String[] findSuspiciousIps(String logPath) 
	{
		//originally I was constructing this using a Pattern and Matcher object to verify the log entries,
		//but I realized that for our purposes that's unnecessary and we can go really far just 
		//using String.split() instead :).

		try
		{
			bufferedReader = new BufferedReader(new FileReader(logPath));
			
			suspiciousIpsMap = new HashMap<String,Integer>();
			suspiciousIpsSet = new HashSet<String>();			
			
			for (readLogEntryString = bufferedReader.readLine(); readLogEntryString != null; 
			readLogEntryString = bufferedReader.readLine()) {
				
				parsedLogEntryArray = readLogEntryString.split(" ");
				if (suspiciousIpsSet.contains(parsedLogEntryArray[0]))
				{
					continue;
				}
				httpRequestCode = Integer.parseInt(parsedLogEntryArray[8]);
				
				if (httpRequestCode >= 400 && httpRequestCode <= 499)
				{
					
					if (parsedLogEntryArray[6].equals("/account/information"))
					{
						currentSecHelper = 
							Integer.parseInt(parsedLogEntryArray[3].substring(parsedLogEntryArray[3].lastIndexOf(":") 
								+ 1));
						if (((currentSec + 1) % 60)  < (currentSecHelper % 59)) 
						{
							currentSec = currentSecHelper;
							suspiciousIpsMap = null;
						}
						else
						{
							//we're within a second:
							if (suspiciousIpsMap == null)
							{
								suspiciousIpsMap = new HashMap<String,Integer>();
							}
							if (suspiciousIpsMap.get(parsedLogEntryArray[0]) == null)
							{
								suspiciousIpsMap.put(parsedLogEntryArray[0], 1);
							}
							
							suspiciousIpsMap.put(parsedLogEntryArray[0], 
								suspiciousIpsMap.get(parsedLogEntryArray[0])+1);
							
							
							if (suspiciousIpsMap.get(parsedLogEntryArray[0]) >= 3)
							{
								//suspicious IP!
								suspiciousIpsSet.add(parsedLogEntryArray[0]);
							}
						}
					}
				}
			}
		}
		catch (Exception e)
		{
			return new String[] {"Error while reading the log file"};
		}
		finally
		{
			if (bufferedReader != null)
			{
				try
				{
					bufferedReader.close();
				}
				catch(Exception e)
				{
					return new String[] {"Exception thrown while closing the reader"};
				}
				
			}
		}
		
		int hashSetSize = suspiciousIpsSet.size();
		if (hashSetSize > 0)
		{
			return suspiciousIpsSet.toArray(new String[hashSetSize]);
		}
		else
		{
			return new String[] {"Empty list of suspicious IPs"};
		}
	}
	
    /**
     * Tests the method abbreviate with the examples given in the question. 
     * This test code is provided only for your convenience.
     */
    public static void main(String[] args) {
        System.out.println("test1.log");
        for (String ip : findSuspiciousIps("test1.log"))
        {
            System.out.println(ip);
        }
        System.out.println("test2.log:");
        for (String ip : findSuspiciousIps("test2.log"))
        {
            System.out.println(ip);
        }
    }

	    
}
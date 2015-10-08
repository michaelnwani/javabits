import java.io.BufferedReader;
import java.io.FileReader;
import java.util.*;
import java.util.regex.*;

/**
Written by Michael Nwani:

Write a program which reads PITCH data from standard input and, at the end of the input, 
shows a table of the top ten symbols by executed volume
*/

public class HotspotFX
{
	private static Map<String,String> hashMap;
	private static Map<String,String> processPITCHDataHelperMap;
	private static Map<String,String> createDataFieldsMap;
	private static Pattern checkRegex;
	private static Matcher regexMatcher;
	private static Map<String,Integer> tradeVolumeMap;
	static ArrayList<Map<String,String>> mapArrayList = new ArrayList<Map<String,String>>();
	private static String orderID, sideIndicator, shares, symbol, price, display, executionID;
	private static String wholeNumberAndDecimal;
	private static String wholeNumberPortion;
	private static String decimalNumberPortion;
	private static Iterator iter;
	private static Scanner input;
	
	public static void main(String[] args) throws Exception {
		processPITCHData(input);
		printTop10ExecutedVolume(mapArrayList);
	}
	
	/**
		Method that is ready and listening for PITCH data from the input stream
		@param input 	Scanner object that listens for PITCH data
		@return			an ArrayList full of dictionaries, each representing a PITCH data message
		re-structured according to its data fields
	*/
	public static ArrayList processPITCHData(Scanner input) throws Exception{
		input = new Scanner(System.in);
		String line = input.nextLine();
		hashMap = processPITCHDataHelper(line);
		if (hashMap != null){
			mapArrayList.add(hashMap);
		}
		
		while (input.hasNextLine())
		{
			// System.out.println(line);
			if (line != null && line.isEmpty()){
				continue;
			}
			line = input.nextLine();
			
			hashMap = processPITCHDataHelper(line);
			if (hashMap != null){
				mapArrayList.add(hashMap);
			}
			
		}

		return mapArrayList;
	}
	
	/**
		This helper method will re-structure each PITCH Message line into dictionary segments
		according to the Message Type's fields.
		@param dataFeedLine	a PITCH data fixed-length message sequence
		@return	
	*/
	public static Map<String,String> processPITCHDataHelper(String dataFeedLine) {
		
		//Check if it's an Add Order, an Execute Order, Trade Order, or Cancel Order message type
		if (addOrderPatternChecker(dataFeedLine) != null){
			
			dataFeedLine = dataFeedLine.substring(1, dataFeedLine.length());
			
			processPITCHDataHelperMap = createMapFromDataFields(dataFeedLine, "addOrder");
		} 
		else if (executeOrderPatternChecker(dataFeedLine) != null) {
			
			dataFeedLine = dataFeedLine.substring(1, dataFeedLine.length());
			
			processPITCHDataHelperMap = createMapFromDataFields(dataFeedLine, "executeOrder");
		} 
		else if (tradeOrderPatternChecker(dataFeedLine) != null) {
			
			dataFeedLine = dataFeedLine.substring(1, dataFeedLine.length());
			
			processPITCHDataHelperMap = createMapFromDataFields(dataFeedLine, "tradeOrder");
		} else if (cancelOrderPatternChecker(dataFeedLine) != null){
			
			dataFeedLine = dataFeedLine.substring(1, dataFeedLine.length());
			
			processPITCHDataHelperMap = createMapFromDataFields(dataFeedLine, "cancelOrder");
		}
		else {
			//It's a type of order we aren't interested in for these purposes. 
			return null;
		}

		return processPITCHDataHelperMap;
	}
	
	/**
		Helper method that uses regular expressions to find patterns in 
		PITCH data message types and returns them.
		@param theRegex		the regular expression format being used
		@param strToCheck	the PITCH data message sequence to analyze
		@return	the found pattern in strToCheck if successful, otherwise null
	*/
	public static String patternChecker(String theRegex, String strToCheck){
		checkRegex = Pattern.compile(theRegex);
		
		regexMatcher = checkRegex.matcher(strToCheck);
		
		while (regexMatcher.find()){
			if (regexMatcher.group().length() != 0){
				return regexMatcher.group();
				
			}
		}
		return null;
	}
	
	/**
		Utilizes patternChecker helper method to find a PITCH Add Order message type.
		@param strToCheck the PITCH data message sequence to analyze
		@return the found pattern in strToCheck if successful, otherwise null
	*/
	public static String addOrderPatternChecker(String strToCheck){
		if (strToCheck != null){
			return patternChecker("\\d{8}A[0-9A-Z]{12}(B|S)\\d{6}[A-Z]{1,6}\\s{0,5}\\d{10}(Y|N)", 
				strToCheck.substring(1, strToCheck.length()));
		}
		return null;
	}
	
	/**
		Utilizes patternChecker helper method to find a PITCH Execute Order message type.
		@param strToCheck the PITCH data message sequence to analyze
		@return the found pattern in strToCheck if successful, otherwise null
	*/
	public static String executeOrderPatternChecker(String strToCheck){
		if (strToCheck != null){
			return patternChecker("\\d{8}E[0-9A-Z]{12}\\d{6}[0-9A-Z]{12}", 
			strToCheck.substring(1, strToCheck.length()));
		}
		return null;
	}
	
	/**
		Utilizes patternChecker helper method to find a PITCH Trade Order message type.
		@param strToCheck the PITCH data message sequence to analyze
		@return the found pattern in strToCheck if successful, otherwise null
	*/
	public static String tradeOrderPatternChecker(String strToCheck){
		if (strToCheck != null){
			return patternChecker("\\d{8}P[0-9A-Z]{12}B\\d{6}[A-Z]{1,6}\\s{0,5}\\d{10}[0-9A-Z]{12}", 
				strToCheck.substring(1, strToCheck.length()));
		}
		return null;
		
	}
	
	/**
		Utilizes patternChecker helper method to find a PITCH Cancel Order message type.
		@param strToCheck the PITCH data message sequence to analyze
		@return the found pattern in strToCheck if successful, otherwise null
	*/
	public static String cancelOrderPatternChecker(String strToCheck){
		if (strToCheck != null){
			return patternChecker("\\d{8}X[0-9A-Z]{12}\\d{6}", 
				strToCheck.substring(1, strToCheck.length()));
		}
		return null;
		
	}
	
	/**
		Creates a HashMap and builds it up according to the PITCH data message type
		@param pitchMessage the PITCH data message sequence to analyze
		@param msgType identifier: addOrder, executeOrder, tradeOrder or cancelOrder
		@return a dictionary categorized according to the PITCH message type
	*/
	public static Map<String, String> createMapFromDataFields(String pitchMessage, String msgType){
		createDataFieldsMap = new HashMap<String,String>();
		// String orderID, sideIndicator, shares, symbol, price, display, executionID;
		switch (msgType) {
			case "addOrder":
			
				createDataFieldsMap.put("timestamp", patternChecker("\\d{8}", pitchMessage));
				createDataFieldsMap.put("messageType", "A");
			
				orderID = patternChecker("\\d{8}A[0-9A-Z]{12}", pitchMessage);
				createDataFieldsMap.put("orderID", orderID.substring(9, orderID.length()));
			
				//I didn't want to re-execute patternChecker() for Side Indicator 
				//because it'd be a waste of computation
				//but for the sake of consistency and accuracy I do.
				sideIndicator = patternChecker("\\d{8}A[0-9A-Z]{12}(B|S)", pitchMessage);
				createDataFieldsMap.put("sideIndicator", sideIndicator.substring(21, sideIndicator.length()));
			
				shares = patternChecker("\\d{8}A[0-9A-Z]{12}(B|S)\\d{6}", pitchMessage);
				createDataFieldsMap.put("shares", shares.substring(22, shares.length()));
			
				symbol = patternChecker("\\d{8}A[0-9A-Z]{12}(B|S)\\d{6}[A-Z]{1,6}\\s{0,5}", pitchMessage);
				createDataFieldsMap.put("symbol", symbol.substring(28, symbol.length()).trim());
			
				price = patternChecker("\\d{8}A[0-9A-Z]{12}(B|S)\\d{6}[A-Z]{1,6}\\s{1,5}\\d{10}", 
					pitchMessage);
				price = truePrice(price.substring(34, price.length()));
				createDataFieldsMap.put("price", price);
			
				display = patternChecker("\\d{8}A[0-9A-Z]{12}(B|S)\\d{6}[A-Z]{1,6}\\s{1,5}\\d{10}(Y|N)", 
				pitchMessage);
				createDataFieldsMap.put("display", display.substring(44, display.length()));
			break;
			
			case "executeOrder":
			
				createDataFieldsMap.put("timestamp", patternChecker("\\d{8}", pitchMessage));
				createDataFieldsMap.put("messageType", "E");
				
				orderID = patternChecker("\\d{8}E[0-9A-Z]{12}", pitchMessage);
				createDataFieldsMap.put("orderID", orderID.substring(9, orderID.length()));
				
				shares = patternChecker("\\d{8}E[0-9A-Z]{12}\\d{6}", pitchMessage);
				createDataFieldsMap.put("shares", shares.substring(21, shares.length()));
				
				//Find the execute order's matching symbol using getExecuteOrderSymbol()
				createDataFieldsMap.put("symbol", getExecuteOrderSymbol(orderID.substring(9, orderID.length())));
				
				executionID = patternChecker("\\d{8}E[0-9A-Z]{12}\\d{6}[0-9A-Z]{12}", pitchMessage);
				createDataFieldsMap.put("executionID", executionID.substring(27, executionID.length()));
				
			break;
			
			case "tradeOrder":
				createDataFieldsMap.put("timestamp", patternChecker("\\d{8}", pitchMessage));
				createDataFieldsMap.put("messageType", "P");
				
				orderID = patternChecker("\\d{8}P[0-9A-Z]{12}", pitchMessage);
				createDataFieldsMap.put("orderID", orderID.substring(9, orderID.length()));
			
				createDataFieldsMap.put("sideIndicator", "B");
				
				shares = patternChecker("\\d{8}P[0-9A-Z]{12}B\\d{6}", pitchMessage);
				createDataFieldsMap.put("shares", shares.substring(22, shares.length()));
			
				symbol = patternChecker("\\d{8}P[0-9A-Z]{12}B\\d{6}[A-Z]{1,6}\\s{0,5}", pitchMessage);
				createDataFieldsMap.put("symbol", symbol.substring(28, symbol.length()).trim());
			
				price = patternChecker("\\d{8}P[0-9A-Z]{12}B\\d{6}[A-Z]{1,6}\\s{1,5}\\d{10}", 
					pitchMessage);
				price = truePrice(price.substring(34, price.length()));
				createDataFieldsMap.put("price", price);
				
				executionID = 
					patternChecker("\\d{8}P[0-9A-Z]{12}B\\d{6}[A-Z]{1,6}\\s{1,5}\\d{10}[0-9A-Z]{12}", 
						pitchMessage);
				createDataFieldsMap.put("executionID", executionID.substring(44, executionID.length()));
				
			break;
			
			case "cancelOrder":
				createDataFieldsMap.put("timestamp", patternChecker("\\d{8}", pitchMessage));
				createDataFieldsMap.put("messageType", "X");
			
				orderID = patternChecker("\\d{8}X[0-9A-Z]{12}", pitchMessage);
				createDataFieldsMap.put("orderID", orderID.substring(9, orderID.length()));
				
				shares = patternChecker("\\d{8}X[0-9A-Z]{12}\\d{6}", pitchMessage);
				createDataFieldsMap.put("canceledShares", shares.substring(21, shares.length()));
				
			break;
			
			default:
			break;
		}
		
		return createDataFieldsMap;
	}
	
	/**
		Re-formats PITCH data message Price field.
		@param price the PITCH price data type found in the sequenced message
		@return the price re-formatted to show the whole number portion + 
		a decimal point + the decimal number portion
	*/
	public static String truePrice(String price){
		//I am taking for granted that we always know the decimal portion will be two digits long,
		//less computation.
		wholeNumberAndDecimal = patternChecker("[1-9]{1,10}", price);
		
		if (wholeNumberAndDecimal.length() == 1){
			return wholeNumberAndDecimal + ".00";
		}
		
		wholeNumberPortion = wholeNumberAndDecimal.substring(0, wholeNumberAndDecimal.length()-2);
		
		decimalNumberPortion = wholeNumberAndDecimal.substring(wholeNumberAndDecimal.length()-2, 
			wholeNumberAndDecimal.length());
		
		return wholeNumberPortion + "." + decimalNumberPortion;
			
	}
	
	/**
		Prints the top 10 stock symbols according to their total executed volume at any point.
		@param mapArrayList 	ArrayList full of dictionaries of all PITCH messages
		
	*/
	public static void printTop10ExecutedVolume(ArrayList<Map<String, String>> mapArrayList){
		tradeVolumeMap = new HashMap<String, Integer>();
		// System.out.println("mapArrayList size: " + mapArrayList.size());

		for (Map<String,String> map : mapArrayList){
			if (map.get("messageType") == "E" || map.get("messageType") == "P"){
				if (tradeVolumeMap.get(map.get("symbol")) != null){
					tradeVolumeMap.put(map.get("symbol"),
						tradeVolumeMap.get(map.get("symbol")) + Integer.parseInt(map.get("shares")));
				} else{
					tradeVolumeMap.put(map.get("symbol"), Integer.parseInt(map.get("shares")));
				}
				
			}
		}

		tradeVolumeMap = sortMap(tradeVolumeMap);
		
		iter = tradeVolumeMap.entrySet().iterator();
		
		if (tradeVolumeMap.size() < 10){
			while (iter.hasNext()){
				Map.Entry pair = (Map.Entry)iter.next();
				int num = 15 - String.valueOf(pair.getKey()).length();
				String format = "%" + String.valueOf(num) + "d";
				System.out.printf(pair.getKey() + format + "\n", pair.getValue());
				iter.remove();
			}
			
		} else{
			int count = 0;
			while (count < 10){
				Map.Entry pair = (Map.Entry)iter.next();
				int num = 15 - String.valueOf(pair.getKey()).length();
				String format = "%" + String.valueOf(num) + "d";
				System.out.printf(pair.getKey() + format + "\n", pair.getValue());
				count++;
				iter.remove();
				
			}
		}
	}
	
	/**
		Gets the stock symbol associated with an Execute Order and returns it for use in a dictionary
		@param orderID PITCH Execute Order OrderID used to cross-analyze Add Order OrderID's
		@return stock symbol associated with an Execute Order if successful, otherwise empty string
	*/
	public static String getExecuteOrderSymbol(String orderID){
		//We need to get the name of the stock symbol associated with this execution order
		//via their identical Order ID's. Once we have the stock symbol we can break out of the loop.
		String returnSymbol = "";

		for (Map<String,String> map : mapArrayList){
			if (map.get("messageType") == "A"){
				returnSymbol = map.get("symbol");
				break;
			}
		}
		
		return returnSymbol;
	}
	
	/**
		Custom sort method used to sort a dictionary of PITCH Execute and Trade Order's according to
		largest executed volume 
		@param map the dictionary
		@return a LinkedHashMap that keeps order of largest executed volume
	*/
	public static <K, V extends Comparable<? super V>> Map<K, V> sortMap(Map<K, V> map)
	{
	    List<Map.Entry<K, V>> list = new LinkedList<>(map.entrySet());
	    Collections.sort(list, new Comparator<Map.Entry<K, V>>()
	    {
	        @Override
	        public int compare(Map.Entry<K, V> object1, Map.Entry<K, V> object2)
	        {	//we want the values in descending order
				if ((object1.getValue()).compareTo(object2.getValue()) == 1){
					return -1;
				} else if ((object1.getValue()).compareTo(object2.getValue()) == -1){
					return 1;
				} else return 0;

	        }
	    });

	    Map<K, V> result = new LinkedHashMap<>();
	    for (Map.Entry<K, V> entry : list)
	    {
	        result.put( entry.getKey(), entry.getValue() );
	    }
	    return result;
	}
}




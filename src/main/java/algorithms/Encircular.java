package main.java.algorithms;
import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Encircular {

	// My solution was something like this, except using a switch-case statement,
	// and direction="N","E","S","W"
	static String doesCircleExist(String commands) {

		int x1 = 0;
		int y1 = 0;
		
		int x2 = 0;
		int y2 = 0;
		String direction = "N";
		
		for (int i = 0; i < commands.length(); i++) {
			switch (direction){
				case "N":
				if (commands.charAt(i) == 'G'){
					y2++;
				}
				else if (commands.charAt(i)	=='L'){
					direction = "W";
				}
				else if (commands.charAt(i) == 'R'){
					direction = "E";
				}
				break;
				
				case "E":
				if (commands.charAt(i) == 'G'){
					x2++;
				}
				else if (commands.charAt(i)	=='L'){
					direction = "N";
				}
				else if (commands.charAt(i) == 'R'){
					direction = "S";
				}
				break;
				
				case "S":
				if (commands.charAt(i) == 'G'){
					y2--;
				}
				else if (commands.charAt(i)	=='L'){
					direction = "E";
				}
				else if (commands.charAt(i) == 'R'){
					direction = "W";
				}
				break;
				
				case "W":
				if (commands.charAt(i) == 'G'){
					x2--;
				}
				else if (commands.charAt(i)	=='L'){
					direction = "S";
				}
				else if (commands.charAt(i) == 'R'){
					direction = "N";
				}
				break;
				default:
				System.out.println("Invalid input");
				break;
			}
		}
		
		if (direction.equals("N") && ((Math.pow(x2-x1,2) + Math.pow(y2-y1,2)) > 0)) {
			return "NO";
		} else {
			return "YES";
		}
	}
	
	
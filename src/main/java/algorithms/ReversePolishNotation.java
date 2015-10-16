package main.java.algorithms;
import java.util.*;

public class ReversePolishNotation{
	
	static ArrayDeque<Integer> stack;
	
	public static int expressionResult(String[] arithmetic_expression){
		if (arithmetic_expression == null || arithmetic_expression.length == 0){
			throw new IllegalArgumentException("Can't be null!");
		}
		int a=0,b=0;
		
		stack = new ArrayDeque<Integer>(arithmetic_expression.length);
		//Assuming that there won't be an operator before atleast two operands (unless it's ++ or -- types)
		
		for (int i = 0; i < arithmetic_expression.length; i++){
			switch (arithmetic_expression[i]){
				case "+":
					b = stack.pop();
					a = stack.pop();
					stack.push(a+b);
				break;
				
				case "-":
					b = stack.pop();
					a = stack.pop();
					stack.push(a-b);
				break;
				
				case "/":
					b = stack.pop();
					a = stack.pop();
					stack.push(a/b);
				break;
				
				case "*":
					b = stack.pop();
					a = stack.pop();
					stack.push(a*b);	
				break;
				
				default:
					stack.push(Integer.valueOf(arithmetic_expression[i]));
				break;
			}
		}
		
		return stack.pop();
	}
	
	public static void main(String[] args){
		String[] expression = {"2", "1", "+", "3", "*"};
		
		int result = expressionResult(expression);
		
		System.out.println(result);
	}
}
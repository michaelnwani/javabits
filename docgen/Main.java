package docgen;

import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
public class Main{
	public static void main(String[] args){
		// Get a class object
		Class<?> clazz = String.class;
		
		Method[] methods = clazz.getDeclaredMethods();
		
		for (Method m : methods){
			// Display method name
			System.out.printf("name: %s%n", m.getName());
			
			// Display parameter count
			System.out.printf("\t# params: %s%n", m.getParameterCount());
			// Display return type (getSimpleName())
			System.out.printf("\treturn type: %s%n", m.getReturnType());
			
			// Display modifiers
			int mods = m.getModifiers();
			String modStr = Modifier.toString(mods);
			System.out.printf("\tmodifiers: %s%n", modStr);
		}
	}
}
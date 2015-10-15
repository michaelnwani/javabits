package docgen;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

import java.lang.annotation.Target;
import java.lang.annotation.ElementType;

//shorthand for value = RetentionPolicy.RUNTIME
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.TYPE,ElementType.METHOD}) //where this annotation can be used
public @interface Doc{
	
	/** Description of class or method **/
	String desc() default "";
	
	/** Description of parameters, if annotated element is a method & has parameters **/
	String[] params() default {};
	
	/** Description of return value, if annotated element is a method & isn't void **/
	String returnVal() default "";
}
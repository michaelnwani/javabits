package test;
import org.junit.Test;
import static org.junit.Assert.*;
// Just testing my classpath with this method
public class MyUnitTest{
	
	@Test
	public static void testConcatenate() {
		String result = "one"+"two";
		assertEquals("failure", result);
	}
	
	public static void main(String[] args) {
		testConcatenate();
	}
}
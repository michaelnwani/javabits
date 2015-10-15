import docgen.Doc;

@Doc(
	desc = "Utility class for testing custom annotations"
)
public class TestAnnotations{
	
	@Doc(
		desc = "Tests this annotation",
		params = {"Tests this params annotation"},
		returnVal = "Tests the returnVal annotation"
	)
	public static void test1(){
		
	}
	
	@Doc(
		desc = "Tests test2 description",
		params = {"Tests params annotation test2"},
		returnVal = ""
	)
	public static void test2(){
		
	}
	
	@Doc(
		desc = "Tests test3 description"
	)
	public static void test3(){
		
	}
	public static void main(String[] args){
		
	}
}
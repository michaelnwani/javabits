import java.io.BufferedReader;
import java.io.FileReader;

//Scanner is kinda specialized for reading from console input; 
//BufferedReader is kind of everything else (BufferedReader uses FileReader)
public class FR 
{
	public static void main(String[] args) throws Exception
	{
		//Scanner read = new Scanner(System.in);
		//path to the file
		FileReader file = new FileReader("/Users/michaelnwani/Desktop/java/pitch_example_data");
		BufferedReader reader = new BufferedReader(file);
		
		String text = "";
		String line = reader.readLine();
		while (line != null)
		{
			System.out.println(line);
			text += line;
			line = reader.readLine();
			
		}
		
		
	}
}
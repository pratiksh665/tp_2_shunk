import edu.princeton.cs.introcs.StdIn;
import edu.princeton.cs.introcs.StdOut;

public class UI {

	public String print(String string) {
		StdOut.println(string);
		return string;
	}
	
	public String userInputOutput(String prompt) {
		StdOut.println(prompt);
		String input = StdIn.readLine();
		return input;
	}
	
}

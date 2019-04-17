package se2019package;

/**
 * Client class uses main method and it plays the role of the client in a facade pattern.
 * @author George Stamatopoulos
 * @version 1.0
 * @since 2019-04-14
 */
import java.io.IOException;

public class Client {

	/**
	 * This is the main method which takes two command line arguments as an input from the user.
	 * It calls MetricsFacade as it participates in a facade pattern giving for
	 * parameters the two inputs.
	 * 
	 * @param args used.
	 * @exception FileIOException on failed I/O operation.
	 */
	public static void main(String[] args) throws IOException {
		// The first argument is the path of the file that the code is inside
		String file = new String(args[0]);
		// The second argument can only be 'string' or 'regex'
		String analyzerMethod = new String(args[1]);
		// creates a MetricsFacade object and calls MetricsAnalyzer method
		MetricsFacade m = new MetricsFacade();
		m.MetricsAnalyzer(file, analyzerMethod);

	}

}

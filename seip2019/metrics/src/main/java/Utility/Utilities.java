package Utility;

/**
 *Utilities class has readFile and writeFile methods and 
 *they are used by the MetricsFacade class.
 * @author George Stamatopoulos
 * @version 1.0
 * @since 2019-04-14
 */
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public final class Utilities {

	/**
	 * This is readFile method which returns a list with the lines of code.
	 *
	 * @param file
	 * @throws IOException
	 */
	public static List<String> readFile(String file) throws IOException {

		// read every line of the file and put it in the list.
		List<String> codeLines = Files.readAllLines(Paths.get(file));
		return codeLines;
	}

	/**
	 * This is writeFile method which writes the results of the metrics in a csv
	 * file.
	 *
	 * @param file
	 * @param code
	 * @throws IOException
	 */
	public static void writeFile(String file, List<String> code) throws IOException {
		List<String> metricsNames = new ArrayList<String>();
		metricsNames.add("Lines of Code");
		metricsNames.add("Number of Methods");
		metricsNames.add("Number of Classes");
		FileOutputStream output = new FileOutputStream(file); // file represents the name of the output file.
		PrintWriter writer = new PrintWriter(output);

		writer.println(code); // code is the list with the results.
		writer.close();
	}
}
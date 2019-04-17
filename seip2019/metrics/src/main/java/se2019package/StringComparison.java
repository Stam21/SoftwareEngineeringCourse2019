package se2019package;

/**
 *Regex class is an implementation of the strategy interface Analyzer.
 *Metrics is the method that implements Analyzer and calculation methods countNom,countNoc.
 * @author George Stamatopoulos
 * @version 1.0
 * @since 2019-04-14
 */
import java.util.ArrayList;
import java.util.List;

public class StringComparison implements Analyzer {

	/**
	 * This is Metrics method which takes a string list and calculates the number of
	 * methods, the number of classes and the lines of code.
	 *
	 * @param codeLines
	 * @return CsvList
	 */
	public List<String> Metrics(List<String> codeLines) {

		List<String> CsvList = new ArrayList<String>();// create the return list
		int loc = 0;// lines of code
		int nom = 0;// number of methods
		int noc = 0;// number of classes
		boolean flag = true; // flag to ensure comment is always closed

		for (String line : codeLines) {

			// Check if line is comment or empty line
			if (!line.trim().startsWith("/*") && !line.trim().startsWith("//") && !line.trim().startsWith("*")
					&& !line.isEmpty()) {
				if (flag) {
					loc++;

					// check if line has characteristics of methods and classes
					if (line.trim().startsWith("public") || line.trim().startsWith("private")
							|| line.trim().startsWith("protected") || line.trim().startsWith("static")
							|| line.trim().startsWith("abstract") || line.trim().startsWith("final")
							|| line.trim().startsWith("strictfp")) {

						nom = countNom(line, nom);
						noc = countNoc(line, noc);

					}
				}
			} else {

				// When line contains /* update flag
				if (line.contains("/*")) {
					flag = false;
				}

				// When line contains */ update flag
				if (line.contains("*/")) {
					flag = true;
				}
			}
		}

		// add the results in the return list
		CsvList.add("Lines of Code:" + String.valueOf(loc));
		CsvList.add("Number of Classes:" + String.valueOf(noc));
		CsvList.add("Number of Methods:" + String.valueOf(nom));
		return CsvList;// Returns the list for the csv
	}

	/**
	 * This is countNom method which checks possible new methods. When a method is
	 * found number of methods is increased by 1.
	 *
	 * @param line
	 * @param nom
	 * @return nom
	 */
	public int countNom(String line, int nom) {

		// Ensures that is a method.
		if (line.contains("ArrayList") || line.contains("List") || line.contains("void") || line.contains("boolean<")
				|| line.contains("int") || line.contains("String") && !line.contains("=")) {
			nom++;
		}
		return nom;

	}

	/**
	 * This is countNoc method which checks possible new classes. When a class is
	 * found number of methods is increased by 1.
	 *
	 * @param line
	 * @param noc
	 * @return noc
	 */
	public int countNoc(String line, int noc) {

		// Ensures that is a class.
		if (line.contains("class")) {
			noc++;
		}
		return noc;
	}
}
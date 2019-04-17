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
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Regex implements Analyzer {

	/**
	 * This is Metrics method which takes a string list and calculates the number of
	 * methods, the number of classes and the lines of code.
	 *
	 * @param codeLines
	 * @return CsvList
	 */
	public List<String> Metrics(List<String> codeLines) {

		List<String> CsvList = new ArrayList<String>();// create the return list
		int loc = 0; // lines of code
		int nom = 0; // number of methods
		int noc = 0; // number of classes
		Pattern pComment = Pattern.compile("^\\*|/\\*.*|//.*");// regex for possible comments
		Pattern pEmpty = Pattern.compile("^\\s*$");// regex for possible empty lines
		boolean flag = true; // flag to ensure comment is always closed

		for (String line : codeLines) {
			Matcher mComment = pComment.matcher(line.trim());
			Matcher mEmpty = pEmpty.matcher(line);
			// Check if line is comment or empty line
			if (!mComment.matches() && !mEmpty.matches()) {
				if (flag) {
					loc++;
					nom = countNom(line, nom);
					noc = countNoc(line, noc);
				}
			}
			//
			// When line contains /* update flag
			if (line.matches("/\\*.*")) {
				flag = false;
			}
			// When */ is at the end of the line update flag
			if (line.matches(".*\\*/.*$")) {
				flag = true;
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

		// the line that is taken as a parameter must match to the following regex as to
		// increase the number of methods.
		if (line.trim().matches(
				"((protected|public|static|transient|abstract|private|final|native)+\\s)+[\\$_\\w\\<\\>\\[\\]]*\\s+[\\$_\\w]+\\([^"
						+ "\\)]*\\)?\\s*\\{?[^\\}]*\\}?")) {
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

		// the line that is taken as a parameter must match to the following regex as to
		// increase the number of methods.
		if (line.trim().matches(
				"(?:\\s*(protected|public|abstract|private|final|native|strictfp)\\s+)?(?:static\\s+)?class.*")) {
			noc++;
		}
		return noc;
	}
}
package se2019package;

/**
 *Analyzer is an interface using Metrics method and it plays 
 *the role of the product in the factory pattern.
 *It participates in a strategy pattern while it has two
 *implementations. 
 * @author George Stamatopoulos
 * @version 1.0
 * @since 2019-04-14
 */
import java.util.List;

public interface Analyzer {

	/**
	 * This is Metrics method which returns a list with the lines of code, number of
	 * methods, number of classes.
	 *
	 * @param codeLines
	 */
	public List<String> Metrics(List<String> codeLines);

}

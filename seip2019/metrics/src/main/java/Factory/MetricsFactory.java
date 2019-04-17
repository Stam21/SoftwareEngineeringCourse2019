package Factory;

/**
 *MetricsFactory class has createAnalyzer method and it plays
 *the role of the factory in the factory pattern.
 * @author George Stamatopoulos
 * @version 1.0
 * @since 2019-04-14
 */
import se2019package.Analyzer;
import se2019package.Regex;
import se2019package.StringComparison;

public class MetricsFactory {

	/**
	 * This is createAnalyzer method which returns an analyzer *object. Analyzer can
	 * only be functional when user's input is 'regex' or 'string'.
	 *
	 * @param id
	 */
	public static Analyzer createAnalyzer(String id) {
		Analyzer a = null;

		if (id.startsWith("s")) {
			a = new StringComparison();
		} else if (id.startsWith("r")) {
			a = new Regex();
		}

		return a;
	}

}

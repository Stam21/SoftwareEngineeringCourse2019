package codeAnalyzers;

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

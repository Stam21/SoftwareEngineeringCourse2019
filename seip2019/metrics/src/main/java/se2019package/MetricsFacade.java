package se2019package;

/**
 * MetricsFacade class uses MetricsAnalyzer method and it plays the role of the facade class in 
 * a facade pattern.
 * @author George Stamatopoulos
 * @version 1.0
 * @since 2019-04-14
 */

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import Factory.MetricsFactory;
import Utility.Utilities;

public class MetricsFacade {
	/**
	 * This is MetricsAnalyzer method which uses Utilities class to read the file
	 * and write the csv. It also calculates the code metrics by creating an object
	 * type Analyzer and doing the analysis.
	 * 
	 * @param file
	 * @param id
	 * @throws IOException
	 */
	public void MetricsAnalyzer(String file, String id) throws IOException {
		List<String> codeLines = Utilities.readFile(file);
		Analyzer analyzer = MetricsFactory.createAnalyzer(id);// creates object type Analyzer with MetricsFactory class
		List<String> CsvList = new ArrayList<String>();
		CsvList = analyzer.Metrics(codeLines);// Metrics results are saved in the list
		String csvfile = "test.csv";// name of output file
		Utilities.writeFile(csvfile, CsvList);
	}
}
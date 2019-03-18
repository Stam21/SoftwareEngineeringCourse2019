package se2019package;

/**
 * The HistogramGenerator program reads grades from a <file>.txt and store them into an array. 
 * Then it generates and presents a histogram based on an array of integers. In other words,
 * it shows the grades' frequencies in a diagram.
 * 
 * @author George Stamatopoulos
 * @version 1.0
 * @since 2019-03-18
 */

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartFrame;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;
import java.util.Scanner;
import java.io.*;

public class HistogramGenerator {

	/***
	 * Receives a single dimension Integer array. From this array the dataset
	 * that will be used for the visualization is generated. Finally, The chart
	 * is generated with the use of the aforementioned dataset and then
	 * presented in the screen.
	 * 
	 * @param dataValues Single dimension integer array
	 */
	public void generateChart(int[] dataValues) {
		
		/*
		 * The XYSeriesCollection object is a set XYSeries series (dataset) that
		 * can be visualized in the same chart
		 */
		XYSeriesCollection dataset = new XYSeriesCollection();
		
		/*
		 * The XYSeries that are loaded in the dataset. There might be many
		 * series in one dataset.
		 */
		XYSeries data = new XYSeries("random values");

		/*
		 * Populating the XYSeries data object from the input Integer array
		 * values.
		 */
		for (int i = 0; i < dataValues.length; i++) {
			data.add(i, dataValues[i]);
		}

		// add the series to the dataset
		dataset.addSeries(data);

		boolean legend = false; // do not visualize a legend
		boolean tooltips = false; // do not visualize tooltips
		boolean urls = false; // do not visualize urls

		// Declare and initialize a createXYLineChart JFreeChart
		JFreeChart chart = ChartFactory.createXYLineChart("Chart title", "x_axis title", "y_axis_title", dataset,
				PlotOrientation.VERTICAL, legend, tooltips, urls);

		/*
		 * Initialize a frame for visualizing the chart and attach the
		 * previously created chart.
		 */
		ChartFrame frame = new ChartFrame("Grades", chart);
		frame.pack();
		// makes the previously created frame visible
		frame.setVisible(true);
	}

	  /**
	   * This is the main method which makes use of generateChart method.
	   * @param args used.
	   * @exception FileNotFoundException on input error.
	   */
	public static void main(String[] args) throws FileNotFoundException {
		
		//Takes as an input a txt file as command line argument 
		Scanner s = new Scanner(new File(args[0]));
		
		int[] grades = new int[11];
		
		//Every grade in the file is stored in an array
		while (s.hasNextInt()) {
			int count = s.nextInt();
			if (count >= 0 && count <= 10) {
				grades[count]++;
			}
		}
		/*
		 * Create a new object gen and then calls the generateChart method using as an input 
		 * the array that is created above
		 */
		HistogramGenerator gen = new HistogramGenerator();
		gen.generateChart(grades);
		s.close();
	}
}

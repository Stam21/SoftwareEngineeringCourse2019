package se2019package;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartFrame;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;
import java.util.Scanner;
import java.io.*;

public class HistogramGenerator {

	public void generateChart(int[] dataValues) {

		XYSeriesCollection dataset = new XYSeriesCollection();
		XYSeries data = new XYSeries("random values");

		for (int i = 0; i < dataValues.length; i++) {
			data.add(i, dataValues[i]);
		}

		dataset.addSeries(data);

		boolean legend = false;
		boolean tooltips = false;
		boolean urls = false;

		JFreeChart chart = ChartFactory.createXYLineChart("Chart title", "x_axis title", "y_axis_title", dataset,
				PlotOrientation.VERTICAL, legend, tooltips, urls);

		ChartFrame frame = new ChartFrame("Grades", chart);
		frame.pack();
		frame.setVisible(true);
	}

	public static void main(String[] args) throws FileNotFoundException {
		Scanner input = new Scanner(System.in);
		System.out.println("Give the name of the file that contains the grades");
		/* The file has to be located in the target folder */ 
		Scanner s = new Scanner(new File(input.nextLine()));
		int[] grades = new int[11];
		while (s.hasNextInt()) {
			int count = s.nextInt();
			if (count >= 0 && count <= 10) {
				grades[count]++;
			}
		}
		HistogramGenerator gen = new HistogramGenerator();
		gen.generateChart(grades);
		s.close();
		input.close();
	}
}

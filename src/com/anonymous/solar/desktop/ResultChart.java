package com.anonymous.solar.desktop;


import java.util.ArrayList;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.NumberAxis;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.plot.XYPlot;
import org.jfree.data.xy.XYDataset;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;

import com.anonymous.solar.shared.ResultsDetails;
import com.anonymous.solar.shared.SolarResult;

/**
 * This class is designed to create an updatable JFreeChart object for displaying various
 * data from the SolarResult class
 * 
 * @author 07377495 Luke Durkan
 * @version 1.0
 */
public class ResultChart{
	
	private SolarResult solarResult;
	private JFreeChart resultChart;
	private XYDataset resultDataset;
	
	public ResultChart(SolarResult solResult) {
		this.solarResult = solResult;
		setUpChart();

	}
	
	/**
	 * This method updates ResultChart with the data from the new Solar Result object
	 * and recreates the JFreeChart object
	 * 
	 * @param newSolarResult the solarResult object to create a chart for
	 */
	public void updateChart(SolarResult newSolarResult) {
		this.solarResult = newSolarResult;
		setUpChart();
	}
	
	/**
	 * This method retrieves the JFreechart panel created by this class
	 * 
	 * @return a JFreeChart that gives a graphical view at some of the data calculated
	 */
	public JFreeChart getChartPanel() {
		return resultChart;
	}
	
	/**
	 * This method creates the XYDataset used for the creation of the graph
	 * 
	 * @return the XYDataset to be used for the creation of the chart
	 */
	private XYDataset updateDataset() {
		
		XYSeriesCollection dataset = new XYSeriesCollection();
		ArrayList<ResultsDetails> monthlyResults = solarResult.getResultsDetailsList();
		
		//Add in cumulative savings
		double cumulativeSavings = 0.0;
		XYSeries cumulativeSavingsSeries = new XYSeries("Cumulative Savings");
		XYSeries monthlyPowerGenerationSeries = new XYSeries("Monthly Power Generation");
		for (int i = 0; i < monthlyResults.size(); i++) {
			cumulativeSavings+= monthlyResults.get(i).getIncome();
			cumulativeSavingsSeries.add((i + 1)/12, cumulativeSavings);
		}
		
		dataset.addSeries(cumulativeSavingsSeries);
		
		return dataset;
	}
	
	/**
	 * This method creates the JFreeChart object and customises it as need be
	 */
	private void createChart() {
		resultChart = ChartFactory.createXYLineChart(
				"Calculation Results", 
				"Years", 
				"Savings ($)", 
				resultDataset, 
				PlotOrientation.VERTICAL, 
				true, 
				true, 
				false);
		
		// get a reference to the plot for further customisation
        XYPlot plot = resultChart.getXYPlot();
		
		// change the auto tick unit selection to integer units only
        NumberAxis rangeAxis = (NumberAxis) plot.getRangeAxis();
        rangeAxis.setStandardTickUnits(NumberAxis.createIntegerTickUnits());
		
	}
	
	/**
	 * This method runs the method required for creating a chart
	 */
	private void setUpChart() {
		resultDataset = updateDataset();
		createChart();
	}

}

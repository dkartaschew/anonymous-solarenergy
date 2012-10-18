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
 * This class is designed to create an updatable JFreeChart object for comparing various
 * data from the SolarResult class
 * 
 * @author 07377495 Luke Durkan, 08311382 Michael Munchin
 * @version 1.0
 */
public class ComparisonChart{
	
	private SolarResult solarResult;
	private JFreeChart resultChart;
	private XYSeriesCollection resultDataset;
	
	private ArrayList<XYSeries> dataSeriesList;
	
	public ComparisonChart(SolarResult solResult) {
		this.solarResult = solResult;
		dataSeriesList = new ArrayList<XYSeries>();
		
		addDataset(solResult);
	}
	
	/**
	 * This method updates ComparisonChart with the data from the new Solar Result object
	 * and recreates the JFreeChart object
	 * 
	 * @param newSolarResult the solarResult object to update data for
	 */
	public void updateChart(SolarResult newSolarResult) {
		this.solarResult = newSolarResult;
		addDataset(newSolarResult);
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
	 * This method adds the new data to the XYDataset
	 * 
	 * @param resultToAdd the SolarResult object to add
	 */
	public void addDataset(SolarResult resultToAdd) {	
		updateDataset(resultToAdd);
		
		createDataSet();
	}
	
	/**
	 * This method creates the dataset to be used by the graph
	 */
	private void createDataSet() {
		
		resultDataset = new XYSeriesCollection();
		for(int i=0; i < dataSeriesList.size(); i++) {
			resultDataset.addSeries(dataSeriesList.get(i));
		}
		createChart();
	}
	
	/**
	 * This method updates the dataset to be used by the graph
	 * 
	 * @param resultToAdd the SolarResult object to add
	 */
	private void updateDataset(SolarResult resultToAdd) {
		ArrayList<ResultsDetails> monthlySavingsList = solarResult.getResultsDetailsList();
		
		//Add in cumulative savings
		double cumulativeSavings = 0.0;
		XYSeries cumulativeSavingsSeries = new XYSeries(resultToAdd.getSolarSetup().getSetupName());
		for (int i = 0; i < monthlySavingsList.size(); i++) {
			cumulativeSavings+= monthlySavingsList.get(i).getIncome();
			cumulativeSavingsSeries.add((i + 1)/12, cumulativeSavings);
		}
		dataSeriesList.add(cumulativeSavingsSeries);
	}
	
	/**
	 * Remove the dataset at the given index
	 * 
	 * @param index The index of the dataset to remove
	 */
	public void removeDataset(int index) {
		dataSeriesList.remove(index);
		
		createDataSet();
	}
	
	/**
	 * This method creates the JFreeChart object and customises it as need be
	 */
	private void createChart() {
		resultChart = ChartFactory.createXYLineChart(
				"System Comparison", 
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


}

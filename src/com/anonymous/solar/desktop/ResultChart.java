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

import com.anonymous.solar.shared.SolarResult;

public class ResultChart{
	
	private SolarResult solarResult;
	private JFreeChart resultChart;
	private XYDataset resultDataset;
	
	public ResultChart(SolarResult solResult) {
		this.solarResult = solResult;
		setUpChart();

	}
	
	public void updateChart(SolarResult newSolarResult) {
		this.solarResult = newSolarResult;
		setUpChart();
	}
	
	public JFreeChart getChartPanel() {
		return resultChart;
	}
	
	private XYDataset updateDataset() {
		
		XYSeriesCollection dataset = new XYSeriesCollection();
		ArrayList<Double> yearlySavingsList = solarResult.getSavingsOverYears();
		
		//Add in cumulative savings
		double cumulativeSavings = 0.0;
		XYSeries cumulativeSavingsSeries = new XYSeries("Cumulative Savings");
		for (int i = 0; i < yearlySavingsList.size(); i++) {
			cumulativeSavings+= yearlySavingsList.get(i);
			cumulativeSavingsSeries.add(i + 1, cumulativeSavings);
		}
		
		dataset.addSeries(cumulativeSavingsSeries);
		
		return dataset;
	}
	
	private void createChart() {
		resultChart = ChartFactory.createXYLineChart(
				"Calculation Results", 
				"Year", 
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
	
	private void setUpChart() {
		resultDataset = updateDataset();
		createChart();
	}

}

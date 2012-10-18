package com.anonymous.solar.shared;

import java.util.ArrayList;

public class SolarReport {

	private String reportHTML;
	private boolean finalized = false;
	private boolean coloured = false;
	
	//Styling
	private String textColor = "#000";
	private String bodyColour = "#CCC";
	private String backgroundColor = "#FFF";
	
	public SolarReport(){
		//Add starting elements from <body> -> content div
		reportHTML = "<body style=\"background-color:" + bodyColour + ";margin: 0px;padding: 0px;font-family:Arial;\">\n";
		reportHTML += "<div style=\"width:1000px;min-height:600px;margin-left:auto;margin-right:auto;padding: 10px 10px 0px 10px;background-image:url(/Pictures/matrix1.png);\">\n";
		reportHTML += "<div id=\"head\" style=\"width:100%;height:250px;margin-left:auto;margin-right:" + 
					  "auto;padding: 10px 10px 10px 10px;background-image: url(/Pictures/qutChemSoc.jpg);" + 
					  "background-position:center;background-repeat:repeat-x;background-color:" + backgroundColor + ";\">PICTURE</div>";		
		reportHTML += "<div style=\"background-color:" + backgroundColor + ";float:left;margin-top:20px;padding:15px 15px 0px 15px;width:100%;color:" + textColor + ";\">";
	}
	
	/**
	 * Add a header onto the HTML file
	 */
	private void addHeader(){
		
		String header = "<head>\n";
		
		header += "</head>\n";
		
		reportHTML = header + reportHTML;
	}
	
	/**
	 * Add a footer onto the html file
	 */
	private void addFooter(){
		
		String footer = "</div>\n</div>\n<div style=\"position: relative; color:red; bottom: 0px; width: 100%; ";
		footer += "padding: 15px 0px; margin-top: 5px; font-style: italic; font-weight: bold; ";
		footer += "font-size: 13px; letter-spacing: 2px; clear:both; background-color:#000; ";
		footer += "border-top:1px dotted #500; text-align:center;\">\n"; 
		
		footer += "This is a Solar Anonymous Energy Report ";
		footer += "</div>\n</body>\n";
		
		reportHTML = reportHTML + footer;
	}
	
	/**
	 * Finalize the report. Once the report has been finalized nothing more can be 
	 * added to the report
	 */
	public void Finalize(){
		addHeader();
		addFooter();
		
		
		
		String htmlStart = "<!DOCTYPE html>\n";
		htmlStart += "<html xmlns=\"http://www.w3.org/1999/xhtml\">\n";
		
		reportHTML = htmlStart + reportHTML + "</html>\n";
		finalized = true;	
		
		
		
	}
	
	/**
	 * Add a single string to the report
	 * @param input - the string to add
	 * @throws SolarReportException
	 */
	public void addContent(String input) throws SolarReportException{
		if(finalized){
			throw new SolarReportException("Error: Report Finalized");
		}
		
		reportHTML += input + "\n";
		
	}
	
	/**
	 * Add a simple title and label to the report
	 * @param title - title of the page (left)
	 * @param content - add content that relates to the title (to right of title, float left)
	 * @throws SolarReportException
	 */
	public void addContent(String title, String content) throws SolarReportException{
		addContent("<span style=\"float:left; width:200px;padding:5px;clear:left;margin:2px;\">" + title + "</span>");
		addContent("<span style=\"float:left; width:300px;padding:5px;margin:2px;\">" + content + "</span>");
		
	}
	
	/**
	 * Loads the solar result with all details structured into the appropriate containes into the page
	 * @param result - the solar result to add
	 * @throws SolarReportException
	 */
	public void addContent(SolarResult result) throws SolarReportException{	
		
		//Title Details
		addContent("Title: ", result.getSolarSetup().getSetupName());
		addContent("Description: ", result.getSolarSetup().getSetupDescription());
		addContent("<br />");
		
		//Panels
		addContent("<h3 style=\"clear:left\">Panel Selection</h3>");
		addContent(result.getSolarSetup().getSolarPanels());
		
		//Inverter
		addContent("<h3 style=\"clear:left\">Inverter Selection</h3>");
		addContent(result.getSolarSetup().getInverter());
		
		//Customer Details
		addContent("<h3 style=\"clear:left\">Customer Details</h3>");
		addContent(result.getSolarSetup().getCustomerData());
		
	}
	
	/**
	 * Add a list of solar panels formatted in a table
	 * @param panels
	 * @throws SolarReportException
	 */
	public void addContent(ArrayList<SolarPanels> panels) throws SolarReportException{
		//Table heading
		addContent("<table style=\"margin-top: 1em;clear: both;background-color:#FFF;width:100%;color:Black;\">" 
		+ "<tr>"
		+"<th>Count</th>"
		+"<th>Direction</th>"
		+"<th>Azimuth</th>"
		+"<th>Name</th>"
		+"<th>Manufacturer</th>"
		+"<th>Wattage</th>"
		+"<th>Life</th>"
		+"<th>Cost</th>"
		+"<th>Efficiency</th>"
		+"</tr>");
		
		//Table body
		for(SolarPanels panelz : panels){
		addContent("<tr style=\"background-color:#BBB\"><td>" + panelz.getPanelCount() 
				+ "</td><td>" + panelz.getPanelDirection() 
				+ "</td><td>" + panelz.getPanelAzimuth() 
				+ "</td><td>" + panelz.getPanelType().getPanelName()
				+ "</td><td>" + panelz.getPanelType().getPanelManufacturer() 
				+ "</td><td>" + panelz.getPanelType().getPanelWattage() 
				+ "</td><td>" + panelz.getPanelType().getPanelLifeYears() 
				+ "</td><td>" + panelz.getPanelType().getPanelCost() 
				+ "</td><td>" + panelz.getPanelType().getPanelLossYear() 
				+ "</td></tr>");
		}
		addContent("</table>");
		
	}
	
	/**
	 * Add a solar inverter into the report formatted into table
	 * @param inverter - inverter to add into the report
	 * @throws SolarReportException
	 */
	public void addContent(SolarInverter inverter) throws SolarReportException{
		//Table heading
		addContent("<table style=\"margin-top: 1em;clear: both;background-color:#FFF;width:100%;color:Black;\">" 
		+ "<tr>"
		+"<th>Name</th>"
		+"<th>Manufacturer</th>"
		+"<th>Wattage</th>"
		+"<th>Life</th>"
		+"<th>Cost</th>"
		+"<th>Efficiency</th>"
		+"</tr>");
		
		addContent("<tr style=\"background-color:#BBB\"><td>" + inverter.getInverterName()
				+ "</td><td>" + inverter.getInverterManufacturer() 
				+ "</td><td>" + inverter.getInverterWattage() 
				+ "</td><td>" + inverter.getInverterLifeYears() 
				+ "</td><td>" + inverter.getInverterCost() 
				+ "</td><td>" + inverter.getInverterLossYear() 
				+ "</td></tr>");
	
		addContent("</table>");
		
	}
	
	/**
	 * Add customer details to the report formatted into a table
	 * @param details - Customer details to add to report
	 * @throws SolarReportException
	 */
	public void addContent(CustomerData details) throws SolarReportException{
		//Table heading
		addContent("<table style=\"margin-top: 1em;clear: both;background-color:#FFF;width:100%;color:Black;\">" 
		+ "<tr>"
		+"<th>Tariff 11 Cost</th>"
		+"<th>Tariff 11 Fee</th>"
		+"<th>Tariff 33 Cost</th>"
		+"<th>Tariff 33 Fee</th>"
		+"<th>Tariff Feed In Rate</th>"
		+"<th>Tariff Change %</th>"
		+"</tr>");
		
		addContent("<tr style=\"background-color:#BBB\"><td>" + details.getTariff11Cost()
				+ "</td><td>" + details.getTariff11Fee() 
				+ "</td><td>" + details.getTariff13Cost() 
				+ "</td><td>" + details.getTariff13Fee() 
				+ "</td><td>" + details.getFeedInFee() 
				+ "</td><td>!"
				+ "</td></tr>");
	
		addContent("</table>");
		
	}
	
	
	/**
	 * Standard toString method
	 */
	public String toString(){
		return reportHTML;
	}
	
	
	
	
	

}

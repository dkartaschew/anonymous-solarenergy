package com.anonymous.solar.shared;

import java.util.ArrayList;

import com.google.appengine.api.search.Results;

public class SolarReport {

	private String reportHTML;
	private boolean finalized = false;
	private boolean coloured = false;
	
	public SolarReport(){
		//Add starting elements from <body> -> content div
		reportHTML = "<body onload=\"\" " +  getBodyCSS() + ">\n";
		reportHTML += "<div id=\"wrapper\" " + getWrapperCSS() + ">\n";
		reportHTML += "<div id=\"head\" " + getHeadCSS() + " >\n";
		
		reportHTML += "<img border=\"0\" src=\"http://us.123rf.com/400wm/400/400/coliap/coliap1110"
				   + "/coliap111001390/10959841-solar-energy-panel-with-sun-and-leaves-alternative"
				   +"-energy-icon.jpg\" alt=\"Leaf\" width=\"100\" height=\"100\">";
		reportHTML += "ANONYMOUS SOLAR ENERGY REPORT\n";
		reportHTML += "<button onclick=\"load()\" style=\"float:right\">Print</button></div>\n";
		
		reportHTML += "<div id=\"pageBody\" " + getPageBodyCSS() + " >\n";
	}
	
	
	/*****************************************************************************************************
	 * PRIVATE METHODS: CONTAINING THE BODY OF THE HTML - ADD HEADER AND FOOTER
	 *****************************************************************************************************/

	/**
	 * Add a header onto the HTML file
	 */
	private void addHeader(){
		
		String header = "";
		
		header +="<head>\n";
		//additional head stuff
		header += "<script>\n";
		header += "\tfunction load()\n";
		header += "\t{\n";
		//header += "\tprint();\n";
		
		header += "\tprint();\n";
		
		header += "\t}\n";
		header += "</script>\n";
		header += "</head>\n";
		
		reportHTML = header + reportHTML;
	}
	
	/**
	 * Add a footer onto the html file
	 */
	private void addFooter(){
		
		String footer = "";
		footer += "</div>\n";
		footer += "</div>\n";
		footer += "<div id=\"footer\" " + getFooterCSS() + ">\n"; 
		
		footer += "This is an Anonymous Solar Energy Report ";
		footer += "</div>\n</body>\n";
		
		reportHTML = reportHTML + footer;
	}
	
	/*****************************************************************************************************
	 * PUBLIC METHODS: FINALIZE THE REPORT. ONCE THIS HAS DONE ALL ADDITION OF INFORMATION IS PREVENTED
	 *****************************************************************************************************/
	
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
	
	/*****************************************************************************************************
	 * PUBLIC METHODS: ADDING CONTENT TO REPORT
	 *****************************************************************************************************/
	
	
	/**
	 * Add a single string to the report. Warning: This will be COMPLETELY unformatted
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
	 * Add a simple title and title-detail to the report
	 * @param title - title of the page (left)
	 * @param content - add content that relates to the title (to right of title, float left)
	 * @throws SolarReportException
	 */
	public void addContent(String title, String content) throws SolarReportException{
		addContent("<span style=\"float:left; width:200px;padding:5px;clear:left;margin:2px;\">" + title + "</span>");
		addContent("<span style=\"float:left; width:700px;padding:5px;margin:2px;\">" + content + "</span>");
		addContent("<br />\n<br />\n");
	}
	
	/**
	 * Add a simple title and title-detail to the report, where the title-detail is a double
	 * @param title - title of the page (left)
	 * @param content - numeric double content to add to report (to right of title, float left)
	 * @throws SolarReportException
	 */
	public void addContent(String title, Double content) throws SolarReportException{
		addContent("<span style=\"float:left; width:200px;padding:5px;clear:left;margin:2px;\">" + title + "</span>");
		addContent("<span style=\"float:left; width:700px;padding:5px;margin:2px;\">" + content + "</span>");
		addContent("<br />\n<br />\n");
	}
	
	/**
	 * Add a simple title and title-detail to the report, where the title-detail is a double
	 * @param title - title of the page (left)
	 * @param content - numeric integer content to add to report (to right of title, float left)
	 * @throws SolarReportException
	 */
	public void addContent(String title, Integer content) throws SolarReportException{
		addContent("<span style=\"float:left; width:200px;padding:5px;clear:left;margin:2px;\">" + title + "</span>");
		addContent("<span style=\"float:left; width:700px;padding:5px;margin:2px;\">" + content + "</span>");
		addContent("<br />\n<br />\n");
	}
	
	/**
	 * Loads the solar result with all details structured into the appropriate containes into the page
	 * @param result - the solar result to add
	 * @throws SolarReportException
	 */
	public void addContent(SolarResult result, Integer timeFrame) throws SolarReportException{	
		
		String table = "";
		
		//
		//Solar Setup details
		//
		
		addContent(result.getSolarSetup());
		
		
		//
		//Result Details
		//
		
		//Initial Cost
		addContent("<div style=\"background-color:#FFC\">");	//OPEN DIV
		addContent("<h4 style=\"clear:left\">Results</h4>");
		addContent("System Startup Cost", "$" + result.getInitialSystemCost());
		
		//Yearly Saving Details
		addContent("<h4 style=\"clear:left\">Yearly Savings</h4>");
		addContent("<table style=\"margin-top: 1em;clear: both;width:40%;color:Black;\">");

		addContent("<tr>\n" 
				+ "<th>Year</th>\n" 
				+ "<th>Savings</th>\n" 
				+ "</tr>\n");
		
		for(int i = 1; i <= timeFrame; i++){
			addContent("<tr>\n" 
					+ "<td>Year " + i + "</td>\n"
					+ "<td>" + String.format("$%,.2f", result.getYearlySavings(i)) + "</td>\n"
					+ "</tr>\n");
		}

		addContent(table + "</table>");
		addContent("<h4 style=\"clear:left\"></h4>");
		addContent("</div>");									//CLOSE DIV
	}
	
	/**
	 * Loads the solar result with all details structured into the appropriate containes into the page
	 * @param setup - the solar result to add
	 * @throws SolarReportException
	 */
	public void addContent(SolarSetup setup) throws SolarReportException{	
		
		//Title Details
		addContent("<div style=\"background-color:#CFF\">");
		addContent("<b>Title: </b>", setup.getSetupName());
		addContent("<b>Description: </b>", setup.getSetupDescription());
		addContent(setup.getLocationInformation());
		addContent("<h4 style=\"clear:left\"></h4>");
		addContent("</div>");
		
		//Panels
		addContent("<div style=\"background-color:#CF6\">");
		addContent("<h4 style=\"clear:left\">Panel Selection</h4>");
		addContent(setup.getSolarPanels());
		
		//Inverter
		addContent("<h4 style=\"clear:left\">Inverter Selection</h4>");
		addContent(setup.getInverter());
		
		//Customer Details
		addContent("<h4 style=\"clear:left\">Customer Details</h4>");
		addContent(setup.getCustomerData());
		addContent("<h4 style=\"clear:left\"></h4>");
		addContent("</div>");
		

	}
	
	public void addContent(LocationData location) throws SolarReportException{
		
		addContent("<b>Location: </b>", location.getLocationName());
		addContent("<b>Longitude: </b>", location.getLongitude());
		addContent("<b>Latitude: </b>", location.getLatitude());
	}
	
	/**
	 * Add a list of solar panels formatted in a table
	 * @param panels
	 * @throws SolarReportException
	 */
	public void addContent(ArrayList<SolarPanels> panels) throws SolarReportException{
		//Table heading
		addContent("<table cellspacing=\"0\" " + getTableCSS() + ">" 
		+ "<tr>"
		+"<td>Name</td>"
		+"<td>Manufacturer</td>"
		+"<td>Wattage</td>"
		+"<td>Life</td>"
		+"<td>Direction</td>"
		+"<td>Azimutd</td>"
		+"<td>Cost($)</td>"
		+"<td>Units</td>"
		+"<td>Total($)</td>"
		+"<td>Efficiency</td>"
		+"</tr>");
		
		//Table body
		for(SolarPanels panelz : panels){
		addContent("<tr " + getTableRowCSS() + ">"
				
				+ "<td>" + panelz.getPanelType().getPanelName() + "</td>" 
				+ "<td>" + panelz.getPanelType().getPanelManufacturer() + "</td>" 
				+ "<td>" + panelz.getPanelType().getPanelWattage() + "</td>" 
				+ "<td>" + panelz.getPanelType().getPanelLifeYears() + "</td>" 
				+ "<td>" + panelz.getPanelDirection() + "</td>" 
				+ "<td>" + panelz.getPanelAzimuth() + "</td>" 
				+ "<td>" + panelz.getPanelType().getPanelCost() + "</td>"
				+ "<td>" + panelz.getPanelCount() + "</td>" 
				+ "<td>$" + panelz.getPanelCount() * panelz.getPanelType().getPanelCost() + "</td>"
				+ "<td>" + panelz.getPanelType().getPanelLossYear() 
				+ "</tr>");
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
		addContent("<table cellspacing=\"0\" " + getTableCSS() + ">" 
		+ "<tr>"
		+"<td>Name</td>"
		+"<td>Manufacturer</td>"
		+"<td>Wattage</td>"
		+"<td>Life</td>"
		+"<td>Cost</td>"
		+"<td>Efficiency</td>"
		+"</tr>");
		
		addContent("<tr " + getTableRowCSS() + "><td>" + inverter.getInverterName()
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
		addContent("<table cellspacing=\"0\" " + getTableCSS() + " >" 
		+ "<tr>"
		+"<td>Tariff 11 Cost</td>"
		+"<td>Tariff 11 Fee</td>"
		+"<td>Tariff 33 Cost</td>"
		+"<td>Tariff 33 Fee</td>"
		+"<td>Tariff Feed In Rate</td>"
		+"<td>Tariff Change %</td>"
		+"</tr>");
		
		addContent("<tr " + getTableRowCSS() + "><td>" + details.getTariff11Cost()
				+ "</td><td>" + details.getTariff11Fee() 
				+ "</td><td>" + details.getTariff13Cost() 
				+ "</td><td>" + details.getTariff13Fee() 
				+ "</td><td>" + details.getFeedInFee() 
				+ "</td><td>" + details.getAnnualTariffIncrease()
				+ "</td></tr>");
	
		
		
		if(CustomerData.class == CustomerData.class);
		
		addContent("</table>");
		
	}
	
	
	/**
	 * Standard toString method
	 */
	public String toString(){
		return reportHTML;
	}
	
	public void addContent(){
		
	}
	
	
	
	/*****************************************************************************************************
	 * PRIVATE METHODS: CSS STYLING
	 *****************************************************************************************************/
	
	/**
	 * Provides a CSS styling in the form of style="..." for table rows
	 * 
	 * @return CSS styling in form of style="..."
	 */
	private String getTableRowCSS(){
		return "style=\"" 
				+ "background-color:#DDD;" 
				+ "\"";	
	}
	
	/**
	 * Provides a CSS styling in the form of style="..." for tables that contain panels, inverters or
	 * customer details
	 * @return CSS styling in form of style="..."
	 */
	private String getTableCSS(){
		return "style=\""
				+ "margin-top: 1em;" 
				+ "clear: both;" 
				+ "width:100%;" 
				+ "color:Black;" 
				+ "\"";	
	}
	
	/**
	 * Provides a CSS styling in the form of style="..." for the [body] of the web report page
	 * @return CSS styling in form of style="..."
	 */
	private String getBodyCSS(){
		return "style=\""
				+ "background-color:#CCC;" 
				+ "margin: 0px;"
				+ "padding: 0px;"
				+ "font-family:Arial;"
				+ "\"";
	}
	
	/**
	 * Provides a CSS styling in the form of style="..." for the [div id="wrapper"] of the web report page
	 * @return CSS styling in form of style="..."
	 */
	private String getWrapperCSS(){
		return "style=\""
				+ "width:1000px;"
				+ "background-color:#FFF;" 
				+ "margin-left:auto;"
				+ "margin-right:auto;"
				+ "padding: 10px 10px 0px 10px;"
				+ "\"";
	}
	
	/**
	 * Provides a CSS styling in the form of style="..." for the [div id="head"] of the web report page
	 * @return CSS styling in form of style="..."
	 */
	private String getHeadCSS(){
		return "style=\""
				+ "width:95%;"
				+ "height:80px;"
				+ "margin-left:auto;"
				+ "margin-right:auto;"
				+ "padding: 2.5% 2.5% 2.5% 2.5%;"
				+ "border-bottom:4px solid #000;"
				+ "background-image: url(/Pictures/qutChemSoc.jpg);"
				+ "background-position:center;"
				+ "background-repeat:repeat-x;"
				+ "background-color:#FFF;"
				+ "font-size:30px;"
				+ "font-weight:bold;"
				+ "\"";
	}
	
	/**
	 * Provides a CSS styling in the form of style="..." for the [div id="pageBody"] of the web report page
	 * @return CSS styling in form of style="..."
	 */
	private String getPageBodyCSS(){
		return "style=\""
				+ "background-color:#FFF;"
				+ "padding:2.5% 2.5% 0% 2.5%;"
				+ "width:95%;"
				+ "color:#000;"
				+ "\"";
	}
	
	/**
	 * Provides a CSS styling in the form of style="..." for the [div id="footer"] of the web report page
	 * @return CSS styling in form of style="..."
	 */
	private String getFooterCSS(){
		return "style=\""
				+ "position: relative;"
				+ "color:red;"
				+ "bottom: 0px;"
				+ "width: 100%;"
				+ "padding: 15px 0px;"
				+ "margin-top: 5px;"
				+ "font-style: italic;"
				+ "font-weight: bold;"
				+ "font-size: 13px;"
				+ "letter-spacing: 2px;"
				+ "clear:both;"
				+ "background-color:#000;"
				+ "border-top:1px dotted #500;"
				+ "text-align:center;"
				+ "\"";
	}
	
	
	
	

}

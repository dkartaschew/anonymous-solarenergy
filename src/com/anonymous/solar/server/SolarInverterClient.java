package com.anonymous.solar.server;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.anonymous.solar.shared.SolarInverter;
import com.anonymous.solar.shared.SolarPanel;

public class SolarInverterClient extends HttpServlet {

	/**
	 * Private instance to perform various datastore actions.
	 */
	private DataStoreUtils dsutils = new DataStoreUtils();
	
	/**
	 * Override the default doPost() method to handle adding/deleting panels from the system.
	 */
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		// Handle panel delete, else assume, new panel?
		if (request.getParameter("delKey") != null) {
			Long invertKey = Long.parseLong(request.getParameter("delKey"));
			dsutils.removePanel(invertKey);
		}

		// Handle new panel.
		else if (request.getParameter(SolarPanel.PANEL_NAME) != null) {
			SolarInverter inverter = new SolarInverter();
			try {
				inverter.setInverterName(request.getParameter(SolarPanel.PANEL_NAME).toString());
				inverter.setInverterManufacturer(request.getParameter(SolarPanel.PANEL_MANUFACTURER).toString());
				inverter.setInverterManufacturerCode(request.getParameter(SolarPanel.PANEL_MANUFACTURER_CODE).toString());
				inverter.setInverterWattage(Double.parseDouble(request.getParameter(SolarPanel.PANEL_WATTAGE)));
				inverter.setInverterCost(Double.parseDouble(request.getParameter(SolarPanel.PANEL_PANEL_COST)));
				inverter.setInverterLossYear(Double.parseDouble(request.getParameter(SolarPanel.PANEL_LOSS_YEAR)));
				inverter.setInverterRRP(Double.parseDouble(request.getParameter(SolarPanel.PANEL_RRP)));
				inverter.setInverterLifeYears(Integer.parseInt(request.getParameter(SolarPanel.PANEL_LIFE_YEARS)));
				dsutils.storeInverter(inverter);

			} catch (Exception e) {
				// Oops, something went wrong, let the client know.
				response.sendRedirect("panels.jsp?error=CommitFailed");
				return;
			}
		}
		response.sendRedirect("panels.jsp");
	}

	
	/**
	 * Override default doGet() method to return a complete list of panels in
	 * the system, as well as a form to add new panels as needed.
	 */
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		PrintWriter out = response.getWriter();

		// Write out the header and any error messages for the client.
		out.print(SolarPanelsHTMLHelper.getHTMLHeader("Solar Panel Client"));
		if (request.getParameter("error") != null) {
			String errorMessage = request.getParameter("error").toString();
			out.print("<p class=\"error\">Error: " + errorMessage + "</p>\n");
		}
		
		// List all the panels in the system.
		out.print("<h1>Solar inverter installed within the system</h1>\n");
		out.print(displaySolarINVERTER());
		
		out.print("<h1>Insert a new solar inverter into the system</h1>\n");
		out.print(insertSolarINVERTER());
		
		// Display the page footer.
		out.print(SolarPanelsHTMLHelper.getHTMLFooter());
	}
	
	/**
	 * Display all the solar panels in the datastore in a table, and include a button to remove them as needed.
	 * @return A string containing the table.
	 */
	private String displaySolarINVERTER() {
		List<SolarInverter> panels = dsutils.getAllInverters();

		String table = "<table border=\"1\">\n";

		table += "<tr><th>Manufacturer</th>";
		table += "<th>Manufacturer Code</th>";
		table += "<th>Panel Name</th>";
		table += "<th>Maximum Wattage</th>";
		table += "<th>Panel Life</th>";
		table += "<th>Cost</th>";
		table += "<th>RRP</th>";
		table += "<th>Efficiency Loss (Annual)</th>";
		table += "<th>&nbsp;</th></tr>";
		for (SolarInverter panel : panels) {
			table += "<tr>\n<td>" + panel.getInverterManufacturer() + "</td>\n";
			table += "<td>" + panel.getInverterManufacturerCode() + "</td>\n";
			table += "<td>" + panel.getInverterName() + "</td>\n";
			table += "<td>" + panel.getInverterWattage().toString() + "</td>\n";
			table += "<td>" + panel.getInverterLifeYears().toString() + "</td>\n";
			table += "<td>$" + panel.getInverterCost().toString() + "</td>\n";
			table += "<td>$" + panel.getInverterRRP().toString() + "</td>\n";
			table += "<td>" + panel.getInverterLossYear().toString() + "%</td>\n";
			table += "<td><form action=\"panels.jsp\" method=\"post\">"
					+ "<input type=\"hidden\" name=\"delKey\" value=\"" + panel.getKey() + "\">"
					+ "<input type=\"submit\" value=\"Delete\"></form></td>\n ";
			table += "</tr>\n";
		}
		table += "</table>\n";
		return table;
	}
	
	
	/**
	 * Disply the form to insert a new inverter
	 * @return A string containing a form
	 */
	private String insertSolarINVERTER() {
		String form = "<form action=\"panels.jsp\" method=\"post\">\n";
		form += "<span class=\"textfield\">Inverter Name: </span><input type=\"text\" name=\"" + SolarInverter.INVERTER_NAME
				+ "\" /><br />\n";
		form += "<span class=\"textfield\">Inverter Manu: </span><input type=\"text\" name=\"" + SolarInverter.INVERTER_MANUFACTURER
				+ "\" /><br />\n";
		form += "<span class=\"textfield\">Inverter Code: </span><input type=\"text\" name=\"" + SolarInverter.INVERTER_CODE
				+ "\" /><br />\n";
		form += "<span class=\"textfield\">Inverter Wattage: </span><input type=\"text\" name=\"" + SolarInverter.INVERTER_WATTAGE
				+ "\" /><br />\n";
		form += "<span class=\"textfield\">Inverter Loss/year: </span><input type=\"text\" name=\"" + SolarInverter.INVERTER_LOSS_YEAR
				+ "\" /><br />\n";
		form += "<span class=\"textfield\">Inverter Efficiency: </span><input type=\"text\" name=\"" + SolarInverter.INVERTER_EFFICIENCY
				+ "\" /><br />\n";
		form += "<span class=\"textfield\">Inverter Cost: </span><input type=\"text\" name=\"" + SolarInverter.INVERTER_COST
				+ "\" /><br />\n";
		form += "<span class=\"textfield\">Inverter RRP: </span><input type=\"text\" name=\"" + SolarInverter.INVERTER_RRP
				+ "\" /><br />\n";
		form += "<span class=\"textfield\">Inverter RRP: </span><input type=\"text\" name=\"" + SolarInverter.INVERTER_LIFE
				+ "\" /><br />\n";
		form += "<input type=\"submit\" name=\"Submit\">\n";
		form += "</form>\n";
		return form;
	}
	
}

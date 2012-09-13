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
		out.print("<h1>N: Solar INVERTER installed within the system</h1>\n");
		out.print(displaySolarINVERTER());
		

		
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
	
}

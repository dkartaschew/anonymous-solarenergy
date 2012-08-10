/**
 * 
 */
package com.anonymous.solar.client;

import java.io.*;
import java.util.List;

import javax.servlet.*;
import javax.servlet.http.*;
import com.anonymous.solar.server.*;
import com.anonymous.solar.shared.*;

/**
 * Servlet to handle HTML interface to the storage of panel objects in the
 * datastore. Do not use directly, instead use the panels.jsp to access this
 * servlet.
 * 
 * @author 07627505 Darran Kartaschew
 * @version 1.0
 */
@SuppressWarnings("serial")
public class SolarPanelsClient extends HttpServlet {

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
		out.print("<h1>Solar Panels installed within the system</h1>\n");
		out.print(displaySolarPanels());
		
		// Display a form to add new panel information.
		out.print("<h1>Add new panel configuration</h1>\n");
		out.print(displaySolarPanelNewForm());
		
		// Display the page footer.
		out.print(SolarPanelsHTMLHelper.getHTMLFooter());
	}

	/**
	 * Override the default doPost() method to handle adding/deleting panels from the system.
	 */
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		// Handle panel delete, else assume, new panel?
		if (request.getParameter("delKey") != null) {
			Long panelKey = Long.parseLong(request.getParameter("delKey"));
			dsutils.removePanel(panelKey);
		}

		// Handle new panel.
		else if (request.getParameter(SolarPanel.PANEL_NAME) != null) {
			SolarPanel panel = new SolarPanel();
			try {
				panel.setPanelName(request.getParameter(SolarPanel.PANEL_NAME).toString());
				panel.setPanelManufacturer(request.getParameter(SolarPanel.PANEL_MANUFACTURER).toString());
				panel.setPanelManufacturerCode(request.getParameter(SolarPanel.PANEL_MANUFACTURER_CODE).toString());
				panel.setPanelWattage(Double.parseDouble(request.getParameter(SolarPanel.PANEL_WATTAGE)));
				panel.setPanelCost(Double.parseDouble(request.getParameter(SolarPanel.PANEL_PANEL_COST)));
				panel.setPanelLossYear(Double.parseDouble(request.getParameter(SolarPanel.PANEL_LOSS_YEAR)));
				panel.setPanelRRP(Double.parseDouble(request.getParameter(SolarPanel.PANEL_RRP)));
				panel.setPanelLifeYears(Integer.parseInt(request.getParameter(SolarPanel.PANEL_LIFE_YEARS)));
				dsutils.storePanel(panel);

			} catch (Exception e) {
				// Oops, something went wrong, let the client know.
				response.sendRedirect("panels.jsp?error=CommitFailed");
				return;
			}
		}
		response.sendRedirect("panels.jsp");
	}

	/**
	 * Display a new form to add a new panel into the system.
	 * @return A string containing the form.
	 */
	private String displaySolarPanelNewForm() {
		String form = "<form action=\"panels.jsp\" method=\"post\">\n";
		form += "<span class=\"textfield\">Panel Name: </span><input type=\"text\" name=\"" + SolarPanel.PANEL_NAME
				+ "\" /><br />\n";
		form += "<span class=\"textfield\">Panel Manufacturer:  </span><input type=\"text\" name=\""
				+ SolarPanel.PANEL_MANUFACTURER + "\" /><br />\n";
		form += "<span class=\"textfield\">Panel Code:  </span><input type=\"text\" name=\""
				+ SolarPanel.PANEL_MANUFACTURER_CODE + "\" /><br />\n";
		form += "<span class=\"textfield\">Panel Wattage:  </span><input type=\"text\" name=\""
				+ SolarPanel.PANEL_WATTAGE + "\" /><br />\n";
		form += "<span class=\"textfield\">Panel Life:  </span><input type=\"text\" name=\""
				+ SolarPanel.PANEL_LIFE_YEARS + "\" /><br />\n";
		form += "<span class=\"textfield\">Panel Cost:  </span><input type=\"text\" name=\""
				+ SolarPanel.PANEL_PANEL_COST + "\" /><br />\n";
		form += "<span class=\"textfield\">Panel RRP:  </span><input type=\"text\" name=\"" + SolarPanel.PANEL_RRP
				+ "\" /><br />\n";
		form += "<span class=\"textfield\">Panel Efficiency Loss:  </span><input type=\"text\" name=\""
				+ SolarPanel.PANEL_LOSS_YEAR + "\" /><br />\n";
		form += "<input type=\"submit\" name=\"Submit\">\n";
		form += "</form>\n";
		return form;
	}

	/**
	 * Display all the solar panels in the datastore in a table, and include a button to remove them as needed.
	 * @return A string containing the table.
	 */
	private String displaySolarPanels() {
		List<SolarPanel> panels = dsutils.getAllPanels();

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
		for (SolarPanel panel : panels) {
			table += "<tr>\n<td>" + panel.getPanelManufacturer() + "</td>\n";
			table += "<td>" + panel.getPanelManufacturerCode() + "</td>\n";
			table += "<td>" + panel.getPanelName() + "</td>\n";
			table += "<td>" + panel.getPanelWattage().toString() + "</td>\n";
			table += "<td>" + panel.getPanelLifeYears().toString() + "</td>\n";
			table += "<td>$" + panel.getPanelCost().toString() + "</td>\n";
			table += "<td>$" + panel.getPanelRRP().toString() + "</td>\n";
			table += "<td>" + panel.getPanelLossYear().toString() + "%</td>\n";
			table += "<td><form action=\"panels.jsp\" method=\"post\">"
					+ "<input type=\"hidden\" name=\"delKey\" value=\"" + panel.getKey() + "\">"
					+ "<input type=\"submit\" value=\"Delete\"></form></td>\n ";
			table += "</tr>\n";
		}
		table += "</table>\n";
		return table;
	}
}

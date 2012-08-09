package com.anonymous.solar.client;

import java.io.*;
import java.util.List;

import javax.servlet.*;
import javax.servlet.http.*;
import com.anonymous.solar.server.*;
import com.anonymous.solar.shared.*;

@SuppressWarnings("serial")
public class SolarPanelsClient extends HttpServlet {

	private DataStoreUtils dsutils = new DataStoreUtils();

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		PrintWriter out = response.getWriter();
		// Use "out" to send content to browser
		out.print(SolarPanelsHTMLHelper.getHTMLHeader("Solar Panel Client"));
		out.print("<h1>Solar Panels installed within the system</h1>\n");
		out.print(displaySolarPanels());
		out.print("<h1>Add new panel configuration</h1>\n");
		out.print(displaySolarPanelNewForm());
		out.print(SolarPanelsHTMLHelper.getHTMLFooter());
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// Handle panel delete, else assume, new panel?
		if (request.getParameter("delItemCode") != null) {
			String panelManufacturerCode = request.getParameter("delItemCode").toString();
			String panelName = request.getParameter("delItemName").toString();
			dsutils.removePanel(panelManufacturerCode, panelName);
		}

		// Handle new panel.
		else if (request.getParameter(SolarPanel.PANEL_NAME) != null) {
			SolarPanel panel = new SolarPanel();
			panel.setPanelName(request.getParameter(SolarPanel.PANEL_NAME)
					.toString());
			panel.setPanelManufacturer(request.getParameter(
					SolarPanel.PANEL_MANUFACTURER).toString());
			panel.setPanelManufacturerCode(request.getParameter(
					SolarPanel.PANEL_MANUFACTURER_CODE).toString());
			try {
				panel.setPanelWattage(Double.parseDouble(request
						.getParameter(SolarPanel.PANEL_WATTAGE)));
			} catch (Exception e) {
				panel.setPanelWattage(0.00);
			}
			try {
				panel.setPanelCost(Double.parseDouble(request
						.getParameter(SolarPanel.PANEL_PANEL_COST)));
			} catch (Exception e) {
				panel.setPanelCost(0.00);
			}
			try {
				panel.setPanelLossYear(Double.parseDouble(request
						.getParameter(SolarPanel.PANEL_LOSS_YEAR)));
			} catch (Exception e) {
				panel.setPanelLossYear(0.00);
			}
			try {
				panel.setPanelRRP(Double.parseDouble(request
						.getParameter(SolarPanel.PANEL_RRP)));
			} catch (Exception e) {
				panel.setPanelRRP(0.00);
			}
			try {
				panel.setPanelLifeYears(Integer.parseInt(request
						.getParameter(SolarPanel.PANEL_LIFE_YEARS)));
			} catch (Exception e) {
				panel.setPanelLifeYears(0);
			}
			dsutils.storePanel(panel);

		}
		response.sendRedirect("panels.jsp");
	}

	private String displaySolarPanelNewForm() {
		String form = "<form action=\"panels.jsp\" method=\"post\">\n";
		form += "<span class=\"textfield\">Panel Name: </span><input type=\"text\" name=\""
				+ SolarPanel.PANEL_NAME + "\" /><br />\n";
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
		form += "<span class=\"textfield\">Panel RRP:  </span><input type=\"text\" name=\""
				+ SolarPanel.PANEL_RRP + "\" /><br />\n";
		form += "<span class=\"textfield\">Panel Efficiency Loss:  </span><input type=\"text\" name=\""
				+ SolarPanel.PANEL_LOSS_YEAR + "\" /><br />\n";
		form += "<input type=\"submit\" name=\"Submit\">\n";
		form += "</form>\n";
		return form;
	}

	private String displaySolarPanels() {
		List<SolarPanel> panels = dsutils.getAllPanels();

		String table = "<table border=\"1\">\n";
		table += "<tr><th>Panel Name</th>";
		table += "<th>Manufacturer</th>";
		table += "<th>Manufacturer Code</th>";
		table += "<th>Maximum Wattage</th>";
		table += "<th>Panel Life</th>";
		table += "<th>Cost</th>";
		table += "<th>RRP</th>";
		table += "<th>Efficiency Loss (Annual)</th>";
		table += "<th>&nbsp;</th></tr>";
		for (SolarPanel panel : panels) {
			table += "<tr>\n<td>" + panel.getPanelName() + "</td>\n";
			table += "<td>" + panel.getPanelManufacturer() + "</td>\n";
			table += "<td>" + panel.getPanelManufacturerCode() + "</td>\n";
			table += "<td>" + panel.getPanelWattage().toString() + "</td>\n";
			table += "<td>" + panel.getPanelLifeYears().toString() + "</td>\n";
			table += "<td>$" + panel.getPanelCost().toString() + "</td>\n";
			table += "<td>$" + panel.getPanelRRP().toString() + "</td>\n";
			table += "<td>" + panel.getPanelLossYear().toString() + "%</td>\n";
			table += "<td><form action=\"panels.jsp\" method=\"post\">"
					+ "<input type=\"hidden\" name=\"delItemCode\" value=\""
					+ panel.getPanelManufacturerCode() + "\">"
					+ "<input type=\"hidden\" name=\"delItemName\" value=\""
					+ panel.getPanelName() + "\">"
					+ "<input type=\"submit\" value=\"Delete\"></form></td>\n ";
			table += "</tr>\n";
		}
		table += "</table>\n";
		return table;
	}
}

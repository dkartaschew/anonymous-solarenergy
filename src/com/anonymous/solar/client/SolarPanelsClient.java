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

		if (request.getParameter("panelName") != null) {
			SolarPanel panel = new SolarPanel();
			panel.setPanelName(request.getParameter("panelName").toString());
			panel.setPanelManufacturer(request
					.getParameter("panelManufacturer").toString());
			panel.setPanelManufacturerCode(request.getParameter(
					"panelManufacturerCode").toString());
			dsutils.storePanel(panel);

		}
		response.sendRedirect("panels.jsp");
	}

	private String displaySolarPanelNewForm() {
		String form = "<form action=\"panels.jsp\" method=\"post\">\n";
		form += "Panel Name: <input type=\"text\" name=\"panelName\" /><br />\n";
		form += "Panel Manufacturer: <input type=\"text\" name=\"panelManufacturer\" /><br />\n";
		form += "Panel Code: <input type=\"text\" name=\"panelManufacturerCode\" /><br />\n";
		form += "<input type=\"submit\" name=\"Submit\">\n";
		form += "</form>\n";
		return form;
	}

	private String displaySolarPanels() {
		List<SolarPanel> panels = dsutils.getAllPanels();

		String table = "<table  border=\"1\">\n";
		for (SolarPanel panel : panels) {
			table += "<tr>\n<td>" + panel.getPanelName() + "</td>\n";
			table += "<td>" + panel.getPanelManufacturer() + "</td>\n";
			table += "<td>" + panel.getPanelManufacturerCode() + "</td>\n";
			table += "</tr>\n";
		}
		table = table + "</table>\n";
		return table;
	}

}

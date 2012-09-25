/**
 * 
 */
package com.anonymous.solar.server;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.anonymous.solar.shared.SolarPanel;
import com.anonymous.solar.shared.TariffRate;

/**
 * Servlet to handle HTML interface to the storage of panel objects in the
 * datastore. Do not use directly, instead use the Tariffs.jsp to access this
 * servlet.
 * 
 * @author 07627505 Darran Kartaschew
 * @version 1.0
 */
@SuppressWarnings("serial")
public class TariffRateClient extends HttpServlet {

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
		out.print(SolarPanelsHTMLHelper.getHTMLHeader("Tariff Rate Client"));
		if (request.getParameter("error") != null) {
			String errorMessage = request.getParameter("error").toString();
			out.print("<p class=\"error\">Error: " + errorMessage + "</p>\n");
		}
		
		// List all the panels in the system.
		out.print("<h1>N: Tariff Rates installed within the system</h1>\n");
		out.print(displayTariffRates());
		
		// Display a form to add new panel information.
		out.print("<h1>Add new tariff configuration</h1>\n");
		out.print(displayTariffRateNewForm());
		
		// Display the page footer.
		out.print(SolarPanelsHTMLHelper.getHTMLFooter());
	}

	/**
	 * Override the default doPost() method to handle adding/deleting panels from the system.
	 */
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		// Handle panel delete, else assume, new panel?
		if (request.getParameter("delKey") != null) {
			Long tariffKey = Long.parseLong(request.getParameter("delKey"));
			dsutils.removeTariffRate(tariffKey);
		}

		// Handle new panel.
		else if (request.getParameter(TariffRate.TARIFF_PROVIDER) != null) {
			TariffRate tarrif = new TariffRate();
			try {
				tarrif.setTariffProvider(request.getParameter(TariffRate.TARIFF_PROVIDER).toString());
				tarrif.setTariffState(request.getParameter(TariffRate.TARIFF_STATE).toString());
				tarrif.setTariff11Cost(Double.parseDouble(request.getParameter(TariffRate.TARIFF_11_COST)));
				tarrif.setTariff11Fee(Double.parseDouble(request.getParameter(TariffRate.TARIFF_11_FEE)));
				tarrif.setTariff33Cost(Double.parseDouble(request.getParameter(TariffRate.TARIFF_33_COST)));
				tarrif.setTariff33Fee(Double.parseDouble(request.getParameter(TariffRate.TARIFF_33_FEE)));
				tarrif.setTariffFeedInFee(Double.parseDouble(request.getParameter(TariffRate.TARIFF_FEE_IN)));
				dsutils.storeTariffRate(tarrif);

			} catch (Exception e) {
				// Oops, something went wrong, let the client know.
				response.sendRedirect("Tariffs.jsp?error=CommitFailed");
				return;
			}
		}
		response.sendRedirect("Tariffs.jsp");
	}

	/**
	 * Display a new form to add a new panel into the system.
	 * @return A string containing the form.
	 */
	private String displayTariffRateNewForm() {
		String form = "<form action=\"Tariffs.jsp\" method=\"post\">\n";
		form += "<span class=\"textfield\">Tariff Provider: </span><input type=\"text\" name=\"" + TariffRate.TARIFF_PROVIDER
				+ "\" /><br />\n";
		form += "<span class=\"textfield\">Tariff STATE:  </span><input type=\"text\" name=\""
				+ TariffRate.TARIFF_STATE + "\" /><br />\n";
		form += "<span class=\"textfield\">Tariff 11 Cost:  </span><input type=\"text\" name=\""
				+ TariffRate.TARIFF_11_COST + "\" /><br />\n";
		form += "<span class=\"textfield\">Tariff 11 Fee:  </span><input type=\"text\" name=\""
				+ TariffRate.TARIFF_11_FEE + "\" /><br />\n";
		form += "<span class=\"textfield\">Tariff 33 Cost:  </span><input type=\"text\" name=\""
				+ TariffRate.TARIFF_33_COST + "\" /><br />\n";
		form += "<span class=\"textfield\">Tariff 33 Fee:  </span><input type=\"text\" name=\""
				+ TariffRate.TARIFF_33_FEE + "\" /><br />\n";
		form += "<span class=\"textfield\">Feed In Fee:  </span><input type=\"text\" name=\"" + TariffRate.TARIFF_FEE_IN
				+ "\" /><br />\n";
		form += "<input type=\"submit\" name=\"Submit\">\n";
		form += "</form>\n";
		return form;
	}

	/**
	 * Display all the tariff rates in the datastore in a table, and include a button to remove them as needed.
	 * @return A string containing the table.
	 */
	private String displayTariffRates() {
		List<TariffRate> tariffs = dsutils.getAllTariffs();

		String table = "<table border=\"1\">\n";

		table += "<tr><th>Provider</th>";
		table += "<th>State</th>";
		table += "<th>11 Cost</th>";
		table += "<th>11 Fee</th>";
		table += "<th>33 Cost</th>";
		table += "<th>33 Fee</th>";
		table += "<th>Feed In Reward</th>";
		table += "<th>&nbsp;</th></tr>";
		for (TariffRate tariff : tariffs) {
			table += "<tr>\n<td>" + tariff.getTariffProvider() + "</td>\n";
			table += "<td>" + tariff.getTariffState() + "</td>\n";
			table += "<td>" + tariff.getTariff11Cost() + "c</td>\n";
			table += "<td>" + tariff.getTariff11Fee().toString() + "c</td>\n";
			table += "<td>" + tariff.getTariff33Cost().toString() + "c</td>\n";
			table += "<td>" + tariff.getTariff33Fee().toString() + "c</td>\n";
			table += "<td>" + tariff.getTariffFeedInFee().toString() + "c</td>\n";
			table += "<td><form action=\"Tariffs.jsp\" method=\"post\">"
					+ "<input type=\"hidden\" name=\"delKey\" value=\"" + tariff.getKey() + "\">"
					+ "<input type=\"submit\" value=\"Delete\"></form></td>\n ";
			table += "</tr>\n";
		}
		table += "</table>\n";
		return table;
	}
}

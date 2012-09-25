package com.anonymous.solar.server;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.Enumeration;
import java.util.List;
import java.util.StringTokenizer;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.soap.MessageFactory;
import javax.xml.soap.MimeHeaders;
import javax.xml.soap.SOAPException;
import javax.xml.soap.SOAPMessage;

import com.anonymous.solar.shared.SolarInverter;
import com.anonymous.solar.shared.SolarPanel;
import com.anonymous.solar.shared.TariffRate;

@SuppressWarnings("serial")
public class TRateSOAPServerServelet extends HttpServlet {
	static MessageFactory messageFactory;
	static TRateSOAPHandler soapHandler;

	/**
	 * Private instance to perform various datastore actions.
	 */
	private DataStoreUtils dsutils = new DataStoreUtils();
	
	static {
	    try {
	    	messageFactory = MessageFactory.newInstance();
	    	soapHandler = new TRateSOAPHandler();
	    } catch (Exception ex) {
	        throw new RuntimeException(ex);
	    }
	  }

	@Override
	public void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
	    try {
			 // Get all the headers from the HTTP request
			 MimeHeaders headers = getHeaders(req);
			
			 // Construct a SOAPMessage from the XML in the request body
			 InputStream is = req.getInputStream();
			 SOAPMessage soapRequest = messageFactory.createMessage(headers, is);
			
			 // Handle soapReqest
			 SOAPMessage soapResponse = soapHandler.handleSOAPRequest(soapRequest);
			
			 // Write to HttpServeltResponse
			 resp.setStatus(HttpServletResponse.SC_OK);
			 resp.setContentType("text/xml;charset=\"utf-8\"");
			 OutputStream os = resp.getOutputStream();
			 soapResponse.writeTo(os);
			 os.flush();
	    } catch (SOAPException e) {
	        throw new IOException("Exception while creating SOAP message.", e);
	    }
	  }

	@SuppressWarnings("unchecked")
	static MimeHeaders getHeaders(HttpServletRequest req) {
	    Enumeration headerNames = req.getHeaderNames();
	    MimeHeaders headers = new MimeHeaders();
	    while (headerNames.hasMoreElements()) {
	        String headerName = (String) headerNames.nextElement();
	        String headerValue = req.getHeader(headerName);
	        StringTokenizer values = new StringTokenizer(headerValue, ",");
	      while (values.hasMoreTokens()) {
	        headers.addHeader(headerName, values.nextToken().trim());
	      }
	    }
	    return headers;
	  }
	
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
		
		// Display the page footer.
		out.print(SolarPanelsHTMLHelper.getHTMLFooter());
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
			table += "<td>" + tariff.getTariff11Cost() + "</td>\n";
			table += "<td>" + tariff.getTariff11Fee().toString() + "</td>\n";
			table += "<td>" + tariff.getTariff33Cost().toString() + "</td>\n";
			table += "<td>$" + tariff.getTariff33Fee().toString() + "</td>\n";
			table += "<td>$" + tariff.getTariffFeedInFee().toString() + "</td>\n";
			table += "<td><form action=\"tariffs.jsp\" method=\"post\">"
					+ "<input type=\"hidden\" name=\"delKey\" value=\"" + tariff.getKey() + "\">"
					+ "<input type=\"submit\" value=\"Delete\"></form></td>\n ";
			table += "</tr>\n";
		}
		table += "</table>\n";
		return table;
	}
	
}

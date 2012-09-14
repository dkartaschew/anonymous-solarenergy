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

@SuppressWarnings("serial")
public class SInverterSOAPServerServelet extends HttpServlet {
	static MessageFactory messageFactory;
	static SInverterSOAPHandler soapHandler;

	/**
	 * Private instance to perform various datastore actions.
	 */
	private DataStoreUtils dsutils = new DataStoreUtils();
	
	static {
	    try {
	    	messageFactory = MessageFactory.newInstance();
	    	soapHandler = new SInverterSOAPHandler();
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
	
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		PrintWriter out = response.getWriter();

		// Write out the header and any error messages for the client.
		out.print(SolarPanelsHTMLHelper.getHTMLHeader("Location Information Client"));
		if (request.getParameter("error") != null) {
			String errorMessage = request.getParameter("error").toString();
			out.print("<p class=\"error\">Error: " + errorMessage + "</p>\n");
		}
		
		// List all the panels in the system.
		out.print("<h1>Solar Inverters installed within the system</h1>\n");
		out.print(displaySolarINVERTER());

		// Display the page footer.
		out.print(SolarPanelsHTMLHelper.getHTMLFooter());
	}
	
	/**
	 * Display all the solar inverters in the datastore in a table, and include a button to remove them as needed.
	 * @return A string containing the table.
	 */
	private String displaySolarINVERTER() {
		List<SolarInverter> inverters = dsutils.getAllInverters();

		String table = "<table border=\"1\">\n";

		table += "<tr><th>Manufacturer</th>";
		table += "<th>Manufacturer Code</th>";
		table += "<th>Panel Name</th>";
		table += "<th>Maximum Wattage</th>";
		table += "<th>Panel Life</th>";
		table += "<th>Cost</th>";
		table += "<th>RRP</th>";
		table += "<th>Efficiency Loss (Annual)</th>";
		table += "<th>Key</th>";
		table += "<th>&nbsp;</th></tr>";
		for (SolarInverter inverter : inverters) {
			table += "<tr>\n<td>" + inverter.getInverterManufacturer() + "</td>\n";
			table += "<td>" + inverter.getInverterManufacturerCode() + "</td>\n";
			table += "<td>" + inverter.getInverterName() + "</td>\n";
			table += "<td>" + inverter.getInverterWattage().toString() + "</td>\n";
			table += "<td>" + inverter.getInverterLifeYears().toString() + "</td>\n";
			table += "<td>$" + inverter.getInverterCost().toString() + "</td>\n";
			table += "<td>$" + inverter.getInverterRRP().toString() + "</td>\n";
			table += "<td>" + inverter.getInverterLossYear().toString() + "%</td>\n";
			table += "<td>[key]" + inverter.getKey().toString() + "[key]</td>\n";
			table += "<td><form action=\"inverters.jsp\" method=\"post\">"
					+ "<input type=\"hidden\" name=\"delKey\" value=\"" + inverter.getKey() + "\">"
					+ "<input type=\"submit\" value=\"Delete\"></form></td>\n ";
			table += "</tr>\n";
		}
		table += "</table>\n";
		return table;
	}
	
}

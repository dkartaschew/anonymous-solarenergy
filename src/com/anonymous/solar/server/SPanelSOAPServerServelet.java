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

import com.anonymous.solar.shared.SolarPanel;

@SuppressWarnings("serial")
public class SPanelSOAPServerServelet extends HttpServlet {
	static MessageFactory messageFactory;
	static SPanelSOAPHandler soapHandler;

	/**
	 * Private instance to perform various datastore actions.
	 */
	private DataStoreUtils dsutils = new DataStoreUtils();
	
	static {
	    try {
	    	messageFactory = MessageFactory.newInstance();
	    	soapHandler = new SPanelSOAPHandler();
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
		out.print("<h1>Solar Panels installed within the system</h1>\n");
		out.print(displaySolarPanels());

		// Display the page footer.
		out.print(SolarPanelsHTMLHelper.getHTMLFooter());
	}
	
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

package com.anonymous.solar.server;

import java.util.Iterator;

import javax.xml.bind.JAXB;
import javax.xml.namespace.QName;
import javax.xml.soap.MessageFactory;
import javax.xml.soap.SAAJResult;
import javax.xml.soap.SOAPBody;
import javax.xml.soap.SOAPElement;
import javax.xml.soap.SOAPException;
import javax.xml.soap.SOAPFault;
import javax.xml.soap.SOAPMessage;
import javax.xml.transform.dom.DOMSource;

import com.anonymous.solar.server.jaxws.CalculateDailySavings;
import com.anonymous.solar.server.jaxws.CalculateYearlySavings;
import com.anonymous.solar.server.jaxws.CalculateYearlySavingsOverTime;

/**
 * This class handles any of the SOAP requests sent to the server for the solar calculator
 * and does the appropriate action.
 * 
 * @author 07377495 Luke Durkan
 * @version 1.0
 *
 */
public class SolarCalculatorSOAPHandler {

	 private static final String NAMESPACE_URI = "http://server.solar.anonymous.com/";
	 private static final QName CALCULATE_DAILY_SAVINGS_QNAME = new QName
			 (NAMESPACE_URI, "calculateDailySavings");
	 private static final QName CALCULATE_YEARLY_SAVINGS_QNAME = new QName
			 (NAMESPACE_URI, "calculateYearlySavings");
	 private static final QName CALCULATE_YEARLY_SAVINGS_OVER_TIME_QNAME = new QName
			 (NAMESPACE_URI, "calculateYearlySavingsOverTime");
	 
	 private MessageFactory messageFactory;
	 private SolarCalculatorAdapter solarCalculatorAdapter;
	 
	 public SolarCalculatorSOAPHandler() throws SOAPException {
		 messageFactory = MessageFactory.newInstance();
		 solarCalculatorAdapter = new SolarCalculatorAdapter();
		 
	 }
	
	public SOAPMessage handleSOAPRequest(SOAPMessage request) throws SOAPException {
		SOAPBody soapBody = request.getSOAPBody();
	    Iterator iterator = soapBody.getChildElements();
	    Object responsePojo = null;
	    
	    while (iterator.hasNext()) {
	      Object next = iterator.next();
	      
	      if (next instanceof SOAPElement) {
	        SOAPElement soapElement = (SOAPElement) next;
	        QName qname = soapElement.getElementQName();
	         
	        if (CALCULATE_DAILY_SAVINGS_QNAME.equals(qname)) {
	            responsePojo = handleCalculateDailySavingsRequest(soapElement);
	            break;
	        } else if (CALCULATE_YEARLY_SAVINGS_QNAME.equals(qname)) {
	            responsePojo = handleCalculateYearlySavingsRequest(soapElement);
	            break;
	        } else if (CALCULATE_YEARLY_SAVINGS_OVER_TIME_QNAME.equals(qname)) {
	        	responsePojo = handleCalculateYearlySavingsOverTimeRequest(soapElement);
	            break;
	        }
	      }
	    }
	    
	    SOAPMessage soapResponse = messageFactory.createMessage();
	    soapBody = soapResponse.getSOAPBody();
	    
	    if (responsePojo != null) {
	      JAXB.marshal(responsePojo, new SAAJResult(soapBody));
	    } else {
	      SOAPFault fault = soapBody.addFault();
	      fault.setFaultString("Unrecognized SOAP request.");
	    }
	    
	    return soapResponse;
	}

	private Object handleCalculateDailySavingsRequest(SOAPElement soapElement) {
		CalculateDailySavings calculateDailySavingsRequest = JAXB.unmarshal(
				new DOMSource(soapElement), CalculateDailySavings.class);
	    return solarCalculatorAdapter.CalculateDailySavings(calculateDailySavingsRequest);
	}
	
	private Object handleCalculateYearlySavingsRequest(SOAPElement soapElement) {
		CalculateYearlySavings calculateYearlySavingsRequest = JAXB.unmarshal(new 
				DOMSource(soapElement), CalculateYearlySavings.class);
		return solarCalculatorAdapter.CalculateYearlySavings(calculateYearlySavingsRequest);
	}
	
	private Object handleCalculateYearlySavingsOverTimeRequest(SOAPElement soapElement) {
		CalculateYearlySavingsOverTime calculateYearlySavingsOverTimeRequest = 
				JAXB.unmarshal(new DOMSource(soapElement), 
						CalculateYearlySavingsOverTime.class);
		return solarCalculatorAdapter.CalculateYearlySavingsOverTime
				(calculateYearlySavingsOverTimeRequest);
	}
}

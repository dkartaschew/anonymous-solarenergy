package com.anonymous.solar.server;

import javax.xml.soap.SOAPMessage;

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
import com.anonymous.solar.server.jaxws.*;


public class TRateSOAPHandler {
	
	private static final String NAMESPACE_URI = "http://server.solar.anonymous.com/";
	private static final QName GET_ALL_TARIFFS = new QName(NAMESPACE_URI, "getTariffRates");
	private static final QName INSERT_TARIFF_RATE = new QName(NAMESPACE_URI, "insertTariffRate");
	private static final QName REMOVE_TARIFF_RATE = new QName(NAMESPACE_URI, "removeTariffRate");

	private MessageFactory messageFactory;
	private TRateAdapter tRateAdapter;
	
	public TRateSOAPHandler() throws SOAPException {
	    messageFactory = MessageFactory.newInstance();
	    tRateAdapter = new TRateAdapter();
	}

	public SOAPMessage handleSOAPRequest(SOAPMessage request) throws SOAPException{
		SOAPBody soapBody = request.getSOAPBody();
	    Iterator iterator = soapBody.getChildElements();
	    Object responsePojo = null;
	    while (iterator.hasNext()) {
	      Object next = iterator.next();
	      if (next instanceof SOAPElement) {
	        SOAPElement soapElement = (SOAPElement) next;
	        QName qname = soapElement.getElementQName();
	          if (GET_ALL_TARIFFS.equals(qname)) {
	            responsePojo = handleInsertTariffRateRequest(soapElement);
	            break;
	          } else if (INSERT_TARIFF_RATE.equals(qname)) {
	            responsePojo = handleGetTariffRatesRequest(soapElement);
	            break;
	      	  } else if (REMOVE_TARIFF_RATE.equals(qname)) {
	            responsePojo = handleRemoveTariffRateRequest(soapElement);
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
	
	private Object handleRemoveTariffRateRequest(SOAPElement soapElement) {
	    RemoveTariffRate removeTariffRateRequest = JAXB.unmarshal(new DOMSource(soapElement), RemoveTariffRate.class);	    
	    return tRateAdapter.removeTariffRate(removeTariffRateRequest);
	}
	
	private Object handleInsertTariffRateRequest(SOAPElement soapElement) {
	    InsertTariffRate insertTariffRateRequest = JAXB.unmarshal(new DOMSource(soapElement), InsertTariffRate.class);	    
	    return tRateAdapter.insertTariffRate(insertTariffRateRequest);
	}

	private Object handleGetTariffRatesRequest(SOAPElement soapElement) {
		return tRateAdapter.getTariffRates();
	}

	
	
}

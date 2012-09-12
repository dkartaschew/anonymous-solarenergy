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


public class SPanelSOAPHandler {
	
	private static final String NAMESPACE_URI = "http://server.solar.anonymous.com/";
	private static final QName GET_ALL_PANELS = new QName(NAMESPACE_URI, "getPanels");
	private static final QName INSERT_PANEL = new QName(NAMESPACE_URI, "insertPanel");

	private MessageFactory messageFactory;
	private SPanelAdapter spanelAdapter;
	
	public SPanelSOAPHandler() throws SOAPException {
	    messageFactory = MessageFactory.newInstance();
	    spanelAdapter = new SPanelAdapter();
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
	          if (INSERT_PANEL.equals(qname)) {
	            responsePojo = handleInsertPanelRequest(soapElement);
	            break;
	          } else if (GET_ALL_PANELS.equals(qname)) {
	            responsePojo = handleGetPanelsRequest(soapElement);
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
	
	private Object handleInsertPanelRequest(SOAPElement soapElement) {
	    InsertPanel insertPanelRequest = JAXB.unmarshal(new DOMSource(soapElement), InsertPanel.class);	    
	    return spanelAdapter.insertPanel(insertPanelRequest);
	}

	private Object handleGetPanelsRequest(SOAPElement soapElement) {
		return spanelAdapter.getPanels();
	}

	
	
}

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
import com.anonymous.solar.server.jaxws.*;

public class LocationInformationSOAPHandler {

	private static final String NAMESPACE_URI = "http://server.solar.anonymous.com/";
	private static final QName GET_ALL_LOCATIONS_QNAME = new QName(NAMESPACE_URI, "StoreLocationGetAll");
	private static final QName STORE_LOCATION_QNAME = new QName(NAMESPACE_URI, "StoreLocationInformation");

	private MessageFactory messageFactory;
	private LocationInformationAdapter locationAdapter;

	public LocationInformationSOAPHandler() throws SOAPException {
		messageFactory = MessageFactory.newInstance();
		locationAdapter = new LocationInformationAdapter();
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
				if (GET_ALL_LOCATIONS_QNAME.equals(qname)) {
					responsePojo = handleLocationGetAll(soapElement);
					break;
				} else if (STORE_LOCATION_QNAME.equals(qname)) {
					responsePojo = handleStoreRequest(soapElement);
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
	
	private Object handleLocationGetAll(SOAPElement soapElement) {
	    return locationAdapter.getAllLocations();
	  }

	  private Object handleStoreRequest(SOAPElement soapElement) {
	    StoreLocationInformation request =
	        JAXB.unmarshal(new DOMSource(soapElement), StoreLocationInformation.class);
	    return locationAdapter.storeLocation(request);
	  }


}

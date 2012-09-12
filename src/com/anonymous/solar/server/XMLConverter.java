package com.anonymous.solar.server;

import java.io.File;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;

/**
 * 
 * This class is a generic XML converter, that convert objects to XML files and XML files back
 * to their respective Objects.
 * 
 * @author 07377495 Luke Durkan
 * @version 1.0
 *
 */
public class XMLConverter {

	public XMLConverter() {
		
	}
	
	public <T> File convertObjectToXML(Object object, Class<T> cl) {
		File file = new File("C:\\file.xml");
		
		try {
			JAXBContext jaxbContext = JAXBContext.newInstance(cl);
			Marshaller jaxbMarshaller = jaxbContext.createMarshaller();
	 
			jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
			jaxbMarshaller.marshal(object, file);
		
		} catch (JAXBException e) {
			
		}
		
		return file;
	}
	
	public <T> Class<T> convertXMLToObject(File file, Class<T> cl) {
		Class<T> returnObject = null;
		
		try {
			JAXBContext jaxbContext = JAXBContext.newInstance(cl);
			Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
			returnObject = (Class<T>) jaxbUnmarshaller.unmarshal(file);
		} catch (JAXBException e) {
		}
		
		return returnObject;
	}
}

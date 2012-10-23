package com.anonymous.solar.desktop;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.StringReader;
import java.io.StringWriter;
import java.io.UnsupportedEncodingException;

import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileFilter;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;

import com.anonymous.solar.shared.*;


public class FileService {

	/**
	 * Load a solar setup from the local computer. 
	 * Warning: This will return null if there is an error or the user chooses
	 * to cancel. You must allow for this.
	 * 
	 * @return SolarSetup or null
	 */
	public static SolarSetup LoadSetup(){
		FileInputStream fis = null;
		
		JFileChooser fc = new JFileChooser();
		fc.addChoosableFileFilter(new SSUFilter());
		

		int returnVal = fc.showDialog(new JFrame(), "Attach");

		File file = fc.getSelectedFile();

		try{
			if (returnVal == JFileChooser.APPROVE_OPTION) {
			
				fis = new FileInputStream(file);
				String xml = "";
		
				int content;
				while ((content = fis.read()) != -1) {
					// convert to char and display it
					xml += (char) content;
				}
				fis.close();
		
				final JAXBContext context = JAXBContext.newInstance(SolarSetup.class);
		
				// =============================================================================================================
				// Unmarshalling XML to OBJECT
				// =============================================================================================================
		
				// Create the unmarshaller, this is the nifty little thing that will
				// actually transform the XML back into an object
				final Unmarshaller unmarshaller = context.createUnmarshaller();
		
				// Unmarshal the XML in the stringWriter back into an object
				final SolarSetup setup = (SolarSetup) unmarshaller
						.unmarshal(new StringReader(xml));
		
				// Print out the contents of the JavaObject we just unmarshalled from
				// the XML
				//JOptionPane.showMessageDialog(new JFrame(), setup.toString());
				// JOptionPane.showMessageDialog(new JFrame(),
				// javaObject2.getSolarSetup().getSetupDescription());
		
				return setup;
	
			} else {
				return null;
			}
		} catch (Exception e) {
			JOptionPane.showMessageDialog(new JFrame(), "Your file cannot be loaded at this time.");
			return null;
		}

	}
	
	/**
	 * Load a solar result from the local computer. 
	 * Warning: This will return null if there is an error or the user chooses
	 * to cancel. You must allow for this.
	 * 
	 * @return SolarResult or null
	 */
	public static SolarResult LoadResult(){
		FileInputStream fis = null;
		
		JFileChooser fc = new JFileChooser();
		fc.addChoosableFileFilter(new SRUFilter());
		

		int returnVal = fc.showDialog(new JFrame(), "Attach");

		File file = fc.getSelectedFile();

		try{
			if (returnVal == JFileChooser.APPROVE_OPTION) {
			
				fis = new FileInputStream(file);
				String xml = "";
		
				int content;
				while ((content = fis.read()) != -1) {
					// convert to char and display it
					xml += (char) content;
				}
				fis.close();
		
				final JAXBContext context = JAXBContext.newInstance(SolarResult.class);
		
				// =============================================================================================================
				// Unmarshalling XML to OBJECT
				// =============================================================================================================
		
				// Create the unmarshaller, this is the nifty little thing that will
				// actually transform the XML back into an object
				final Unmarshaller unmarshaller = context.createUnmarshaller();
		
				// Unmarshal the XML in the stringWriter back into an object
				final SolarResult result = (SolarResult) unmarshaller
						.unmarshal(new StringReader(xml));
		
				// Print out the contents of the JavaObject we just unmarshalled from
				// the XML
				//JOptionPane.showMessageDialog(new JFrame(), setup.toString());
				// JOptionPane.showMessageDialog(new JFrame(),
				// javaObject2.getSolarSetup().getSetupDescription());
		
				return result;
	
			} else {
				return null;
			}
		} catch (Exception e) {
			return null;
		}

	}
	
	/**
	 * Save a SolarSetup to the local machine
	 * @throws JAXBException 
	 * @throws IOException 
	 */
	public static void SaveSetup(SolarSetup setup) throws JAXBException, IOException{
		JFileChooser fc = new JFileChooser();
		fc.addChoosableFileFilter(new SSUFilter());
		int returnVal;
		String fileName;
		FileOutputStream fos;
		int nameLength;
		int lastOccurence;

		// =============================================================================================================
		// Setup JAXB
		// =============================================================================================================

		// Create a JAXB context passing in the class of the object we want to
		// marshal/unmarshal
		final JAXBContext context = JAXBContext.newInstance(SolarSetup.class);

		// =============================================================================================================
		// Marshalling OBJECT to XML
		// =============================================================================================================

		// Create the marshaller, this is the nifty little thing that will
		// actually transform the object into XML
		final Marshaller marshaller = context.createMarshaller();

		// Create a stringWriter to hold the XML
		final StringWriter stringWriter = new StringWriter();

		// Marshal the javaObject and write the XML to the stringWriter
		marshaller.marshal(setup, stringWriter);

		// Print out the contents of the stringWriter
		// System.out.println(stringWriter.toString());
		// JOptionPane.showMessageDialog(new JFrame(), stringWriter.toString());

		returnVal = fc.showDialog(new JFrame(), "Save");

		if (returnVal == JFileChooser.APPROVE_OPTION) {

			fileName = fc.getSelectedFile().getName();
			nameLength = fileName.length();
			lastOccurence = fileName.lastIndexOf('.');
			
			//JOptionPane.showMessageDialog(new JFrame(), fileName);
			
			//Determine whether to add .html or not
			if(lastOccurence == -1){
			fos = new FileOutputStream(fc.getSelectedFile()
					+ ".ssu");
			} else {
				String extension = fileName.substring(lastOccurence, fileName.length());
				
				if (extension != null) {
		            if (extension.compareTo(".ssu") == 0) {
		            	fos = new FileOutputStream(fc.getSelectedFile());
		            } else {
		            	fos = new FileOutputStream(fc.getSelectedFile()
		    					+ ".ssu");
		            }
		        } else {
		        	fos = new FileOutputStream(fc.getSelectedFile()
							+ ".ssu");
		        }
			}
			

			OutputStreamWriter out = new OutputStreamWriter(fos, "UTF-8");
			out.write(stringWriter.toString());
			out.close();

		}

	}
	
	/**
	 * Save a solarResult to the local machine
	 * @param result
	 * @throws JAXBException, IOException 
	 */
	public static void SaveResult(SolarResult result) throws JAXBException, IOException{
		JFileChooser fc = new JFileChooser();
		fc.addChoosableFileFilter(new SRUFilter());
		int returnVal;
		String fileName;
		FileOutputStream fos;
		int nameLength;
		int lastOccurence;

		// =============================================================================================================
		// Setup JAXB
		// =============================================================================================================

		// Create a JAXB context passing in the class of the object we want to
		// marshal/unmarshal
		final JAXBContext context = JAXBContext.newInstance(SolarResult.class);

		// =============================================================================================================
		// Marshalling OBJECT to XML
		// =============================================================================================================

		// Create the marshaller, this is the nifty little thing that will
		// actually transform the object into XML
		final Marshaller marshaller = context.createMarshaller();

		// Create a stringWriter to hold the XML
		final StringWriter stringWriter = new StringWriter();

		// Marshal the javaObject and write the XML to the stringWriter
		marshaller.marshal(result, stringWriter);

		// Print out the contents of the stringWriter
		// System.out.println(stringWriter.toString());
		// JOptionPane.showMessageDialog(new JFrame(), stringWriter.toString());
		
		returnVal = fc.showDialog(new JFrame(), "Save");

		if (returnVal == JFileChooser.APPROVE_OPTION) {

			fileName = fc.getSelectedFile().getName();
			nameLength = fileName.length();
			lastOccurence = fileName.lastIndexOf('.');
			
			//JOptionPane.showMessageDialog(new JFrame(), fileName);
			
			//Determine whether to add .html or not
			if(lastOccurence == -1){
			fos = new FileOutputStream(fc.getSelectedFile()
					+ ".sru");
			} else {
				String extension = fileName.substring(lastOccurence, fileName.length());
				
				if (extension != null) {
		            if (extension.compareTo(".sru") == 0) {
		            	fos = new FileOutputStream(fc.getSelectedFile());
		            } else {
		            	fos = new FileOutputStream(fc.getSelectedFile()
		    					+ ".sru");
		            }
		        } else {
		        	fos = new FileOutputStream(fc.getSelectedFile()
							+ ".sru");
		        }
			}
			

			OutputStreamWriter out = new OutputStreamWriter(fos, "UTF-8");
			out.write(stringWriter.toString());
			out.close();

		}

	}
	
	private void Save(FileFilter filter, String extension, String content){
		
	}
}

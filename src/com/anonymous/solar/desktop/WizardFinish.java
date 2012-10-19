/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.anonymous.solar.desktop;

import java.io.FileOutputStream;
import java.io.OutputStreamWriter;
import java.io.StringReader;
import java.io.StringWriter;

import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;

import com.anonymous.solar.shared.SolarReport;
import com.anonymous.solar.shared.SolarResult;
import com.anonymous.solar.shared.SolarSetup;

import java.io.*;

import org.w3c.dom.*;
import javax.xml.parsers.*;
import javax.xml.transform.*;
import javax.xml.transform.dom.*;
import javax.xml.transform.stream.*;

/**
 *
 * @author darran
 */
public class WizardFinish extends javax.swing.JPanel implements WizardPanel {

    private final String title = "Complete";
    private Wizard parent = null;
    
    /**
     * Creates new form WizardFinish, with reference to parent
     */
    public WizardFinish(Wizard parent) {
        initComponents();
        this.parent = parent;
    }
    
    /**
     * Creates new form WizardFinish
     */
    public WizardFinish() {
        initComponents();
    }


    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabelFinishMsg = new javax.swing.JLabel();
        jButtonSaveConfiguration = new javax.swing.JButton();
        jButtonGenerateReport = new javax.swing.JButton();

        jLabelFinishMsg.setText("<html> <h1>Thank you</h1> <p>Thank you for using the Solar Energy Calculator.</p> <p>If you have any questions please do not hesitate to contact the development team.</p> </html>");

        jButtonSaveConfiguration.setText("Save Configuration");
        jButtonSaveConfiguration.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonSaveConfigurationActionPerformed(evt);
            }
        });

        jButtonGenerateReport.setText("Generate a report");
        jButtonGenerateReport.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonGenerateReportActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabelFinishMsg, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButtonSaveConfiguration)
                    .addComponent(jButtonGenerateReport))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabelFinishMsg, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jButtonSaveConfiguration)
                .addGap(18, 18, 18)
                .addComponent(jButtonGenerateReport)
                .addContainerGap(100, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonSaveConfigurationActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonSaveConfigurationActionPerformed
        // TODO add your handling code here:
    	try {
    		saveConfiguration();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }//GEN-LAST:event_jButtonSaveConfigurationActionPerformed

    private void jButtonGenerateReportActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonGenerateReportActionPerformed
    	try {
			saveHTMLReport();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }//GEN-LAST:event_jButtonGenerateReportActionPerformed
    
    private void saveConfiguration() throws Exception {
		JFileChooser fc = new JFileChooser();
		fc.addChoosableFileFilter(new SSUFilter());
		int returnVal;

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

		// Create the sample object we wish to transform into XML
		SolarSetup setup = parent.getSetup();

		// Marshal the javaObject and write the XML to the stringWriter
		marshaller.marshal(setup, stringWriter);

		// Print out the contents of the stringWriter
		// System.out.println(stringWriter.toString());
		// JOptionPane.showMessageDialog(new JFrame(), stringWriter.toString());

		returnVal = fc.showDialog(new JFrame(), "Save");

		if (returnVal == JFileChooser.APPROVE_OPTION) {

			FileOutputStream fos = new FileOutputStream(fc.getSelectedFile()
					+ ".ssu");
			OutputStreamWriter out = new OutputStreamWriter(fos, "UTF-8");
			out.write(stringWriter.toString());
			out.close();

		}

	}

    
    private void saveHTMLReport() throws Exception {
		JFileChooser fc = new JFileChooser();
		fc.addChoosableFileFilter(new HTMLFilter());
		int returnVal;
		
		SolarReport report = new SolarReport();

		report.addContent(parent.getResults());

		returnVal = fc.showDialog(new JFrame(), "Save");

		if (returnVal == JFileChooser.APPROVE_OPTION) {

			FileOutputStream fos = new FileOutputStream(fc.getSelectedFile()
					+ ".html");
			OutputStreamWriter out = new OutputStreamWriter(fos, "UTF-8");
			out.write(report.toString());
			out.close();

		}

	}

    

	public void MarshallExample() throws Exception {
		// =============================================================================================================
        // Setup JAXB
        // =============================================================================================================
 
        // Create a JAXB context passing in the class of the object we want to marshal/unmarshal
        final JAXBContext context = JAXBContext.newInstance(SolarResult.class);
 
        // =============================================================================================================
        // Marshalling OBJECT to XML
        // =============================================================================================================
 
        // Create the marshaller, this is the nifty little thing that will actually transform the object into XML
        final Marshaller marshaller = context.createMarshaller();
 
        // Create a stringWriter to hold the XML
        final StringWriter stringWriter = new StringWriter();
 
        // Create the sample object we wish to transform into XML
        final SolarResult result = parent.getResults();
 
        // Marshal the javaObject and write the XML to the stringWriter
        marshaller.marshal(result, stringWriter);
 
        // Print out the contents of the stringWriter
        //System.out.println(stringWriter.toString());
        //JOptionPane.showMessageDialog(new JFrame(), stringWriter.toString());
        
        FileOutputStream fos = new FileOutputStream("D:/actualSetup.xml");
		OutputStreamWriter out = new OutputStreamWriter(fos, "UTF-8"); 
		out.write(stringWriter.toString());
		out.close();
 
        // =============================================================================================================
        // Unmarshalling XML to OBJECT
        // =============================================================================================================
 
        // Create the unmarshaller, this is the nifty little thing that will actually transform the XML back into an object
        final Unmarshaller unmarshaller = context.createUnmarshaller();
 
        // Unmarshal the XML in the stringWriter back into an object
        final SolarResult javaObject2 = (SolarResult) unmarshaller.unmarshal(new StringReader(stringWriter.toString()));
 
        // Print out the contents of the JavaObject we just unmarshalled from the XML
        System.out.println(javaObject2.toString());
        //JOptionPane.showMessageDialog(new JFrame(), javaObject2.getSolarSetup().getSetupDescription());
	}


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonGenerateReport;
    private javax.swing.JButton jButtonSaveConfiguration;
    private javax.swing.JLabel jLabelFinishMsg;
    // End of variables declaration//GEN-END:variables


    /**
     * Callback method used by the parent panel to notify this panel that we
     * have been given context to the user.
     * @return true is ok to move.
     */
    @Override
    public boolean callbackStart() {
        return true;
    }

    /**
     * Callback method used by the parent panel to notify this panel that we
     * have requested a move away from this panel.
     * @return true is ok to move.
     */
    @Override
    public boolean callbackDispose(boolean validateInput) {
        return true;
    }

    /**
     * Return the title to be used for this wizard panel;
     * @return 
     */
    @Override
    public String getTitle() {
        return title;
    }
}

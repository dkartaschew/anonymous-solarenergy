/**
 * 
 */
package com.anonymous.solar.desktop;

import java.awt.BorderLayout;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.OutputStreamWriter;
import java.io.StringReader;
import java.io.StringWriter;

import javax.print.DocPrintJob;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;

import com.anonymous.solar.shared.SolarPanelsException;
import com.anonymous.solar.shared.SolarReport;
import com.anonymous.solar.shared.SolarReportException;
import com.anonymous.solar.shared.SolarResult;
import com.anonymous.solar.shared.SolarResultException;
import com.anonymous.solar.shared.SolarSetup;

/**
 * Main Entry Point for Desktop Application
 * 
 * @author 07627505 Darran Kartaschew
 * @version 1.0
 */
public class SolarApplication extends javax.swing.JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 7786544899511067111L;

	/**
	 * Creates new form SolarApplication
	 * @throws SolarResultException 
	 * @throws SolarPanelsException
	 */
	public SolarApplication() {
		initComponents();
		this.getContentPane().setLayout(new BorderLayout());
		this.getContentPane().add(new Wizard(this));

	}

	/**
	 * This method is called from within the constructor to initialize the form.
	 * WARNING: Do NOT modify this code. The content of this method is always
	 * regenerated by the Form Editor.
	 */
	@SuppressWarnings("unchecked")
	// <editor-fold defaultstate="collapsed"
	// desc="Generated Code">//GEN-BEGIN:initComponents
	private void initComponents() {

		menuMain = new javax.swing.JMenuBar();
		menuFile = new javax.swing.JMenu();
		menuFileExit = new javax.swing.JMenuItem();
		menuFileLoadConfig = new javax.swing.JMenuItem();
		menuFileSaveConfig = new javax.swing.JMenuItem();
		menuHelp = new javax.swing.JMenu();
		menuHelpAbout = new javax.swing.JMenuItem();

		setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);

		// Add listener to actually handle the shutdown of the application.
		addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent we) {
				confirmExit();
			}
		});

		setTitle("Solar Power Calculator");
		setResizable(false);

		menuFile.setText("File");

		menuFileExit.setAccelerator(javax.swing.KeyStroke.getKeyStroke(
				java.awt.event.KeyEvent.VK_F4,
				java.awt.event.InputEvent.ALT_MASK));
		menuFileExit.setIcon(new javax.swing.ImageIcon(getClass().getResource(
				"/com/anonymous/solar/desktop/images/window-close.png"))); // NOI18N
		menuFileExit.setText("Exit");
		menuFileExit.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				menuFileExitActionPerformed(evt);
			}
		});

		menuFileLoadConfig.setText("Load Configuration");
		menuFileLoadConfig
				.addActionListener(new java.awt.event.ActionListener() {
					public void actionPerformed(java.awt.event.ActionEvent evt) {
						menuFileLoadConfigActionPerformed(evt);
					}
				});

		menuFileSaveConfig.setText("Save Configuration");
		menuFileSaveConfig
				.addActionListener(new java.awt.event.ActionListener() {
					public void actionPerformed(java.awt.event.ActionEvent evt) {
						menuFileSaveConfigActionPerformed(evt);
					}
				});

		menuFile.add(menuFileSaveConfig);
		menuFile.add(menuFileLoadConfig);
		menuFile.add(menuFileExit);

		menuMain.add(menuFile);

		menuHelp.setText("Help");

		menuHelpAbout.setIcon(new javax.swing.ImageIcon(getClass().getResource(
				"/com/anonymous/solar/desktop/images/help-about.png"))); // NOI18N
		menuHelpAbout.setText("About");
		menuHelpAbout.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				menuHelpAboutActionPerformed(evt);
			}
		});
		menuHelp.add(menuHelpAbout);

		menuMain.add(menuHelp);

		setJMenuBar(menuMain);

		javax.swing.GroupLayout layout = new javax.swing.GroupLayout(
				getContentPane());
		getContentPane().setLayout(layout);
		layout.setHorizontalGroup(layout.createParallelGroup(
				javax.swing.GroupLayout.Alignment.LEADING).addGap(0, 780,
				Short.MAX_VALUE));
		layout.setVerticalGroup(layout.createParallelGroup(
				javax.swing.GroupLayout.Alignment.LEADING).addGap(0, 457,
				Short.MAX_VALUE));

		pack();
	}// </editor-fold>//GEN-END:initComponents

	private void confirmExit() {
		int n = JOptionPane.showConfirmDialog(this,
				"Are you sure you want to exit?", "Exit Confirmation",
				JOptionPane.YES_NO_OPTION);
		if (n == JOptionPane.YES_OPTION) {
			this.dispose();
			System.exit(0);
		}
	}

	private void loadConfiguration(File file) throws Exception {

		FileInputStream fis = null;
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

		Wizard wizard = (Wizard) this.getContentPane().getComponent(0);
		wizard.setSetup(setup);
		
	}

	private void saveConfiguration() throws Exception {
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

		// Create the sample object we wish to transform into XML
		Wizard abc = (Wizard) this.getContentPane().getComponent(0);
		SolarSetup setup = abc.getSetup();

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

	private void menuFileExitActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_menuFileExitActionPerformed
		confirmExit();
	}// GEN-LAST:event_menuFileExitActionPerformed

	private void menuFileLoadConfigActionPerformed(
			java.awt.event.ActionEvent evt) {// GEN-FIRST:event_menuFileExitActionPerformed
		JFileChooser fc = new JFileChooser();
		fc.addChoosableFileFilter(new SSUFilter());

		int returnVal = fc.showDialog(new JFrame(), "Attach");

		File file = fc.getSelectedFile();

		if (returnVal == JFileChooser.APPROVE_OPTION) {
			try {
				loadConfiguration(file);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}// GEN-LAST:event_menuFileExitActionPerformed

	private void menuFileSaveConfigActionPerformed(
			java.awt.event.ActionEvent evt) {// GEN-FIRST:event_menuFileExitActionPerformed
		try {
			saveConfiguration();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}// GEN-LAST:event_menuFileExitActionPerformed

	private void menuHelpAboutActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_menuHelpAboutActionPerformed
		AboutDialog dialog = new AboutDialog(this, true);
		dialog.setVisible(true);
	}// GEN-LAST:event_menuHelpAboutActionPerformed

	/**
	 * @param args
	 *            the command line arguments
	 */
	public static void main(String args[]) {
		/* Set the GTK+ look and feel */
		// <editor-fold defaultstate="collapsed"
		// desc=" Look and feel setting code (optional) ">
		/*
		 * If Nimbus (introduced in Java SE 6) is not available, stay with the
		 * default look and feel. For details see
		 * http://download.oracle.com/javase
		 * /tutorial/uiswing/lookandfeel/plaf.html
		 */
		try {
			for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager
					.getInstalledLookAndFeels()) {
				if ("Nimbus".equals(info.getName())) {
					javax.swing.UIManager.setLookAndFeel(info.getClassName());
					break;
				}
			}
		} catch (ClassNotFoundException ex) {
			java.util.logging.Logger
					.getLogger(SolarApplication.class.getName()).log(
							java.util.logging.Level.SEVERE, null, ex);
		} catch (InstantiationException ex) {
			java.util.logging.Logger
					.getLogger(SolarApplication.class.getName()).log(
							java.util.logging.Level.SEVERE, null, ex);
		} catch (IllegalAccessException ex) {
			java.util.logging.Logger
					.getLogger(SolarApplication.class.getName()).log(
							java.util.logging.Level.SEVERE, null, ex);
		} catch (javax.swing.UnsupportedLookAndFeelException ex) {
			java.util.logging.Logger
					.getLogger(SolarApplication.class.getName()).log(
							java.util.logging.Level.SEVERE, null, ex);
		}
		// </editor-fold>

		/* Create and display the form */
		java.awt.EventQueue.invokeLater(new Runnable() {
			public void run() {

				new SolarApplication().setVisible(true);

			}
		});
	}

	// Variables declaration - do not modify//GEN-BEGIN:variables
	private javax.swing.JMenu menuFile;
	private javax.swing.JMenuItem menuFileExit;
	private javax.swing.JMenuItem menuFileLoadConfig;
	private javax.swing.JMenuItem menuFileSaveConfig;
	private javax.swing.JMenu menuHelp;
	private javax.swing.JMenuItem menuHelpAbout;
	private javax.swing.JMenuBar menuMain;
	// End of variables declaration//GEN-END:variables
}

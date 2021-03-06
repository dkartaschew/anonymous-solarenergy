/*
 *
 */
package com.anonymous.solar.desktop;

import java.awt.Color;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import com.anonymous.solar.shared.SolarInverter;
import com.anonymous.solar.shared.SolarSetup;
import com.anonymous.solar.shared.SolarSetupException;

/**
 * Wizard Panel that displays the electrical setup for the solar setup.
 * 
 * @author 07627505 Darran Kartaschew
 * @version 1.0
 */

public class WizardSetupElectrical extends javax.swing.JPanel implements WizardPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = -7975980174740559955L;

	private final String title = "Electrical Setup";

	private Wizard parent = null;

	SolarInverter inverter = null;

	/**
	 * Creates new form WizardFinish, with reference to parent
	 */
	public WizardSetupElectrical(Wizard parent) {
		initComponents();
		nameComponents();
		this.parent = parent;
	}

	/**
	 * Creates new form WizardSetupElectrical
	 */
	public WizardSetupElectrical() {
		initComponents();
		nameComponents();
	}

	/**
	 * Names components for GUI Testing
	 */
	private void nameComponents() {
		jTextFieldInverter.setName("TextFieldInverter");
		jButtonSetInverter.setName("EditInverterDetails");
		jSpinnerWiringLength.setName("SpinnerWiringLength");
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

		jPanelElectricalGroup = new javax.swing.JPanel();
		jLabelInverter = new javax.swing.JLabel();
		jTextFieldInverter = new javax.swing.JTextField();
		jButtonSetInverter = new javax.swing.JButton();
		jLabelInverterHeader = new javax.swing.JLabel();
		jLabelInverterDetails = new javax.swing.JLabel();
		jPanel1 = new javax.swing.JPanel();
		jLabelWiringLength = new javax.swing.JLabel();
		jLabelWiringEfficiency = new javax.swing.JLabel();
		jSpinnerWiringLength = new javax.swing.JSpinner();
		jSpinnerWiringEfficiency = new javax.swing.JSpinner();

		jPanelElectricalGroup.setBorder(javax.swing.BorderFactory.createTitledBorder("Inverter"));

		jLabelInverter.setText("Inverter:");

		jTextFieldInverter.setEditable(false);
		jTextFieldInverter.setToolTipText("Press the button to the right to create an inverter");

		jButtonSetInverter.setText("...");
		jButtonSetInverter.setToolTipText("Select to create an inverter");
		jButtonSetInverter.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				jButtonSetInverterActionPerformed(evt);
			}
		});

		jLabelInverterHeader.setText("Inverter Details:");

		jLabelInverterDetails.setText("<unknown>");

		javax.swing.GroupLayout jPanelElectricalGroupLayout = new javax.swing.GroupLayout(jPanelElectricalGroup);
		jPanelElectricalGroup.setLayout(jPanelElectricalGroupLayout);
		jPanelElectricalGroupLayout.setHorizontalGroup(jPanelElectricalGroupLayout.createParallelGroup(
				javax.swing.GroupLayout.Alignment.LEADING).addGroup(
				jPanelElectricalGroupLayout
						.createSequentialGroup()
						.addContainerGap()
						.addGroup(
								jPanelElectricalGroupLayout
										.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
										.addComponent(jLabelInverter).addComponent(jLabelInverterHeader))
						.addGap(26, 26, 26)
						.addGroup(
								jPanelElectricalGroupLayout
										.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
										.addGroup(
												jPanelElectricalGroupLayout
														.createSequentialGroup()
														.addComponent(jTextFieldInverter,
																javax.swing.GroupLayout.DEFAULT_SIZE, 408,
																Short.MAX_VALUE)
														.addPreferredGap(
																javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
														.addComponent(jButtonSetInverter))
										.addGroup(
												jPanelElectricalGroupLayout.createSequentialGroup()
														.addComponent(jLabelInverterDetails)
														.addGap(0, 0, Short.MAX_VALUE))).addContainerGap()));
		jPanelElectricalGroupLayout.setVerticalGroup(jPanelElectricalGroupLayout.createParallelGroup(
				javax.swing.GroupLayout.Alignment.LEADING).addGroup(
				jPanelElectricalGroupLayout
						.createSequentialGroup()
						.addContainerGap()
						.addGroup(
								jPanelElectricalGroupLayout
										.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
										.addComponent(jLabelInverter)
										.addComponent(jTextFieldInverter, javax.swing.GroupLayout.PREFERRED_SIZE,
												javax.swing.GroupLayout.DEFAULT_SIZE,
												javax.swing.GroupLayout.PREFERRED_SIZE)
										.addComponent(jButtonSetInverter))
						.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
						.addGroup(
								jPanelElectricalGroupLayout
										.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
										.addComponent(jLabelInverterHeader).addComponent(jLabelInverterDetails))
						.addContainerGap(32, Short.MAX_VALUE)));

		jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Wiring"));

		jLabelWiringLength.setText("Wiring Length (m):");

		jLabelWiringEfficiency.setText("Wiring Efficiency (%):");
		jLabelWiringEfficiency.setToolTipText("");

		jSpinnerWiringLength.setModel(new javax.swing.SpinnerNumberModel(0.0d, 0.0d, 1000.0d, 1.0d));
		jSpinnerWiringLength.setToolTipText("Enter the length of the wiring to be used (in metres)");
		jSpinnerWiringEfficiency.setModel(new javax.swing.SpinnerNumberModel(99.0d, 0.0d, 100.0d, 0.1d));
		jSpinnerWiringEfficiency.setToolTipText("Enter the efficiency (%) of the wire used");

		javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
		jPanel1.setLayout(jPanel1Layout);
		jPanel1Layout.setHorizontalGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(
						jPanel1Layout.createSequentialGroup().addContainerGap().addComponent(jLabelWiringLength)
								.addGap(35, 35, 35).addComponent(jSpinnerWiringLength)
								.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
								.addComponent(jLabelWiringEfficiency).addGap(21, 21, 21)
								.addComponent(jSpinnerWiringEfficiency).addContainerGap()));
		jPanel1Layout.setVerticalGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(
						jPanel1Layout
								.createSequentialGroup()
								.addContainerGap()
								.addGroup(
										jPanel1Layout
												.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
												.addComponent(jLabelWiringLength)
												.addComponent(jSpinnerWiringLength,
														javax.swing.GroupLayout.PREFERRED_SIZE,
														javax.swing.GroupLayout.DEFAULT_SIZE,
														javax.swing.GroupLayout.PREFERRED_SIZE)
												.addComponent(jLabelWiringEfficiency)
												.addComponent(jSpinnerWiringEfficiency,
														javax.swing.GroupLayout.PREFERRED_SIZE,
														javax.swing.GroupLayout.DEFAULT_SIZE,
														javax.swing.GroupLayout.PREFERRED_SIZE))
								.addContainerGap(16, Short.MAX_VALUE)));

		javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
		this.setLayout(layout);
		layout.setHorizontalGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addGroup(
				javax.swing.GroupLayout.Alignment.TRAILING,
				layout.createSequentialGroup()
						.addContainerGap()
						.addGroup(
								layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
										.addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE,
												javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
										.addComponent(jPanelElectricalGroup, javax.swing.GroupLayout.DEFAULT_SIZE,
												javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
						.addContainerGap()));
		layout.setVerticalGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addGroup(
				layout.createSequentialGroup()
						.addContainerGap()
						.addComponent(jPanelElectricalGroup, javax.swing.GroupLayout.PREFERRED_SIZE,
								javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
						.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
						.addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE,
								javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
						.addContainerGap(89, Short.MAX_VALUE)));
	}// </editor-fold>//GEN-END:initComponents
		// Variables declaration - do not modify//GEN-BEGIN:variables

	private javax.swing.JButton jButtonSetInverter;
	private javax.swing.JLabel jLabelInverter;
	private javax.swing.JLabel jLabelInverterDetails;
	private javax.swing.JLabel jLabelInverterHeader;
	private javax.swing.JLabel jLabelWiringEfficiency;
	private javax.swing.JLabel jLabelWiringLength;
	private javax.swing.JPanel jPanel1;
	private javax.swing.JPanel jPanelElectricalGroup;
	private javax.swing.JTextField jTextFieldInverter;
	private javax.swing.JSpinner jSpinnerWiringLength;
	private javax.swing.JSpinner jSpinnerWiringEfficiency;

	// End of variables declaration//GEN-END:variables

	/**
	 * Callback method used by the parent panel to notify this panel that we
	 * have been given context to the user.
	 * 
	 * @return true is ok to move.
	 */
	@Override
	public boolean callbackStart() {
		SolarSetup global = parent.getSetup();
		if (global != null) {
			// Get our inverter.
			inverter = global.getInverter();
			if (inverter != null) {
				// set the text fields.
				jTextFieldInverter.setText(inverter.getInverterName());
				jButtonSetInverter.setText("Edit");
				jLabelInverterDetails.setText(inverter.toString(true));
			}
			// Set the wiring length, etc.
			jSpinnerWiringLength.setValue(global.getWireLength());
			jSpinnerWiringEfficiency.setValue(global.getWireEfficiency());
		}
		return true;
	}

	/**
	 * Clear all the error effects from text boxes and jSpinners
	 */
	private void returnToWhite() {
		javax.swing.border.LineBorder clear = new javax.swing.border.LineBorder(Color.white, 0);
		jButtonSetInverter.setBackground(Color.white);
		jSpinnerWiringLength.setBorder(clear);
	}

	/**
	 * Callback method used by the parent panel to notify this panel that we
	 * have requested a move away from this panel.
	 * 
	 * @return true is ok to move.
	 */
	@Override
	public boolean callbackDispose(boolean validateInput) {
		javax.swing.border.LineBorder borderError = new javax.swing.border.LineBorder(Color.red, 3);
		returnToWhite();

		if (validateInput) {
			if (inverter.getInverterName().trim().compareTo("") == 0) {
				jButtonSetInverter.setBackground(Color.red);
				// Oops, missing data, need to handle this.
				JOptionPane.showMessageDialog(this,
						"You are missing inverter details. Please enter these to continue.",
						"Inverter Details Missing", JOptionPane.OK_OPTION);
				return false;
			} else if (((Double) jSpinnerWiringLength.getValue()) == 0) {
				jSpinnerWiringLength.setBorder(borderError);
				return false;
			}
		}
		// Set our parent's global data based on our form!
		SolarSetup global = parent.getSetup();
		if (global != null) {
			try {
				global.setWireLength((Double) jSpinnerWiringLength.getValue());
				global.setWireEfficiency((Double) jSpinnerWiringEfficiency.getValue());
				if (inverter != null) {
					global.setInverter(inverter);
				}
			} catch (SolarSetupException e) {
				// Oops, missing data, need to handle this.
				JOptionPane.showMessageDialog(this,
						"You have invalid inverter or wiring details. Please correct these to continue.",
						"Inverter Details Invalid", JOptionPane.OK_OPTION);
				return false;
			}
		}
		return true;
	}

	/**
	 * Return the title to be used for this wizard panel;
	 * 
	 * @return
	 */
	@Override
	public String getTitle() {
		return title;
	}

	private void jButtonSetInverterActionPerformed(java.awt.event.ActionEvent evt) {
		AddNewInverter invert = new AddNewInverter(this);

		invert.setVisible(true);

		if (inverter != null) {
			jTextFieldInverter.setText(inverter.getInverterName());
			jButtonSetInverter.setText("Edit");
			jLabelInverterDetails.setText(inverter.toString(true));
		}
	}
}

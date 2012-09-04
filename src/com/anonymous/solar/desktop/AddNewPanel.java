/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.anonymous.solar.desktop;

//import com.anonymous.solar.shared.SolarPanel;

import java.awt.Color;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import com.anonymous.solar.shared.SolarPanel;
import com.anonymous.solar.shared.SolarPanels;


/**
 *
 * @author Thura
 */
@SuppressWarnings("serial")
public class AddNewPanel extends javax.swing.JDialog {

	
	private WizardSetupSolarPanels parent;
	private int location = -1;
    /**
     * Creates new form AddNewPanel
     */
    public AddNewPanel(WizardSetupSolarPanels parent, boolean modal, Integer location) {
        super(new JFrame(), true);
        initComponents();
        nameComponents();
        this.parent = parent;
        this.setModal(true);
        
        if(location != null){
        	this.location = location;
        	LoadPanels(this.parent.panels.get(location));
        }
    }
    
    /**
     * Names components for GUI testing
     */
    private void nameComponents() {
    	txtName.setName("TextFieldSolarPanelName");
    	txtManufacturer.setName("TextFieldSolarPanelManufacturerName");
    	txtCode.setName("TextFieldSolarPanelManufacturerCode");
    	
    	jSpinnerWattage.setName("SpinnerSolarPanelWattage");
    	jSpinnerLife.setName("SpinnerSolarPanelLife");
    	jSpinnerCost.setName("SpinnerSolarPanelCost");
    	jSpinnerRRP.setName("SpinnerSolarPanelRRP");
    	jSpinnerEfficiency.setName("SpinnerSolarPanelEfficiency");
    	
    	jSpinnerPanelCount.setName("SpinnerSolarPanelCount");
    	jSpinnerAzimuth.setName("SpinnerSolarPanelAzimuth");
    	jSpinnerDirection.setName("SpinnerSolarPanelDirection");
    }
    
    /*
     * Solar Panel
     */
    SolarPanels newPanels;
    
    /**
     * A return status code - returned if Cancel button has been pressed
     */
    public static final int RET_CANCEL = 0;
    /**
     * A return status code - returned if OK button has been pressed
     */
    public static final int RET_OK = 1;

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnCancel = new javax.swing.JButton();
        btnSubmit = new javax.swing.JButton();
        lblError = new javax.swing.JLabel();
        jPanelDataGroup = new javax.swing.JPanel();
        lblName = new javax.swing.JLabel();
        lblCost = new javax.swing.JLabel();
        lblCode = new javax.swing.JLabel();
        lblEfficiency = new javax.swing.JLabel();
        txtName = new javax.swing.JTextField();
        txtName.setToolTipText("Enter a name of the panel(s)");
        lblLife = new javax.swing.JLabel();
        lblWattage = new javax.swing.JLabel();
        lblRRP = new javax.swing.JLabel();
        txtManufacturer = new javax.swing.JTextField();
        txtManufacturer.setToolTipText("Enter the manufacturer of the panel(s)");
        txtCode = new javax.swing.JTextField();
        txtCode.setToolTipText("Enter the unique identifier code of the panel(s)");
        lblManufacturer = new javax.swing.JLabel();
        jSpinnerLife = new javax.swing.JSpinner();
        jSpinnerLife.setToolTipText("Enter the expected life of the panel(s)");
        jSpinnerWattage = new javax.swing.JSpinner();
        jSpinnerCost = new javax.swing.JSpinner();
        jSpinnerRRP = new javax.swing.JSpinner();
        jSpinnerEfficiency = new javax.swing.JSpinner();
        jPanelPanelLocationGroup = new javax.swing.JPanel();
        lblCount = new javax.swing.JLabel();
        lblAzimuth = new javax.swing.JLabel();
        lblDirection = new javax.swing.JLabel();
        jSpinnerPanelCount = new javax.swing.JSpinner();
        jSpinnerAzimuth = new javax.swing.JSpinner();
        jSpinnerDirection = new javax.swing.JSpinner();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Add Panel Set");
        setName("dialogAddPanel"); // NOI18N
        setResizable(false);

        btnCancel.setText("Cancel");
        btnCancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelActionPerformed(evt);
            }
        });

        btnSubmit.setText("Submit");
        btnSubmit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
 
				btnSubmitActionPerformed(evt);
            }
        });

        lblError.setText(".");

        jPanelDataGroup.setBorder(javax.swing.BorderFactory.createTitledBorder("Panel Data"));
        jPanelDataGroup.setName("Panel Details"); // NOI18N

        lblName.setText("Name");

        lblCost.setText("Cost");

        lblCode.setText("Code");

        lblEfficiency.setText("Efficiency");

        lblLife.setText("Life");

        lblWattage.setText("Wattage");

        lblRRP.setText("RRP");

        lblManufacturer.setText("Manufacturer");

        jSpinnerLife.setModel(new javax.swing.SpinnerNumberModel(25, 0, 50, 5));

        jSpinnerWattage.setModel(new javax.swing.SpinnerNumberModel(100.0d, 0.0d, 1000.0d, 5.0d));

        jSpinnerCost.setModel(new javax.swing.SpinnerNumberModel(0.0d, 0.0d, 25000.0d, 10.0d));

        jSpinnerRRP.setModel(new javax.swing.SpinnerNumberModel(0.0d, 0.0d, 25000.0d, 10.0d));

        jSpinnerEfficiency.setModel(new javax.swing.SpinnerNumberModel(0.0d, 0.0d, 100.0d, 1.0d));

        javax.swing.GroupLayout jPanelDataGroupLayout = new javax.swing.GroupLayout(jPanelDataGroup);
        jPanelDataGroup.setLayout(jPanelDataGroupLayout);
        jPanelDataGroupLayout.setHorizontalGroup(
            jPanelDataGroupLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelDataGroupLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanelDataGroupLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanelDataGroupLayout.createSequentialGroup()
                        .addComponent(lblName)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(txtName, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanelDataGroupLayout.createSequentialGroup()
                        .addGroup(jPanelDataGroupLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblManufacturer)
                            .addComponent(lblCode)
                            .addComponent(lblWattage))
                        .addGap(53, 53, 53)
                        .addGroup(jPanelDataGroupLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(txtCode)
                            .addComponent(jSpinnerWattage, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 120, Short.MAX_VALUE)
                            .addComponent(txtManufacturer, javax.swing.GroupLayout.Alignment.LEADING))))
                .addGap(18, 18, 18)
                .addGroup(jPanelDataGroupLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblRRP)
                    .addComponent(lblCost)
                    .addComponent(lblLife)
                    .addComponent(lblEfficiency))
                .addGap(25, 25, 25)
                .addGroup(jPanelDataGroupLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jSpinnerCost, javax.swing.GroupLayout.DEFAULT_SIZE, 120, Short.MAX_VALUE)
                    .addComponent(jSpinnerLife)
                    .addComponent(jSpinnerRRP)
                    .addComponent(jSpinnerEfficiency))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanelDataGroupLayout.setVerticalGroup(
            jPanelDataGroupLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelDataGroupLayout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addGroup(jPanelDataGroupLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanelDataGroupLayout.createSequentialGroup()
                        .addGroup(jPanelDataGroupLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblLife)
                            .addComponent(txtName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jSpinnerLife, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jSpinnerCost, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jSpinnerRRP, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanelDataGroupLayout.createSequentialGroup()
                        .addGroup(jPanelDataGroupLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanelDataGroupLayout.createSequentialGroup()
                                .addGap(4, 4, 4)
                                .addComponent(lblName)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(jPanelDataGroupLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(txtManufacturer, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(lblManufacturer)))
                            .addComponent(lblCost, javax.swing.GroupLayout.Alignment.TRAILING))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanelDataGroupLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanelDataGroupLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(txtCode, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(lblCode))
                            .addComponent(lblRRP, javax.swing.GroupLayout.Alignment.TRAILING))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanelDataGroupLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblWattage)
                            .addComponent(jSpinnerWattage, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblEfficiency)
                            .addComponent(jSpinnerEfficiency, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(18, Short.MAX_VALUE))
        );

        jPanelPanelLocationGroup.setBorder(javax.swing.BorderFactory.createTitledBorder("Location Data"));

        lblCount.setText("Panel Count");

        lblAzimuth.setText("Azimuth");

        lblDirection.setText("Direction");

        jSpinnerPanelCount.setModel(new javax.swing.SpinnerNumberModel(0, 0, 100, 5));

        jSpinnerAzimuth.setModel(new javax.swing.SpinnerNumberModel(0.0d, -180.0d, 180.0d, 1.0d));

        jSpinnerDirection.setModel(new javax.swing.SpinnerNumberModel(0.0d, 0.0d, 359.0d, 10.0d));

        javax.swing.GroupLayout jPanelPanelLocationGroupLayout = new javax.swing.GroupLayout(jPanelPanelLocationGroup);
        jPanelPanelLocationGroup.setLayout(jPanelPanelLocationGroupLayout);
        jPanelPanelLocationGroupLayout.setHorizontalGroup(
            jPanelPanelLocationGroupLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelPanelLocationGroupLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanelPanelLocationGroupLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(lblAzimuth, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lblCount, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(60, 60, 60)
                .addGroup(jPanelPanelLocationGroupLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jSpinnerPanelCount)
                    .addComponent(jSpinnerAzimuth, javax.swing.GroupLayout.DEFAULT_SIZE, 120, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addComponent(lblDirection, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSpinnerDirection, javax.swing.GroupLayout.DEFAULT_SIZE, 117, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanelPanelLocationGroupLayout.setVerticalGroup(
            jPanelPanelLocationGroupLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelPanelLocationGroupLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanelPanelLocationGroupLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblCount)
                    .addComponent(jSpinnerPanelCount, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanelPanelLocationGroupLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblAzimuth)
                    .addComponent(jSpinnerAzimuth, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblDirection)
                    .addComponent(jSpinnerDirection, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(15, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanelDataGroup, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jPanelPanelLocationGroup, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                            .addComponent(lblError, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGap(18, 18, 18)
                            .addComponent(btnCancel)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addComponent(btnSubmit))))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanelDataGroup, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanelPanelLocationGroup, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnSubmit)
                    .addComponent(btnCancel)
                    .addComponent(lblError))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanelDataGroup.getAccessibleContext().setAccessibleName("sdfsdf");
        jPanelDataGroup.getAccessibleContext().setAccessibleDescription("");

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnSubmitActionPerformed(java.awt.event.ActionEvent evt){//GEN-FIRST:event_btnSubmitActionPerformed
    	boolean success = submitPanelData();
    	
    	if(success){
            doClose();
    	} else {
    		lblError.setText("Error! Please review your input!");
    	}
    }//GEN-LAST:event_btnSubmitActionPerformed

    private void btnCancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelActionPerformed
        doClose();
    }//GEN-LAST:event_btnCancelActionPerformed

    private void doClose() {
        setVisible(false);
    }
    
    /**
     * Load the dialog with current values.
     * @param oldPanels 
     */
    private void LoadPanels(SolarPanels oldPanels){
    	
    	if(oldPanels != null){
	        txtName.setText(oldPanels.getPanelType().getPanelName());
	        txtManufacturer.setText(oldPanels.getPanelType().getPanelManufacturer());
	        txtCode.setText(oldPanels.getPanelType().getPanelManufacturerCode());
	        jSpinnerWattage.setValue(oldPanels.getPanelType().getPanelWattage());
	        jSpinnerCost.setValue(oldPanels.getPanelType().getPanelCost());
	        jSpinnerRRP.setValue(oldPanels.getPanelType().getPanelRRP());
	        jSpinnerLife.setValue(oldPanels.getPanelType().getPanelLifeYears());
	        jSpinnerEfficiency.setValue(oldPanels.getPanelType().getPanelLossYear());
	        jSpinnerDirection.setValue(oldPanels.getPanelDirection());
	        jSpinnerPanelCount.setValue(oldPanels.getPanelCount());
	        jSpinnerAzimuth.setValue(oldPanels.getPanelAzimuth());
    	}
    }
    
    private void returnToWhite(){
    	javax.swing.border.LineBorder clear = new javax.swing.border.LineBorder(Color.white, 0);
    	
    	txtName.setBackground(Color.white);
        txtManufacturer.setBackground(Color.white);
        txtCode.setBackground(Color.white);
        jSpinnerWattage.setBackground(Color.white);
        jSpinnerCost.setBackground(Color.white);
        jSpinnerRRP.setBackground(Color.white);
        jSpinnerLife.setBorder(clear);
        jSpinnerEfficiency.setBorder(clear);
        jSpinnerDirection.setBorder(clear);
        jSpinnerPanelCount.setBorder(clear);
        jSpinnerAzimuth.setBorder(clear);
    }
    
    /**
     * Submit the panel information
     * @return 
     * @throws Exception 
     */
    private boolean submitPanelData(){
        SolarPanel panel = new SolarPanel();
    	Integer panelCount;
    	Double panelDirection;
    	Double panelAzimuth;
    	boolean error = false;
    	javax.swing.border.LineBorder borderError = new javax.swing.border.LineBorder(Color.red, 3);
    	
    	returnToWhite();
    	
        try {
        	if(txtName.getText().equals("") == true){
        		error = true;
        		txtName.setBackground(Color.red);
        	}
            if(txtManufacturer.getText().equals("") == true){
        		error = true;
            	txtManufacturer.setBackground(Color.red);
            }
            if(txtCode.getText().equals("") == true){
        		error = true;
            	txtCode.setBackground(Color.red);
            } 
        	if((Double)jSpinnerCost.getModel().getValue() == 0){
        		error = true;
        		jSpinnerCost.setBorder(borderError);
            }
            
            if((Integer)jSpinnerPanelCount.getModel().getValue() == 0){
        		error = true;
            	jSpinnerPanelCount.setBorder(borderError);
            }
            
            if(error){
            	throw new Exception();
            }
                //panel data
                panel.setPanelName(txtName.getText());
                panel.setPanelManufacturer(txtManufacturer.getText());
                panel.setPanelManufacturerCode(txtCode.getText());
                panel.setPanelWattage((Double)jSpinnerWattage.getModel().getValue());
                panel.setPanelCost((Double)jSpinnerCost.getModel().getValue());
                panel.setPanelLossYear((Double)jSpinnerEfficiency.getModel().getValue());
                panel.setPanelRRP((Double)jSpinnerRRP.getModel().getValue());
                panel.setPanelLifeYears((Integer)jSpinnerLife.getModel().getValue());

                //location data
                panelCount = (Integer)jSpinnerPanelCount.getModel().getValue();
                panelDirection = (Double)jSpinnerDirection.getModel().getValue();
                panelAzimuth = (Double)jSpinnerAzimuth.getModel().getValue();
                
                //Generate Panel(s)
                newPanels = new SolarPanels(panel, panelCount, panelDirection, panelAzimuth);
               
                //location set, update panel
                if(location > -1){
                	this.parent.panels.remove(location);
                	this.parent.panels.add(location, newPanels);
                } else {
                //else, add the new panel to the end of the list
                	this.parent.panels.add(newPanels);
                }
                
                return true;
        	
        } catch (Exception e) {
                // Oops, something went wrong, let the client know.
                return false;
        }
    }
    
    /**
     * @param args the command line arguments
     */
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCancel;
    private javax.swing.JButton btnSubmit;
    private javax.swing.JPanel jPanelDataGroup;
    private javax.swing.JPanel jPanelPanelLocationGroup;
    private javax.swing.JSpinner jSpinnerAzimuth;
    private javax.swing.JSpinner jSpinnerCost;
    private javax.swing.JSpinner jSpinnerDirection;
    private javax.swing.JSpinner jSpinnerEfficiency;
    private javax.swing.JSpinner jSpinnerLife;
    private javax.swing.JSpinner jSpinnerPanelCount;
    private javax.swing.JSpinner jSpinnerRRP;
    private javax.swing.JSpinner jSpinnerWattage;
    private javax.swing.JLabel lblAzimuth;
    private javax.swing.JLabel lblCode;
    private javax.swing.JLabel lblCost;
    private javax.swing.JLabel lblCount;
    private javax.swing.JLabel lblDirection;
    private javax.swing.JLabel lblEfficiency;
    private javax.swing.JLabel lblError;
    private javax.swing.JLabel lblLife;
    private javax.swing.JLabel lblManufacturer;
    private javax.swing.JLabel lblName;
    private javax.swing.JLabel lblRRP;
    private javax.swing.JLabel lblWattage;
    private javax.swing.JTextField txtCode;
    private javax.swing.JTextField txtManufacturer;
    private javax.swing.JTextField txtName;
    // End of variables declaration//GEN-END:variables

}


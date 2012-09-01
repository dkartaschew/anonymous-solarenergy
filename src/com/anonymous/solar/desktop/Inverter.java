/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.anonymous.solar.desktop;

//import com.anonymous.solar.shared.SolarPanel;

import com.anonymous.solar.shared.SolarInverter;


/**
 *
 * @author Thura
 */
@SuppressWarnings("serial")
public class Inverter extends javax.swing.JDialog {

    /**
     * Creates new form AddNewPanel
     */
    public Inverter(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
    }
    /*
     * Solar Inverter
     */
    SolarInverter inverter;
   

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
        jPanel1 = new javax.swing.JPanel();
        lblWattage = new javax.swing.JLabel();
        lblEfficiency = new javax.swing.JLabel();
        lblLoss = new javax.swing.JLabel();
        lblLife = new javax.swing.JLabel();
        jSpinnerWattage = new javax.swing.JSpinner();
        jSpinnerLife = new javax.swing.JSpinner();
        jSpinnerEfficiency = new javax.swing.JSpinner();
        jSpinnerEffLossYr = new javax.swing.JSpinner();
        jPanel2 = new javax.swing.JPanel();
        lblName = new javax.swing.JLabel();
        txtName = new javax.swing.JTextField();
        lblCost = new javax.swing.JLabel();
        jSpinnerCost = new javax.swing.JSpinner();
        txtManufacturer = new javax.swing.JTextField();
        lblManufacturer = new javax.swing.JLabel();
        lblRRP = new javax.swing.JLabel();
        jSpinnerRRP = new javax.swing.JSpinner();
        txtCode = new javax.swing.JTextField();
        lblCode = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Inverter Information");
        setModal(true);
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

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Inverter Data"));

        lblWattage.setText("Wattage");

        lblEfficiency.setText("Rated Efficiency");

        lblLoss.setText("Efficiency Loss per Year");

        lblLife.setText("Expected Life");

        jSpinnerWattage.setModel(new javax.swing.SpinnerNumberModel(1800.0d, 0.0d, 50000.0d, 100.0d));

        jSpinnerLife.setModel(new javax.swing.SpinnerNumberModel(15, 0, 50, 5));

        jSpinnerEfficiency.setModel(new javax.swing.SpinnerNumberModel(98.0d, 0.0d, 100.0d, 1.0d));

        jSpinnerEffLossYr.setModel(new javax.swing.SpinnerNumberModel(0.0d, 0.0d, 100.0d, 1.0d));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblWattage)
                    .addComponent(lblEfficiency))
                .addGap(31, 31, 31)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jSpinnerEfficiency, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(lblLoss))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jSpinnerWattage, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(lblLife)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 16, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jSpinnerLife, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jSpinnerEffLossYr, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblWattage)
                    .addComponent(jSpinnerWattage, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblLife)
                    .addComponent(jSpinnerLife, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jSpinnerEfficiency, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblEfficiency)
                    .addComponent(lblLoss)
                    .addComponent(jSpinnerEffLossYr, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(25, Short.MAX_VALUE))
        );

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder("Inverter Information"));

        lblName.setText("Name");

        lblCost.setText("Cost $");

        jSpinnerCost.setModel(new javax.swing.SpinnerNumberModel(0.0d, 0.0d, 25000.0d, 10.0d));

        lblManufacturer.setText("Manufacturer");

        lblRRP.setText("RRP $");

        jSpinnerRRP.setModel(new javax.swing.SpinnerNumberModel(0.0d, 0.0d, 25000.0d, 10.0d));

        lblCode.setText("Manufacturer Code");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblName)
                    .addComponent(lblManufacturer)
                    .addComponent(lblCode))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(txtCode, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(txtName, javax.swing.GroupLayout.DEFAULT_SIZE, 120, Short.MAX_VALUE)
                            .addComponent(txtManufacturer))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(lblRRP)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jSpinnerRRP, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(lblCost)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jSpinnerCost, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblName)
                    .addComponent(txtName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblCost)
                    .addComponent(jSpinnerCost, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtManufacturer, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblManufacturer)
                    .addComponent(lblRRP)
                    .addComponent(jSpinnerRRP, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtCode, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblCode))
                .addContainerGap(13, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(12, 12, 12)
                        .addComponent(lblError, javax.swing.GroupLayout.PREFERRED_SIZE, 412, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnCancel)
                        .addGap(18, 18, 18)
                        .addComponent(btnSubmit)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(btnSubmit, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnCancel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(lblError, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnSubmitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSubmitActionPerformed
    	success = submitInverterData();
    	
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
    
    public SolarInverter GetInverter(){
    	return inverter;
    }
    
    public void LoadInverter(SolarInverter oldInverter){
    	txtName.setText(oldInverter.getInverterName());
		txtManufacturer.setText(oldInverter.getInverterManufacturer());
		txtCode.setText(oldInverter.getInverterManufacturerCode());
                jSpinnerWattage.setValue(oldInverter.getInverterWattage());
                jSpinnerCost.setValue(oldInverter.getInverterCost());
                jSpinnerEffLossYr.setValue(oldInverter.getInverterLossYear());
                jSpinnerRRP.setValue(oldInverter.getInverterRRP());
                jSpinnerLife.setValue(oldInverter.getInverterLifeYears());
                jSpinnerEfficiency.setValue(oldInverter.getInverterEfficiency());
    }
    
    /**
     * Get the success of the panel acquisition
     * @return true on success, false if not
     */
    public boolean GetSuccess(){
    	return success;
    }
    
    private boolean submitInverterData(){
    	inverter = new SolarInverter();
		try {
			
			if(txtName.getText().equals("") == true || txtManufacturer.getText().equals("") == true  || txtCode.getText().equals("") == true){
				throw new Exception();
			}
			
			if((Double)jSpinnerCost.getModel().getValue() == 0){
            	throw new Exception();
            }
				
			inverter.setInverterName(txtName.getText());
			inverter.setInverterManufacturer(txtManufacturer.getText());
			inverter.setInverterManufacturerCode(txtCode.getText());
                        inverter.setInverterWattage((Double)jSpinnerWattage.getModel().getValue());
			inverter.setInverterCost((Double)jSpinnerCost.getModel().getValue());
			inverter.setInverterLossYear((Double)jSpinnerEffLossYr.getModel().getValue());
			inverter.setInverterRRP((Double)jSpinnerRRP.getModel().getValue());
			inverter.setInverterLifeYears((Integer)jSpinnerLife.getModel().getValue());
			inverter.setInverterEfficiency((Double)jSpinnerEfficiency.getModel().getValue());
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
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JSpinner jSpinnerCost;
    private javax.swing.JSpinner jSpinnerEffLossYr;
    private javax.swing.JSpinner jSpinnerEfficiency;
    private javax.swing.JSpinner jSpinnerLife;
    private javax.swing.JSpinner jSpinnerRRP;
    private javax.swing.JSpinner jSpinnerWattage;
    private javax.swing.JLabel lblCode;
    private javax.swing.JLabel lblCost;
    private javax.swing.JLabel lblEfficiency;
    private javax.swing.JLabel lblError;
    private javax.swing.JLabel lblLife;
    private javax.swing.JLabel lblLoss;
    private javax.swing.JLabel lblManufacturer;
    private javax.swing.JLabel lblName;
    private javax.swing.JLabel lblRRP;
    private javax.swing.JLabel lblWattage;
    private javax.swing.JTextField txtCode;
    private javax.swing.JTextField txtManufacturer;
    private javax.swing.JTextField txtName;
    // End of variables declaration//GEN-END:variables

   private boolean success = false;

}

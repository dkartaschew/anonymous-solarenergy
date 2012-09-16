/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.anonymous.solar.desktop;

import java.awt.Color;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import com.anonymous.solar.client.SInverter;
import com.anonymous.solar.client.SInverterService;
import com.anonymous.solar.shared.SolarInverter;

/**
 *
 * @author Thura
 */
@SuppressWarnings("serial")
public class AddNewInverter extends javax.swing.JDialog {

    /**
     * Creates new form AddNewInverter
     */
    public AddNewInverter(WizardSetupElectrical parent) {
        super(new JFrame(), true);
        initComponents();
        this.iParent = parent;
        LoadInverter(parent.inverter);
        setTitle("Inverter Information");
    }
    
    /**
     * Solar Inverter
     */
    SolarInverter inverter;
    
    /**
     * Parent
     */
    private WizardSetupElectrical iParent = null;

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanelDataGroup = new javax.swing.JPanel();
        lblName = new javax.swing.JLabel();
        lblCost = new javax.swing.JLabel();
        lblCode = new javax.swing.JLabel();
        txtName = new javax.swing.JTextField();
        lblRRP = new javax.swing.JLabel();
        txtManufacturer = new javax.swing.JTextField();
        txtCode = new javax.swing.JTextField();
        lblManufacturer = new javax.swing.JLabel();
        jSpinnerCost = new javax.swing.JSpinner();
        jSpinnerRRP = new javax.swing.JSpinner();
        jButtonSave = new javax.swing.JButton();
        jPanelDataGroup1 = new javax.swing.JPanel();
        lblEfficiency1 = new javax.swing.JLabel();
        lblLife1 = new javax.swing.JLabel();
        lblWattage1 = new javax.swing.JLabel();
        jSpinnerLife = new javax.swing.JSpinner();
        jSpinnerWattage = new javax.swing.JSpinner();
        jSpinnerEfficiency = new javax.swing.JSpinner();
        lblLife2 = new javax.swing.JLabel();
        jSpinnerEffLossYr = new javax.swing.JSpinner();
        btnCancel = new javax.swing.JButton();
        btnSubmit = new javax.swing.JButton();
        jButtonLoadInverter = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanelDataGroup.setBorder(javax.swing.BorderFactory.createTitledBorder("Inverter Details"));
        jPanelDataGroup.setToolTipText("rgdfg");
        jPanelDataGroup.setName("Panel Details"); // NOI18N

        lblName.setText("Name");

        lblCost.setText("Cost");

        lblCode.setText("Code");

        lblRRP.setText("RRP");

        lblManufacturer.setText("Manufacturer");

        jSpinnerCost.setModel(new javax.swing.SpinnerNumberModel(0.0d, 0.0d, 25000.0d, 10.0d));

        jSpinnerRRP.setModel(new javax.swing.SpinnerNumberModel(0.0d, 0.0d, 25000.0d, 10.0d));

        javax.swing.GroupLayout jPanelDataGroupLayout = new javax.swing.GroupLayout(jPanelDataGroup);
        jPanelDataGroup.setLayout(jPanelDataGroupLayout);
        jPanelDataGroupLayout.setHorizontalGroup(
            jPanelDataGroupLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelDataGroupLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanelDataGroupLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanelDataGroupLayout.createSequentialGroup()
                        .addComponent(lblName)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 91, Short.MAX_VALUE)
                        .addComponent(txtName, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanelDataGroupLayout.createSequentialGroup()
                        .addGroup(jPanelDataGroupLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblManufacturer)
                            .addComponent(lblCode))
                        .addGap(53, 53, 53)
                        .addGroup(jPanelDataGroupLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(txtCode, javax.swing.GroupLayout.DEFAULT_SIZE, 120, Short.MAX_VALUE)
                            .addComponent(txtManufacturer, javax.swing.GroupLayout.Alignment.LEADING))))
                .addGap(18, 18, 18)
                .addGroup(jPanelDataGroupLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblRRP)
                    .addComponent(lblCost))
                .addGap(49, 49, 49)
                .addGroup(jPanelDataGroupLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jSpinnerCost, javax.swing.GroupLayout.DEFAULT_SIZE, 120, Short.MAX_VALUE)
                    .addComponent(jSpinnerRRP))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanelDataGroupLayout.setVerticalGroup(
            jPanelDataGroupLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelDataGroupLayout.createSequentialGroup()
                .addContainerGap(18, Short.MAX_VALUE)
                .addGroup(jPanelDataGroupLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanelDataGroupLayout.createSequentialGroup()
                        .addGroup(jPanelDataGroupLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanelDataGroupLayout.createSequentialGroup()
                                .addGap(4, 4, 4)
                                .addComponent(lblName)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(jPanelDataGroupLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(txtManufacturer, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(lblManufacturer)))
                            .addGroup(jPanelDataGroupLayout.createSequentialGroup()
                                .addComponent(jSpinnerCost, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jSpinnerRRP, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanelDataGroupLayout.createSequentialGroup()
                                .addComponent(lblCost)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(lblRRP)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanelDataGroupLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtCode, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblCode)))))
        );

        jButtonSave.setText("Save Inverter");
        jButtonSave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonSaveActionPerformed(evt);
            }
        });

        jPanelDataGroup1.setBorder(javax.swing.BorderFactory.createTitledBorder("Technical Specifications"));
        jPanelDataGroup1.setToolTipText("rgdfg");
        jPanelDataGroup1.setName("Panel Details"); // NOI18N

        lblEfficiency1.setText("Rated Efficiency");

        lblLife1.setText("Expected Life");

        lblWattage1.setText("Wattage");

        jSpinnerLife.setModel(new javax.swing.SpinnerNumberModel(25, 0, 50, 5));

        jSpinnerWattage.setModel(new javax.swing.SpinnerNumberModel(100.0d, 0.0d, 1000.0d, 5.0d));

        jSpinnerEfficiency.setModel(new javax.swing.SpinnerNumberModel(0.0d, 0.0d, 100.0d, 1.0d));

        lblLife2.setText("Efficiency Loss Per Year");

        jSpinnerEffLossYr.setModel(new javax.swing.SpinnerNumberModel(25, 0, 50, 5));

        javax.swing.GroupLayout jPanelDataGroup1Layout = new javax.swing.GroupLayout(jPanelDataGroup1);
        jPanelDataGroup1.setLayout(jPanelDataGroup1Layout);
        jPanelDataGroup1Layout.setHorizontalGroup(
            jPanelDataGroup1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelDataGroup1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanelDataGroup1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblWattage1)
                    .addComponent(lblEfficiency1))
                .addGap(40, 40, 40)
                .addGroup(jPanelDataGroup1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jSpinnerWattage, javax.swing.GroupLayout.DEFAULT_SIZE, 120, Short.MAX_VALUE)
                    .addComponent(jSpinnerEfficiency))
                .addGap(18, 18, 18)
                .addGroup(jPanelDataGroup1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblLife2)
                    .addComponent(lblLife1))
                .addGap(18, 18, 18)
                .addGroup(jPanelDataGroup1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jSpinnerLife, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jSpinnerEffLossYr, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(40, Short.MAX_VALUE))
        );
        jPanelDataGroup1Layout.setVerticalGroup(
            jPanelDataGroup1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelDataGroup1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanelDataGroup1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblWattage1)
                    .addComponent(jSpinnerWattage, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblLife1)
                    .addComponent(jSpinnerLife, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanelDataGroup1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanelDataGroup1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(lblLife2)
                        .addComponent(jSpinnerEffLossYr, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanelDataGroup1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(lblEfficiency1)
                        .addComponent(jSpinnerEfficiency, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

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

        jButtonLoadInverter.setText("Load Inverter");
        jButtonLoadInverter.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonLoadInverterActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jPanelDataGroup1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jPanelDataGroup, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jButtonSave)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButtonLoadInverter)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnCancel)
                        .addGap(7, 7, 7)
                        .addComponent(btnSubmit)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanelDataGroup, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanelDataGroup1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnCancel)
                    .addComponent(btnSubmit)
                    .addComponent(jButtonSave)
                    .addComponent(jButtonLoadInverter))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
    
    private SolarInverter getVerifiedInverter() throws Exception{
        SolarInverter inverter = new SolarInverter();
        boolean error = false;
        javax.swing.border.LineBorder borderError = new javax.swing.border.LineBorder(Color.red, 3);
        returnToWhite();
       
	   jSpinnerCost.setBackground(Color.red);
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
	        if((Double)jSpinnerRRP.getModel().getValue() == 0){
	        error = true;
	        jSpinnerRRP.setBorder(borderError);
	        }
	        if((Double)jSpinnerCost.getModel().getValue() == 0){
	        error = true;
	        jSpinnerCost.setBorder(borderError);
	        }
	        if((Double)jSpinnerCost.getModel().getValue() > (Double)jSpinnerRRP.getModel().getValue()){
	        error = true;
	        jSpinnerCost.setBorder(borderError);
	        }
	       
	       if(error){
	        throw new Exception();
	       }
	
		   inverter.setInverterName(txtName.getText());
		   inverter.setInverterManufacturer(txtManufacturer.getText());
		   inverter.setInverterManufacturerCode(txtCode.getText());
		   inverter.setInverterWattage((Double)jSpinnerWattage.getModel().getValue());
		   inverter.setInverterCost((Double)jSpinnerCost.getModel().getValue());
		   inverter.setInverterLossYear((Double.parseDouble(jSpinnerEffLossYr.getModel().getValue().toString())));
		   inverter.setInverterRRP((Double)jSpinnerRRP.getModel().getValue());
		   inverter.setInverterLifeYears((Integer)jSpinnerLife.getModel().getValue());
		   inverter.setInverterEfficiency((Double)jSpinnerEfficiency.getModel().getValue());
		   return inverter;

    }		

    private void jButtonSaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonSaveActionPerformed
    	SolarInverter inverter;
    	try {
    	inverter = getVerifiedInverter();
    	SInverter SInverterSOAP = new SInverterService().getSInverterPort();
    	boolean succ = SInverterSOAP.insertInverter(inverter);

    	if (succ) {
    	JOptionPane.showMessageDialog(new JFrame(), "Inverter Saved");
    	} else {
    	JOptionPane.showMessageDialog(new JFrame(),
    	"The inverter can not be saved at this point");
    	}

    	} catch (Exception e) {
    	JOptionPane.showMessageDialog(new JFrame(),
    	"This is an invalid inverter!");
    	}
    	
    }//GEN-LAST:event_jButtonSaveActionPerformed

    private void btnCancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelActionPerformed
        doClose();
    }//GEN-LAST:event_btnCancelActionPerformed

    private void btnSubmitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSubmitActionPerformed
    	boolean success = submitInverterData();
    	
    	if(success){
            doClose();
    	}
    }//GEN-LAST:event_btnSubmitActionPerformed

    private void jButtonLoadInverterActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonLoadInverterActionPerformed
        LoadInverter webInverter = new LoadInverter(this);
        webInverter.setVisible(true);
    }//GEN-LAST:event_jButtonLoadInverterActionPerformed
    
    private void doClose() {
        setVisible(false);
    }
    
protected void LoadInverter(SolarInverter oldInverter){
    	
    	if(oldInverter != null){
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
    }
    
    /**
     * Clear all the error effects from textboxes and jSpinners
     */
    private void returnToWhite(){
    	javax.swing.border.LineBorder clear = new javax.swing.border.LineBorder(Color.white, 0);
    	
    	txtName.setBackground(Color.white);
        txtManufacturer.setBackground(Color.white);
        txtCode.setBackground(Color.white);
        jSpinnerWattage.setBackground(Color.white);
        jSpinnerCost.setBorder(clear);
        jSpinnerEffLossYr.setBorder(clear);
        jSpinnerRRP.setBorder(clear);
        jSpinnerLife.setBorder(clear);
        jSpinnerEfficiency.setBorder(clear);
    }
    
    private boolean submitInverterData(){
		inverter = new SolarInverter();
	    boolean error = false;
	    javax.swing.border.LineBorder borderError = new javax.swing.border.LineBorder(Color.red, 3);
	    returnToWhite();
	   
	   try {
	
	   inverter = getVerifiedInverter();
	   this.iParent.inverter = inverter;
	   return true;
	
	   } catch (Exception e) {
	   // Oops, something went wrong, let the client know.
	   return false;
	   }
    }
    
    

    
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(AddNewInverter.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AddNewInverter.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AddNewInverter.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AddNewInverter.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                AddNewInverter dialog = new AddNewInverter(new WizardSetupElectrical());
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCancel;
    private javax.swing.JButton btnSubmit;
    private javax.swing.JButton jButtonLoadInverter;
    private javax.swing.JButton jButtonSave;
    private javax.swing.JPanel jPanelDataGroup;
    private javax.swing.JPanel jPanelDataGroup1;
    private javax.swing.JSpinner jSpinnerCost;
    private javax.swing.JSpinner jSpinnerEffLossYr;
    private javax.swing.JSpinner jSpinnerEfficiency;
    private javax.swing.JSpinner jSpinnerLife;
    private javax.swing.JSpinner jSpinnerRRP;
    private javax.swing.JSpinner jSpinnerWattage;
    private javax.swing.JLabel lblCode;
    private javax.swing.JLabel lblCost;
    private javax.swing.JLabel lblEfficiency1;
    private javax.swing.JLabel lblLife1;
    private javax.swing.JLabel lblLife2;
    private javax.swing.JLabel lblManufacturer;
    private javax.swing.JLabel lblName;
    private javax.swing.JLabel lblRRP;
    private javax.swing.JLabel lblWattage1;
    private javax.swing.JTextField txtCode;
    private javax.swing.JTextField txtManufacturer;
    private javax.swing.JTextField txtName;
    // End of variables declaration//GEN-END:variables
}

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.anonymous.solar.desktop;

import java.awt.Component;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import javax.swing.DefaultListModel;
import javax.swing.JList;

import com.anonymous.solar.client.SPanel;
import com.anonymous.solar.client.SPanelService;
import com.anonymous.solar.comparison.*;
import com.anonymous.solar.shared.SolarPanel;

/**
 *
 * @author Thura
 */
public class LoadPanel extends javax.swing.JDialog {

    /**
     * Creates new form LoadPanel
     */
	AddNewPanel parent;
	
    public LoadPanel(AddNewPanel parent) {
        super(parent, true);
        initComponents();
        LoadStoredPanels(new PanelCostComparison());
        this.parent = parent;
        btnLoadPanel.setEnabled(false);
    }
    
    private void LoadStoredPanels(Comparator comparison){
    	SPanel SPanelSOAP = new SPanelService().getSPanelPort();
    	
		int counter = 0;
    	
        List<SolarPanel> panelData = (List<SolarPanel>) SPanelSOAP.getPanels();
        Collections.sort(panelData, comparison);
        
        final Object[] objs = new Object[panelData.size()];
        
        
        for (SolarPanel pan : panelData) {
                objs[counter] = pan;
                counter++;
        }
        
        
        lstPanelInformation.setModel(new javax.swing.AbstractListModel() {
            //String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return objs.length; }
            public Object getElementAt(int i) { return objs[i]; }
        });
        
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButton1 = new javax.swing.JButton();
        cmbSortBy = new javax.swing.JComboBox();
        btnLoadPanel = new javax.swing.JButton();
        lblPanelName = new javax.swing.JLabel();
        lblPanelManufacturer = new javax.swing.JLabel();
        lblPanelManufacturerCode = new javax.swing.JLabel();
        lblPanelWattage = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        lstPanelInformation = new javax.swing.JList();
        lblPanelEfficiencyLoss = new javax.swing.JLabel();
        lblPanelCost = new javax.swing.JLabel();
        txtPanelName = new javax.swing.JTextField();
        txtPanelManufacturer = new javax.swing.JTextField();
        txtPanelManufacturerCode = new javax.swing.JTextField();
        txtPanelWattage = new javax.swing.JTextField();
        txtPanelEfficiencyLoss = new javax.swing.JTextField();
        txtPanelCost = new javax.swing.JTextField();
        txtPanelLifetime = new javax.swing.JTextField();
        txtPanelRRP = new javax.swing.JTextField();
        lblPanelRRP = new javax.swing.JLabel();
        lblPanelLifetime = new javax.swing.JLabel();
        btnCancel = new javax.swing.JButton();
        lblSortBy = new javax.swing.JLabel();

        jButton1.setText("jButton1");

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setResizable(false);

        cmbSortBy.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Cost", "Efficiency Loss", "Life", "Wattage" }));
        cmbSortBy.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbSortByActionPerformed(evt);
            }
        });

        btnLoadPanel.setText("Load Panel");
        btnLoadPanel.setFocusCycleRoot(true);
        btnLoadPanel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLoadPanelActionPerformed(evt);
            }
        });

        lblPanelName.setText("Name: ");
        lblPanelName.setToolTipText("");

        lblPanelManufacturer.setText("Manufacturer: ");
        lblPanelManufacturer.setToolTipText("");

        lblPanelManufacturerCode.setText("Manufacturer Code: ");

        lblPanelWattage.setText("Wattage: ");

        lstPanelInformation.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                lstPanelInformationMouseReleased(evt);
            }
        });
        lstPanelInformation.addListSelectionListener(new javax.swing.event.ListSelectionListener() {
            public void valueChanged(javax.swing.event.ListSelectionEvent evt) {
                lstPanelInformationValueChanged(evt);
            }
        });
        jScrollPane2.setViewportView(lstPanelInformation);

        lblPanelEfficiencyLoss.setText("Annual Efficiency Loss: ");

        lblPanelCost.setText("Cost: ");

        txtPanelName.setEditable(false);
        txtPanelName.setToolTipText("");

        txtPanelManufacturer.setEditable(false);
        txtPanelManufacturer.setToolTipText("");

        txtPanelManufacturerCode.setEditable(false);
        txtPanelManufacturerCode.setToolTipText("");

        txtPanelWattage.setEditable(false);
        txtPanelWattage.setToolTipText("");

        txtPanelEfficiencyLoss.setEditable(false);
        txtPanelEfficiencyLoss.setToolTipText("");

        txtPanelCost.setEditable(false);
        txtPanelCost.setToolTipText("");
        txtPanelCost.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtPanelCostActionPerformed(evt);
            }
        });

        txtPanelLifetime.setEditable(false);
        txtPanelLifetime.setToolTipText("");
        txtPanelLifetime.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtPanelLifetimeActionPerformed(evt);
            }
        });

        txtPanelRRP.setEditable(false);
        txtPanelRRP.setToolTipText("");

        lblPanelRRP.setText("RRP:");

        lblPanelLifetime.setText("Lifetime:");

        btnCancel.setText("Cancel");
        btnCancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelActionPerformed(evt);
            }
        });

        lblSortBy.setText("Sort By: ");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jScrollPane2)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblPanelWattage)
                            .addComponent(lblPanelManufacturerCode)
                            .addComponent(lblPanelManufacturer)
                            .addComponent(lblPanelName))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtPanelWattage, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtPanelManufacturerCode, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(txtPanelName, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(txtPanelManufacturer, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lblPanelCost)
                                    .addComponent(lblPanelEfficiencyLoss))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(txtPanelCost, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtPanelEfficiencyLoss, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lblPanelRRP, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(lblPanelLifetime, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtPanelLifetime, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtPanelRRP, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(btnCancel, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(btnLoadPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addComponent(lblSortBy)
                        .addGap(12, 12, 12)
                        .addComponent(cmbSortBy, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 207, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(9, 9, 9)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblSortBy)
                            .addComponent(cmbSortBy, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                            .addComponent(lblPanelName)
                                            .addComponent(txtPanelName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                            .addComponent(lblPanelManufacturer)
                                            .addComponent(txtPanelManufacturer, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                            .addComponent(lblPanelEfficiencyLoss, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(txtPanelEfficiencyLoss, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                            .addComponent(lblPanelCost)
                                            .addComponent(txtPanelCost, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(lblPanelManufacturerCode)
                                    .addComponent(txtPanelManufacturerCode, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(lblPanelRRP, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(lblPanelWattage)
                                    .addComponent(txtPanelWattage, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(lblPanelLifetime)))
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(layout.createSequentialGroup()
                                    .addGap(26, 26, 26)
                                    .addComponent(txtPanelLifetime, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addComponent(txtPanelRRP, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(52, 52, 52))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnCancel)
                            .addComponent(btnLoadPanel))
                        .addContainerGap())))
        );

        btnLoadPanel.getAccessibleContext().setAccessibleName("btnLoadPanel");

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtPanelCostActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtPanelCostActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtPanelCostActionPerformed

    private void txtPanelLifetimeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtPanelLifetimeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtPanelLifetimeActionPerformed

    private void cmbSortByActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbSortByActionPerformed
        String selected = (String)cmbSortBy.getSelectedItem();
        
        //TODO: Compare nicely
    	if(selected == "Cost") {
    		LoadStoredPanels(new PanelCostComparison());
    	}else if(selected == "Wattage"){
    		LoadStoredPanels(new PanelWattageComparison());
    	}else if(selected == "Efficiency Loss"){
    		LoadStoredPanels(new PanelEfficiencyComparison());
    	}else if(selected == "Life"){
    		LoadStoredPanels(new PanelLifeComparison());
    	}
    }//GEN-LAST:event_cmbSortByActionPerformed

    private void btnLoadPanelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLoadPanelActionPerformed
        SolarPanel panel = (SolarPanel) lstPanelInformation.getSelectedValue();
        parent.LoadPanel(panel);
        this.setVisible(false);
        
    }//GEN-LAST:event_btnLoadPanelActionPerformed

    private void lstPanelInformationValueChanged(javax.swing.event.ListSelectionEvent evt) {//GEN-FIRST:event_lstPanelInformationValueChanged
        //
    }//GEN-LAST:event_lstPanelInformationValueChanged

    private void lstPanelInformationMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lstPanelInformationMouseReleased
        SolarPanel panel = new SolarPanel();
        panel = (SolarPanel)lstPanelInformation.getSelectedValue();
        
        if(panel != null){
	        txtPanelName.setText(panel.getPanelName());
	        txtPanelManufacturer.setText(panel.getPanelManufacturer());
	        txtPanelManufacturerCode.setText(panel.getPanelManufacturerCode());
	        txtPanelWattage.setText(panel.getPanelWattage().toString());
	        txtPanelCost.setText(panel.getPanelCost().toString());
	        txtPanelRRP.setText(panel.getPanelRRP().toString());
	        txtPanelLifetime.setText(panel.getPanelLifeYears().toString());
	        txtPanelEfficiencyLoss.setText(panel.getPanelLossYear().toString());
    	}
        btnLoadPanel.setEnabled(true);
    }//GEN-LAST:event_lstPanelInformationMouseReleased

    private void btnCancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelActionPerformed
        setVisible(false);
    }//GEN-LAST:event_btnCancelActionPerformed

 
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCancel;
    private javax.swing.JButton btnLoadPanel;
    private javax.swing.JComboBox cmbSortBy;
    private javax.swing.JButton jButton1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel lblPanelCost;
    private javax.swing.JLabel lblPanelEfficiencyLoss;
    private javax.swing.JLabel lblPanelLifetime;
    private javax.swing.JLabel lblPanelManufacturer;
    private javax.swing.JLabel lblPanelManufacturerCode;
    private javax.swing.JLabel lblPanelName;
    private javax.swing.JLabel lblPanelRRP;
    private javax.swing.JLabel lblPanelWattage;
    private javax.swing.JLabel lblSortBy;
    private javax.swing.JList lstPanelInformation;
    private javax.swing.JTextField txtPanelCost;
    private javax.swing.JTextField txtPanelEfficiencyLoss;
    private javax.swing.JTextField txtPanelLifetime;
    private javax.swing.JTextField txtPanelManufacturer;
    private javax.swing.JTextField txtPanelManufacturerCode;
    private javax.swing.JTextField txtPanelName;
    private javax.swing.JTextField txtPanelRRP;
    private javax.swing.JTextField txtPanelWattage;
    // End of variables declaration//GEN-END:variables
}

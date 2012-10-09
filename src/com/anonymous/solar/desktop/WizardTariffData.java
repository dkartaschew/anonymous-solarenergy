/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.anonymous.solar.desktop;

import com.anonymous.solar.client.TRate;
import com.anonymous.solar.client.TRateService;
import com.anonymous.solar.comparison.TariffStateComparer;
import java.awt.Color;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import com.anonymous.solar.shared.CustomerData;
import com.anonymous.solar.shared.SolarPanel;
import com.anonymous.solar.shared.SolarPanelException;
import com.anonymous.solar.shared.SolarSetup;
import com.anonymous.solar.shared.SolarSetupException;
import com.anonymous.solar.shared.TariffRate;
import com.anonymous.solar.shared.TariffRateException;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * User Cost Pane for Desktop Application
 * 
 * @author Alex Colvin
 * @version 1.0
 */
public class WizardTariffData extends javax.swing.JPanel implements WizardPanel {

        private final String title = "Tariff Rates";

    private Wizard parent = null;
    private CustomerData data; 
    
    
    /**
     * Creates new form WizardUserCosts
     */
    public WizardTariffData() {
        initComponents();
        nameComponents();
    }
    
    /**
     * Creates new form WizardFinish, with reference to parent
     */
    public WizardTariffData(Wizard parent) {
        initComponents();
        nameComponents();
        this.parent = parent;
    }
    
    /**
     * Names components for GUI testing
     */
    private void nameComponents() {
    	lstProviderInformation.setName("ListTariffProviderInformation");
    	jSpinnerTariffIncrease.setName("SpinnerTariffIncrease");
    }


    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanelUsageGroup = new javax.swing.JPanel();
        jLabelDailyAvgUsage = new javax.swing.JLabel();
        cmbSortBy = new javax.swing.JComboBox();
        jScrollPane2 = new javax.swing.JScrollPane();
        lstProviderInformation = new javax.swing.JList();
        jPanelTariffGroup = new javax.swing.JPanel();
        jSpinnerTariff11 = new javax.swing.JSpinner();
        jLabelTariff11 = new javax.swing.JLabel();
        jSpinnerTariff33 = new javax.swing.JSpinner();
        jLabelTariff33 = new javax.swing.JLabel();
        jLabelUsage = new javax.swing.JLabel();
        jLabelUsage2 = new javax.swing.JLabel();
        jSpinnerDailyCostTariff11 = new javax.swing.JSpinner();
        jSpinnerDailyCostTariff33 = new javax.swing.JSpinner();
        jSpinnerFeedInFee = new javax.swing.JSpinner();
        jLabelFeedInFee = new javax.swing.JLabel();
        jSpinnerTariffIncrease = new javax.swing.JSpinner();
        jLabelAnnualTariffIncrease = new javax.swing.JLabel();

        setPreferredSize(new java.awt.Dimension(548, 262));

        jPanelUsageGroup.setBorder(javax.swing.BorderFactory.createTitledBorder("Provider Details"));

        jLabelDailyAvgUsage.setText("Select your state:");

        cmbSortBy.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "QLD", "NSW", "VIC", "TAS", "ACT", "NT", "SA", "WA" }));
        cmbSortBy.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbSortByActionPerformed(evt);
            }
        });

        lstProviderInformation.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                lstProviderInformationMouseReleased(evt);
            }
        });
        lstProviderInformation.addListSelectionListener(new javax.swing.event.ListSelectionListener() {
            public void valueChanged(javax.swing.event.ListSelectionEvent evt) {
                lstProviderInformationValueChanged(evt);
            }
        });
        jScrollPane2.setViewportView(lstProviderInformation);

        javax.swing.GroupLayout jPanelUsageGroupLayout = new javax.swing.GroupLayout(jPanelUsageGroup);
        jPanelUsageGroup.setLayout(jPanelUsageGroupLayout);
        jPanelUsageGroupLayout.setHorizontalGroup(
            jPanelUsageGroupLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelUsageGroupLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabelDailyAvgUsage)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cmbSortBy, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
            .addComponent(jScrollPane2)
        );
        jPanelUsageGroupLayout.setVerticalGroup(
            jPanelUsageGroupLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelUsageGroupLayout.createSequentialGroup()
                .addGroup(jPanelUsageGroupLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelDailyAvgUsage)
                    .addComponent(cmbSortBy, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 79, Short.MAX_VALUE))
        );

        jPanelTariffGroup.setBorder(javax.swing.BorderFactory.createTitledBorder("Tariff Rates"));

        jSpinnerTariff11.setModel(new javax.swing.SpinnerNumberModel(0.0d, 0.0d, 250.0d, 0.1d));

        jLabelTariff11.setText("Tariff 11 Fee (c/kW)");

        jSpinnerTariff33.setModel(new javax.swing.SpinnerNumberModel(0.0d, 0.0d, 250.0d, 0.1d));

        jLabelTariff33.setText("Tariff 33 Fee (c/kW)");

        jLabelUsage.setText("Daily Tariff 11 Cost:");

        jLabelUsage2.setText("Daily Tariff 33 Cost:");

        jSpinnerDailyCostTariff11.setModel(new javax.swing.SpinnerNumberModel(Double.valueOf(0.0d), Double.valueOf(0.0d), null, Double.valueOf(25.0d)));

        jSpinnerDailyCostTariff33.setModel(new javax.swing.SpinnerNumberModel(Double.valueOf(0.0d), Double.valueOf(0.0d), null, Double.valueOf(25.0d)));

        jSpinnerFeedInFee.setModel(new javax.swing.SpinnerNumberModel(0.5d, 0.0d, 25.0d, 0.1d));

        jLabelFeedInFee.setText("Feed in Fee");

        jSpinnerTariffIncrease.setModel(new javax.swing.SpinnerNumberModel(0.0d, 0.0d, 500.0d, 1.0d));

        jLabelAnnualTariffIncrease.setText("Annual Tariff Increase");

        javax.swing.GroupLayout jPanelTariffGroupLayout = new javax.swing.GroupLayout(jPanelTariffGroup);
        jPanelTariffGroup.setLayout(jPanelTariffGroupLayout);
        jPanelTariffGroupLayout.setHorizontalGroup(
            jPanelTariffGroupLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelTariffGroupLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanelTariffGroupLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabelUsage)
                    .addComponent(jLabelUsage2)
                    .addComponent(jLabelFeedInFee))
                .addGap(26, 26, 26)
                .addGroup(jPanelTariffGroupLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jSpinnerFeedInFee, javax.swing.GroupLayout.DEFAULT_SIZE, 120, Short.MAX_VALUE)
                    .addComponent(jSpinnerDailyCostTariff11)
                    .addComponent(jSpinnerDailyCostTariff33))
                .addGap(18, 18, 18)
                .addGroup(jPanelTariffGroupLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanelTariffGroupLayout.createSequentialGroup()
                        .addGroup(jPanelTariffGroupLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanelTariffGroupLayout.createSequentialGroup()
                                .addComponent(jLabelTariff11)
                                .addGap(18, 18, 18)
                                .addComponent(jSpinnerTariff11, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanelTariffGroupLayout.createSequentialGroup()
                                .addComponent(jLabelTariff33)
                                .addGap(18, 18, 18)
                                .addComponent(jSpinnerTariff33, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 1, Short.MAX_VALUE))
                    .addGroup(jPanelTariffGroupLayout.createSequentialGroup()
                        .addComponent(jLabelAnnualTariffIncrease)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jSpinnerTariffIncrease, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        jPanelTariffGroupLayout.setVerticalGroup(
            jPanelTariffGroupLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelTariffGroupLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanelTariffGroupLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelUsage)
                    .addComponent(jSpinnerDailyCostTariff11, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabelTariff11)
                    .addComponent(jSpinnerTariff11, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanelTariffGroupLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jSpinnerDailyCostTariff33, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabelUsage2)
                    .addComponent(jLabelTariff33)
                    .addComponent(jSpinnerTariff33, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanelTariffGroupLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jSpinnerFeedInFee, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabelFeedInFee)
                    .addComponent(jLabelAnnualTariffIncrease)
                    .addComponent(jSpinnerTariffIncrease, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanelTariffGroup, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanelUsageGroup, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanelUsageGroup, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanelTariffGroup, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void cmbSortByActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbSortByActionPerformed
        String selected = (String)cmbSortBy.getSelectedItem();

        LoadStoredTariffs(selected);
    }//GEN-LAST:event_cmbSortByActionPerformed

    private void lstProviderInformationMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lstProviderInformationMouseReleased
        TariffRate tariff = new TariffRate();
        tariff = (TariffRate)lstProviderInformation.getSelectedValue();

        if(tariff != null){
            jSpinnerFeedInFee.setValue(tariff.getTariffFeedInFee());
            jSpinnerDailyCostTariff11.setValue(tariff.getTariff11Fee());
            jSpinnerTariff11.setValue(tariff.getTariff11Cost());
            jSpinnerDailyCostTariff33.setValue(tariff.getTariff33Fee());
            jSpinnerTariff33.setValue(tariff.getTariff33Cost());
        }

    }//GEN-LAST:event_lstProviderInformationMouseReleased

    private void lstProviderInformationValueChanged(javax.swing.event.ListSelectionEvent evt) {//GEN-FIRST:event_lstProviderInformationValueChanged
        TariffRate tariff = new TariffRate();
        tariff = (TariffRate)lstProviderInformation.getSelectedValue();

        if(tariff != null){
            jSpinnerFeedInFee.setValue(tariff.getTariffFeedInFee());
            jSpinnerDailyCostTariff11.setValue(tariff.getTariff11Fee());
            jSpinnerTariff11.setValue(tariff.getTariff11Cost());
            jSpinnerDailyCostTariff33.setValue(tariff.getTariff33Fee());
            jSpinnerTariff33.setValue(tariff.getTariff33Cost());
        }
    }//GEN-LAST:event_lstProviderInformationValueChanged

    /**
     * Load panels from the datastore
     * 
     * @param comparison - A comparator used to order the panels
     */
    private void LoadStoredTariffs(Comparator comparison){
    	TRate TRateSOAP = new TRateService().getTRatePort();
    	
		int counter = 0;
    	
        List<TariffRate> tRateData = (List<TariffRate>) TRateSOAP.getTariffRates();
        Collections.sort(tRateData, comparison);
        
        final Object[] objs = new Object[tRateData.size()];
        
        for (TariffRate tar : tRateData) {
                objs[counter] = tar;
                counter++;
        }
        
        
        lstProviderInformation.setModel(new javax.swing.AbstractListModel() {
            //String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return objs.length; }
            public Object getElementAt(int i) { return objs[i]; }
        });
        
    }
    
    private void LoadStoredTariffs(String selected) {
    	TRate TRateSOAP = new TRateService().getTRatePort();
    	
        List<TariffRate> tRateData = (List<TariffRate>) TRateSOAP.getTariffRates();
        
        final List<Object> objs = new ArrayList<Object>();
        
        for (TariffRate tar : tRateData) {
        		if(tar.getTariffState().compareTo(selected) == 0){
        			objs.add(tar);
        		}
        }
        
		lstProviderInformation.setModel(new javax.swing.AbstractListModel() {
            //String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return objs.size(); }
            public Object getElementAt(int i) { return objs.get(i); }
        });
		
                
	}
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox cmbSortBy;
    private javax.swing.JLabel jLabelAnnualTariffIncrease;
    private javax.swing.JLabel jLabelDailyAvgUsage;
    private javax.swing.JLabel jLabelFeedInFee;
    private javax.swing.JLabel jLabelTariff11;
    private javax.swing.JLabel jLabelTariff33;
    private javax.swing.JLabel jLabelUsage;
    private javax.swing.JLabel jLabelUsage2;
    private javax.swing.JPanel jPanelTariffGroup;
    private javax.swing.JPanel jPanelUsageGroup;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JSpinner jSpinnerDailyCostTariff11;
    private javax.swing.JSpinner jSpinnerDailyCostTariff33;
    private javax.swing.JSpinner jSpinnerFeedInFee;
    private javax.swing.JSpinner jSpinnerTariff11;
    private javax.swing.JSpinner jSpinnerTariff33;
    private javax.swing.JSpinner jSpinnerTariffIncrease;
    private javax.swing.JList lstProviderInformation;
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
        LoadStoredTariffs(new TariffStateComparer());
    	
        if (global != null) {
            data = global.getCustomerData();
            jSpinnerDailyCostTariff11.setValue(data.getTariff11Cost());
            jSpinnerTariff11.setValue(data.getTariff11Fee());
            jSpinnerDailyCostTariff33.setValue(data.getTariff13Cost());
            jSpinnerTariff33.setValue(data.getTariff13Fee());
            jSpinnerTariffIncrease.setValue(data.getAnnualTariffIncrease());
            jSpinnerFeedInFee.setValue(data.getFeedInFee());
        }
        return true;
    }
    
    /**
     * Clear all the error effects from textboxes and jSpinners
     */
    private void returnToWhite(){
    	javax.swing.border.LineBorder clear = new javax.swing.border.LineBorder(Color.white, 0);
  
    	jSpinnerDailyCostTariff11.setBorder(clear);
    	jSpinnerTariff11.setBorder(clear);
    	jSpinnerDailyCostTariff33.setBorder(clear);
    	jSpinnerTariff33.setBorder(clear);
    	jSpinnerTariffIncrease.setBorder(clear);
    	jSpinnerFeedInFee.setBorder(clear);

    }
    
    private void validateInput() throws TariffRateException{
    	javax.swing.border.LineBorder borderError = new javax.swing.border.LineBorder(Color.red, 1);
    	boolean errorFree = true;
    	
    	if((Double)jSpinnerDailyCostTariff11.getValue() == 0){
    		jSpinnerDailyCostTariff11.setBorder(borderError);
    		errorFree = false;
    	}
    	
    	if((Double)jSpinnerDailyCostTariff33.getValue() == 0){
    		jSpinnerDailyCostTariff33.setBorder(borderError);
    		errorFree = false;
    	}
    	
    	if((Double)jSpinnerTariffIncrease.getValue() == 0){
    		jSpinnerTariffIncrease.setBorder(borderError);
    		errorFree = false;
    	}
    	
    	if((Double)jSpinnerTariff11.getValue() == 0){
    		jSpinnerTariff11.setBorder(borderError);
    		errorFree = false;
    	}
    	
    	if((Double)jSpinnerTariff33.getValue() == 0){
    		jSpinnerTariff33.setBorder(borderError);
    		errorFree = false;
    	}
    	
    	if(!errorFree){
    		throw new TariffRateException();
    	}
    }


    /**
     * Callback method used by the parent panel to notify this panel that we
     * have requested a move away from this panel.
     *
     * @return true is ok to move.
     */
    @Override
    public boolean callbackDispose(boolean validateInput) {
    	
    	returnToWhite();
    	try {
			validateInput();
    	} catch (TariffRateException e1) {
    		JOptionPane.showMessageDialog(this, "Please fill in all the required fields!",
					"Estimated Usage Missing", JOptionPane.OK_OPTION);
			return false;
		}
    	
	        SolarSetup global = parent.getSetup();
	        if (global != null) {
	            // Store the name and description fields.
	            try {    
	                data.setTariff11Cost((Double) jSpinnerDailyCostTariff11.getValue());
	                data.setTariff11Fee((Double) jSpinnerTariff11.getValue());
	                data.setTariff13Cost((Double) jSpinnerDailyCostTariff33.getValue());
	                data.setTariff13Fee((Double) jSpinnerTariff33.getValue());
	                data.setAnnualTariffIncrease((Double) jSpinnerTariffIncrease.getValue());
	                data.setFeedInFee((Double) jSpinnerFeedInFee.getValue());
	            } catch (Exception e) {
	                return false;
	            }
	        }
    	
        return true;
    }
    
    protected void LoadTariff(TariffRate tariff){
		jSpinnerDailyCostTariff11.setValue(tariff.getTariff11Cost());
		jSpinnerTariff11.setValue(tariff.getTariff11Fee());
		jSpinnerDailyCostTariff33.setValue(tariff.getTariff33Cost());
		jSpinnerTariff33.setValue(tariff.getTariff33Fee());
		jSpinnerFeedInFee.setValue(tariff.getTariffFeedInFee());
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
}
/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.anonymous.solar.desktop;

import java.awt.Color;

import javax.swing.JOptionPane;

import com.anonymous.solar.shared.CustomerData;
import com.anonymous.solar.shared.SolarSetup;

/**
 *
 * @author darran
 */
public class WizardUserCosts extends javax.swing.JPanel implements WizardPanel {

        private final String title = "Customer Usage";

    private Wizard parent = null;
    
    
    /**
     * Creates new form WizardUserCosts
     */
    public WizardUserCosts() {
        initComponents();
        nameComponents();
    }
    
    /**
     * Creates new form WizardFinish, with reference to parent
     */
    public WizardUserCosts(Wizard parent) {
        initComponents();
        nameComponents();
        this.parent = parent;
    }
    
    /**
     * Names components for GUI testing
     */
    private void nameComponents() {
    	jSpinnerDailyAverageUsage.setName("SpinnerDailyAverageUsage");
    	jSpinnerDayTimeHourlyUsage.setName("SpinnerDayTimeHourlyUsage");
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
        jSpinnerDailyAverageUsage = new javax.swing.JSpinner();
        jSpinnerDayTimeHourlyUsage = new javax.swing.JSpinner();
        jLabelDayTime = new javax.swing.JLabel();
        jPanelTariffGroup = new javax.swing.JPanel();
        jSpinnerTariff11 = new javax.swing.JSpinner();
        jLabelTariff11 = new javax.swing.JLabel();
        jSpinnerTariff33 = new javax.swing.JSpinner();
        jLabelTariff33 = new javax.swing.JLabel();
        jLabelUsage = new javax.swing.JLabel();
        jLabelUsage2 = new javax.swing.JLabel();
        jSpinnerMonthlyCostTariff1 = new javax.swing.JSpinner();
        jSpinnerMonthlyCostTariff2 = new javax.swing.JSpinner();
        jSpinnerFeedInFee = new javax.swing.JSpinner();
        jLabelFeedInFee = new javax.swing.JLabel();
        jSpinnerTariffIncrease = new javax.swing.JSpinner();
        jLabelAnnualTariffIncrease = new javax.swing.JLabel();

        jPanelUsageGroup.setBorder(javax.swing.BorderFactory.createTitledBorder("Average Monthly Usage"));

        jLabelDailyAvgUsage.setText("Daily Average Usage (KWh):");

        jSpinnerDailyAverageUsage.setModel(new javax.swing.SpinnerNumberModel(0.0d, 0.0d, 10000.0d, 1.0d));
        jSpinnerDailyAverageUsage.setToolTipText("Enter the estimated usage of kWh per day ");

        jSpinnerDayTimeHourlyUsage.setModel(new javax.swing.SpinnerNumberModel(0.0d, 0.0d, 24.0d, 1.0d));
        jSpinnerDayTimeHourlyUsage.setToolTipText("Enter the estimated usage of kWh per hour");

        jLabelDayTime.setText("Day Time Hourly Usage (KWh):");

        javax.swing.GroupLayout jPanelUsageGroupLayout = new javax.swing.GroupLayout(jPanelUsageGroup);
        jPanelUsageGroup.setLayout(jPanelUsageGroupLayout);
        jPanelUsageGroupLayout.setHorizontalGroup(
            jPanelUsageGroupLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelUsageGroupLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanelUsageGroupLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabelDailyAvgUsage)
                    .addComponent(jLabelDayTime))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanelUsageGroupLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jSpinnerDayTimeHourlyUsage, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jSpinnerDailyAverageUsage, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanelUsageGroupLayout.setVerticalGroup(
            jPanelUsageGroupLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelUsageGroupLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanelUsageGroupLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelDailyAvgUsage)
                    .addComponent(jSpinnerDailyAverageUsage, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanelUsageGroupLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jSpinnerDayTimeHourlyUsage, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabelDayTime))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanelTariffGroup.setBorder(javax.swing.BorderFactory.createTitledBorder("Tariff Rates"));

        jSpinnerTariff11.setModel(new javax.swing.SpinnerNumberModel(0.0d, 0.0d, 250.0d, 0.1d));
        jSpinnerTariff11.setToolTipText("Enter the cost of per kWh for tariff 11");

        jLabelTariff11.setText("Tariff 11 Fee");

        jSpinnerTariff33.setModel(new javax.swing.SpinnerNumberModel(0.0d, 0.0d, 250.0d, 0.1d));
        jSpinnerTariff33.setToolTipText("Enter the cost per kWh for tariff 13");

        jLabelTariff33.setText("Tariff 33 Fee");

        jLabelUsage.setText("Monthly Tariff 11 Cost:");

        jLabelUsage2.setText("Monthly Tariff 33 Cost:");

        jSpinnerMonthlyCostTariff1.setModel(new javax.swing.SpinnerNumberModel(Double.valueOf(0.0d), Double.valueOf(0.0d), null, Double.valueOf(25.0d)));
        jSpinnerMonthlyCostTariff1.setToolTipText("Enter the monthly fee for tariff 11");
        
        jSpinnerMonthlyCostTariff2.setModel(new javax.swing.SpinnerNumberModel(Double.valueOf(0.0d), Double.valueOf(0.0d), null, Double.valueOf(25.0d)));
        jSpinnerMonthlyCostTariff2.setToolTipText("Enter the monthly fee for tariff 13");
        
        jSpinnerFeedInFee.setModel(new javax.swing.SpinnerNumberModel(0.5d, 0.0d, 25.0d, 0.1d));
        jSpinnerFeedInFee.setToolTipText("Enter the feed in fee per month");

        jLabelFeedInFee.setText("Feed in Fee");

        jSpinnerTariffIncrease.setModel(new javax.swing.SpinnerNumberModel(0.0d, 0.0d, 500.0d, 1.0d));
        jSpinnerTariffIncrease.setToolTipText("Enter the estimated yearly increase in tariff costs");

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
                    .addComponent(jSpinnerMonthlyCostTariff1)
                    .addComponent(jSpinnerMonthlyCostTariff2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 26, Short.MAX_VALUE)
                .addGroup(jPanelTariffGroupLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelTariffGroupLayout.createSequentialGroup()
                        .addComponent(jLabelTariff11)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jSpinnerTariff11, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelTariffGroupLayout.createSequentialGroup()
                        .addComponent(jLabelTariff33)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jSpinnerTariff33, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelTariffGroupLayout.createSequentialGroup()
                        .addComponent(jLabelAnnualTariffIncrease)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jSpinnerTariffIncrease, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        jPanelTariffGroupLayout.setVerticalGroup(
            jPanelTariffGroupLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelTariffGroupLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanelTariffGroupLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelUsage)
                    .addComponent(jSpinnerMonthlyCostTariff1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabelTariff11)
                    .addComponent(jSpinnerTariff11, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanelTariffGroupLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jSpinnerMonthlyCostTariff2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
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
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanelTariffGroup, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanelUsageGroup, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanelUsageGroup, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanelTariffGroup, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabelAnnualTariffIncrease;
    private javax.swing.JLabel jLabelDailyAvgUsage;
    private javax.swing.JLabel jLabelDayTime;
    private javax.swing.JLabel jLabelFeedInFee;
    private javax.swing.JLabel jLabelTariff11;
    private javax.swing.JLabel jLabelTariff33;
    private javax.swing.JLabel jLabelUsage;
    private javax.swing.JLabel jLabelUsage2;
    private javax.swing.JPanel jPanelTariffGroup;
    private javax.swing.JPanel jPanelUsageGroup;
    private javax.swing.JSpinner jSpinnerDailyAverageUsage;
    private javax.swing.JSpinner jSpinnerDayTimeHourlyUsage;
    private javax.swing.JSpinner jSpinnerFeedInFee;
    private javax.swing.JSpinner jSpinnerMonthlyCostTariff1;
    private javax.swing.JSpinner jSpinnerMonthlyCostTariff2;
    private javax.swing.JSpinner jSpinnerTariff11;
    private javax.swing.JSpinner jSpinnerTariff33;
    private javax.swing.JSpinner jSpinnerTariffIncrease;
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
    	CustomerData data;
		if (global != null) {
			data = global.getCustomerData();
			jSpinnerDailyAverageUsage.setValue(data.getDailyAverageUsage());
			jSpinnerDayTimeHourlyUsage.setValue(data.getHourlyAverageUsage());
			jSpinnerMonthlyCostTariff1.setValue(data.getTariff11Cost());
			jSpinnerTariff11.setValue(data.getTariff11Fee());
			jSpinnerMonthlyCostTariff2.setValue(data.getTariff13Cost());
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
  
    	jSpinnerDailyAverageUsage.setBorder(clear);
    	jSpinnerDayTimeHourlyUsage.setBorder(clear);

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
    	
    	CustomerData data = new CustomerData();
    	
		if (validateInput) {
			if ((((Double)jSpinnerDailyAverageUsage.getValue()) == 0) && 
					(((Double)jSpinnerDayTimeHourlyUsage.getValue()) == 0)) {
				
				jSpinnerDailyAverageUsage.setBorder(borderError);
		    	jSpinnerDayTimeHourlyUsage.setBorder(borderError);
				// Oops, missing data, need to handle this.
				JOptionPane.showMessageDialog(this, "Please enter either an hourly usage, a daily usage or both.",
						"Estimated Usage Missing", JOptionPane.OK_OPTION);
				return false;
			}
		}
		SolarSetup global = parent.getSetup();
		if (global != null) {
			
			// Store the name and description fields.
			data.setDailyAverageUsage((Double) jSpinnerDailyAverageUsage.getValue());
			data.setHourlyAverageUsage((Double) jSpinnerDayTimeHourlyUsage.getValue());
			data.setTariff11Cost((Double) jSpinnerMonthlyCostTariff1.getValue());
			data.setTariff11Fee((Double) jSpinnerTariff11.getValue());
			data.setTariff13Cost((Double) jSpinnerMonthlyCostTariff2.getValue());
			data.setTariff13Fee((Double) jSpinnerTariff33.getValue());
			data.setAnnualTariffIncrease((Double) jSpinnerTariffIncrease.getValue());
			data.setFeedInFee((Double) jSpinnerFeedInFee.getValue());
			global.setCustomerData(data);
			
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
}
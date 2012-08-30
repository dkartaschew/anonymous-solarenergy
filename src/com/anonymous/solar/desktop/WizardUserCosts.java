/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.anonymous.solar.desktop;

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
    }
    
    /**
     * Creates new form WizardFinish, with reference to parent
     */
    public WizardUserCosts(Wizard parent) {
        initComponents();
        this.parent = parent;
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

        jSpinnerDayTimeHourlyUsage.setModel(new javax.swing.SpinnerNumberModel(0.0d, 0.0d, 24.0d, 1.0d));

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

        jLabelTariff11.setText("Tariff 11 Fee");

        jSpinnerTariff33.setModel(new javax.swing.SpinnerNumberModel(0.0d, 0.0d, 250.0d, 0.1d));

        jLabelTariff33.setText("Tariff 33 Fee");

        jLabelUsage.setText("Monthly Tariff 11 Cost:");

        jLabelUsage2.setText("Monthly Tariff 33 Cost:");

        jSpinnerMonthlyCostTariff1.setModel(new javax.swing.SpinnerNumberModel(Double.valueOf(0.0d), Double.valueOf(0.0d), null, Double.valueOf(25.0d)));

        jSpinnerMonthlyCostTariff2.setModel(new javax.swing.SpinnerNumberModel(Double.valueOf(0.0d), Double.valueOf(0.0d), null, Double.valueOf(25.0d)));

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
        return true;
    }


    /**
     * Callback method used by the parent panel to notify this panel that we
     * have requested a move away from this panel.
     *
     * @return true is ok to move.
     */
    @Override
    public boolean callbackDispose() {
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
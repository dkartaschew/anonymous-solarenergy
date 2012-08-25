/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.anonymous.solar.desktop;

/**
 *
 * @author darran
 */
public class WizardSetupElectrical extends javax.swing.JPanel implements WizardPanel {

    private final String title = "Electrical Setup";

    private Wizard parent = null;


    /**
     * Creates new form WizardFinish, with reference to parent
     */
    public WizardSetupElectrical(Wizard parent) {
        initComponents();
        this.parent = parent;
    }


    /**
     * Creates new form WizardSetupElectrical
     */
    public WizardSetupElectrical() {
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

        jPanelElectricalGroup = new javax.swing.JPanel();
        jLabelInverter = new javax.swing.JLabel();
        jTextFieldInverter = new javax.swing.JTextField();
        jButtonSetInverter = new javax.swing.JButton();
        jLabelInverterHeader = new javax.swing.JLabel();
        jLabelInverterDeatils = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jLabelWiringLength = new javax.swing.JLabel();
        jTextFieldWiringLength = new javax.swing.JTextField();
        jLabelWiringEfficiency = new javax.swing.JLabel();
        jTextFieldWiringEfficiency = new javax.swing.JTextField();

        jPanelElectricalGroup.setBorder(javax.swing.BorderFactory.createTitledBorder("Inverter"));

        jLabelInverter.setText("Inverter:");

        jButtonSetInverter.setText("...");

        jLabelInverterHeader.setText("Inverter Details:");

        jLabelInverterDeatils.setText("<unknown>");

        javax.swing.GroupLayout jPanelElectricalGroupLayout = new javax.swing.GroupLayout(jPanelElectricalGroup);
        jPanelElectricalGroup.setLayout(jPanelElectricalGroupLayout);
        jPanelElectricalGroupLayout.setHorizontalGroup(
            jPanelElectricalGroupLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelElectricalGroupLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanelElectricalGroupLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabelInverter)
                    .addComponent(jLabelInverterHeader))
                .addGap(26, 26, 26)
                .addGroup(jPanelElectricalGroupLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanelElectricalGroupLayout.createSequentialGroup()
                        .addComponent(jTextFieldInverter, javax.swing.GroupLayout.DEFAULT_SIZE, 408, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jButtonSetInverter))
                    .addGroup(jPanelElectricalGroupLayout.createSequentialGroup()
                        .addComponent(jLabelInverterDeatils)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanelElectricalGroupLayout.setVerticalGroup(
            jPanelElectricalGroupLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelElectricalGroupLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanelElectricalGroupLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelInverter)
                    .addComponent(jTextFieldInverter, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButtonSetInverter))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanelElectricalGroupLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelInverterHeader)
                    .addComponent(jLabelInverterDeatils))
                .addContainerGap(32, Short.MAX_VALUE))
        );

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Wiring"));

        jLabelWiringLength.setText("Wiring Length:");

        jLabelWiringEfficiency.setText("Wiring Efficiency:");
        jLabelWiringEfficiency.setToolTipText("");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabelWiringLength)
                .addGap(35, 35, 35)
                .addComponent(jTextFieldWiringLength)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabelWiringEfficiency)
                .addGap(21, 21, 21)
                .addComponent(jTextFieldWiringEfficiency)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelWiringLength)
                    .addComponent(jTextFieldWiringLength, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabelWiringEfficiency)
                    .addComponent(jTextFieldWiringEfficiency, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(16, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanelElectricalGroup, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanelElectricalGroup, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(89, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonSetInverter;
    private javax.swing.JLabel jLabelInverter;
    private javax.swing.JLabel jLabelInverterDeatils;
    private javax.swing.JLabel jLabelInverterHeader;
    private javax.swing.JLabel jLabelWiringEfficiency;
    private javax.swing.JLabel jLabelWiringLength;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanelElectricalGroup;
    private javax.swing.JTextField jTextFieldInverter;
    private javax.swing.JTextField jTextFieldWiringEfficiency;
    private javax.swing.JTextField jTextFieldWiringLength;
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
    public boolean callbackDispose() {
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

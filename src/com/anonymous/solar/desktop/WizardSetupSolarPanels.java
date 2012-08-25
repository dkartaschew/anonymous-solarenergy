/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.anonymous.solar.desktop;

import com.anonymous.solar.shared.SolarPanel;
import com.anonymous.solar.shared.SolarPanels;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

/**
 *
 * @author darran
 */
public class WizardSetupSolarPanels extends javax.swing.JPanel implements WizardPanel {

    private final String title = "Solar Panel Setup";

    private Wizard parent = null;

    ArrayList<SolarPanels> panels = new ArrayList<SolarPanels>();


    /**
     * Creates new form WizardFinish, with reference to parent
     */
    public WizardSetupSolarPanels(Wizard parent) {
        initComponents();
        this.parent = parent;
    }


    /**
     * Creates new form WizardSetupSolarPanels
     */
    public WizardSetupSolarPanels() {
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

        jPanelPanelInformationGroup = new javax.swing.JPanel();
        jScrollPaneSolarPanels = new javax.swing.JScrollPane();
        jTableSolarPanels = new javax.swing.JTable();
        jButtonAdd = new javax.swing.JButton();

        jPanelPanelInformationGroup.setBorder(javax.swing.BorderFactory.createTitledBorder("Panel Information"));

        jTableSolarPanels.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null}
            },
            new String [] {
                "Name", "Cost", "Wattage", "Life", "Efficiency"
            }
        ));
        jScrollPaneSolarPanels.setViewportView(jTableSolarPanels);

        jButtonAdd.setText("Add");
        jButtonAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonAddActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanelPanelInformationGroupLayout = new javax.swing.GroupLayout(jPanelPanelInformationGroup);
        jPanelPanelInformationGroup.setLayout(jPanelPanelInformationGroupLayout);
        jPanelPanelInformationGroupLayout.setHorizontalGroup(
            jPanelPanelInformationGroupLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelPanelInformationGroupLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanelPanelInformationGroupLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPaneSolarPanels, javax.swing.GroupLayout.DEFAULT_SIZE, 340, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelPanelInformationGroupLayout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jButtonAdd)))
                .addContainerGap())
        );
        jPanelPanelInformationGroupLayout.setVerticalGroup(
            jPanelPanelInformationGroupLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelPanelInformationGroupLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPaneSolarPanels, javax.swing.GroupLayout.DEFAULT_SIZE, 186, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addComponent(jButtonAdd)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanelPanelInformationGroup, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanelPanelInformationGroup, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonAdd;
    private javax.swing.JPanel jPanelPanelInformationGroup;
    private javax.swing.JScrollPane jScrollPaneSolarPanels;
    private javax.swing.JTable jTableSolarPanels;
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


    private void jButtonAddActionPerformed(java.awt.event.ActionEvent evt) {
        AddNewPanel panelSet = new AddNewPanel(new JFrame(), true);
        panelSet.setVisible(true);
        JOptionPane optionPane;
        int response;
        final int YES = 0;
        final int NO = 1;

        boolean success = panelSet.GetSuccess();

        //if panel was created successfully
        if (success) {
            SolarPanels solPanels = panelSet.GetPanels();
            SolarPanel solPanel = solPanels.getPanelType();

            //Let user know what they are submitting and final check
            String data = String.valueOf(
                    "You have orderd " + solPanels.getPanelCount() + " panels\n"
                    + "Your panels are facing " + solPanels.getPanelDirection()
                    + " with an azimuth of " + solPanels.getPanelAzimuth() + ".\n\n"
                    + "Name: \t\t" + solPanel.getPanelName() + "\n"
                    + "Cost: \t\t$" + solPanel.getPanelCost() + "\n"
                    + "Wattage: \t\t" + solPanel.getPanelWattage() + " W\n"
                    + "Life: \t\t" + solPanel.getPanelLifeYears() + " years\n"
                    + "Efficiency: \t\t" + solPanel.getPanelLossYear() + "%");

            optionPane = new JOptionPane(
                    data,
                    JOptionPane.QUESTION_MESSAGE,
                    JOptionPane.DEFAULT_OPTION);

            response = JOptionPane.showConfirmDialog(new JFrame(), data);

            //submit panel if user chose yes
            if (response == YES) {
                panels.add(solPanels);
                UpdateTable();
            }
        }

        panelSet.dispose();
    }


    private void UpdateTable() {

        int size = panels.size();
        int count = 0;
        Object[][] panelData = new Object[size][7];
        JButton button = new JButton();

        for (SolarPanels panel : panels) {
            panelData[count][0] = panel.getPanelType().getPanelName();
            panelData[count][1] = panel.getPanelType().getPanelCost();
            panelData[count][2] = panel.getPanelType().getPanelWattage();
            panelData[count][3] = panel.getPanelType().getPanelLifeYears();
            panelData[count][4] = panel.getPanelType().getPanelLossYear();
            panelData[count][5] = panel.getPanelCount();
            panelData[count][6] = "delete";
            count++;
        }

        jTableSolarPanels.setModel(new javax.swing.table.DefaultTableModel(
                panelData,
                new String[]{
                    "Name", "Cost", "Wattage", "Life", "Loss %", "Number", "Delete"
                }));


    }
}

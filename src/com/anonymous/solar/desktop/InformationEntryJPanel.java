/**
 * 
 */
package com.anonymous.solar.desktop;

import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

import com.anonymous.solar.shared.SolarInverter;
import com.anonymous.solar.shared.SolarPanel;
import com.anonymous.solar.shared.SolarPanels;

/**
 * Information Entry Panel for Desktop Application
 * 
 * @author 07627505 Darran Kartaschew
 * @version 1.0
 */
public class InformationEntryJPanel extends javax.swing.JPanel {

    /**
	 * Serial ID
	 */
	private static final long serialVersionUID = -3321276319902514732L;
	/*
	 * Variable(s) to hold the solar setup details
	 */
	ArrayList<SolarPanels> panels = new ArrayList<SolarPanels>();
	SolarInverter inverter = null;
	
	/*
	/**
     * Creates new form InformationEntryJPanel
     */
    public InformationEntryJPanel() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanelDetailsGroup = new javax.swing.JPanel();
        jLabelSetupName = new javax.swing.JLabel();
        jTextFieldSetupName = new javax.swing.JTextField();
        jLabelSetupDescription = new javax.swing.JLabel();
        jScrollPaneSetupDescription = new javax.swing.JScrollPane();
        jTextAreaSetupDescription = new javax.swing.JTextArea();
        jLabelLocation = new javax.swing.JLabel();
        jTextFieldLocation = new javax.swing.JTextField();
        jButtonSetLocation = new javax.swing.JButton();
        jPanelElectricalGroup = new javax.swing.JPanel();
        jLabelInverter = new javax.swing.JLabel();
        jTextFieldInverter = new javax.swing.JTextField();
        jButtonSetInverter = new javax.swing.JButton();
        jLabelWiringLength = new javax.swing.JLabel();
        jTextFieldWiringLength = new javax.swing.JTextField();
        jLabelWiringEfficiency = new javax.swing.JLabel();
        jTextFieldWiringEfficiency = new javax.swing.JTextField();
        jPanelPanelInformationGroup = new javax.swing.JPanel();
        jScrollPaneSolarPanels = new javax.swing.JScrollPane();
        jTableSolarPanels = new javax.swing.JTable();
        jButtonAdd = new javax.swing.JButton();
        jButtonCalculate = new javax.swing.JButton();
        
        jTextFieldInverter.setEditable(false);

        jPanelDetailsGroup.setBorder(javax.swing.BorderFactory.createTitledBorder("Details"));
        jPanelDetailsGroup.setName("Details"); // NOI18N

        jLabelSetupName.setText("Setup Name:");

        jLabelSetupDescription.setText("Setup Description:");

        jTextAreaSetupDescription.setColumns(20);
        jTextAreaSetupDescription.setRows(3);
        jScrollPaneSetupDescription.setViewportView(jTextAreaSetupDescription);

        jLabelLocation.setText("Location:");

        jTextFieldLocation.setEditable(false);

        jButtonSetLocation.setText("...");

        javax.swing.GroupLayout jPanelDetailsGroupLayout = new javax.swing.GroupLayout(jPanelDetailsGroup);
        jPanelDetailsGroup.setLayout(jPanelDetailsGroupLayout);
        jPanelDetailsGroupLayout.setHorizontalGroup(
            jPanelDetailsGroupLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelDetailsGroupLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanelDetailsGroupLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabelSetupName)
                    .addComponent(jLabelLocation)
                    .addComponent(jLabelSetupDescription))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanelDetailsGroupLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jTextFieldSetupName)
                    .addComponent(jScrollPaneSetupDescription)
                    .addGroup(jPanelDetailsGroupLayout.createSequentialGroup()
                        .addComponent(jTextFieldLocation)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jButtonSetLocation)))
                .addContainerGap())
        );
        jPanelDetailsGroupLayout.setVerticalGroup(
            jPanelDetailsGroupLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelDetailsGroupLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanelDetailsGroupLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelSetupName)
                    .addComponent(jTextFieldSetupName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanelDetailsGroupLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPaneSetupDescription, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabelSetupDescription))
                .addGap(18, 18, 18)
                .addGroup(jPanelDetailsGroupLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanelDetailsGroupLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jTextFieldLocation, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabelLocation))
                    .addComponent(jButtonSetLocation))
                .addContainerGap(25, Short.MAX_VALUE))
        );

        jPanelElectricalGroup.setBorder(javax.swing.BorderFactory.createTitledBorder("Electrical Components"));

        jLabelInverter.setText("Inverter:");

        jButtonSetInverter.setText("...");
        jButtonSetInverter.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonSetInverterActionPerformed(evt);
            }
        });

        jLabelWiringLength.setText("Wiring Length:");

        jLabelWiringEfficiency.setText("Wiring Efficiency:");
        jLabelWiringEfficiency.setToolTipText("");

        javax.swing.GroupLayout jPanelElectricalGroupLayout = new javax.swing.GroupLayout(jPanelElectricalGroup);
        jPanelElectricalGroup.setLayout(jPanelElectricalGroupLayout);
        jPanelElectricalGroupLayout.setHorizontalGroup(
            jPanelElectricalGroupLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelElectricalGroupLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanelElectricalGroupLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabelInverter)
                    .addComponent(jLabelWiringLength))
                .addGap(38, 38, 38)
                .addGroup(jPanelElectricalGroupLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanelElectricalGroupLayout.createSequentialGroup()
                        .addComponent(jTextFieldInverter)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jButtonSetInverter))
                    .addGroup(jPanelElectricalGroupLayout.createSequentialGroup()
                        .addComponent(jTextFieldWiringLength)
                        .addGap(18, 18, 18)
                        .addComponent(jLabelWiringEfficiency)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTextFieldWiringEfficiency)))
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
                .addGap(18, 18, 18)
                .addGroup(jPanelElectricalGroupLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelWiringLength)
                    .addComponent(jTextFieldWiringLength, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabelWiringEfficiency)
                    .addComponent(jTextFieldWiringEfficiency, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(16, Short.MAX_VALUE))
        );

        jPanelPanelInformationGroup.setBorder(javax.swing.BorderFactory.createTitledBorder("Panel Information"));

        // TODO: Update table model as needed.
        jTableSolarPanels.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null}
            },
            new String [] {
	                    "Name", "Cost", "Wattage", "Life", "Loss %", "Number", "Delete"
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
                    .addComponent(jScrollPaneSolarPanels, javax.swing.GroupLayout.DEFAULT_SIZE, 636, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelPanelInformationGroupLayout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jButtonAdd)))
                .addContainerGap())
        );
        jPanelPanelInformationGroupLayout.setVerticalGroup(
            jPanelPanelInformationGroupLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelPanelInformationGroupLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPaneSolarPanels, javax.swing.GroupLayout.DEFAULT_SIZE, 124, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addComponent(jButtonAdd)
                .addContainerGap())
        );

        jButtonCalculate.setText("Calculate");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanelPanelInformationGroup, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanelDetailsGroup, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanelElectricalGroup, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jButtonCalculate)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanelDetailsGroup, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanelElectricalGroup, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanelPanelInformationGroup, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButtonCalculate)
                .addGap(6, 6, 6))
        );
    }// </editor-fold>//GEN-END:initComponents
    
    private void jButtonSetInverterActionPerformed(java.awt.event.ActionEvent evt) {
        Inverter invert = new Inverter(new JFrame(), true);
        
        if(inverter != null){
        	invert.LoadInverter(inverter);
        }
        
        invert.setVisible(true);
        
        JOptionPane optionPane;
    	int response;
    	final int YES = 0;
    	final int NO = 1;
        
        boolean success = invert.GetSuccess();
        
        //if panel was created successfully
        if(success){
        	SolarInverter inverter = invert.GetInverter();
            
            //Let user know what they are submitting and final check
	        String data = String.valueOf(
	        		"Name: \t\t" + inverter.getInverterName() + "\n" +
	        		"Cost: \t\t$" + inverter.getInverterCost() + "\n" + 
	        		"Wattage: \t\t" + inverter.getInverterWattage() + " W\n" + 
	        		"Life: \t\t" + inverter.getInverterLifeYears() + " years\n" +
	        		"Efficiency: \t\t" + inverter.getInverterLossYear() + "%");
	        
	        optionPane = new JOptionPane(
	        	    data,
	        	    JOptionPane.QUESTION_MESSAGE,
	        	    JOptionPane.DEFAULT_OPTION);
	        
	        response = JOptionPane.showConfirmDialog(new JFrame(), data);
	        
	        //submit panel if user chose yes
	        if(response == YES){
		        this.inverter = inverter;
		        jTextFieldInverter.setText(inverter.getInverterName());
		        jButtonSetInverter.setText("Edit");
	        }
        }
        
        invert.dispose();
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
        if(success){
        	SolarPanels solPanels = panelSet.GetPanels();
            SolarPanel solPanel = solPanels.getPanelType();
            
            //Let user know what they are submitting and final check
	        String data = String.valueOf(
	        		"You have orderd " + solPanels.getPanelCount() + " panels\n" +
	        		"Your panels are facing " + solPanels.getPanelDirection() +
	        		" with an azimuth of " + solPanels.getPanelAzimuth() + ".\n\n" +
	        		"Name: \t\t" + solPanel.getPanelName() + "\n" +
	        		"Cost: \t\t$" + solPanel.getPanelCost() + "\n" + 
	        		"Wattage: \t\t" + solPanel.getPanelWattage() + " W\n" + 
	        		"Life: \t\t" + solPanel.getPanelLifeYears() + " years\n" +
	        		"Efficiency: \t\t" + solPanel.getPanelLossYear() + "%");
	        
	        optionPane = new JOptionPane(
	        	    data,
	        	    JOptionPane.QUESTION_MESSAGE,
	        	    JOptionPane.DEFAULT_OPTION);
	        
	        response = JOptionPane.showConfirmDialog(new JFrame(), data);
	        
	        //submit panel if user chose yes
	        if(response == YES){
		        panels.add(solPanels);
		        UpdateTable();
	        }
        }
        
        panelSet.dispose();
    }
    
	private void UpdateTable(){
		
			int size = panels.size();
			int count = 0;
			Object[][] panelData = new Object[size][7];
			JButton button = new JButton();
	    	
	    	for(SolarPanels panel: panels){
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
	                new String [] {
	                    "Name", "Cost", "Wattage", "Life", "Loss %", "Number", "Delete"
	                }
	            ));
	    	
	    	
	}
	
	


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonAdd;
    private javax.swing.JButton jButtonCalculate;
    private javax.swing.JButton jButtonSetInverter;
    private javax.swing.JButton jButtonSetLocation;
    private javax.swing.JLabel jLabelInverter;
    private javax.swing.JLabel jLabelLocation;
    private javax.swing.JLabel jLabelSetupDescription;
    private javax.swing.JLabel jLabelSetupName;
    private javax.swing.JLabel jLabelWiringEfficiency;
    private javax.swing.JLabel jLabelWiringLength;
    private javax.swing.JPanel jPanelDetailsGroup;
    private javax.swing.JPanel jPanelElectricalGroup;
    private javax.swing.JPanel jPanelPanelInformationGroup;
    private javax.swing.JScrollPane jScrollPaneSetupDescription;
    private javax.swing.JScrollPane jScrollPaneSolarPanels;
    private javax.swing.JTable jTableSolarPanels;
    private javax.swing.JTextArea jTextAreaSetupDescription;
    private javax.swing.JTextField jTextFieldInverter;
    private javax.swing.JTextField jTextFieldLocation;
    private javax.swing.JTextField jTextFieldSetupName;
    private javax.swing.JTextField jTextFieldWiringEfficiency;
    private javax.swing.JTextField jTextFieldWiringLength;
    // End of variables declaration//GEN-END:variables
}

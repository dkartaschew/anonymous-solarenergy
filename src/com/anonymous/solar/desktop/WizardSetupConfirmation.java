/*
 *
 */
package com.anonymous.solar.desktop;

import java.awt.Color;

import com.anonymous.solar.shared.SolarSetup;

/**
 * Panel for the wizard that displays the contents of the SolarSetup class, and
 * will stop the user from proceeding if any information is missing.
 * 
 * @author 07627505 Darran Kartaschew
 * @version 1.0
 */
public class WizardSetupConfirmation extends javax.swing.JPanel implements WizardPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 5109017302999808743L;
	private final String title = "Setup Confirmation";
	private Wizard parent = null;

	/**
	 * Creates new form WizardFinish, with reference to parent
	 */
	public WizardSetupConfirmation(Wizard parent) {
		initComponents();
		this.parent = parent;
		
	}

	/**
	 * Creates new form WizardSetupConfirmation
	 */
	public WizardSetupConfirmation() {
		initComponents();
	}

	/**
	 * This method is called from within the constructor to initialize the form.
	 * WARNING: Do NOT modify this code. The content of this method is always
	 * regenerated by the Form Editor.
	 */
	@SuppressWarnings("unchecked")
	// <editor-fold defaultstate="collapsed"
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabelConfirmationMsg = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTextAreaConfirmationDetails = new javax.swing.JEditorPane();
        jLabel1 = new javax.swing.JLabel();
        jSpinnerTimeFrame = new javax.swing.JSpinner();

        jLabelConfirmationMsg.setText("If you are happy with the details above, please click on Next to generate a report");

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Current Setup Details"));

        jScrollPane2.setMinimumSize(new java.awt.Dimension(22, 22));

        jTextAreaConfirmationDetails.setContentType("text/html"); // NOI18N
        jScrollPane2.setViewportView(jTextAreaConfirmationDetails);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 198, Short.MAX_VALUE)
                .addContainerGap())
        );

        jLabel1.setText("Set number of years to calculate for");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jLabelConfirmationMsg))
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jSpinnerTimeFrame, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jSpinnerTimeFrame, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 22, Short.MAX_VALUE)
                .addComponent(jLabelConfirmationMsg)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabelConfirmationMsg;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JSpinner jSpinnerTimeFrame;
    private javax.swing.JEditorPane jTextAreaConfirmationDetails;
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
		jSpinnerTimeFrame.setValue(parent.getTimeFrame());
		if (global != null) {
			jTextAreaConfirmationDetails.setText(global.toString());
			// TODO: Add in checks to see if any invalid data, and if so, disable the NEXT button.
		}
		return true;
	}

	/**
	 * Callback method used by the parent panel to notify this panel that we
	 * have requested a move away from this panel.
	 * 
	 * @return true is ok to move.
	 */
	@Override
	public boolean callbackDispose(boolean validateInput) {
		javax.swing.border.LineBorder clear = new javax.swing.border.LineBorder(Color.white, 0);
		javax.swing.border.LineBorder red = new javax.swing.border.LineBorder(Color.red, 2);
		jSpinnerTimeFrame.setBorder(clear);
		
		try{
			Integer years = (Integer) jSpinnerTimeFrame.getValue();
			parent.setTimeFrame(years);
			return true;
			
			
		} catch (Exception e) {
			jSpinnerTimeFrame.setBorder(red);
			return false;
		}
		
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

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.anonymous.solar.desktop;

/**
 *
 * @author darran
 */
public class WizardFinish extends javax.swing.JPanel implements WizardPanel {

    private final String title = "Complete";
    private Wizard parent = null;
    
    /**
     * Creates new form WizardFinish, with reference to parent
     */
    public WizardFinish(Wizard parent) {
        initComponents();
        this.parent = parent;
    }
    
    /**
     * Creates new form WizardFinish
     */
    public WizardFinish() {
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

        jLabelFinishMsg = new javax.swing.JLabel();

        jLabelFinishMsg.setText("<html> <h1>Thank you</h1> <p>Thank you for using the Solar Energy Calculator.</p> <p>If you have any questions please do not hesitate to contact the development team.</p> </html>");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabelFinishMsg, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabelFinishMsg, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabelFinishMsg;
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
    public boolean callbackDispose(boolean validateInput) {
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
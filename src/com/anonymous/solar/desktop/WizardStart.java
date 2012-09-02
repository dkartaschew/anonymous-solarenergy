/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.anonymous.solar.desktop;

/**
 * Main Entry Point for Wizard Panels.
 * 
 * @author 07627505 Darran Kartaschew
 * @version 1.0
 */
public class WizardStart extends javax.swing.JPanel implements WizardPanel {

    /**
	 * 
	 */
	private static final long serialVersionUID = -3384417351508564096L;

	private final String title = "";

    private Wizard parent = null;


    /**
     * Creates new form WizardFinish, with reference to parent
     */
    public WizardStart(Wizard parent) {
        initComponents();
        this.parent = parent;
    }


    /**
     * Creates new form WizardInformation
     */
    public WizardStart() {
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

        jLabelMainDescription = new javax.swing.JLabel();
        labelMainTitle = new javax.swing.JLabel();
        imageSolar = new javax.swing.JLabel();
        
        jLabelMainDescription.setName("mainDescription");
        labelMainTitle.setName("mainTitle");
        imageSolar.setName("imageSolar");

        jLabelMainDescription.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelMainDescription.setText("<html>\n<center>\nA simple Solar Power Calculator<br>\nfor domestic installations.<br>\n<br>\n<small>Copyright 2012, Team Anonymous (QUT)<br>\nReleased under the GPL v3 license</small>\n</center>\n</html>");
        jLabelMainDescription.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        labelMainTitle.setFont(new java.awt.Font("Verdana", 1, 24)); // NOI18N
        labelMainTitle.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labelMainTitle.setText("Solar Energy Calculator");
        labelMainTitle.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        imageSolar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/anonymous/solar/desktop/images/solar_power_flower.jpg"))); // NOI18N
        imageSolar.setPreferredSize(new java.awt.Dimension(400, 300));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(122, 122, 122)
                .addComponent(imageSolar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(118, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(labelMainTitle, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabelMainDescription))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(imageSolar, javax.swing.GroupLayout.PREFERRED_SIZE, 238, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(labelMainTitle)
                .addGap(18, 18, 18)
                .addComponent(jLabelMainDescription, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(68, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel imageSolar;
    private javax.swing.JLabel jLabelMainDescription;
    private javax.swing.JLabel labelMainTitle;
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

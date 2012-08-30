/*
 * 
 */
package com.anonymous.solar.desktop;

import java.awt.BorderLayout;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

/**
 * Main Entry Point for the wizard interface for the Desktop Application
 * 
 * @author 07627505 Darran Kartaschew
 * @version 1.0
 */
public class Wizard extends javax.swing.JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = -8415093022775319312L;

	/**
	 * Arraylist to hold all the panels that get displayed as part of the wizard
	 */
	private ArrayList<JPanel> panels = new ArrayList<JPanel>();

	/**
	 * Reference to the parent frame.
	 */
	private javax.swing.JFrame parentFrame = null;

	/**
	 * Index into the ArrayList, so we know the current we are on.
	 */
	private int wizardIndex = 0;

	/**
	 * Creates new form Wizard
	 */
	public Wizard(javax.swing.JFrame parent) {
		initComponents();
		jButtonBack.setVisible(false);
		initWizardPanels();
	}

	/**
	 * This method is called from within the constructor to initialize the form.
	 * WARNING: Do NOT modify this code. The content of this method is always
	 * regenerated by the Form Editor.
	 */
	@SuppressWarnings("unchecked")
	// <editor-fold defaultstate="collapsed"
	// desc="Generated Code">//GEN-BEGIN:initComponents
	private void initComponents() {

		jSeparator1 = new javax.swing.JSeparator();
		jButtonBack = new javax.swing.JButton();
		jButtonNext = new javax.swing.JButton();
		jButtonClose = new javax.swing.JButton();
		jPanelMainContent = new javax.swing.JPanel();
		jLabelHeader = new javax.swing.JLabel();
		jSeparator2 = new javax.swing.JSeparator();

		jButtonBack.setIcon(new javax.swing.ImageIcon(getClass().getResource(
				"/com/anonymous/solar/desktop/images/go-previous.png"))); // NOI18N
		jButtonBack.setText("Back");
		jButtonBack.setToolTipText("");
		jButtonBack.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				jButtonBackActionPerformed(evt);
			}
		});

		jButtonNext.setIcon(new javax.swing.ImageIcon(getClass().getResource(
				"/com/anonymous/solar/desktop/images/go-next.png"))); // NOI18N
		jButtonNext.setText("Next");
		jButtonNext.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				jButtonNextActionPerformed(evt);
			}
		});

		jButtonClose.setIcon(new javax.swing.ImageIcon(getClass().getResource(
				"/com/anonymous/solar/desktop/images/window-close.png"))); // NOI18N
		jButtonClose.setText("Close");
		jButtonClose.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				jButtonCloseActionPerformed(evt);
			}
		});

		javax.swing.GroupLayout jPanelMainContentLayout = new javax.swing.GroupLayout(jPanelMainContent);
		jPanelMainContent.setLayout(jPanelMainContentLayout);
		jPanelMainContentLayout.setHorizontalGroup(jPanelMainContentLayout.createParallelGroup(
				javax.swing.GroupLayout.Alignment.LEADING).addGap(0, 616, Short.MAX_VALUE));
		jPanelMainContentLayout.setVerticalGroup(jPanelMainContentLayout.createParallelGroup(
				javax.swing.GroupLayout.Alignment.LEADING).addGap(0, 307, Short.MAX_VALUE));

		jLabelHeader.setFont(jLabelHeader.getFont().deriveFont(jLabelHeader.getFont().getStyle() | java.awt.Font.BOLD,
				jLabelHeader.getFont().getSize() + 7));
		jLabelHeader.setText("<Header>");

		javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
		this.setLayout(layout);
		layout.setHorizontalGroup(layout
				.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(
						layout.createSequentialGroup()
								.addContainerGap()
								.addGroup(
										layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
												.addComponent(jPanelMainContent,
														javax.swing.GroupLayout.Alignment.TRAILING,
														javax.swing.GroupLayout.DEFAULT_SIZE,
														javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
												.addGroup(
														javax.swing.GroupLayout.Alignment.TRAILING,
														layout.createSequentialGroup()
																.addGap(0, 0, Short.MAX_VALUE)
																.addComponent(jButtonBack,
																		javax.swing.GroupLayout.PREFERRED_SIZE, 90,
																		javax.swing.GroupLayout.PREFERRED_SIZE)
																.addPreferredGap(
																		javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
																.addComponent(jButtonNext,
																		javax.swing.GroupLayout.PREFERRED_SIZE, 90,
																		javax.swing.GroupLayout.PREFERRED_SIZE)
																.addGap(33, 33, 33)
																.addComponent(jButtonClose,
																		javax.swing.GroupLayout.PREFERRED_SIZE, 90,
																		javax.swing.GroupLayout.PREFERRED_SIZE))
												.addComponent(jSeparator1, javax.swing.GroupLayout.Alignment.TRAILING,
														javax.swing.GroupLayout.DEFAULT_SIZE, 616, Short.MAX_VALUE)
												.addComponent(jSeparator2)).addContainerGap())
				.addGroup(
						layout.createSequentialGroup().addGap(36, 36, 36).addComponent(jLabelHeader)
								.addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)));
		layout.setVerticalGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(
						javax.swing.GroupLayout.Alignment.TRAILING,
						layout.createSequentialGroup()
								.addGap(18, 18, 18)
								.addComponent(jLabelHeader)
								.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
								.addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 10,
										javax.swing.GroupLayout.PREFERRED_SIZE)
								.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
								.addComponent(jPanelMainContent, javax.swing.GroupLayout.DEFAULT_SIZE,
										javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
								.addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE,
										javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
								.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
								.addGroup(
										layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
												.addComponent(jButtonClose).addComponent(jButtonNext)
												.addComponent(jButtonBack)).addContainerGap()));
	}// </editor-fold>//GEN-END:initComponents

	/**
	 * Event handler for the Close Button in the main panel.
	 * 
	 * @param evt
	 *            GUI evt
	 */
	private void jButtonCloseActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_jButtonCloseActionPerformed
		// Are you sure to exit dialog?
		int n = JOptionPane.showConfirmDialog(parentFrame, "Are you sure you want to exit?", "Exit Confirmation",
				JOptionPane.YES_NO_OPTION);
		if (n == JOptionPane.YES_OPTION) {
			System.exit(0);
		}
	}// GEN-LAST:event_jButtonCloseActionPerformed

	/**
	 * Event handler for the Next Button in the main panel.
	 * 
	 * @param evt
	 */
	private void jButtonNextActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_jButtonNextActionPerformed
		if (wizardIndex + 1 < panels.size()) {
			boolean changePanel = false;
			try {
				changePanel = ((WizardPanel) panels.get(wizardIndex)).callbackDispose();
			} catch (Exception e) {
			}
			if (changePanel) {
				setWizardPanel(++wizardIndex);
			}
		}
		jButtonBack.setVisible(true);
		jButtonBack.setEnabled(true);
		if (wizardIndex + 1 == panels.size()) {
			jButtonNext.setEnabled(false);
		}
	}// GEN-LAST:event_jButtonNextActionPerformed

	/**
	 * Event handler for the Back Button in the main panel.
	 * 
	 * @param evt
	 */
	private void jButtonBackActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_jButtonBackActionPerformed
		if (wizardIndex > 0) {
			boolean changePanel = false;
			try {
				changePanel = ((WizardPanel) panels.get(wizardIndex)).callbackDispose();
			} catch (Exception e) {
			}
			if (changePanel) {
				setWizardPanel(--wizardIndex);
			}
		}
		jButtonNext.setEnabled(true);
		if (wizardIndex == 0) {
			jButtonBack.setVisible(false);
		}
	}// GEN-LAST:event_jButtonBackActionPerformed
		// Variables declaration - do not modify//GEN-BEGIN:variables

	private javax.swing.JButton jButtonBack;
	private javax.swing.JButton jButtonClose;
	private javax.swing.JButton jButtonNext;
	private javax.swing.JLabel jLabelHeader;
	private javax.swing.JPanel jPanelMainContent;
	private javax.swing.JSeparator jSeparator1;
	private javax.swing.JSeparator jSeparator2;

	// End of variables declaration//GEN-END:variables

	/**
	 * Initialise all the panels we wish to have displayed, as part of the
	 * Wizard
	 */
	private void initWizardPanels() {
		panels.add(new WizardStart(this));
		// panels.add(new WizardUser(this));
		panels.add(new WizardSetupDescription(this));
		panels.add(new WizardSetupElectrical(this));
		panels.add(new WizardSetupSolarPanels(this));
		panels.add(new WizardSetupConfirmation(this));
		panels.add(new WizardResults(this));
		panels.add(new WizardFinish(this));

		// Set to show the first panel.
		setWizardPanel(wizardIndex);
	}

	/**
	 * Set which panel of the panels collection we wish to display within the
	 * main window.
	 * 
	 * @param index
	 */
	private void setWizardPanel(int index) {
		jPanelMainContent.removeAll();
		jPanelMainContent.setLayout(new BorderLayout());
		jPanelMainContent.add(panels.get(index));
		String title = ((WizardPanel) panels.get(index)).getTitle();
		// If no title, then disable the title section of the panel.
		if (title.compareTo("") == 0) {
			jLabelHeader.setVisible(false);
			jSeparator2.setVisible(false);
		} else {
			jLabelHeader.setText(title);
			jLabelHeader.setVisible(true);
			jSeparator2.setVisible(true);
		}
		// Try to call the start handler of the panel.
		try {
			((WizardPanel) panels.get(index)).callbackStart();
		} catch (Exception e) {
		}
		// Update the UI of the main panel.
		revalidate();
		updateUI();
	}

	/**
	 * Retrieve the reference to the back button, so client panels may change
	 * it's settings.
	 * 
	 * @return The Back button.
	 */
	public javax.swing.JButton getBackButton() {
		return jButtonBack;
	}

	/**
	 * Retrieve the reference to the next button, so client panels may change
	 * it's settings.
	 * 
	 * @return The Next Button.
	 */
	public javax.swing.JButton getNextButton() {
		return jButtonNext;
	}
}

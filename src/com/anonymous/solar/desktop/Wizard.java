/*
 * 
 */
package com.anonymous.solar.desktop;

import java.awt.BorderLayout;
import java.awt.Desktop;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import com.anonymous.solar.shared.CustomerData;
import com.anonymous.solar.shared.LocationData;
import com.anonymous.solar.shared.LocationDataException;
import com.anonymous.solar.shared.SolarInverter;
import com.anonymous.solar.shared.SolarPanel;
import com.anonymous.solar.shared.SolarPanelException;
import com.anonymous.solar.shared.SolarPanels;
import com.anonymous.solar.shared.SolarPanelsException;
import com.anonymous.solar.shared.SolarResult;
import com.anonymous.solar.shared.SolarSetup;
import com.anonymous.solar.shared.SolarSetupException;
import com.anonymous.solar.shared.TariffRate;

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
	 * Solar Setup Data
	 */
	private SolarSetup setup = new SolarSetup();
	
	private SolarResult results;
	
	private Integer timeFrame = 10;

	/**
	 * Arraylist to hold all the panels that get displayed as part of the wizard
	 */
	private ArrayList<JPanel> panels = new ArrayList<JPanel>();
	private ArrayList<JButton> sideBarButtons = new ArrayList<JButton>();

	/**
	 * Reference to the parent frame.
	 */
	private javax.swing.JFrame parentFrame = null;

	/**
	 * Index into the ArrayList, so we know the current we are on.
	 */
	private int wizardIndex = 0;

	// Variables declaration - do not modify//GEN-BEGIN:variables
	private javax.swing.JButton jButtonBack;
	private javax.swing.JButton jButtonClose;
	private javax.swing.JButton jButtonNext;
	private javax.swing.JLabel jLabelApplicationImage;
	private javax.swing.JLabel jLabelHeader;
	private javax.swing.JPanel jPanelMainContent;
	private javax.swing.JPanel jPanelSideBar;
	private javax.swing.JSeparator jSeparator1;
	private javax.swing.JSeparator jSeparator2;
	private javax.swing.JSeparator jSeparator3;

	// End of variables declaration//GEN-END:variables

	/**
	 * Creates new form Wizard
	 * @throws SolarPanelsException 
	 */
	public Wizard(javax.swing.JFrame parent) {
		initComponents();
		jButtonBack.setVisible(false);
		initWizardPanels();
		
		

		// if a web browser is the default HTML handler, this might work too
		

		
	}
	
		
	
	/**
	 * Load dummy data in wizard for manual UI testing.
	 * @throws SolarPanelException
	 * @throws LocationDataException
	 * @throws SolarPanelsException
	 */
	private void LoadTestData() throws SolarPanelException, LocationDataException, SolarPanelsException{
		SolarPanel slow = new SolarPanel("PAN_SLOW_DEGRADE", "D_MANU", "D_MANU_CODE", 100.0, 1.0, 100.0, 100.0, 30);
		SolarPanel medium = new SolarPanel("PAN_MED_DEGRADE", "D_MANU", "D_MANU_CODE", 100.0, 2.0, 100.0, 100.0, 30);
		SolarPanel fast = new SolarPanel("PAN_FAST_DEGRADE", "D_MANU", "D_MANU_CODE", 100.0, 4.0, 100.0, 100.0, 30);
		ArrayList<Double> monthData = new ArrayList<Double>();
		for(Double i = 0.0; i < 12; i++){
			monthData.add(i);
		}
		
		try{
		//String and Double Data
		setup.setSetupName("DEFAULT_TITLE");
		setup.setSetupDescription("DEFAULT_DESCRIPTION");
		setup.setWireEfficiency(15.0);
		setup.setWireLength(15.0);
		
		//Panel Data
		List<SolarPanels> panels = setup.getSolarPanels();
		panels.add(new SolarPanels(slow, 5, 0.0, 5.0));//NORTH
		panels.add(new SolarPanels(medium, 5, 90.0, 5.0));//EAST
		panels.add(new SolarPanels(fast, 5, 180.0, 5.0));//SOUTH
		
		//Customer Data
		CustomerData customer = new CustomerData(24.0, 1.0, 720.0, 5.0, 0.1, 7.0, 0.2, 10.0, 1.0);
		setup.setCustomerData(customer);
		
		//Location Data
		LocationData location = new LocationData(12.314890, 23.8765430, "DEFAULT_NAME", monthData, monthData);
		setup.setLocationInformation(location);
		
		//Inverter Data
		SolarInverter invert = new SolarInverter("DEF_TITLE", "D_MANU", "D_MANU_CODE", 100.0, 5.0, 100.0, 100.0, 100.0, 30);
		setup.setInverter(invert);
		} catch (SolarSetupException e){
			
		}
	}

	private SolarSetup GetTestData() throws SolarPanelException, LocationDataException, SolarPanelsException{
		SolarSetup setup = new SolarSetup();
		SolarPanel slow = new SolarPanel("PAN_SLOW_DEGRADE", "D_MANU", "D_MANU_CODE", 100.0, 1.0, 100.0, 100.0, 30);
		SolarPanel medium = new SolarPanel("PAN_MED_DEGRADE", "D_MANU", "D_MANU_CODE", 100.0, 2.0, 100.0, 100.0, 30);
		SolarPanel fast = new SolarPanel("PAN_FAST_DEGRADE", "D_MANU", "D_MANU_CODE", 100.0, 4.0, 100.0, 100.0, 30);
		ArrayList<Double> monthData = new ArrayList<Double>();
		for(Double i = 0.0; i < 12; i++){
			monthData.add(i);
		}
		
		try{
		//String and Double Data
		setup.setSetupName("DEFAULT_TITLE");
		setup.setSetupDescription("DEFAULT_DESCRIPTION");
		setup.setWireEfficiency(15.0);
		setup.setWireLength(15.0);
		
		//Panel Data
		List<SolarPanels> panels = setup.getSolarPanels();
		panels.add(new SolarPanels(slow, 5, 0.0, 5.0));//NORTH
		panels.add(new SolarPanels(medium, 5, 90.0, 5.0));//EAST
		panels.add(new SolarPanels(fast, 5, 180.0, 5.0));//SOUTH
		
		//Customer Data
		CustomerData customer = new CustomerData(24.0, 1.0, 720.0, 5.0, 0.1, 7.0, 0.2, 10.0, 1.0);
		setup.setCustomerData(customer);
		
		//Location Data
		LocationData location = new LocationData(12.314890, 23.8765430, "DEFAULT_NAME", monthData, monthData);
		setup.setLocationInformation(location);
		
		//Inverter Data
		SolarInverter invert = new SolarInverter("DEF_TITLE", "D_MANU", "D_MANU_CODE", 100.0, 5.0, 100.0, 100.0, 100.0, 30);
		setup.setInverter(invert);
		} catch (SolarSetupException e){
			return new SolarSetup();
		}
		
		return setup;
	}

	/**
	 * This method is called from within the constructor to initialize the form.
	 * WARNING: Do NOT modify this code. The content of this method is always
	 * regenerated by the Form Editor.
	 */
	@SuppressWarnings("unchecked")
	// <editor-fold defaultstate="collapsed"
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
		jPanelSideBar = new javax.swing.JPanel();
		jSeparator3 = new javax.swing.JSeparator();
		jLabelApplicationImage = new javax.swing.JLabel();

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
				javax.swing.GroupLayout.Alignment.LEADING).addGap(0, 0, Short.MAX_VALUE));
		jPanelMainContentLayout.setVerticalGroup(jPanelMainContentLayout.createParallelGroup(
				javax.swing.GroupLayout.Alignment.LEADING).addGap(0, 0, Short.MAX_VALUE));

		jLabelHeader.setFont(jLabelHeader.getFont().deriveFont(jLabelHeader.getFont().getStyle() | java.awt.Font.BOLD,
				jLabelHeader.getFont().getSize() + 7));
		jLabelHeader.setText("<Header>");

		jPanelSideBar.setBorder(null);

		javax.swing.GroupLayout jPanelSideBarLayout = new javax.swing.GroupLayout(jPanelSideBar);
		jPanelSideBar.setLayout(jPanelSideBarLayout);
		jPanelSideBarLayout.setHorizontalGroup(jPanelSideBarLayout.createParallelGroup(
				javax.swing.GroupLayout.Alignment.LEADING).addGap(0, 103, Short.MAX_VALUE));
		jPanelSideBarLayout.setVerticalGroup(jPanelSideBarLayout.createParallelGroup(
				javax.swing.GroupLayout.Alignment.LEADING).addGap(0, 378, Short.MAX_VALUE));

		jSeparator3.setOrientation(javax.swing.SwingConstants.VERTICAL);

		jLabelApplicationImage.setIcon(new javax.swing.ImageIcon(getClass().getResource(
				"/com/anonymous/solar/desktop/images/solar.png"))); // NOI18N
		jLabelApplicationImage.setFocusable(false);

		javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
		this.setLayout(layout);
		layout.setHorizontalGroup(layout
				.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(
						layout.createSequentialGroup()
								.addContainerGap()
								.addGroup(
										layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
												.addComponent(jSeparator1, javax.swing.GroupLayout.Alignment.TRAILING,
														javax.swing.GroupLayout.DEFAULT_SIZE, 720, Short.MAX_VALUE)
												.addComponent(jSeparator2)
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
												.addGroup(
														layout.createSequentialGroup().addGap(28, 28, 28)
																.addComponent(jLabelApplicationImage)
																.addGap(100, 100, 100).addComponent(jLabelHeader)
																.addGap(0, 0, Short.MAX_VALUE))
												.addGroup(
														layout.createSequentialGroup()
																.addComponent(jPanelSideBar,
																		javax.swing.GroupLayout.PREFERRED_SIZE,
																		javax.swing.GroupLayout.DEFAULT_SIZE,
																		javax.swing.GroupLayout.PREFERRED_SIZE)
																.addPreferredGap(
																		javax.swing.LayoutStyle.ComponentPlacement.RELATED)
																.addComponent(jSeparator3,
																		javax.swing.GroupLayout.PREFERRED_SIZE, 6,
																		javax.swing.GroupLayout.PREFERRED_SIZE)
																.addPreferredGap(
																		javax.swing.LayoutStyle.ComponentPlacement.RELATED)
																.addComponent(jPanelMainContent,
																		javax.swing.GroupLayout.DEFAULT_SIZE,
																		javax.swing.GroupLayout.DEFAULT_SIZE,
																		Short.MAX_VALUE))).addContainerGap()));
		layout.setVerticalGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(
						javax.swing.GroupLayout.Alignment.TRAILING,
						layout.createSequentialGroup()
								.addGroup(
										layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
												.addGroup(
														layout.createSequentialGroup().addGap(18, 18, 18)
																.addComponent(jLabelHeader))
												.addGroup(
														layout.createSequentialGroup().addContainerGap()
																.addComponent(jLabelApplicationImage)))
								.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
								.addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 10,
										javax.swing.GroupLayout.PREFERRED_SIZE)
								.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
								.addGroup(
										layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
												.addComponent(jSeparator3)
												.addComponent(jPanelMainContent, javax.swing.GroupLayout.DEFAULT_SIZE,
														javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
												.addComponent(jPanelSideBar, javax.swing.GroupLayout.DEFAULT_SIZE,
														javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
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
				changePanel = ((WizardPanel) panels.get(wizardIndex)).callbackDispose(true);
			} catch (Exception e) {
			}
			if (changePanel) {
				setWizardPanel(++wizardIndex);
				setSideBarButton(wizardIndex);
			}
		}
		jButtonBack.setVisible(true);
		jButtonBack.setEnabled(true);
		
		// Disable the next button if we are at the end.
		if (wizardIndex == panels.size() - 1) {
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
				changePanel = ((WizardPanel) panels.get(wizardIndex)).callbackDispose(false);
			} catch (Exception e) {
			}
			if (changePanel) {
				setWizardPanel(--wizardIndex);
				setSideBarButton(wizardIndex);
			}
		}
		jButtonNext.setEnabled(true);
		if (wizardIndex == 0) {
			jButtonBack.setVisible(false);
		}
	}// GEN-LAST:event_jButtonBackActionPerformed

	/**
	 * Initialise all the panels we wish to have displayed, as part of the
	 * Wizard
	 */
	private void initWizardPanels() {
		panels.add(new WizardStart(this));
		// panels.add(new WizardUser(this));
		panels.add(new WizardSetupDescription(this));
		panels.add(new WizardUserCosts(this));
		panels.add(new WizardTariffData(this));
		panels.add(new WizardSetupElectrical(this));
		panels.add(new WizardSetupSolarPanels(this));
		panels.add(new WizardSetupConfirmation(this));
		panels.add(new WizardResults(this));
		panels.add(new WizardFinish(this));

		// Initialise the sidebar;
		initSideBar();

		// Set to show the first panel.
		setWizardPanel(wizardIndex);
	}

	/**
	 * Initialise the sidebar navigation buttons for use by the user.
	 */
	private void initSideBar() {
		Integer buttonID = 0;
		// Create our buttons.
		jPanelSideBar.setLayout(new BoxLayout(jPanelSideBar, BoxLayout.PAGE_AXIS));
		jPanelSideBar.setPreferredSize(new java.awt.Dimension(155, 0));
		for (JPanel panel : panels) {
			javax.swing.JButton newButton = new javax.swing.JButton();
			newButton.setFont(newButton.getFont().deriveFont(newButton.getFont().getSize() - 1f));
			newButton.setText(((WizardPanel) panel).getTitle());
			newButton.setBorderPainted(false);
			newButton.setOpaque(false);
			newButton.setContentAreaFilled(false);
			newButton.setVisible(true);
			newButton.setEnabled(false);
			newButton.setName("sidebarButton" + buttonID.toString());
			// Add event handler to allow switching to panels as needed.
			newButton.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent evt) {
					sideBarActionPerformed(evt);
				}
			});

			// Add button to sidebar object store.
			sideBarButtons.add(newButton);

			// Add button to panel
			jPanelSideBar.add(Box.createHorizontalGlue());
			jPanelSideBar.add(newButton);
		}

	}

	/**
	 * Redraw the navigation sidebar based on actions of the user
	 * 
	 * @param index
	 *            The current panel index.
	 */
	private void setSideBarButton(int index) {
		JButton activeButton = sideBarButtons.get(index);
		activeButton.setEnabled(true);
		for (int i = 0; i < sideBarButtons.size(); i++) {
			JButton button = sideBarButtons.get(i);
			button.setFont(button.getFont().deriveFont(java.awt.Font.PLAIN, button.getFont().getSize()));
		}
		activeButton.setFont(activeButton.getFont().deriveFont(java.awt.Font.BOLD, activeButton.getFont().getSize()));
	}
	
	

	/**
	 * Event handler for the sidebar buttons.
	 * 
	 * @param evt
	 */
	private void sideBarActionPerformed(java.awt.event.ActionEvent evt) {
		// get which sidebar button was pressed.
		JButton sourceButton = (JButton) evt.getSource();
		int buttonID = sideBarButtons.indexOf(sourceButton);
		if (buttonID == wizardIndex) {
			return; // do nothing if we already on the same panel
		}
		boolean changePanel = false;
		try {
			if (buttonID < wizardIndex) {
				changePanel = ((WizardPanel) panels.get(wizardIndex)).callbackDispose(false);
			} else {
				// Must validate the old panel before we leave it. (This ensures
				// we have have valid information and avoid ways of breaking the
				// system, by being able to bypass certain validation checks
				changePanel = ((WizardPanel) panels.get(wizardIndex)).callbackDispose(true);
			}
		} catch (Exception e) {
		}
		// Change to the selected panel.
		if (changePanel) {
			setWizardPanel(buttonID);
			setSideBarButton(buttonID);
			wizardIndex = buttonID;
		}
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
		// If no title, then disable the title and sidebar section of the panel.
		if (title.compareTo("") == 0) {
			jLabelHeader.setVisible(false);
			jSeparator2.setVisible(false);
			jSeparator3.setVisible(false);
			jLabelApplicationImage.setVisible(false);
			jPanelSideBar.setVisible(false);
		} else {
			jLabelHeader.setText(title);
			jLabelHeader.setVisible(true);
			jSeparator2.setVisible(true);
			jSeparator3.setVisible(true);
			jLabelApplicationImage.setVisible(true);
			jPanelSideBar.setVisible(true);
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

	/**
	 * Allow client panels to get the global solar setup...
	 * 
	 * @return SolarSetup used to define the results.
	 */
	public SolarSetup getSetup() {
		return setup;
	}
	
	public void setSetup(SolarSetup setup){
		this.setup = setup;
	}
	
	/**
	 * Allow client panels to get the global solar results...
	 * 
	 * @return SolarResult used to define the results.
	 */
	public SolarResult getResults() {
		return results;
	}
	
	public void setResults(SolarResult results){
		this.results = results;
	}
	
	public void setTimeFrame(Integer timeFrame){
		this.timeFrame = timeFrame;
	}
	
	public Integer getTimeFrame(){
		return timeFrame;
	}
	
	
	public void loadSetup(SolarSetup setup){
		int index = 0;
		
		this.setup = setup;
		
		for(JPanel panel:panels){
			setWizardPanel(index);
			setSideBarButton(index);
			wizardIndex = index;
			index++;
			
		}
		
		setWizardPanel(index - 3);
		wizardIndex = index - 3;
		
		
	}


}

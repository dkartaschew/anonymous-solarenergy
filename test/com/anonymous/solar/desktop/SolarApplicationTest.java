package com.anonymous.solar.desktop;

import java.awt.Color;

import javax.swing.JPanel;

import org.junit.Ignore;
import org.openstreetmap.gui.jmapviewer.JMapViewer;
import org.uispec4j.Button;
import org.uispec4j.ComboBox;
import org.uispec4j.Mouse;
import org.uispec4j.Trigger;
import org.uispec4j.UIComponent;
import org.uispec4j.UISpec4J;
import org.uispec4j.UISpecAdapter;
import org.uispec4j.UISpecTestCase;
import org.uispec4j.Window;
import org.uispec4j.interception.MainClassAdapter;
import org.uispec4j.interception.WindowHandler;
import org.uispec4j.interception.WindowInterceptor;

public class SolarApplicationTest extends UISpecTestCase {
	
	private final static String TEST_STRING = "TestString";
	private final static String ANOTHER_TEST_STRING = "AnotherTestString";
	
	static {
	      UISpec4J.init();
	  }
	
	/**
	 * Test the main window title is correct
	 */
	public void testMainWindowTitle(){
		setAdapter((UISpecAdapter) new MainClassAdapter(SolarApplication.class, new String[]{}));
		Window mainWindow = getMainWindow();
	    assertTrue(mainWindow.getTitle().compareTo("Solar Power Calculator") == 0);
	}
	
	/**
	 * Test the about dialog
	 */
	public void testMainAboutDialog(){
		setAdapter((UISpecAdapter) new MainClassAdapter(SolarApplication.class, new String[]{}));
		Window mainWindow = getMainWindow();
	    WindowInterceptor.init(mainWindow.getMenuBar().getMenu("Help").getSubMenu("About").triggerClick()).process(new WindowHandler() {
	    	public Trigger process(Window dialog) {
	    	      assertTrue(dialog.titleEquals("About"));
	    	      return dialog.getButton("Close").triggerClick();
	    	    }
	    }).run();
	}
	
	
	/**
	 * Test the title is correct
	 */
	public void testMainTitle() {
		setAdapter((UISpecAdapter) new MainClassAdapter(SolarApplication.class, new String[]{}));
		Window mainWindow = getMainWindow();
		
		assertTrue(mainWindow.getTextBox("MainTitle").getText().compareTo("Solar Energy Calculator") == 0);
	}
	
	public void testMainDescription() {
		setAdapter((UISpecAdapter) new MainClassAdapter(SolarApplication.class, new String[]{}));
		Window mainWindow = getMainWindow();
		
		assertTrue(mainWindow.getTextBox("MainDescription").getText().compareTo("<html>\n<center>\nA simple Solar Power Calculator<br>\nfor domestic installations.<br>\n<br>\n<small>Copyright 2012, Team Anonymous (QUT)<br>\nReleased under the GPL v3 license</small>\n</center>\n</html>") == 0);
	}
	
	/**
	 * Test exit dialog
	 */
	public void testCloseDialog() {
		setAdapter((UISpecAdapter) new MainClassAdapter(SolarApplication.class, new String[]{}));
		Window mainWindow = getMainWindow();

		WindowInterceptor.init(mainWindow.getButton("Close").triggerClick()).process(new WindowHandler() {
	    	public Trigger process(Window dialog) {
	    	      assertTrue(dialog.titleEquals("Exit Confirmation"));
	    	      return dialog.getButton("No").triggerClick();
	    	    }
	    }).run();
	}
	
	/**
	 * Test attempt to move on without setup name complete
	 */
	public void testNextWithoutSetupName() {
		setAdapter((UISpecAdapter) new MainClassAdapter(SolarApplication.class, new String[]{}));
		Window mainWindow = getMainWindow();
		
		mainWindow.getButton("Next").click();
		mainWindow.getTextBox("TextFieldSetupName").setText("");
		assertTrue(mainWindow.getTextBox("TextFieldSetupName").getText().compareTo("") == 0);
		
		WindowInterceptor.init(mainWindow.getButton("Next").triggerClick()).process(new WindowHandler() {
	    	public Trigger process(Window dialog) {
	    	      assertTrue(dialog.titleEquals("Setup Name Missing"));
	    	      return dialog.getButton("OK").triggerClick();
	    	    }
	    }).run();
	}
	
	/**
	 * Test attempt to move on without complete usage details
	 */
	public void testNextWithoutUsageDetails() {
		setAdapter((UISpecAdapter) new MainClassAdapter(SolarApplication.class, new String[]{}));
		Window mainWindow = getMainWindow();
		
		mainWindow.getButton("Next").click();
		mainWindow.getTextBox("TextFieldSetupName").setText("TestSetupName");
		
		WindowInterceptor.init(mainWindow.getButton("ButtonSetLocation").triggerClick()).process(new WindowHandler() {
	    	public Trigger process(Window dialog) {
	    	      assertTrue(dialog.titleEquals("Select Location"));
	    	      return dialog.getButton("OK").triggerClick();
	    	    }
	    }).run();
		
		mainWindow.getButton("Next").click();
		
		WindowInterceptor.init(mainWindow.getButton("Next").triggerClick()).process(new WindowHandler() {
	    	public Trigger process(Window dialog) {
	    		assertTrue(dialog.getTitle().equals("Estimated Usage Missing"));
	    		
	    	      return dialog.getButton("OK").triggerClick();
	    	    }
	    }).run();
	}
	
	//
	// WizardSetupElectrical Tests
	//
	public void gotoElectricalSetup(Window mainWindow) {
		mainWindow.getButton("Next").click();
		mainWindow.getTextBox("TextFieldSetupName").setText("TestSetupName");
		
		WindowInterceptor.init(mainWindow.getButton("ButtonSetLocation").triggerClick()).process(new WindowHandler() {
	    	public Trigger process(Window dialog) {
	    	      assertTrue(dialog.titleEquals("Select Location"));
	    	      return dialog.getButton("OK").triggerClick();
	    	    }
	    }).run();
		
		mainWindow.getButton("Next").click();
		mainWindow.getSpinner("SpinnerDailyAverageUsage").clickForNextValue();
		mainWindow.getButton("Next").click();
	}
	
	
	/**
	 * Test attempt to move on without complete inverter details
	 */
	public void testNextWithoutInverterDetails() {
		setAdapter((UISpecAdapter) new MainClassAdapter(SolarApplication.class, new String[]{}));
		Window mainWindow = getMainWindow();
		
		mainWindow.getButton("Next").click();
		mainWindow.getTextBox("TextFieldSetupName").setText("TestSetupName");
		
		WindowInterceptor.init(mainWindow.getButton("ButtonSetLocation").triggerClick()).process(new WindowHandler() {
	    	public Trigger process(Window dialog) {
	    	      assertTrue(dialog.titleEquals("Select Location"));
	    	      return dialog.getButton("OK").triggerClick();
	    	    }
	    }).run();
		
		mainWindow.getButton("Next").click();
		mainWindow.getSpinner("SpinnerDailyAverageUsage").clickForNextValue();
		mainWindow.getButton("Next").click();
		
		assertTrue(mainWindow.getTextBox("TextFieldInverter").getLabel() == null);

		WindowInterceptor.init(mainWindow.getButton("Next").triggerClick()).process(new WindowHandler() {
	    	public Trigger process(Window dialog) {
	    	      assertTrue(dialog.titleEquals("Inverter Details Missing"));
	    	      return dialog.getButton("OK").triggerClick();
	    	    }
	    }).run();
	}
	
	/**
	 * Test setting an inverter using the inverter dialog
	 */
	public void testInverterInformationDialog() {
		setAdapter((UISpecAdapter) new MainClassAdapter(SolarApplication.class, new String[]{}));
		Window mainWindow = getMainWindow();
		
		gotoElectricalSetup(mainWindow);
		
		WindowInterceptor.init(mainWindow.getButton("EditInverterDetails").triggerClick()).process(new WindowHandler() {
	    	public Trigger process(Window dialog) {
	    	      
	    	      dialog.getTextBox("TextFieldInverterName").setText("TestName");
	    	      dialog.getTextBox("TextFieldInverterManufacturerName").setText("TestManufacturer");
	    	      dialog.getTextBox("TextFieldInverterManufacturerCode").setText("TestManufacturerCode");
	    	      dialog.getSpinner("SpinnerInverterCost").clickForNextValue();
	    	      dialog.getSpinner("SpinnerInverterRRP").clickForNextValue();
	    	      dialog.getSpinner("SpinnerInverterRRP").clickForNextValue();
	    	      
	    	      return dialog.getButton("Submit").triggerClick();
	    	    }
	    }).run();
	}
	
	/**
	 * Test attempt to submit inverter with incomplete details
	 */
	public void testInverterInformationDialogInComplete() {
		setAdapter((UISpecAdapter) new MainClassAdapter(SolarApplication.class, new String[]{}));
		Window mainWindow = getMainWindow();
		
		gotoElectricalSetup(mainWindow);
		
		WindowInterceptor.init(mainWindow.getButton("EditInverterDetails").triggerClick()).process(new WindowHandler() {
	    	public Trigger process(Window dialog) {
	    	      
	    	      dialog.getButton("Submit").click();
	    	      
	    	      assertTrue(dialog.getTextBox("TextFieldInverterName").backgroundEquals("red"));
	    	      assertTrue(dialog.getTextBox("TextFieldInverterManufacturerName").backgroundEquals("red"));
	    	      assertTrue(dialog.getTextBox("TextFieldInverterManufacturerCode").backgroundEquals("red"));
	    	      
	    	      return dialog.getButton("Cancel").triggerClick();
	    	    }
	    }).run();
	}
	
	/**
	 * Test loading an inverter
	 */
	public void testInverterLoadDialog() {
		setAdapter((UISpecAdapter) new MainClassAdapter(SolarApplication.class, new String[]{}));
		Window mainWindow = getMainWindow();
		
		gotoElectricalSetup(mainWindow);
		
		WindowInterceptor.init(mainWindow.getButton("EditInverterDetails").triggerClick()).process(new WindowHandler() {
	    	public Trigger process(Window dialog) {

	    	      WindowInterceptor.init(dialog.getButton("Load Inverter").triggerClick()).process(new WindowHandler() {
	    		    	public Trigger process(Window dialog) {
	    		    	      
	    		    		dialog.getListBox("lstInverterInformation").selectIndex(0);
	    		    	      
	    		    	    return dialog.getButton("Load Inverter").triggerClick();
	    		    	}
	    		    }).run();
	    	      
	    	      return dialog.getButton("Submit").triggerClick();
	    	    }
	    }).run();
	}
	
	/**
	 * Utility method to go through the application up to the solar panel setup screen
	 * @param mainWindow
	 */
	private void gotoSetupSolarPanels(Window mainWindow) {
		gotoElectricalSetup(mainWindow);

		WindowInterceptor.init(mainWindow.getButton("EditInverterDetails").triggerClick()).process(new WindowHandler() {
	    	public Trigger process(Window dialog) {
	    	      
	    	      dialog.getTextBox("TextFieldInverterName").setText("TestInverterName");
	    	      dialog.getTextBox("TextFieldInverterManufacturerName").setText("TestInverterManufacturerName");
	    	      dialog.getTextBox("TextFieldInverterManufacturerCode").setText("TestInverterManufacturerCode");
	    	      
	    	      dialog.getSpinner("SpinnerInverterCost").clickForNextValue();  
	    	      dialog.getSpinner("SpinnerInverterRRP").clickForNextValue();

	    	      return dialog.getButton("Submit").triggerClick();
	    	    }
	    }).run();
		
		mainWindow.getSpinner("SpinnerWiringLength").clickForNextValue();
		
		mainWindow.getButton("Next").click();
	}
	
	/**
	 * Test hitting next on solar panel setup without any panels
	 */
	public void testNextWithoutSolarPanels() {
		setAdapter((UISpecAdapter) new MainClassAdapter(SolarApplication.class, new String[]{}));
		Window mainWindow = getMainWindow();
		
		gotoSetupSolarPanels(mainWindow);
		
		mainWindow.getTable("tableSolarPanels").selectAllRows();
		mainWindow.getTable("tableSolarPanels").clearSelection();
		
		WindowInterceptor.init(mainWindow.getButton("Next").triggerClick()).process(new WindowHandler() {
	    	public Trigger process(Window dialog) {
	    	      assertTrue(dialog.titleEquals("Solar Panel Configuration Information Missing"));
	    	      return dialog.getButton("OK").triggerClick();
	    	    }
	    }).run();
	}
	
	/**
	 * Test attempt to delete without a panel currently selected
	 */
	public void testDeleteWithoutSelection() {
		setAdapter((UISpecAdapter) new MainClassAdapter(SolarApplication.class, new String[]{}));
		Window mainWindow = getMainWindow();
		
		gotoSetupSolarPanels(mainWindow);

		WindowInterceptor.init(mainWindow.getButton("Delete").triggerClick()).process(new WindowHandler() {
	    	public Trigger process(Window dialog) {
	    	      assertTrue(dialog.titleEquals("Delete Panel"));
	    	      return dialog.getButton("OK").triggerClick();
	    	    }
	    }).run();
	}
	
	/**
	 * Test attempt to edit without a panel currently selected
	 */
	public void testEditWithoutSelection() {
		setAdapter((UISpecAdapter) new MainClassAdapter(SolarApplication.class, new String[]{}));
		Window mainWindow = getMainWindow();
		
		gotoSetupSolarPanels(mainWindow);
		
		WindowInterceptor.init(mainWindow.getButton("Edit").triggerClick()).process(new WindowHandler() {
	    	public Trigger process(Window dialog) {
	    	      assertTrue(dialog.titleEquals("Edit Panels"));
	    	      return dialog.getButton("OK").triggerClick();
	    	    }
	    }).run();
	}
	
	/**
	 * Utility method to add panels
	 * @param mainWindow 
	 */
	private void addSomePanels(Window mainWindow){
		WindowInterceptor.init(mainWindow.getButton("Add").triggerClick()).process(new WindowHandler() {
	    	public Trigger process(Window dialog) {
	    		assertTrue(dialog.titleEquals("Add Panel Set"));
	    	      
    	      	dialog.getTextBox("TextFieldSolarPanelName").setText(TEST_STRING);
				dialog.getTextBox("TextFieldSolarPanelManufacturerName").setText(TEST_STRING);
				dialog.getTextBox("TextFieldSolarPanelManufacturerCode").setText(TEST_STRING);
				
				dialog.getSpinner("SpinnerSolarPanelCost").clickForNextValue();
				dialog.getSpinner("SpinnerSolarPanelRRP").clickForNextValue();
				
				dialog.getSpinner("SpinnerSolarPanelCount").clickForNextValue();
	    	      
				return dialog.getButton("Submit").triggerClick();
    	    }
	    }).run();
	}
	
	/**
	 * Test loading an panel
	 */
//	public void testPanelLoadDialog() {
//		setAdapter((UISpecAdapter) new MainClassAdapter(SolarApplication.class, new String[]{}));
//		Window mainWindow = getMainWindow();
//		
//		gotoSetupSolarPanels(mainWindow);
//		
//		WindowInterceptor.init(mainWindow.getButton("Add").triggerClick()).process(new WindowHandler() {
//	    	public Trigger process(Window dialog) {
//
//	    	      WindowInterceptor.init(dialog.getButton("ButtonLoadNewPanel").triggerClick()).process(new WindowHandler() {
//	    		    	public Trigger process(Window dialog) {
//	    		    	      
//	    		    		dialog.getListBox("lstPanelInformation").selectIndex(0);  
//	    		    		assertTrue("Shit's borked",dialog.getButton("ButtonLoadPanel").isEnabled());
//	    		    		
//	    		    	    return dialog.getButton("ButtonLoadPanel").triggerClick();
//	    		    	}
//	    		    }).run();
//	    	      
//	    	      dialog.getSpinner("SpinnerSolarPanelCount").clickForNextValue();
//	    	      
//	    	      return dialog.getButton("Submit").triggerClick();
//	    	    }
//	    }).run();
//	}
	
	/**
	 * Test the addition of solar panels
	 */
	public void testAddSolarPanels() {
		setAdapter((UISpecAdapter) new MainClassAdapter(SolarApplication.class, new String[]{}));
		Window mainWindow = getMainWindow();
		
		gotoSetupSolarPanels(mainWindow);
		
		mainWindow.getTable("tableSolarPanels").selectAllRows();
		mainWindow.getTable("tableSolarPanels").clearSelection();
		
		addSomePanels(mainWindow);
		
		assertTrue(mainWindow.getTable().contentEquals(new String[][]{
				{TEST_STRING, "10.0", "100.0", "25", "0.0", "5"}
		}));
	}
	
	/**
	 * Test the deletion of solar panels
	 */
	public void testDeleteSolarPanels() {
		setAdapter((UISpecAdapter) new MainClassAdapter(SolarApplication.class, new String[]{}));
		Window mainWindow = getMainWindow();
		
		gotoSetupSolarPanels(mainWindow);
		
		mainWindow.getTable("tableSolarPanels").selectAllRows();
		mainWindow.getTable("tableSolarPanels").clearSelection();
		assertTrue(mainWindow.getTable().isEmpty());
		
		addSomePanels(mainWindow);
		assertTrue(mainWindow.getTable().contentEquals(new String[][]{
				{TEST_STRING, "10.0", "100.0", "25", "0.0", "5"}
		}));
		
		mainWindow.getTable().selectRow(0);
		
		WindowInterceptor.init(mainWindow.getButton("Delete").triggerClick()).process(new WindowHandler() {
	    	public Trigger process(Window dialog) {
	    	      assertTrue(dialog.titleEquals("Panel Deletion Confirmation"));
	    	      return dialog.getButton("Yes").triggerClick();
	    	    }
	    }).run();
		
		assertTrue(mainWindow.getTable().isEmpty());
	}
	
	/**
	 * Test editing entered solar panels
	 */
	public void testEditSolarPanels() {
		setAdapter((UISpecAdapter) new MainClassAdapter(SolarApplication.class, new String[]{}));
		Window mainWindow = getMainWindow();
		
		gotoSetupSolarPanels(mainWindow);
		
		mainWindow.getTable("tableSolarPanels").selectAllRows();
		mainWindow.getTable("tableSolarPanels").clearSelection();
		assertTrue(mainWindow.getTable().isEmpty());
		
		addSomePanels(mainWindow);
		assertTrue(mainWindow.getTable().contentEquals(new String[][]{
				{TEST_STRING, "10.0", "100.0", "25", "0.0", "5"}
		}));
		
		mainWindow.getTable().selectRow(0);
		
		WindowInterceptor.init(mainWindow.getButton("Edit").triggerClick()).process(new WindowHandler() {
	    	public Trigger process(Window dialog) {
	    	      assertTrue(dialog.titleEquals("Add Panel Set"));

	    	      // Check the values are the same as first entered
	    	      assertTrue(dialog.getTextBox("TextFieldSolarPanelName").getText().compareTo(TEST_STRING) == 0);
	    	      assertTrue(dialog.getTextBox("TextFieldSolarPanelManufacturerName").getText().compareTo(TEST_STRING) == 0);
	    	      assertTrue(dialog.getTextBox("TextFieldSolarPanelManufacturerCode").getText().compareTo(TEST_STRING) == 0);
	    	      
	    	      assertTrue(dialog.getSpinner("SpinnerSolarPanelCost").valueEquals(10.0));
	    	      assertTrue(dialog.getSpinner("SpinnerSolarPanelRRP").valueEquals(10.0));
	    	      assertTrue(dialog.getSpinner("SpinnerSolarPanelCount").valueEquals(5));
	    	      
	    	      // Edit fields that are shown (RRP needs to be the same or higher than cost)
	    	      dialog.getTextBox("TextFieldSolarPanelName").setText(ANOTHER_TEST_STRING);
	    	      
	    	      dialog.getSpinner("SpinnerSolarPanelCost").clickForNextValue();
	    	      dialog.getSpinner("SpinnerSolarPanelRRP").clickForNextValue();

	    	      dialog.getSpinner("SpinnerSolarPanelCount").clickForNextValue();
	    	      
	    	      return dialog.getButton("Submit").triggerClick();
	    	    }
	    }).run();
		
		// Check the table has been updated
		assertTrue(mainWindow.getTable().contentEquals(new String[][]{
				{ANOTHER_TEST_STRING, "20.0", "100.0", "25", "0.0", "10"}
		}));
	}
	
	/**
	 * Test using the bread crumbs to navigate through the wizard.
	 */
	public void testWizardBreadCrumbNavigation() {
		setAdapter((UISpecAdapter) new MainClassAdapter(SolarApplication.class, new String[]{}));
		Window mainWindow = getMainWindow();
		
		// Setup and Location pane
		mainWindow.getButton("Next").click();
		mainWindow.getTextBox("TextFieldSetupName").setText("TestSetupName");
		
		WindowInterceptor.init(mainWindow.getButton("ButtonSetLocation").triggerClick()).process(new WindowHandler() {
	    	public Trigger process(Window dialog) {
	    	      assertTrue(dialog.titleEquals("Select Location"));
	    	      return dialog.getButton("OK").triggerClick();
	    	    }
	    }).run();
		mainWindow.getButton("Next").click();
		
		// Inverter pane
		mainWindow.getSpinner("SpinnerDailyAverageUsage").clickForNextValue();
		
		// Navigate back to setup name.
		mainWindow.getButton("Setup Description").click();
		
		assertTrue(mainWindow.containsUIComponent(Button.class, "ButtonSetLocation"));
		
	}
	
	/**
	 * Test using the bread crumbs to navigate through the wizard.
	 */
	public void testWizardBreadCrumbNavigation2() {
		setAdapter((UISpecAdapter) new MainClassAdapter(SolarApplication.class, new String[]{}));
		Window mainWindow = getMainWindow();
		
		gotoSetupSolarPanels(mainWindow);
		
		// Navigate back to setup name.
		mainWindow.getButton("Setup Description").click();
		
		assertTrue(mainWindow.containsUIComponent(Button.class, "ButtonSetLocation"));
		
		mainWindow.getButton("Solar Panel Setup").click();
		
		assertTrue(mainWindow.containsUIComponent(Button.class, "Edit"));
		
	}
	
	/**
	 * Test set location via the combobox in the location dialog.
	 */
	public void testLocationDialogSetLocation() {
		setAdapter((UISpecAdapter) new MainClassAdapter(SolarApplication.class, new String[]{}));
		Window mainWindow = getMainWindow();
		
		// Setup and Location pane
		mainWindow.getButton("Next").click();
		mainWindow.getTextBox("TextFieldSetupName").setText("TestSetupName");
		
		WindowInterceptor.init(mainWindow.getButton("ButtonSetLocation").triggerClick()).process(new WindowHandler() {
	    	public Trigger process(Window dialog) {
	    	      assertTrue(dialog.titleEquals("Select Location"));
	    	      
	    	      // Check the dropdown functions.
	    	      assertTrue(dialog.containsUIComponent(ComboBox.class, "jComboBoxLocationName"));
	    	      
	    	      dialog.getComboBox("jComboBoxLocationName").select("Surfers Paradise");
	    	      assertTrue(dialog.getTextBox("jTextFieldLocationName").getText().compareTo("Surfers Paradise") == 0);
	    	      assertTrue(dialog.getTextBox("jTextFieldLatitude").getText().compareTo("-28.001979938258618") == 0);
	    	      assertTrue(dialog.getTextBox("jTextFieldLongitude").getText().compareTo("153.4299087524414") == 0);
	    	      
	    	      return dialog.getButton("OK").triggerClick();
	    	    }
	    }).run();
	}
	
	/**
	 * Test setting the name of the location in the text box.
	 */
	public void testLocationDialogSetLocation2() {
		setAdapter((UISpecAdapter) new MainClassAdapter(SolarApplication.class, new String[]{}));
		Window mainWindow = getMainWindow();
		
		// Setup and Location pane
		mainWindow.getButton("Next").click();
		mainWindow.getTextBox("TextFieldSetupName").setText("TestSetupName");
		
		WindowInterceptor.init(mainWindow.getButton("ButtonSetLocation").triggerClick()).process(new WindowHandler() {
	    	public Trigger process(Window dialog) {
	    	      assertTrue(dialog.titleEquals("Select Location"));
	    	      
	    	      // Check the dropdown functions.
	    	      assertTrue(dialog.containsUIComponent(ComboBox.class, "jComboBoxLocationName"));
	    	      
	    	      dialog.getComboBox("jComboBoxLocationName").select("Surfers Paradise");
	    	      assertTrue(dialog.getTextBox("jTextFieldLocationName").getText().compareTo("Surfers Paradise") == 0);
	    	      assertTrue(dialog.getTextBox("jTextFieldLatitude").getText().compareTo("-28.001979938258618") == 0);
	    	      assertTrue(dialog.getTextBox("jTextFieldLongitude").getText().compareTo("153.4299087524414") == 0);
	    	      
	    	      dialog.getTextBox("jTextFieldLocationName").setText(ANOTHER_TEST_STRING);
	    	      assertTrue(dialog.getTextBox("jTextFieldLocationName").getText().compareTo(ANOTHER_TEST_STRING) == 0);
	    	      
	    	      return dialog.getButton("OK").triggerClick();
	    	    }
	    }).run();
		assertTrue(mainWindow.getTextBox("jTextFieldLocation1").getText().compareTo(ANOTHER_TEST_STRING) == 0);
	}

	
	/**
	 * Test setting the location by clicking on the location window
	 */
	public void testLocationDialogSetLocation3() {
		setAdapter((UISpecAdapter) new MainClassAdapter(SolarApplication.class, new String[]{}));
		Window mainWindow = getMainWindow();
		
		// Setup and Location pane
		mainWindow.getButton("Next").click();
		mainWindow.getTextBox("TextFieldSetupName").setText("TestSetupName");
		
		WindowInterceptor.init(mainWindow.getButton("ButtonSetLocation").triggerClick()).process(new WindowHandler() {
	    	public Trigger process(Window dialog) {
	    	      assertTrue(dialog.titleEquals("Select Location"));
	    	      
	    	      // Check the dropdown functions.
	    	      assertTrue(dialog.containsUIComponent(ComboBox.class, "jComboBoxLocationName"));
	    	      
	    	      dialog.getComboBox("jComboBoxLocationName").select("Surfers Paradise");
	    	      assertTrue(dialog.getTextBox("jTextFieldLocationName").getText().compareTo("Surfers Paradise") == 0);
	    	      assertTrue(dialog.getTextBox("jTextFieldLatitude").getText().compareTo("-28.001979938258618") == 0);
	    	      assertTrue(dialog.getTextBox("jTextFieldLongitude").getText().compareTo("153.4299087524414") == 0);
	    	      
	    	      dialog.getTextBox("jTextFieldLocationName").setText(ANOTHER_TEST_STRING);
	    	      assertTrue(dialog.getTextBox("jTextFieldLocationName").getText().compareTo(ANOTHER_TEST_STRING) == 0);
	    	      
	    	      // Set defined map location, so our result of the click is always 100% accurate
	    	      JMapViewer map = dialog.findSwingComponent(JMapViewer.class);
	    	      map.setDisplayPositionByLatLon(-27.47330928257259, 153.0259519815445, 2);
	    	      
	    	      JPanel mapPanel = (JPanel)dialog.findSwingComponent(JMapViewer.class);
	    	      
	    	      // Click mouse in top left corner of map.
	    	      Mouse.doClickInRectangle(mapPanel, new java.awt.Rectangle(1,1), false, org.uispec4j.Key.Modifier.NONE);
	    	      assertTrue(dialog.getTextBox("jTextFieldLatitude").getText().compareTo("16.299051014581828") == 0);
	    	      assertTrue(dialog.getTextBox("jTextFieldLongitude").getText().compareTo("68.5546875") == 0);

	    	      return dialog.getButton("OK").triggerClick();
	    	    }
	    }).run();
		assertTrue(mainWindow.getTextBox("jTextFieldLocation1").getText().compareTo(ANOTHER_TEST_STRING) == 0);
		assertTrue(mainWindow.getTextBox("jTextFieldLatitude").getText().compareTo("16.299051014581828") == 0);
	    assertTrue(mainWindow.getTextBox("jTextFieldLongitude").getText().compareTo("68.5546875") == 0);
	}
}

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
	
	/********************************************************************************************************
	 ***************************************** Customer Usage tests *****************************************
	 ********************************************************************************************************/
	
	
	
	
	
	/********************************************************************************************************
	 ************************************** WizardTariffData Test **************************************
	 ********************************************************************************************************/
	// Helper method to navigate to the Tariff Rates Wizard page
	private void gotoTariffRatesSetup(Window mainWindow) {
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
	 * Test attempt to go to the next page without data filled in
	 */
	public void testNextWithoutTariffData() {
		setAdapter((UISpecAdapter) new MainClassAdapter(SolarApplication.class, new String[]{}));
		Window mainWindow = getMainWindow();
		
		gotoTariffRatesSetup(mainWindow);
		
		WindowInterceptor.init(mainWindow.getButton("Next").triggerClick()).process(new WindowHandler() {
	    	public Trigger process(Window dialog) {
	    	      assertTrue(dialog.titleEquals("Estimated Usage Missing"));
	    	      return dialog.getButton("OK").triggerClick();
	    	    }
	    }).run();
	}
	
	/**
	 * Test manually entering the tariff data
	 */
	public void testTariffManualDataEntry() {
		setAdapter((UISpecAdapter) new MainClassAdapter(SolarApplication.class, new String[]{}));
		Window mainWindow = getMainWindow();
		
		gotoTariffRatesSetup(mainWindow);
		
		// Complete Information
		mainWindow.getSpinner("SpinnerTariff11").clickForNextValue();
		mainWindow.getSpinner("SpinnerTariff33").clickForNextValue();
		mainWindow.getSpinner("SpinnerDailyCostTariff11").clickForNextValue();
		mainWindow.getSpinner("SpinnerDailyCostTariff33").clickForNextValue();
		mainWindow.getSpinner("SpinnerTariffIncrease").clickForNextValue();
		
		mainWindow.getButton("Next").click();
		
		WindowInterceptor.init(mainWindow.getButton("Next").triggerClick()).process(new WindowHandler() {
	    	public Trigger process(Window dialog) {
	    	      assertTrue(dialog.titleEquals("Inverter Details Missing"));
	    	      return dialog.getButton("OK").triggerClick();
	    	    }
	    }).run();
	}
	
	/**
	 * Test automatically filling the tariff data
	 */
	public void testTariffAutoDataEntry(){
		setAdapter((UISpecAdapter) new MainClassAdapter(SolarApplication.class, new String[]{}));
		Window mainWindow = getMainWindow();
		
		gotoTariffRatesSetup(mainWindow);
		
		// Complete Information
		mainWindow.getListBox("ListTariffProviderInformation").selectIndex(0);
		mainWindow.getSpinner("SpinnerTariffIncrease").clickForNextValue();
		
		mainWindow.getButton("Next").click();
		
		WindowInterceptor.init(mainWindow.getButton("Next").triggerClick()).process(new WindowHandler() {
	    	public Trigger process(Window dialog) {
	    	      assertTrue(dialog.titleEquals("Inverter Details Missing"));
	    	      return dialog.getButton("OK").triggerClick();
	    	    }
	    }).run();
	}
	
	/**
	 * Test sorting by a state
	 */
	public void testTariffSortByState() {
		setAdapter((UISpecAdapter) new MainClassAdapter(SolarApplication.class, new String[]{}));
		Window mainWindow = getMainWindow();
		
		gotoTariffRatesSetup(mainWindow);
		
		// Change State
		mainWindow.getComboBox("ComboSortByState").select("NSW");
		
		// TODO Ensure all values are the selected state
		// Ensure no providers from other states are shown
		//assertTrue(mainWindow.getListBox("ListTariffProviderInformation").contains("Provider: AGL; State: NSW; Tariff11 Cost: 52.54; Tariff33 Cost:13.09"));
		
		mainWindow.getListBox("ListTariffProviderInformation").selectIndex(0);
		mainWindow.getSpinner("SpinnerTariffIncrease").clickForNextValue();
		
		mainWindow.getButton("Next").click();
		
		WindowInterceptor.init(mainWindow.getButton("Next").triggerClick()).process(new WindowHandler() {
	    	public Trigger process(Window dialog) {
	    	      assertTrue(dialog.titleEquals("Inverter Details Missing"));
	    	      return dialog.getButton("OK").triggerClick();
	    	    }
	    }).run();
	}
	
	/********************************************************************************************************
	 ************************************** WizardSetupElectrical Test **************************************
	 ********************************************************************************************************/
	
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
		
		mainWindow.getListBox("ListTariffProviderInformation").selectIndex(0);
		mainWindow.getSpinner("SpinnerTariffIncrease").clickForNextValue();
		mainWindow.getButton("Next").click();
	}
	
	
	/**
	 * Test attempt to move on without complete inverter details
	 */
	public void testNextWithoutInverterDetails() {
		setAdapter((UISpecAdapter) new MainClassAdapter(SolarApplication.class, new String[]{}));
		Window mainWindow = getMainWindow();
		
		gotoElectricalSetup(mainWindow);
		
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
	    	      
	    	      for(int i=0; i < 100; i++) {
	    	    	  dialog.getSpinner("SpinnerInverterEfficiency").clickForNextValue();
	    	      }
	    	      
	    	      for(int i=0; i < 20; i++) {
	    	    	  dialog.getSpinner("SpinnerInverterWattage").clickForNextValue();
	    	      }
	    	      
	    	      dialog.getSpinner("SpinnerInverterEffLossYear").clickForNextValue();
	    	      
	    	      dialog.getSpinner("SpinnerInverterLife").clickForNextValue();
	    	      dialog.getSpinner("SpinnerInverterLife").clickForNextValue();

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
				
				dialog.getSpinner("SpinnerSolarPanelEfficiencyLoss").clickForNextValue();
				
	    	      
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
				{TEST_STRING, "10.0", "100.0", "25", "1.0", "5"}
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
				{TEST_STRING, "10.0", "100.0", "25", "1.0", "5"}
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
				{TEST_STRING, "10.0", "100.0", "25", "1.0", "5"}
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
				{ANOTHER_TEST_STRING, "20.0", "100.0", "25", "1.0", "10"}
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
	
	public void testDailySavings(){
		
	}
	
	public void testMonthlySavings() {
		
	}
	
	public void testAnnualSavings(){
		
	}
	
	/**
	 * Test displaying the efficiency loss table on the results page
	 */
	public void testResultsEfficiencyLossTable() {
		setAdapter((UISpecAdapter) new MainClassAdapter(SolarApplication.class, new String[]{}));
		Window mainWindow = getMainWindow();
		
		gotoSetupSolarPanels(mainWindow);
		
		addSomePanels(mainWindow);
		
		// Click through to the results page
		mainWindow.getButton("Next").click();
		mainWindow.getButton("Next").click();
		
		// Change to tab and check table
		mainWindow.getTabGroup().selectTab("Hardware Efficiency Loss");
		
		assertTrue(mainWindow.getTable("tblHardware").contentEquals(new String[][]{
				{"Inverter", "TestInverterName", "100.00KW (100.00%)", "99.00KW (99.00%)", "98.01KW (98.01%)", "97.03KW (97.03%)", "96.06KW (96.06%)", "95.10KW (95.10%)", 
					"94.15KW (94.15%)", "93.21KW (93.21%)", "92.27KW (92.27%)", "91.35KW (91.35%)", "0.00", "0.00", "0.00", "0.00", "0.00", "0.00", "0.00", "0.00", "0.00",
					"0.00", "0.00", "0.00", "0.00", "0.00", "0.00"},
				{"Panel", TEST_STRING, "100.00KW (100.00%)", "99.00KW (99.00%)", "98.01KW (98.01%)", "97.03KW (97.03%)", "96.06KW (96.06%)", "95.10KW (95.10%)", 
						"94.15KW (94.15%)", "93.21KW (93.21%)", "92.27KW (92.27%)", "91.35KW (91.35%)", "90.44KW (90.44%)", "89.53KW (89.53%)", "88.64KW (88.64%)",
						"87.75KW (87.75%)", "86.87KW (86.87%)", "86.01KW (86.01%)", "85.15KW (85.15%)", "84.29KW (84.29%)", "83.45KW (83.45%)", "82.62KW (82.62%)",
						"81.79KW (81.79%)", "80.97KW (80.97%)", "80.16KW (80.16%)", "79.36KW (79.36%)", "78.57KW (78.57%)"}
		}));
	}
	
	/**
	 * Test displaying the efficiency loss table on the results page with duplicate panels
	 */
	public void testResultsEfficiencyLossTableDuplicatePanels() {
		setAdapter((UISpecAdapter) new MainClassAdapter(SolarApplication.class, new String[]{}));
		Window mainWindow = getMainWindow();
		
		gotoSetupSolarPanels(mainWindow);
		
		addSomePanels(mainWindow);
		addSomePanels(mainWindow);
		
		// Click through to the results page
		mainWindow.getButton("Next").click();
		mainWindow.getButton("Next").click();
		
		// Change to tab and check table
		mainWindow.getTabGroup().selectTab("Hardware Efficiency Loss");
		
		assertTrue(mainWindow.getTable("tblHardware").contentEquals(new String[][]{
				{"Inverter", "TestInverterName", "100.00KW (100.00%)", "99.00KW (99.00%)", "98.01KW (98.01%)", "97.03KW (97.03%)", "96.06KW (96.06%)", "95.10KW (95.10%)", 
					"94.15KW (94.15%)", "93.21KW (93.21%)", "92.27KW (92.27%)", "91.35KW (91.35%)", "0.00", "0.00", "0.00", "0.00", "0.00", "0.00", "0.00", "0.00", "0.00",
					"0.00", "0.00", "0.00", "0.00", "0.00", "0.00"},
					{"Panel", TEST_STRING, "100.00KW (100.00%)", "99.00KW (99.00%)", "98.01KW (98.01%)", "97.03KW (97.03%)", "96.06KW (96.06%)", "95.10KW (95.10%)", 
						"94.15KW (94.15%)", "93.21KW (93.21%)", "92.27KW (92.27%)", "91.35KW (91.35%)", "90.44KW (90.44%)", "89.53KW (89.53%)", "88.64KW (88.64%)",
						"87.75KW (87.75%)", "86.87KW (86.87%)", "86.01KW (86.01%)", "85.15KW (85.15%)", "84.29KW (84.29%)", "83.45KW (83.45%)", "82.62KW (82.62%)",
						"81.79KW (81.79%)", "80.97KW (80.97%)", "80.16KW (80.16%)", "79.36KW (79.36%)", "78.57KW (78.57%)"},
					{"Panel", TEST_STRING, "100.00KW (100.00%)", "99.00KW (99.00%)", "98.01KW (98.01%)", "97.03KW (97.03%)", "96.06KW (96.06%)", "95.10KW (95.10%)", 
						"94.15KW (94.15%)", "93.21KW (93.21%)", "92.27KW (92.27%)", "91.35KW (91.35%)", "90.44KW (90.44%)", "89.53KW (89.53%)", "88.64KW (88.64%)",
						"87.75KW (87.75%)", "86.87KW (86.87%)", "86.01KW (86.01%)", "85.15KW (85.15%)", "84.29KW (84.29%)", "83.45KW (83.45%)", "82.62KW (82.62%)",
						"81.79KW (81.79%)", "80.97KW (80.97%)", "80.16KW (80.16%)", "79.36KW (79.36%)", "78.57KW (78.57%)"}
		}));
	}
	
	/**
	 * Test displaying the efficiency loss table on the results page with multiple unique panels
	 */
	public void testResultsEfficiencyLossTableMultiplePanels() {
		setAdapter((UISpecAdapter) new MainClassAdapter(SolarApplication.class, new String[]{}));
		Window mainWindow = getMainWindow();
		
		gotoSetupSolarPanels(mainWindow);
		
		addSomePanels(mainWindow);
		
		// Add another set of unique panels
		WindowInterceptor.init(mainWindow.getButton("Add").triggerClick()).process(new WindowHandler() {
	    	public Trigger process(Window dialog) {
	    		assertTrue(dialog.titleEquals("Add Panel Set"));
	    	      
    	      	dialog.getTextBox("TextFieldSolarPanelName").setText("SolarPanel");
				dialog.getTextBox("TextFieldSolarPanelManufacturerName").setText(TEST_STRING);
				dialog.getTextBox("TextFieldSolarPanelManufacturerCode").setText(TEST_STRING);
				
				dialog.getSpinner("SpinnerSolarPanelCost").clickForNextValue();
				dialog.getSpinner("SpinnerSolarPanelRRP").clickForNextValue();
				
				dialog.getSpinner("SpinnerSolarPanelCount").clickForNextValue();
				
				for(int i=0; i < 5; i++){
					dialog.getSpinner("SpinnerSolarPanelEfficiencyLoss").clickForNextValue();
				}
	    	      
				return dialog.getButton("Submit").triggerClick();
    	    }
	    }).run();
		
		// Click through to the results page
		mainWindow.getButton("Next").click();
		mainWindow.getButton("Next").click();
		
		// Change to tab and check table
		mainWindow.getTabGroup().selectTab("Hardware Efficiency Loss");
		
		assertTrue(mainWindow.getTable("tblHardware").contentEquals(new String[][]{
				{"Inverter", "TestInverterName", "100.00KW (100.00%)", "99.00KW (99.00%)", "98.01KW (98.01%)", "97.03KW (97.03%)", "96.06KW (96.06%)", "95.10KW (95.10%)", 
					"94.15KW (94.15%)", "93.21KW (93.21%)", "92.27KW (92.27%)", "91.35KW (91.35%)", "0.00", "0.00", "0.00", "0.00", "0.00", "0.00", "0.00", "0.00", "0.00",
					"0.00", "0.00", "0.00", "0.00", "0.00", "0.00"},
				{"Panel", TEST_STRING, "100.00KW (100.00%)", "99.00KW (99.00%)", "98.01KW (98.01%)", "97.03KW (97.03%)", "96.06KW (96.06%)", "95.10KW (95.10%)", 
					"94.15KW (94.15%)", "93.21KW (93.21%)", "92.27KW (92.27%)", "91.35KW (91.35%)", "90.44KW (90.44%)", "89.53KW (89.53%)", "88.64KW (88.64%)",
					"87.75KW (87.75%)", "86.87KW (86.87%)", "86.01KW (86.01%)", "85.15KW (85.15%)", "84.29KW (84.29%)", "83.45KW (83.45%)", "82.62KW (82.62%)",
					"81.79KW (81.79%)", "80.97KW (80.97%)", "80.16KW (80.16%)", "79.36KW (79.36%)", "78.57KW (78.57%)"},
				{"Panel", "SolarPanel", "100.00KW (100.00%)", "95.00KW (95.00%)", "90.25KW (90.25%)","85.74KW (85.74%)","81.45KW (81.45%)","77.38KW (77.38%)",
					"73.51KW (73.51%)",	"69.83KW (69.83%)",	"66.34KW (66.34%)",	"63.02KW (63.02%)",	"59.87KW (59.87%)",	"56.88KW (56.88%)",	"54.04KW (54.04%)",
					"51.33KW (51.33%)",	"48.77KW (48.77%)",	"46.33KW (46.33%)",	"44.01KW (44.01%)",	"41.81KW (41.81%)",	"39.72KW (39.72%)",	"37.74KW (37.74%)",
					"35.85KW (35.85%)",	"34.06KW (34.06%)",	"32.35KW (32.35%)",	"30.74KW (30.74%)",	"29.20KW (29.20%)"}
		}));
	}
	
	/**
	 * Test displaying the efficiency loss table on the results page with a high efficiency loss
	 */
	public void testResultsEfficiencyLossTableHighEfficiencyLoss() {
		setAdapter((UISpecAdapter) new MainClassAdapter(SolarApplication.class, new String[]{}));
		Window mainWindow = getMainWindow();
		
		gotoSetupSolarPanels(mainWindow);
		
		// Add another set of unique panels
		WindowInterceptor.init(mainWindow.getButton("Add").triggerClick()).process(new WindowHandler() {
	    	public Trigger process(Window dialog) {
	    		assertTrue(dialog.titleEquals("Add Panel Set"));
	    	      
    	      	dialog.getTextBox("TextFieldSolarPanelName").setText("SolarPanel");
				dialog.getTextBox("TextFieldSolarPanelManufacturerName").setText(TEST_STRING);
				dialog.getTextBox("TextFieldSolarPanelManufacturerCode").setText(TEST_STRING);
				
				dialog.getSpinner("SpinnerSolarPanelCost").clickForNextValue();
				dialog.getSpinner("SpinnerSolarPanelRRP").clickForNextValue();
				
				dialog.getSpinner("SpinnerSolarPanelCount").clickForNextValue();
				
				for(int i=0; i < 60; i++){
					dialog.getSpinner("SpinnerSolarPanelEfficiencyLoss").clickForNextValue();
				}
	    	      
				return dialog.getButton("Submit").triggerClick();
    	    }
	    }).run();
		
		// Click through to the results page
		mainWindow.getButton("Next").click();
		mainWindow.getButton("Next").click();
		
		// Change to tab and check table
		mainWindow.getTabGroup().selectTab("Hardware Efficiency Loss");
		
		assertTrue(mainWindow.getTable("tblHardware").contentEquals(new String[][]{
				{"Inverter", "TestInverterName", "100.00KW (100.00%)", "99.00KW (99.00%)", "98.01KW (98.01%)", "97.03KW (97.03%)", "96.06KW (96.06%)", "95.10KW (95.10%)", 
					"94.15KW (94.15%)", "93.21KW (93.21%)", "92.27KW (92.27%)", "91.35KW (91.35%)", "0.00", "0.00", "0.00", "0.00", "0.00", "0.00", "0.00", "0.00", "0.00",
					"0.00", "0.00", "0.00", "0.00", "0.00", "0.00"},
				{"Panel", "SolarPanel", "100.00KW (100.00%)", "40.00KW (40.00%)", "16.00KW (16.00%)", "6.40KW (6.40%)", "2.56KW (2.56%)", "1.02KW (1.02%)", 
						"0.41KW (0.41%)", "0.16KW (0.16%)", "0.07KW (0.07%)", "0.03KW (0.03%)", "0.01KW (0.01%)", "0.00KW (0.00%)" , "0.00KW (0.00%)"
						, "0.00KW (0.00%)", "0.00KW (0.00%)", "0.00KW (0.00%)", "0.00KW (0.00%)", "0.00KW (0.00%)", "0.00KW (0.00%)", "0.00KW (0.00%)"
						, "0.00KW (0.00%)", "0.00KW (0.00%)", "0.00KW (0.00%)", "0.00KW (0.00%)", "0.00KW (0.00%)"}
		}));
	}
	
	/**
	 * Test displaying the efficiency loss table on the results page with multiple unique panels and duplicates
	 */
	public void testResultsEfficiencyLossTableMultiplePanelsWithDuplicates() {
		setAdapter((UISpecAdapter) new MainClassAdapter(SolarApplication.class, new String[]{}));
		Window mainWindow = getMainWindow();
		
		gotoSetupSolarPanels(mainWindow);
		
		addSomePanels(mainWindow);
		
		// Add another set of unique panels
		WindowInterceptor.init(mainWindow.getButton("Add").triggerClick()).process(new WindowHandler() {
	    	public Trigger process(Window dialog) {
	    		assertTrue(dialog.titleEquals("Add Panel Set"));
	    	      
    	      	dialog.getTextBox("TextFieldSolarPanelName").setText("SolarPanel");
				dialog.getTextBox("TextFieldSolarPanelManufacturerName").setText(TEST_STRING);
				dialog.getTextBox("TextFieldSolarPanelManufacturerCode").setText(TEST_STRING);
				
				dialog.getSpinner("SpinnerSolarPanelCost").clickForNextValue();
				dialog.getSpinner("SpinnerSolarPanelRRP").clickForNextValue();
				
				dialog.getSpinner("SpinnerSolarPanelCount").clickForNextValue();
				
				for(int i=0; i < 5; i++){
					dialog.getSpinner("SpinnerSolarPanelEfficiencyLoss").clickForNextValue();
				}
	    	      
				return dialog.getButton("Submit").triggerClick();
    	    }
	    }).run();
		
		addSomePanels(mainWindow);
		
		// Click through to the results page
		mainWindow.getButton("Next").click();
		mainWindow.getButton("Next").click();
		
		// Change to tab and check table
		mainWindow.getTabGroup().selectTab("Hardware Efficiency Loss");
		
		assertTrue(mainWindow.getTable("tblHardware").contentEquals(new String[][]{
				{"Inverter", "TestInverterName", "100.00KW (100.00%)", "99.00KW (99.00%)", "98.01KW (98.01%)", "97.03KW (97.03%)", "96.06KW (96.06%)", "95.10KW (95.10%)", 
					"94.15KW (94.15%)", "93.21KW (93.21%)", "92.27KW (92.27%)", "91.35KW (91.35%)", "0.00", "0.00", "0.00", "0.00", "0.00", "0.00", "0.00", "0.00", "0.00",
					"0.00", "0.00", "0.00", "0.00", "0.00", "0.00"},
				{"Panel","TestString","100.00KW (100.00%)","99.00KW (99.00%)","98.01KW (98.01%)","97.03KW (97.03%)","96.06KW (96.06%)","95.10KW (95.10%)","94.15KW (94.15%)",
					"93.21KW (93.21%)","92.27KW (92.27%)","91.35KW (91.35%)","90.44KW (90.44%)","89.53KW (89.53%)","88.64KW (88.64%)","87.75KW (87.75%)","86.87KW (86.87%)",
					"86.01KW (86.01%)","85.15KW (85.15%)","84.29KW (84.29%)","83.45KW (83.45%)","82.62KW (82.62%)","81.79KW (81.79%)","80.97KW (80.97%)","80.16KW (80.16%)",
					"79.36KW (79.36%)","78.57KW (78.57%)"},
				{"Panel","SolarPanel","100.00KW (100.00%)","95.00KW (95.00%)","90.25KW (90.25%)","85.74KW (85.74%)","81.45KW (81.45%)","77.38KW (77.38%)","73.51KW (73.51%)",
					"69.83KW (69.83%)","66.34KW (66.34%)","63.02KW (63.02%)","59.87KW (59.87%)","56.88KW (56.88%)","54.04KW (54.04%)","51.33KW (51.33%)","48.77KW (48.77%)",
					"46.33KW (46.33%)","44.01KW (44.01%)","41.81KW (41.81%)","39.72KW (39.72%)","37.74KW (37.74%)","35.85KW (35.85%)","34.06KW (34.06%)","32.35KW (32.35%)",
					"30.74KW (30.74%)","29.20KW (29.20%)"},
				{"Panel","TestString","100.00KW (100.00%)","99.00KW (99.00%)","98.01KW (98.01%)","97.03KW (97.03%)","96.06KW (96.06%)","95.10KW (95.10%)","94.15KW (94.15%)",
					"93.21KW (93.21%)","92.27KW (92.27%)","91.35KW (91.35%)","90.44KW (90.44%)","89.53KW (89.53%)","88.64KW (88.64%)","87.75KW (87.75%)","86.87KW (86.87%)",
					"86.01KW (86.01%)","85.15KW (85.15%)","84.29KW (84.29%)","83.45KW (83.45%)","82.62KW (82.62%)","81.79KW (81.79%)","80.97KW (80.97%)","80.16KW (80.16%)",
					"79.36KW (79.36%)","78.57KW (78.57%)"}
			     
		}));
	}
}

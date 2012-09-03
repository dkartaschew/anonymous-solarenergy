package com.anonymous.solar.desktop;

import org.uispec4j.Trigger;
import org.uispec4j.UISpec4J;
import org.uispec4j.UISpecAdapter;
import org.uispec4j.UISpecTestCase;
import org.uispec4j.Window;
import org.uispec4j.interception.MainClassAdapter;
import org.uispec4j.interception.WindowHandler;
import org.uispec4j.interception.WindowInterceptor;

import com.anonymous.solar.shared.SolarSetup;

public class SolarApplicationTest extends UISpecTestCase {
	
	private final static String TEST_STRING = "TestString";
	private final static String ANOTHER_TEST_STRING = "AnotherTestString";
	
	static {
	      UISpec4J.init();
	  }
	
	public void testMainWindowTitle(){
		setAdapter((UISpecAdapter) new MainClassAdapter(SolarApplication.class, new String[]{}));
		Window mainWindow = getMainWindow();
	    assertTrue(mainWindow.getTitle().compareTo("Solar Power Calculator") == 0);
	}
	
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
	
	
	//
	// WizardStart Tests
	//
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
	
	// Close Dialog Test
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
	
	// Unsure about this as ImageIcon is apparently not supported by GoogleAppEngine
	// Even though ImageIcon is clearly used elsewhere
	/*public void testSolarImage() {
		setAdapter((UISpecAdapter) new MainClassAdapter(SolarApplication.class, new String[]{}));
		Window mainWindow = getMainWindow();
		
		assertTrue(mainWindow.getTextBox("ImageSolar").iconEquals(new javax.swing.ImageIcon(getClass().getResource("/com/anonymous/solar/desktop/images/solar_power_flower.jpg"))));
	}*/
	
	
	//
	// WizardSetupDescription Tests
	//
	public void testNextWithoutSetupName() {
		setAdapter((UISpecAdapter) new MainClassAdapter(SolarApplication.class, new String[]{}));
		Window mainWindow = getMainWindow();
		
		mainWindow.getButton("Next").click();
		assertTrue(mainWindow.getTextBox("TextFieldSetupName").getText().compareTo("") == 0);

		WindowInterceptor.init(mainWindow.getButton("Next").triggerClick()).process(new WindowHandler() {
	    	public Trigger process(Window dialog) {
	    	      assertTrue(dialog.titleEquals("Setup Name Missing"));
	    	      return dialog.getButton("OK").triggerClick();
	    	    }
	    }).run();
	}
	
	//
	// WizardUserCosts Tests
	//
	public void testNextWithoutUsageDetails() {
		setAdapter((UISpecAdapter) new MainClassAdapter(SolarApplication.class, new String[]{}));
		Window mainWindow = getMainWindow();
		
		mainWindow.getButton("Next").click();
		mainWindow.getTextBox("TextFieldSetupName").setText("TestSetupName");
		mainWindow.getButton("Next").click();
		
		//TODO: Test Spinner value is in fact 0

		WindowInterceptor.init(mainWindow.getButton("Next").triggerClick()).process(new WindowHandler() {
	    	public Trigger process(Window dialog) {
	    	      assertTrue(dialog.titleEquals("Estimated Usage Missing"));
	    	      return dialog.getButton("OK").triggerClick();
	    	    }
	    }).run();
	}
	
	//
	// WizardSetupElectrical Tests
	//
	public void testNextWithoutInverterDetails() {
		setAdapter((UISpecAdapter) new MainClassAdapter(SolarApplication.class, new String[]{}));
		Window mainWindow = getMainWindow();
		
		mainWindow.getButton("Next").click();
		mainWindow.getTextBox("TextFieldSetupName").setText("TestSetupName");
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
	
	//
	// WizardSetupSolarPanels Tests
	//
	private void gotoSetupSolarPanels(Window mainWindow) {
		mainWindow.getButton("Next").click();
		mainWindow.getTextBox("TextFieldSetupName").setText("TestSetupName");
		mainWindow.getButton("Next").click();
		mainWindow.getSpinner("SpinnerDailyAverageUsage").clickForNextValue();
		mainWindow.getButton("Next").click();

		WindowInterceptor.init(mainWindow.getButton("EditInverterDetails").triggerClick()).process(new WindowHandler() {
	    	public Trigger process(Window dialog) {
	    	      assertTrue(dialog.titleEquals("Inverter Information"));
	    	      
	    	      dialog.getTextBox("TextFieldInverterName").setText("TestInverterName");
	    	      dialog.getTextBox("TextFieldInverterManufacturerName").setText("TestInverterManufacturerName");
	    	      dialog.getTextBox("TextFieldInverterManufacturerCode").setText("TestInverterManufacturerCode");
	    	      
	    	      dialog.getSpinner("SpinnerInverterCost").clickForNextValue();  
	    	      dialog.getSpinner("SpinnerInverterRRP").clickForNextValue();

	    	      return dialog.getButton("Submit").triggerClick();
	    	    }
	    }).run();
		
		mainWindow.getButton("Next").click();
	}
	
	public void testNextWithoutSolarPanels() {
		setAdapter((UISpecAdapter) new MainClassAdapter(SolarApplication.class, new String[]{}));
		Window mainWindow = getMainWindow();
		
		gotoSetupSolarPanels(mainWindow);
		
		WindowInterceptor.init(mainWindow.getButton("Next").triggerClick()).process(new WindowHandler() {
	    	public Trigger process(Window dialog) {
	    	      assertTrue(dialog.titleEquals("Solar Panel Configuration Information Missing"));
	    	      return dialog.getButton("OK").triggerClick();
	    	    }
	    }).run();
	}
	
	public void testDeleteWithoutSelection() {
		setAdapter((UISpecAdapter) new MainClassAdapter(SolarApplication.class, new String[]{}));
		Window mainWindow = getMainWindow();
		
		gotoSetupSolarPanels(mainWindow);
		
		assertTrue(mainWindow.getTable().isEmpty());
		WindowInterceptor.init(mainWindow.getButton("Delete").triggerClick()).process(new WindowHandler() {
	    	public Trigger process(Window dialog) {
	    	      assertTrue(dialog.titleEquals("Delete Panel"));
	    	      return dialog.getButton("OK").triggerClick();
	    	    }
	    }).run();
	}
	
	public void testEditWithoutSelection() {
		setAdapter((UISpecAdapter) new MainClassAdapter(SolarApplication.class, new String[]{}));
		Window mainWindow = getMainWindow();
		
		gotoSetupSolarPanels(mainWindow);
		
		assertTrue(mainWindow.getTable().isEmpty());
		WindowInterceptor.init(mainWindow.getButton("Edit").triggerClick()).process(new WindowHandler() {
	    	public Trigger process(Window dialog) {
	    	      assertTrue(dialog.titleEquals("Edit Panels"));
	    	      return dialog.getButton("OK").triggerClick();
	    	    }
	    }).run();
	}
	
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
	
	public void testAddSolarPanels() {
		setAdapter((UISpecAdapter) new MainClassAdapter(SolarApplication.class, new String[]{}));
		Window mainWindow = getMainWindow();
		
		gotoSetupSolarPanels(mainWindow);
		
		assertTrue(mainWindow.getTable().isEmpty());

		addSomePanels(mainWindow);
		
		assertTrue(mainWindow.getTable().contentEquals(new String[][]{
				{TEST_STRING, "10.0", "100.0", "25", "0.0", "5"}
		}));
	}
	
	public void testDeleteSolarPanels() {
		setAdapter((UISpecAdapter) new MainClassAdapter(SolarApplication.class, new String[]{}));
		Window mainWindow = getMainWindow();
		
		gotoSetupSolarPanels(mainWindow);
		
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
	
	public void testEditSolarPanels() {
		setAdapter((UISpecAdapter) new MainClassAdapter(SolarApplication.class, new String[]{}));
		Window mainWindow = getMainWindow();
		
		gotoSetupSolarPanels(mainWindow);
		
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
	
}

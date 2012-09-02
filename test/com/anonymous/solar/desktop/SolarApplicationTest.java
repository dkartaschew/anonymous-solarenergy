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
	
	
	
	// WizardStart Tests
	public void testMainTitle() {
		setAdapter((UISpecAdapter) new MainClassAdapter(SolarApplication.class, new String[]{}));
		Window mainWindow = getMainWindow();
		
		assertTrue(mainWindow.getTextBox("mainTitle").getText().compareTo("Solar Energy Calculator") == 0);
	}
	
	public void testMainDescription() {
		setAdapter((UISpecAdapter) new MainClassAdapter(SolarApplication.class, new String[]{}));
		Window mainWindow = getMainWindow();
		
		assertTrue(mainWindow.getTextBox("mainDescription").getText().compareTo("<html>\n<center>\nA simple Solar Power Calculator<br>\nfor domestic installations.<br>\n<br>\n<small>Copyright 2012, Team Anonymous (QUT)<br>\nReleased under the GPL v3 license</small>\n</center>\n</html>") == 0);
	}
	
	// Unsure about this as ImageIcon is apparently not supported by GoogleAppEngine
	// Even though ImageIcon is clearly used elsewhere
	/*public void testSolarImage() {
		setAdapter((UISpecAdapter) new MainClassAdapter(SolarApplication.class, new String[]{}));
		Window mainWindow = getMainWindow();
		
		assertTrue(mainWindow.getTextBox("imageSolar").iconEquals(new javax.swing.ImageIcon(getClass().getResource("/com/anonymous/solar/desktop/images/solar_power_flower.jpg"))));
	}*/
	
	
	
	// WizardSetupDescription Tests
	public void testNextWithoutSetupName() {
		setAdapter((UISpecAdapter) new MainClassAdapter(SolarApplication.class, new String[]{}));
		Window mainWindow = getMainWindow();
		
		mainWindow.getButton("nextButton").click();

		WindowInterceptor.init(mainWindow.getButton("nextButton").triggerClick()).process(new WindowHandler() {
	    	public Trigger process(Window dialog) {
	    	      assertTrue(dialog.titleEquals("Setup Name Missing"));
	    	      return dialog.getButton("OK").triggerClick();
	    	    }
	    }).run();
	}
	
}

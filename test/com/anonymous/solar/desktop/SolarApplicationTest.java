package com.anonymous.solar.desktop;

import org.uispec4j.Trigger;
import org.uispec4j.UISpec4J;
import org.uispec4j.UISpecAdapter;
import org.uispec4j.UISpecTestCase;
import org.uispec4j.Window;
import org.uispec4j.interception.MainClassAdapter;
import org.uispec4j.interception.WindowHandler;
import org.uispec4j.interception.WindowInterceptor;

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
	
}

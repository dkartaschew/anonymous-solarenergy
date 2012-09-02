package com.anonymous.solar.desktop;

/**
 * The default handlers that all client panels within the wizard MUST implement.
 * 
 * @author 07627505 Darran Kartaschew
 * @version 1.0
 */
public interface WizardPanel {

	/**
	 * Default callback handler that will get called when the panel is brought
	 * into focus.
	 * 
	 * @return true, if the callback succeeded, otherwise false. (false will
	 *         rollback the operation).
	 */
	public boolean callbackStart();

	/**
	 * Default callback handler that will get called when the panel is from
	 * focus.
	 * 
	 * @return true, if the callback succeeded, otherwise false. (false will
	 *         rollback the operation).
	 */
	public boolean callbackDispose(boolean validateInput);

	/**
	 * Retrieve the title text that will be displayed during the operation of
	 * the wizard. Returning "" will result in the header text to be hidden.
	 * 
	 * @return String containing the title text to be displayed.
	 */
	public String getTitle();
}

/**
 * 
 */
package com.anonymous.solar.server;

/**
 * Helper class for generating HTML output.
 * 
 * @author 07627505 Darran Kartaschew
 * @version 1.0
 */
public class SolarPanelsHTMLHelper {

	/**
	 * Return a HTML header for inclusion in the servlets offering HTML support.
	 * 
	 * @param title
	 *            The title to be displayed on the webpage.
	 * @return String with a complete HTML Header.
	 */
	public static String getHTMLHeader(String title) {
		String header = "<!DOCTYPE html PUBLIC \"-//W3C//DTD XHTML 1.0 Strict//EN\" \"http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd\">\n"
				+ "<html xmlns=\"http://www.w3.org/1999/xhtml\">\n"
				+ "<head>\n<title>"
				+ title
				+ "</title>\n"
				+ "<meta http-equiv=\"content-type\" content=\"text/html;charset=utf-8\" />\n"
				+ "<link href=\"SolarCalculator.css\" rel=\"stylesheet\" type=\"text/css\">\n"
				+ "</head>\n<body>\n"
				+ "<div id=\"Menu\">"
				+ "<ul><li><a href=\"panels.jsp\">Panels</a></li>"
				+ "<li class=\"end\"><a href=\"inverters.jsp\">Inverters</a></li>" + "</ul></div>\n";
		return header;
	}

	/**
	 * Return a HTML footer for the website.
	 * 
	 * @return String with a standard HTML footer.
	 */
	public static String getHTMLFooter() {
		return "<hr />\n<div id=\"footer\"><p class=\"align_center\">Copyright Team Anonymous, QUT, 2012.</p></div>\n</body>\n</html>\n";
	}

}

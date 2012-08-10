package com.anonymous.solar.client;

public class SolarPanelsHTMLHelper {

	public static String getHTMLHeader(String title) {
		String header = "<!DOCTYPE html PUBLIC \"-//W3C//DTD XHTML 1.0 Strict//EN\" \"http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd\">\n"
				+ "<html xmlns=\"http://www.w3.org/1999/xhtml\">\n"
				+ "<head>\n<title>"
				+ title
				+ "</title>\n"
				+ "<meta http-equiv=\"content-type\" content=\"text/html;charset=utf-8\" />\n"
				+ "<link href=\"SolarCalculator.css\" rel=\"stylesheet\" type=\"text/css\">\n" + "</head>\n<body>\n";
		return header;
	}

	public static String getHTMLFooter() {
		return "</body>\n</html>\n";
	}

}

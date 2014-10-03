package org.onlinereg.webgwt.client.admin;

import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.FlowPanel;
import com.google.gwt.user.client.ui.HTML;
import com.google.gwt.user.client.ui.Image;

/**
 * This class represents the header of the admin view.
 * 
 * @author Oleg Bezkorovajniy
 */

public class AdminHeader extends Composite {

	/** The main panel of the header */
	private FlowPanel headerPanel = new FlowPanel();

	/** The logo image */
	private Image logo = new Image("images/GoogleCode.png");

	/** The headline below the logo */
	private HTML secondHeadline = new HTML("<h3>User List:</h3>");

	public AdminHeader() {

		logo.setWidth("150px");
		headerPanel.add(logo);
		headerPanel.add(secondHeadline);
	}

	/**
	 * Returns the main panel of the header
	 * 
	 * @return The main panel of the header
	 * */
	public FlowPanel getHeaderPanel() {
		return headerPanel;
	}

}

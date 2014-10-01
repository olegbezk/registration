package org.onlinereg.webgwt.client.admin;

import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.HorizontalPanel;

/**
 * This class represents the footer of the database view.
 * 
 * @author Oleg Bezkorovajniy
 */

public class AdminFooter extends Composite {

	/** The main panel of the footer */
	private HorizontalPanel hpanel = new HorizontalPanel();

	public AdminFooter() {

		hpanel.setHeight("100px");
		hpanel.setWidth("600px");
	}

	/**
	 * Returns the main panel of the footer
	 * 
	 * @return The main panel of the footer
	 * */
	public HorizontalPanel getHpanel() {
		return hpanel;
	}

}

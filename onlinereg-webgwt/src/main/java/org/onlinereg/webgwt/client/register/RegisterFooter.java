package org.onlinereg.webgwt.client.register;

import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.HorizontalPanel;

/**
 * This class represents the footer of the register view.
 * 
 * @author Oleg Bezkorovajniy
 */
public class RegisterFooter extends Composite {

	/** The main panel of the footer */
	private HorizontalPanel hpanel = new HorizontalPanel();

	public RegisterFooter() {
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

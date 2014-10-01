package org.onlinereg.webgwt.client.simple;

import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.HTML;
import com.google.gwt.user.client.ui.Image;
import com.google.gwt.user.client.ui.VerticalPanel;

/**
 * This class represents the simple user view of the application and includes
 * all elements that are displayed in the simple user view.
 * 
 * @author Oleg Bezkorovajnyi
 */

public class SimpleView extends Composite {

	/** The main panel of the main view */
	private VerticalPanel simplePanel = new VerticalPanel();
	private HTML defaultText = new HTML(
			"<h2>Simple User View of the application</h2><p/>");
	private Image defaultImage = new Image("resources/images/GoogleCode.png");

	private Header header = new Header();

	public SimpleView() {

		simplePanel.add(defaultText);
		defaultImage.setWidth("400px");
		simplePanel.add(defaultImage);
	}

	/**
	 * Returns the main panel of the main view
	 * 
	 * @return The main panel of the main view
	 * */
	public VerticalPanel getSimplePanel() {
		return simplePanel;
	}

	/**
	 * Returns the header of the main view
	 * 
	 * @return The header of the main view
	 * */
	public Header getSimpleheader() {
		return header;
	}

}

package org.onlinereg.webgwt.client.simple;

import com.google.gwt.dom.client.Style.Unit;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.HasHorizontalAlignment;
import com.google.gwt.user.client.ui.HorizontalPanel;

/**
*  This class represents the header of the simple user view.
*  
*  @author Oleg Bezkorovajnyi
*  
**/

public class Header extends Composite {

	/** The main panel of the header */
	private HorizontalPanel hPanel = new HorizontalPanel();

	/** The panel for buttons */
	private HorizontalPanel buttonPanel = new HorizontalPanel();

	/** The close database button */
	// private Button closedatabaseButton = new
	// Button("<img src='resources/images/close-database.png' height='30px' width='30px'/>");

	/** The logout button */
	private Button logoutButton = new Button(
			"<img src='images/logout.gif' height='30px' width='30px'/>");

	public Header() {

		// configure buttons
		// closedatabaseButton.getElement().setClassName("closedatabasebutton");
		// closedatabaseButton.getElement().getStyle().setBackgroundColor("white");
		// closedatabaseButton.setWidth("40px");
		// closedatabaseButton.setTitle("Close Database");
		logoutButton.getElement().setClassName("logoutbutton");
		logoutButton.setWidth("40px");
		logoutButton.setTitle("Logout");

		buttonPanel.setWidth("100px");
		buttonPanel.setHorizontalAlignment(HasHorizontalAlignment.ALIGN_RIGHT);
		buttonPanel.getElement().getStyle().setMarginLeft(500, Unit.PX);
		// buttonPanel.add(closedatabaseButton);
		buttonPanel.add(logoutButton);
		hPanel.add(buttonPanel);

		hPanel.getElement().setClassName("mainheader");
		hPanel.setWidth("600px");
		hPanel.setHeight("50px");
	}

	/**
	 * Returns the main panel of the header
	 * 
	 * @return The main panel of the header
	 * */
	public HorizontalPanel gethPanel() {
		return hPanel;
	}

	// /**Returns the close database button
	// *
	// * @return The close database button
	// * */
	// public Button getClosedatabaseButton() {
	// return closedatabaseButton;
	// }

	/**
	 * Returns the logout button
	 * 
	 * @return The logout button
	 * */
	public Button getLogoutButton() {
		return logoutButton;
	}

}

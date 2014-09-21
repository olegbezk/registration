package org.onlinereg.webgwt.client;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.RootPanel;

/**
 * Entry point classes define <code>onModuleLoad()</code>.
 */
public class GUIModule implements EntryPoint {

	/**
	 * This is the entry point method.
	 */
	public void onModuleLoad() {

		loadLogin();

	}

	// login widget
	private void loadLogin() {
		RootPanel rootPanel = RootPanel.get();

		HorizontalPanel horizontalPanel = new HorizontalPanel();
		rootPanel.add(horizontalPanel, 10, 10);
		horizontalPanel.setSize("470px", "212px");

		Login login = new Login();
		horizontalPanel.add(login);
	}
}

package org.onlinereg.webgwt.client;

import org.onlinereg.webgwt.client.admin.AdminView;
import org.onlinereg.webgwt.client.login.LoginView;
import org.onlinereg.webgwt.client.simple.SimpleView;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.user.client.ui.FlowPanel;
import com.google.gwt.user.client.ui.RootPanel;

/**
 * Entry point classes define <code>onModuleLoad()</code>.
 */
public class GUIModule implements EntryPoint {

	/* Main Elements of the Website which represent the divs in the HTML-Page */
	private FlowPanel header = new FlowPanel();
	private FlowPanel content = new FlowPanel();
	private FlowPanel footer = new FlowPanel();

	/* Element of the Loginview */
	private LoginView loginView = new LoginView();

	/* Element of the database view */
	private AdminView adminView = new AdminView();

	/* Element of the main view */
	private SimpleView simpleView = new SimpleView();

	/**
	 * This is the entry point method.
	 */
	public void onModuleLoad() {

	}

	public void setContent(int status) {
		switch (status) {
		case 0:
			System.out.println("User is not logged in");
			header.clear();
			header.add(loginView.getLoginheader().gethPanel());

			content.clear();
			content.add(loginView.getMainPanel());

			footer.clear();
			footer.add(loginView.getLoginfooter().getHpanel());

			/* Associate the panels with the HTML host page. */
			RootPanel.get("content").add(content);

			RootPanel.get("header").add(header);

			RootPanel.get("footer").add(footer);

			break;
		case 1:
			System.out
					.println("User is logged in but has not chosen a database");

			header.clear();
			header.add(adminView.getAdminHeader().getHeaderPanel());

			content.clear();
			content.add(adminView.gethPanel());

			footer.clear();
			footer.add(adminView.getAdminFooter().getHpanel());

			/* Associate the panels with the HTML host page. */
			RootPanel.get("content").add(content);

			RootPanel.get("header").add(header);

			RootPanel.get("footer").add(footer);

			break;
		case 2:
			System.out.println("User is logged in and has chosen a database");
			header.clear();
			header.add(simpleView.getSimpleheader().gethPanel());

			content.clear();
			content.add(simpleView.getSimplePanel());

			footer.clear();

			/* Associate the panels with the HTML host page. */
			RootPanel.get("content").add(content);

			RootPanel.get("header").add(header);

			break;
		default:
			System.out.println("switch-case-defaulttext");
		}
	}

}

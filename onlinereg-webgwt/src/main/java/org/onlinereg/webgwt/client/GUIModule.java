package org.onlinereg.webgwt.client;

import org.onlinereg.webgwt.client.admin.AdminView;
import org.onlinereg.webgwt.client.login.LoginView;
import org.onlinereg.webgwt.client.simple.SimpleView;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
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

	/* Element of the Login view */
	private LoginView loginView = new LoginView();

	/* Element of the admin view */
	private AdminView adminView = new AdminView();

	/* Element of the main view */
	private SimpleView simpleView = new SimpleView();

	/**
	 * This is the entry point method.
	 */
	public void onModuleLoad() {
		
		/* Adding an Eventhandler to the Login-Button */
		this.loginView.getLoginbutton().addClickHandler(new ClickHandler() {
	          public void onClick(ClickEvent event) {

	        	  setContent(1);
	            }
	          });
		/* Adding an Eventhandler to the Register-Button */
		this.loginView.getRegisterbutton().addClickHandler(new ClickHandler() {
	          public void onClick(ClickEvent event) {

	        	  setContent(1);
	            }
	          });
		
		/* Adding an Eventhandler to the Send Email Button*/
		this.adminView.getSendEmailButton().addClickHandler(new ClickHandler() {
	          public void onClick(ClickEvent event) {

	        	  setContent(2);
	            }
	          });
		
//		/*Adds an event handler on the closedatabase button to close the database*/
//		this.simpleView.getSimpleheader().get.addClickHandler(new ClickHandler() {
//	          public void onClick(ClickEvent event) {
//	     
//	        	  setContent(1);               
//	          }
//		 });
	    
		/*Adds an event handler on the logout button of the Simple to log out of the application*/	    
	    this.simpleView.getSimpleheader().getLogoutButton().addClickHandler(new ClickHandler() {
	          public void onClick(ClickEvent event) {
	        	  
	        	  setContent(0);        	  
	          }
		 });
		
		this.setContent(0);

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

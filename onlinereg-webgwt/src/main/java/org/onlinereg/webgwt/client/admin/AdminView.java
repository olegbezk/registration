package org.onlinereg.webgwt.client.admin;

import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.FlowPanel;
import com.google.gwt.user.client.ui.HTML;
import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.ListBox;

/**
 * This class represents the administrator view of the application and includes
 * all elements that are displayed in the administrator view, which is used to
 * manage user rights
 * 
 * @author Oleg Bezkorovajniy
 */
public class AdminView extends Composite {

	/** Main panel of the admin view */
	private HorizontalPanel hPanel = new HorizontalPanel();

	/** Header object */
	private AdminHeader adminHeader = new AdminHeader();

	/** Footer object */
	private AdminFooter adminFooter = new AdminFooter();

	/** List box with single selection mode for users */
	private ListBox multiBox = new ListBox();

	/** Panel for listbox and buttons */
	private FlowPanel contentPanel = new FlowPanel();

	/** Panel for buttons */
	private HorizontalPanel buttonBox = new HorizontalPanel();
	private Button deletUserButton = new Button("Delete");
	private Button sendEmailButton = new Button("Send Email");

	public AdminView() {

		hPanel.setSpacing(20);

		multiBox.ensureDebugId("ListBox-multiBox");
		multiBox.setWidth("20em");
		multiBox.setVisibleItemCount(15);

		buttonBox.add(deletUserButton);
		buttonBox.add(sendEmailButton);
		buttonBox.setSpacing(10);

		contentPanel.add(new HTML("Select User:"));
		contentPanel.add(multiBox);
		contentPanel.add(buttonBox);

		hPanel.add(contentPanel);

		// add example database names
		this.addDatabase("database 1");
		this.addDatabase("database 2");
		this.addDatabase("database 3");
	}

	/**
	 * Adds a database to the database list
	 * 
	 * @param item
	 *            The database item to be added to the list
	 * */
	public void addDatabase(String item) {
		multiBox.addItem(item);
	}

	/**
	 * Removes an entry of the database list
	 * 
	 * @param index
	 *            The index of the databaseentry to be removed from the list
	 * */
	public void removeUserEntry(int index) {
		this.multiBox.removeItem(index);
	}

	/**
	 * Returns the open database button
	 * 
	 * @return The open database button
	 * */
	public Button getDeletUserButton() {
		return deletUserButton;
	}

	/**
	 * Returns the import database button
	 * 
	 * @return The import database button
	 * */
	public Button getSendEmailButton() {
		return sendEmailButton;
	}

	/**
	 * Returns the listbox for databases
	 * 
	 * @return The listbox for databases
	 * */
	public ListBox getMultiBox() {
		return multiBox;
	}

	/**
	 * Returns the footer of the database view
	 * 
	 * @return The footer of the database view
	 * */
	public AdminFooter getAdminFooter() {
		return adminFooter;
	}

	/**
	 * Returns the header of the database view
	 * 
	 * @return The header of the database view
	 * */
	public AdminHeader getAdminHeader() {
		return adminHeader;
	}

	/**
	 * Returns the main panel of the database view
	 * 
	 * @return The main panel of the database view
	 * */
	public HorizontalPanel gethPanel() {
		return hPanel;
	}

}

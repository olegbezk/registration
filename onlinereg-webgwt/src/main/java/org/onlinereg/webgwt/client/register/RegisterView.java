package org.onlinereg.webgwt.client.register;

import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.FlowPanel;
import com.google.gwt.user.client.ui.HorizontalPanel;

/**
 * This class represents the registration view of the application and includes
 * all elements that are displayed in the registration view, which is used to
 * manage user rights
 * 
 * @author Oleg Bezkorovajniy
 */
public class RegisterView extends Composite{
	
	/** Main panel of the reg view */
	private HorizontalPanel hPanel = new HorizontalPanel();
	
	/** Header object */
	private RegisterHeader regHeader = new RegisterHeader();

	/** Footer object */
	private RegisterFooter regFooter = new RegisterFooter();
	
	/** Panel for text boxes and buttons */
	private FlowPanel contentPanel = new FlowPanel();
	
	/** Panel for buttons */
	private HorizontalPanel buttonBox = new HorizontalPanel();
	private Button cancelButton = new Button("Cancel");
	private Button registerButton = new Button("Register");
	
	public RegisterView() {
		// TODO Auto-generated constructor stub
	}

}

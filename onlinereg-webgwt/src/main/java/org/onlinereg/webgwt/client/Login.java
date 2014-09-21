package org.onlinereg.webgwt.client;

import javax.ejb.EJB;

import com.gl.trainee.onlinereg.model.Role;
import com.gl.trainee.onlinereg.model.User;
import com.gl.trainee.onlinereg.service.IUserService;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.i18n.client.HasDirection.Direction;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.FlexTable;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.client.ui.VerticalPanel;

public class Login extends Composite {

	private String login;
	private String password;

	@EJB(lookup = "java:global/onlinereg-ear/onlinereg-ejb/UserService")
	private IUserService userService;

	private TextBox textBoxLogin;
	private TextBox textBoxPassword;

	public Login() {

		VerticalPanel verticalPanel = new VerticalPanel();
		initWidget(verticalPanel);

		Label lblLoginToYour = new Label("Sign in to your account:");
		lblLoginToYour.setStyleName("gwt-Label-Login");
		verticalPanel.add(lblLoginToYour);

		FlexTable flexTable = new FlexTable();
		verticalPanel.add(flexTable);
		flexTable.setWidth("345px");

		Label lblLogin = new Label("Login:");
		lblLogin.setStyleName("gwt-Label-Login");
		flexTable.setWidget(0, 0, lblLogin);

		textBoxLogin = new TextBox();
		flexTable.setWidget(0, 1, textBoxLogin);

		Label lblPassword = new Label("Password:");
		lblPassword.setStyleName("gwt-Label-Login");
		flexTable.setWidget(1, 0, lblPassword);

		textBoxPassword = new TextBox();
		textBoxPassword.setDirection(Direction.RTL);
		flexTable.setWidget(1, 1, textBoxPassword);

		Button btnSignIn = new Button("Sign In");
		btnSignIn.addClickHandler(new ClickHandler() {
			public void onClick(ClickEvent singEvent) {
				if (textBoxLogin.getText().length() == 0
						|| textBoxPassword.getText().length() == 0) {
					Window.alert("Username or password is empty.");
				}
				singIn();
			}
		});
		flexTable.setWidget(2, 1, btnSignIn);

		Button btnRegister = new Button("Register");
		btnRegister.addClickHandler(new ClickHandler() {

			public void onClick(ClickEvent regEvent) {

				userRegister();

			}
		});
		flexTable.setWidget(2, 2, btnRegister);
	}

	protected void userRegister() {
		// TODO Auto-generated method stub

	}

	protected void singIn() {

		User user = userService.getUserByRegInf(login, password);
		if (user != null) {
			Role role = user.getRole();
			if (role == null) {
				woRoleUser();
			} else if (role.getDescription().equals("simple")) {
				simpleUser();
			} else if (role.getDescription().equals("admin")) {
				roleAdmin();
			}
		}

	}

	private void roleAdmin() {
		// TODO Auto-generated method stub
		
	}

	private void simpleUser() {
		// TODO Auto-generated method stub
		
	}

	private void woRoleUser() {
		// TODO Auto-generated method stub
	}

}

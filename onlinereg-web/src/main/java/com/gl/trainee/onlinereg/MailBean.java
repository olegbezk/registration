package com.gl.trainee.onlinereg;

import java.io.Serializable;
import java.util.List;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

import com.gl.trainee.onlinereg.model.User;
import com.gl.trainee.onlinereg.service.IUserService;

@ManagedBean(name = "mailBean")
@RequestScoped
public class MailBean implements Serializable {

	/**
  * 
  */
	private static final long serialVersionUID = 1L;

	private int id;

	private String login;

	private static final String ERROR = "error";

	private static final String SUCCESS = "success";

	private static final String MAIL = "mail";

	@EJB(lookup = "java:global/onlinereg-ear/onlinereg-ejb/UserService")
	private IUserService userService;

	private List<String> unregisteredUsersChecked;

	public List<User> getUnregisteredUsers() {
		return getUserService().getUnregisteredUser();
	}

	public void setUnregisteredUsersChecked(
			List<String> unregisteredUsersChecked) {
		this.unregisteredUsersChecked = unregisteredUsersChecked;
	}

	public List<String> getUnregisteredUsersChecked() {
		return unregisteredUsersChecked;
	}

	public String sendEmail() {
		for (String userId : unregisteredUsersChecked) {
			//System.out.println(Long.valueOf(userId));
			userService.sendEmail(Integer.valueOf(userId));
		}

		return SUCCESS;
	}

	public IUserService getUserService() {
		return userService;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

}

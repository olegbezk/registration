package com.gl.trainee.onlinereg;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

import com.gl.trainee.onlinereg.model.User;
import com.gl.trainee.onlinereg.service.IUserService;

@ManagedBean(name = "mailBean")
@RequestScoped
public class MailBean implements Serializable{

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
	
	private List<User> userListUnreg;
	
	public List<User> getUnregUsers() {
		
		userListUnreg = new ArrayList<User>();
		userListUnreg.addAll(getUserService().getUnregisteredUser());
		
		return userListUnreg;
		
	}
	
	public void setUnregUsers(List<User> userListUnreg) {
		this.userListUnreg = userListUnreg;
	}
	
	public String sendEmail(){
		
		for(User user : userListUnreg){
			System.out.println(user);
		}
		
		return ERROR;
	}
	
	public IUserService getUserService() {
		return userService;
	}
	
	public List<User> getUserListUnreg() {
		return userListUnreg;
	}
	
	public void setUserListUnreg(List<User> userListUnreg) {
		this.userListUnreg = userListUnreg;
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

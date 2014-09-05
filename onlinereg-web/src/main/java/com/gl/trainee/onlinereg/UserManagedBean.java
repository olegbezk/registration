package com.gl.trainee.onlinereg;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

import com.gl.trainee.onlinereg.model.Chat;
import com.gl.trainee.onlinereg.model.Role;
import com.gl.trainee.onlinereg.model.User;
import com.gl.trainee.onlinereg.service.IChatService;
import com.gl.trainee.onlinereg.service.IRoleService;
import com.gl.trainee.onlinereg.service.IUserService;

@ManagedBean(name = "userBean")
@RequestScoped
// @Component("userBean")
// @Scope("request")
public class UserManagedBean implements Serializable {

	private static final long serialVersionUID = 1L;

	private static final String SUCCESS = "success";

	private static final String ERROR = "error";

	private static final String REGSUCCESS = "regsuccess";

	private static final String USERLOG = "userlogsuccess";

	private static final String WOROLE = "withoutrole";

	// Spring User Service is injected...
	// @ManagedProperty(value = "#{UserService}")
	@EJB(lookup = "java:global/onlinereg-ear/onlinereg-ejb/UserService")
	private IUserService userService;

	@EJB
	private IRoleService roleService;

	@EJB
	private IChatService chatService;

	List<User> userList;

	List<Role> roleList;

	List<Chat> chatList;

	private int id;

	private String name;

	private String surname;

	private String login;

	private String password;

	private String email;

	private String hobbie;

	private String note;

	private Role role;

	private String description;

	private Integer roleId;

	public String login() {
		try {
			User user = userService.getUserByRegInf(login, password);
			if (user != null) {
				Role role = user.getRole();
				if (role == null) {
					return WOROLE;
				} else if (role.getDescription().equals("simple")) {
					return USERLOG;
				} else if (role.getDescription().equals("admin")) {
					return SUCCESS;
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return ERROR;
	}

	public String addUser() {
		try {
			if (userService.getUserByRegInf(login, password) != null) {
				return ERROR;
			} else {
				User user = new User();
				user.setName(getName());
				user.setSurname(getSurname());
				user.setEmail(getEmail());
				user.setLogin(getLogin());
				user.setPassword(getPassword());
				user.setHobbie(getHobbie());
				user.setNote(getNote());
				userService.addUser(user);
				return REGSUCCESS;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return ERROR;
	}

	public String setRole() {
		try {

			Role role = new Role();
			role.setDescription(getDescription());
			userService.setRole(role);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	public List<Role> getRoleList() {

		roleList = new ArrayList<Role>();
		roleList.addAll(getUserService().getRoles());

		return roleList;
	}

	public void setRoleList(List<Role> roleList) {
		this.roleList = roleList;
	}

	public List<Chat> getChatList() {
		chatList = new ArrayList<Chat>();
		chatList.addAll(getChatService().getChats());
		return chatList;
	}

	public IChatService getChatService() {
		return chatService;
	}

	public void setChatService(IChatService chatService) {
		this.chatService = chatService;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Integer getRoleId() {
		return roleId;
	}

	public void setRoleId(Integer roleId) {
		this.roleId = roleId;
	}

	public String deleteUser(User user) {
		try {
			getUserService().deleteUser(user);
			userList = null;
			getUserList();
			return SUCCESS;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return ERROR;
	}

	public Role getRole() {
		return role;
	}

	public String getRoleCurrentUser(Role role) {
		User user = userService.getUserByRegInf(login, password);
		role = user.getRole();
		return role.getDescription();
	}

	public String getRole(User user) {
		try {

			Role role = user.getRole();
			if (role == null) {
				return "W/O role";
			}
			return role.getDescription();

		} catch (Exception e) {
			e.printStackTrace();
		}

		return ERROR;
	}

	public void reset() {
		this.setLogin("");
		this.setPassword("");
	}

	public List<User> getUserList() {
		if (userList == null) {
			userList = new ArrayList<User>();
			userList.addAll(getUserService().getUsers());
		}
		return userList;
	}

	public List<User> getUnregUsers() {

		userList = new ArrayList<User>();
		userList.addAll(getUserService().getUnregisteredUser());

		return userList;

	}

	public String updateRole(User user) {
		try {

			Role userRole = roleService.getRole(roleId);
			user.setRole(userRole);

			userService.updateUser(user);

			return SUCCESS;

		} catch (Exception e) {
			e.printStackTrace();
		}
		return ERROR;
	}

	public IUserService getUserService() {
		return userService;
	}

	public void setUserService(IUserService userService) {
		this.userService = userService;
	}

	public void setUserList(List<User> userList) {
		this.userList = userList;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSurname() {
		return surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getHobbie() {
		return hobbie;
	}

	public void setHobbie(String hobbie) {
		this.hobbie = hobbie;
	}

	public String getNote() {
		return note;
	}

	public void setNote(String note) {
		this.note = note;
	}

}
package com.gl.trainee.onlinereg.service;

import java.util.List;

import com.gl.trainee.onlinereg.model.Role;
import com.gl.trainee.onlinereg.model.User;


public interface IUserService {
	
	public void addUser(User user);
	
	public void updateUser(User user);

	public void deleteUser(User user);
	
	public User getUserById(int id);
	
	public List<User> getUsers();
	
	public List<User> getUnregisteredUser();
	
	public User getUserByRegInf(String login, String password);
	
	public User getUserByLogin(String login);
	
	public Role getRole(int id);
	
	public Role addRole(Role role);
	
	public Role deleteRole(Role role);
	
	public Role setRole(Role role);

	public List<Role> getRoles();


}

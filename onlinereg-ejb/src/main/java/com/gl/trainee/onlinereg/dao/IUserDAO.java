package com.gl.trainee.onlinereg.dao;

import java.util.List;

import com.gl.trainee.onlinereg.model.Role;
import com.gl.trainee.onlinereg.model.User;

public interface IUserDAO {

	public void addUser(User user);

	public void updateUser(User user);

	public void deleteUser(User user);

	public User getUserById(int id);

	public List<User> getUsers();
	
	public List<User> getUnregistredUser();

	public User getUserByRegInf(String login, String password);

	public User getUserByLogin(String login);

	public Role addRole(Role role);

	public Role deleteRole(Role role);

	public Role getRole(int id);
	
	public Role setRole(Role role);

	public List<Role> getRoles();
}

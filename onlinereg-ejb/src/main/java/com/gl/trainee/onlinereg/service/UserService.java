package com.gl.trainee.onlinereg.service;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;

import com.gl.trainee.onlinereg.dao.IUserDAO;
import com.gl.trainee.onlinereg.model.Role;
import com.gl.trainee.onlinereg.model.User;

@Stateless
@TransactionAttribute(TransactionAttributeType.NOT_SUPPORTED)
public class UserService implements IUserService {

	@EJB
	private IUserDAO userDAO;

	@TransactionAttribute(TransactionAttributeType.REQUIRES_NEW)
	public void addUser(User user) {
		userDAO.addUser(user);
	}

	@TransactionAttribute(TransactionAttributeType.REQUIRES_NEW)
	public void deleteUser(User user) {
		getUserDAO().deleteUser(user);
	}

	@TransactionAttribute(TransactionAttributeType.REQUIRES_NEW)
	public void updateUser(User user) {
		getUserDAO().updateUser(user);
	}

	public User getUserById(int id) {
		return getUserDAO().getUserById(id);
	}

	public User getUserByRegInf(String login, String password) {
		return getUserDAO().getUserByRegInf(login, password);
	}

	public User getUserByLogin(String login) {
		return getUserDAO().getUserByLogin(login);
	}

	public List<User> getUsers() {
		return getUserDAO().getUsers();
	}

	public IUserDAO getUserDAO() {
		return userDAO;
	}

	public void setUserDAO(IUserDAO userDAO) {
		this.userDAO = userDAO;
	}

	public Role getRole(int id) {
		return userDAO.getRole(id);
	}

	@TransactionAttribute(TransactionAttributeType.REQUIRES_NEW)
	public Role addRole(Role role) {
		return userDAO.addRole(role);
	}

	@TransactionAttribute(TransactionAttributeType.REQUIRES_NEW)
	public Role setRole(Role role) {
		return userDAO.setRole(role);
	}

	@TransactionAttribute(TransactionAttributeType.REQUIRES_NEW)
	public Role deleteRole(Role role) {
		return userDAO.deleteRole(role);
	}

	@Override
	public List<Role> getRoles() {
		return getUserDAO().getRoles();
	}

	@Override
	public List<User> getUnregisteredUser() {
		return getUserDAO().getUnregistredUser();
	}



}

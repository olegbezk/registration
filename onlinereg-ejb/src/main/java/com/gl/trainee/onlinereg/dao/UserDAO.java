package com.gl.trainee.onlinereg.dao;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import com.gl.trainee.onlinereg.model.Role;
import com.gl.trainee.onlinereg.model.User;

@Stateless
public class UserDAO implements IUserDAO {

	@PersistenceContext
	private EntityManager em;

	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	public void addUser(User user) {
		em.persist(user);
	}

	public void deleteUser(User user) {
		em.remove(user);
	}

	public void updateUser(User user) {
		em.merge(user);
	}

	public User getUserById(int id) {
		List<User> list = em
				.createQuery("select u from User u where u.id=?1", User.class)
				.setParameter(1, id).getResultList();
		return list.get(0);
	}

	public List<User> getUsers() {
		List<User> list = em.createQuery("select u from User u", User.class)
				.getResultList();
		return list;

	}

	public User getUserByRegInf(String login, String password) {
		List<User> listRegInf = em
				.createQuery(
						"select u from User u where u.login = ?1 and u.password = ?2",
						User.class).setParameter(1, login)
				.setParameter(2, password).getResultList();
		if (listRegInf.isEmpty()) {
			return null;
		}
		return (User) listRegInf.get(0);

	}

	public Role getRole(int id) {
		Role role = (Role) em.getReference(Role.class, id);
		return role;

	}

	@SuppressWarnings("unchecked")
	public User getUserByLogin(String login) {
		List<User> userList = new ArrayList<User>();
		Query query = em.createQuery("from User u where u.login = :login");
		query.setParameter("login", login);
		userList = query.getResultList();
		if (userList.size() > 0)
			return userList.get(0);
		else
			return null;
	}

	public Role setRole(Role role) {
		em.refresh(role);
		return role;

	}

	public Role addRole(Role role) {
		em.persist(role);
		return role;
	}

	public Role deleteRole(Role role) {
		em.remove(role);
		return role;
	}

	@Override
	public List<Role> getRoles() {
		List<Role> list = em.createQuery("select r from Role r", Role.class)
				.getResultList();
		return list;
	}

	@Override
	public List<User> getUnregistredUser() {
		List<User> list = em.createQuery(
				"select u from User u where u.role is null", User.class)
				.getResultList();
		return list;
	}

}

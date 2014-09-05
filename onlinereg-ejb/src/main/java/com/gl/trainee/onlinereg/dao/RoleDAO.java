package com.gl.trainee.onlinereg.dao;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.gl.trainee.onlinereg.model.Role;

@Stateless
public class RoleDAO implements IRoleDAO {

	@PersistenceContext
	private EntityManager em;

	public List<Role> getRoles() {
		@SuppressWarnings("unchecked")
		List<Role> list = em
				.createQuery("select r from Role r").getResultList();
		return list;
	}

	public void addRole(Role role) {
		em.persist(role);

	}

	public void delete(Role role) {
		em.remove(role);

	}

	public Role getRole(int id) {
		Role role = (Role) em.getReference(
				Role.class, id);
		return role;
	}

}

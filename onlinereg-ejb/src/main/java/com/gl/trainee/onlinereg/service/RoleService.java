package com.gl.trainee.onlinereg.service;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;

import com.gl.trainee.onlinereg.dao.IRoleDAO;
import com.gl.trainee.onlinereg.model.Role;

@Stateless
@TransactionAttribute(TransactionAttributeType.NOT_SUPPORTED)
public class RoleService implements IRoleService {

	@EJB
	private IRoleDAO roleDAO;

	public Role getRole(int id) {
		return roleDAO.getRole(id);
	}

	public List<Role> getRoles() {
		return roleDAO.getRoles();
	}

}

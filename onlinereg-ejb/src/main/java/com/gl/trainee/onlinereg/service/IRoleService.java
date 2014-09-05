package com.gl.trainee.onlinereg.service;

import java.util.List;

import com.gl.trainee.onlinereg.model.Role;

public interface IRoleService {
	
	public Role getRole(int id);
	
	public List<Role> getRoles();

}

package com.mublog.dao;

import java.util.List;

import com.mublog.entity.Role;

public interface RoleDao {

	
	
	Role findById(int id);
    
    //User findBySSO(String sso);
     
    void save(Role role);
     
    //void deleteBySSO(String sso);
     
    List<Role> getRoleList();

	long getId();
}

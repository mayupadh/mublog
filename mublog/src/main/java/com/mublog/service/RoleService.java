package com.mublog.service;
import java.util.List;

import com.mublog.entity.Role;
import com.mublog.exception.InstanceNotFoundException;

 
 
 
public interface RoleService {
     
	Role findById(Long id) throws InstanceNotFoundException;
	
	Role findByName (String roleName) throws InstanceNotFoundException;
	    
    void save(Role role);
    
    void update(Role role);
    
    void deleteById(Long id) throws InstanceNotFoundException;
     
    List<Role> findAll();
    
    //List<Role> findAllActive();
     
  
    boolean isRoleExist(Role role);
     
}
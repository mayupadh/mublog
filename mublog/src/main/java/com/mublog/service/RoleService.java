package com.mublog.service;
import java.util.List;

import com.mublog.entity.Role;

 
 
 
public interface RoleService {
     
    Role findById(long id);
     
    Role findByName(String name);
     
    void saveRole(Role role);
     
    void updateRole(Role role);
     
    void deleteRoleById(long id);
 
    List<Role> findAllRoles(); 
     
    void deleteAllRoles();
     
    public boolean isRoleExist(Role role);
     
}
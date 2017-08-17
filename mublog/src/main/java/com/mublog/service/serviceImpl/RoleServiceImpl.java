package com.mublog.service.serviceImpl;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.mublog.dao.RoleDao;
import com.mublog.entity.Role;
import com.mublog.service.RoleService;

 
@Service("roleService")
@Transactional
public class RoleServiceImpl implements RoleService{
     
    private static final AtomicLong counter = new AtomicLong();
     
    private static List<Role> roles;
    
    @Autowired
    RoleDao roleDao;
     
   /* static{
        roles = populateRoles();
    }*/
 
    public List<Role> findAllRoles() {
    	
    	List<Role> roles = new ArrayList<Role>();
        List<Role> roleList = roleDao.getRoleList();
        
        return roleList;
    }
     
    public Role findById(long id) {
        for(Role role : roles){
            if(role.getId() == id){
                return role;
            }
        }
        return null;
    }
     
    public Role findByName(String name) {
    	if(roles != null){
	        for(Role role : roles){
	            if(role.getRoleName().equalsIgnoreCase(name)){
	                return role;
	            }
	        }
    	}
        return null;
    }
     
    public void saveRole(Role role) {
        //role.setId(counter.incrementAndGet());
    	System.out.println("role  -->"+role.toString());
    	roleDao.save(role);
    }
 
    public void updateRole(Role role) {
        int index = roles.indexOf(role);
        roleDao.save(role);
    }
 
    public void deleteRoleById(long id) {
         
        for (Iterator<Role> iterator = roles.iterator(); iterator.hasNext(); ) {
            Role role = (Role) iterator.next();
            if (role.getId() == id) {
                iterator.remove();
            }
        }
    }
 
    public boolean isRoleExist(Role role) {
        return findByName(role.getRoleName())!=null;
    }
     
    public void deleteAllRoles(){
        roles.clear();
    }
 
   /* private static List<Role> populateRoles(){
        List<Role> roles = new ArrayList<Role>();
        List<Role> roleList = roleDao.getRoleList();
        
        return roleList;
    }*/
 
}
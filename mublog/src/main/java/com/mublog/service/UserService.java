package com.mublog.service;
import java.util.List;

import com.mublog.dao.UserDao;
import com.mublog.entity.User;
import com.mublog.exception.InstanceNotFoundException;

 
 
 
public interface UserService {
     
	User findById(Long id) throws InstanceNotFoundException;
	
	User findByName (String userName) throws InstanceNotFoundException;
	    
    void save(User user);
    
    void update(User user);
    
    void deleteById(Long id) throws InstanceNotFoundException;
     
    List<User> findAll();
    
    //List<User> findAllActive();
     
    //List<User> findUsersByUserType(String userType);
    
    //List<User> findUsersByUserTypeActive(String userType);
    
    boolean isUserExist(User user);
     
}
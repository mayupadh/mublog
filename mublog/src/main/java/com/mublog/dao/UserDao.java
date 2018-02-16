package com.mublog.dao;

import java.util.List;

import com.mublog.exception.InstanceNotFoundException;

import com.mublog.entity.User;

public interface UserDao {

	
    User findById(Long id) throws InstanceNotFoundException;
    
    User findByName (String userName) throws InstanceNotFoundException;
    
    void save(User user);
    
    void update(User user);
    
    void deleteById(Long id) throws InstanceNotFoundException;
     
    List<User> findAll();
    
    //List<User> findAllActive();
}

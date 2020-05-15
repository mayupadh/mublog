package com.mublog.dao;

import java.util.List;

import com.mublog.exception.InstanceNotFoundException;

import com.mublog.entity.Menu;

public interface MenuDao {

	
    Menu findById(Long id) throws InstanceNotFoundException;
    
    Menu findByName (String menuName) throws InstanceNotFoundException;
    
    void save(Menu menu);
    
    void update(Menu menu);
    
    void deleteById(Long id) throws InstanceNotFoundException;
     
    List<Menu> findAll();
    
    //List<Menu> findAllActive();
}

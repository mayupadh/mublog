package com.mublog.service;
import java.sql.SQLException;
import java.util.List;

import com.mublog.dao.MenuDao;
import com.mublog.entity.Menu;
import com.mublog.exception.InstanceNotFoundException;

 
 
 
public interface MenuService {
     
	Menu findById(Long id) throws InstanceNotFoundException;
	
	Menu findByName (String menuName) throws InstanceNotFoundException;
	    
    void save(Menu menu);
    
    void update(Menu menu);
    
    void deleteById(Long id) throws InstanceNotFoundException;
     
    List<Menu> findAll();
    
    //List<Menu> findAllActive();
     
    //List<Menu> findMenusByMenuType(String menuType);
    
    //List<Menu> findMenusByMenuTypeActive(String menuType);
    
    //String uploadMenuIconImage(String strPath) throws SQLException, Exception;
    
    boolean isMenuExist(Menu menu);
     
}
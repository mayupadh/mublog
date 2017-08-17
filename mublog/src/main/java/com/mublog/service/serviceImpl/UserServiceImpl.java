package com.mublog.service.serviceImpl;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.mublog.dao.UserDao;
import com.mublog.entity.User;
import com.mublog.service.UserService;
 
@Service("userService")
@Transactional
public class UserServiceImpl implements UserService{
     
    private static final AtomicLong counter = new AtomicLong();
     
    private static List<User> users;
    
    @Autowired
    UserDao userDao;
     
   /* static{
        users = populateUsers();
    }*/
 
    public List<User> findAllUsers() {
    	
    	List<User> users = new ArrayList<User>();
        List<User> userList = userDao.getUserList();
        
        return userList;
    }
     
    public User findById(long id) {
        for(User user : users){
            if(user.getId() == id){
                return user;
            }
        }
        return null;
    }
     
    public User findByName(String name) {
    	if(users != null){
	        for(User user : users){
	            if(user.getUserName().equalsIgnoreCase(name)){
	                return user;
	            }
	        }
    	}
        return null;
    }
     
    public void saveUser(User user) {
        //user.setId(counter.incrementAndGet());
    	System.out.println("user  -->"+user.toString());
    	userDao.save(user);
    }
 
    public void updateUser(User user) {
        int index = users.indexOf(user);
        userDao.save(user);
    }
 
    public void deleteUserById(long id) {
         
        for (Iterator<User> iterator = users.iterator(); iterator.hasNext(); ) {
            User user = (User) iterator.next();
            if (user.getId() == id) {
                iterator.remove();
            }
        }
    }
 
    public boolean isUserExist(User user) {
        return findByName(user.getUserName())!=null;
    }
     
    public void deleteAllUsers(){
        users.clear();
    }
 
   /* private static List<User> populateUsers(){
        List<User> users = new ArrayList<User>();
        List<User> userList = userDao.getUserList();
        
        return userList;
    }*/
 
}
package com.mublog.service.serviceImpl;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.mublog.dao.UserDao;
import com.mublog.entity.User;
import com.mublog.exception.InstanceNotFoundException;
import com.mublog.service.UserService;
 
@Service
@Transactional
public class UserServiceImpl implements UserService{
     
	@Autowired
	UserDao userDao;


	public User findById(Long id) throws InstanceNotFoundException {
		return userDao.findById(id);
	}

	public User findByName(String userName) throws InstanceNotFoundException {
		return userDao.findByName(userName);
	}

	/*public User findByBarCode(String barCode) throws InstanceNotFoundException {
		return userDao.findByBarCode(barCode);
	}*/

	public void save(User user) {
		userDao.save(user);
	}

	public void update(User user) {
		userDao.update(user);
	}

	public void deleteById(Long id) throws InstanceNotFoundException {
		userDao.deleteById(id);
	}

	public List<User> findAll() {
		List<User> users = userDao.findAll();
		return users;
	}

	/*public List<User> findAllActive() {
		List<User> users = userDao.findAllActive();
		return convertToDiscountApliedUserList(users);
	}*/
	
	public boolean isUserExist(User user) {
		boolean flag = false;
		try {
			 flag = findById(user.getId()) != null?true:false;
		} catch (InstanceNotFoundException ex) {
			return flag;
		}
		return flag;
	}
}
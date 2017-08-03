package com.mublog.dao.daoImpl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.mublog.dao.UserDao;
import com.mublog.entity.User;

@Repository
public class UserDaoImpl implements UserDao {

	private static List<User> userList = new ArrayList<User>();
	
	static 
	{
		User userA = new User();
		userA.setFirstName("Mayank");
		userA.setLastName("Upadhyay");
		userA.setUserName("mayupadh");
		userA.setEmailId("mayank_3082@yahoo.co.in");
		userList.add(userA);
	}
	@Override
	public List<User> getUserList() {
		return userList;
	}

}

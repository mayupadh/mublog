package com.mublog.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.mublog.dao.UserDao;
import com.mublog.entity.User;

@Controller
public class AdminController {

	@Autowired
	UserDao userDao;
	
	@RequestMapping(value= "/userDetails")
	public ModelAndView userDetails()
	{
		ModelAndView mvObj = new ModelAndView("admin");
				mvObj.addObject("title","User Details");
				List<User> userList = userDao.getUserList();
				mvObj.addObject("userList",userList);
				mvObj.addObject("showUserDetails",true);
				return mvObj;
	}
	
	@RequestMapping(value= "/adminDashboard")
	public ModelAndView showDashboard()
	{
		ModelAndView mvObj = new ModelAndView("admin");
				mvObj.addObject("title","Dashboard");
				mvObj.addObject("showDashboardMenu",true);
				return mvObj;
	}
}

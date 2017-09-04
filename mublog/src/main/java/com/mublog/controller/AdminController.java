package com.mublog.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.mublog.dao.UserDao;
import com.mublog.entity.ArticleCategory;
import com.mublog.entity.Role;
import com.mublog.entity.User;
import com.mublog.service.ArticleCategoryService;
import com.mublog.service.RoleService;
import com.mublog.service.UserService;

@Controller
public class AdminController {

	@Autowired
	UserService userService;
	@Autowired
	RoleService roleService;
	@Autowired
	ArticleCategoryService articleCategoryService;
	
	@RequestMapping(value= "/user")
	public ModelAndView userDetails()
	{
		ModelAndView mvObj = new ModelAndView("admin");
				mvObj.addObject("title","User Details");
				List<User> users = userService.findAll();
				mvObj.addObject("userList",users);
				mvObj.addObject("showUserDetails",true);
				return mvObj;
	}
	
	@RequestMapping(value= "/articleCategory")
	public ModelAndView articleCategoryDetails()
	{
		ModelAndView mvObj = new ModelAndView("admin");
				mvObj.addObject("title","Article Category Details");
				List<ArticleCategory> articleCategories = articleCategoryService.findAll();
				mvObj.addObject("articleCategoryList",articleCategories);
				mvObj.addObject("showArticleCategoriesDetails",true);
				return mvObj;
	}
	
	@RequestMapping(value= "/role")
	public ModelAndView roleDetails()
	{
		        ModelAndView mvObj = new ModelAndView("admin");
				mvObj.addObject("title","Role Details");
				List<Role> roles = roleService.findAll();
				mvObj.addObject("roleList",roles);
				mvObj.addObject("showRoleDetails",true);
				return mvObj;
				
				//return mvObj;
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

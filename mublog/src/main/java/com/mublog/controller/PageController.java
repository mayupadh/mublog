package com.mublog.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class PageController {

	@RequestMapping(value={"/","/home","/index"})
	public ModelAndView index()
	{
		ModelAndView mvObj = new ModelAndView("index");
				mvObj.addObject("title","Home");
				mvObj.addObject("userClickHome",true);
				return mvObj;
	}
	
	@RequestMapping(value = "/about" )
	public ModelAndView about()
	{
		ModelAndView mvObj = new ModelAndView("index");
				mvObj.addObject("title","About");
				mvObj.addObject("userClickAboutUs",true);
				return mvObj;
	}
	
	@RequestMapping(value = "/contactus" )
	public ModelAndView contactus()
	{
		ModelAndView mvObj = new ModelAndView("index");
				mvObj.addObject("title","Contact");
				mvObj.addObject("userClickContactUs",true);
				return mvObj;
	}
	
	@RequestMapping(value= "/myblogs" )
	public ModelAndView blogs()
	{
		ModelAndView mvObj = new ModelAndView("index");
				mvObj.addObject("title","Blogs");
				mvObj.addObject("userClickBlogHome",true);
				return mvObj;
	}
	
	@RequestMapping(value= "/admin" )
	public ModelAndView admin()
	{
		ModelAndView mvObj = new ModelAndView("admin");
				mvObj.addObject("title","Admin");
				mvObj.addObject("userClickAdminHome",true);
				return mvObj;
	}
	
	
}

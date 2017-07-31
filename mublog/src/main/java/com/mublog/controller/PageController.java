package com.mublog.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller("/mublog")
public class PageController {

	@RequestMapping(value={"/","/home","/index"})
	public ModelAndView index()
	{
		ModelAndView mvObj = new ModelAndView("index");
				mvObj.addObject("msg","Welcome to Blog index Page");
				return mvObj;
	}
}

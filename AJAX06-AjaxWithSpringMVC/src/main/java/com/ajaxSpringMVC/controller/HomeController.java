package com.ajaxSpringMVC.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HomeController 
{
	@RequestMapping("/")
	public String start()
	{
		return "start";
	}
	
	/*@RequestMapping("/responseName")
	@ResponseBody
	public String responseName(HttpServletRequest req)
	{
		String name = req.getParameter("name");
		return "Hello "+name;
		
	}*/
	
	@RequestMapping("/responseName")
	@ResponseBody
	public String responseName(@RequestParam("name") String n)
	{
		String name = n;
		return "Hello "+name;
		
	}
		
}

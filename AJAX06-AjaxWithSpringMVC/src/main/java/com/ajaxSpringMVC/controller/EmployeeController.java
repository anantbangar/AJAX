package com.ajaxSpringMVC.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ajaxSpringMVC.model.EmployeeModel;
import com.ajaxSpringMVC.service.EmployeeService;

@Controller
public class EmployeeController 
{
	@Autowired
	private EmployeeService employeeService;
	
	@RequestMapping("/getAllEmp")
	public String getAllEmp(Model model)
	{
		List<EmployeeModel> allEmp = employeeService.getAllEmp();
		model.addAttribute("allEmp", allEmp);
		return "showEmp";
		
	}
	
	@RequestMapping("/chkEmailAvail")
	@ResponseBody
	public String chkEmailAvail(@RequestParam String email)
	{		
		String emailStr = employeeService.chkEmailAvail(email);
		return emailStr;
	}

}

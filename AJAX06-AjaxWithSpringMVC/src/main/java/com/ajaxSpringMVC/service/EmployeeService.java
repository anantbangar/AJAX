package com.ajaxSpringMVC.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ajaxSpringMVC.dao.EmployeeDao;
import com.ajaxSpringMVC.model.EmployeeModel;

@Service
public class EmployeeService
{
	@Autowired
	private EmployeeDao employeeDao;
	
	public List<EmployeeModel> getAllEmp()
	{
		List<EmployeeModel> empList=employeeDao.getAllEmp();
		return empList;
	}
	
	public String chkEmailAvail(String email)
	{
		String emailStr = employeeDao.chkEmailAvail(email);
		return emailStr;
	}

}

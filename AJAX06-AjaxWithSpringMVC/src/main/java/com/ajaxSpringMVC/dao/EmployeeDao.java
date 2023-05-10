package com.ajaxSpringMVC.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;

import com.ajaxSpringMVC.model.EmployeeModel;

@Repository
public class EmployeeDao 
{
	@Autowired
	private HibernateTemplate hibernateTemplate;
	
	public List<EmployeeModel> getAllEmp()
	{
		List<EmployeeModel> empList = hibernateTemplate.loadAll(EmployeeModel.class);
		return empList;
	}
	
	public String chkEmailAvail(String email)
	{
		Session session = hibernateTemplate.getSessionFactory().openSession();
		Criteria c=session.createCriteria(EmployeeModel.class);
		c.add(Restrictions.eq("email",email));
		List<EmployeeModel> eList = c.list();
		System.out.println(eList.toString());
		
		return (eList.isEmpty()) ? "Unique" : "Duplicate";
		
	}

}

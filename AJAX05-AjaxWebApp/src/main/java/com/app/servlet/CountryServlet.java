package com.app.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.app.dao.AjaxDao;
import com.app.model.CountryModel;
import com.app.util.HibernateUtil;
import com.google.gson.Gson;

@WebServlet("/countryServlet")
public class CountryServlet extends HttpServlet
{
	protected void doGet(HttpServletRequest req,HttpServletResponse res) throws ServletException,IOException
	{
		processRequest(req,res);
	}
	
	protected void doPost(HttpServletRequest req,HttpServletResponse res) throws ServletException,IOException
	{
		processRequest(req,res);
	}
	
	public void processRequest(HttpServletRequest req,HttpServletResponse res) throws ServletException,IOException
	{
		System.out.println("....Enter CountryServlet....");
		
		res.setContentType("text/html");
		PrintWriter out=res.getWriter();
		
		AjaxDao ajaxDao=new AjaxDao();
		
		Map<Integer, String> countryMap = ajaxDao.getCountryMap();
		
		Gson gson=new Gson();
		
		String countriesStr = gson.toJson(countryMap);
		
		res.getWriter().write(countriesStr);
		
		System.out.println("....Exit CountryServlet....");

	}
}

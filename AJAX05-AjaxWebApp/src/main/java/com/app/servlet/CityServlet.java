package com.app.servlet;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.app.dao.AjaxDao;
import com.google.gson.Gson;

@WebServlet("/cityServlet")
public class CityServlet extends HttpServlet 
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
		System.out.println("....Enter CityServlet....");

		res.setContentType("text/html");
		
		String stateId=req.getParameter("stateId");
		
		AjaxDao ajaxDao=new AjaxDao();
		
		Map<Integer,String> cityMap=new HashMap<Integer, String>();
		
		cityMap=ajaxDao.getCityMap(Integer.parseInt(stateId));
		
		Gson gson=new Gson();
		
		String cityStr=gson.toJson(cityMap);
		
		res.getWriter().write(cityStr);
		
		System.out.println("....Exit CityServlet....");
	}

}

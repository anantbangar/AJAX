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

@WebServlet("/stateServlet")
public class StateServlet extends HttpServlet
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
		System.out.println("....Enter StateServlet....");
		
		res.setContentType("text/html");
		
		int countryId=Integer.parseInt(req.getParameter("countryId"));
		
		Map<Integer,String> stateMap=new HashMap<Integer, String>();
		
		AjaxDao ajaxDao=new AjaxDao();
		
		stateMap=ajaxDao.getStateMap(countryId);
		
		Gson gson=new Gson();
		
		String stateStr=gson.toJson(stateMap);
				
		res.getWriter().write(stateStr);
		
		System.out.println("....Exit StateServlet....");

	}
}

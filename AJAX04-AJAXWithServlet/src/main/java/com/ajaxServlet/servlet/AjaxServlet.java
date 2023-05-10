package com.ajaxServlet.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/ajaxServlet")
public class AjaxServlet extends HttpServlet
{
	public void doGet(HttpServletRequest req,HttpServletResponse res) throws ServletException,IOException
	{
		String name=req.getParameter("name");
		PrintWriter out=res.getWriter();
		
		if(name!=null && !"".equals(name))
		{
			String msg="Hello, "+name;
			res.setContentType("text/html");
			out.write(msg);
		}
		
	}

}

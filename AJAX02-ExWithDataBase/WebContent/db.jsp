<%@page import="com.mysql.cj.protocol.Resultset"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="java.sql.*" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<%
		String id=request.getParameter("id");
		if(id==null || id.trim().equals(""))
		{
			out.print("Please enter the id ");
		}
		else
		{
			int empId=Integer.parseInt(id);
			Connection con=null;
			try
			{
				Class.forName("com.mysql.jdbc.Driver");
				
				con=DriverManager.getConnection("jdbc:mysql://localhost:3306/ajax","root","system123");
				
				//out.print("Connected to DB");
				
				/*
				Statement stmt=con.createStatement();
				ResultSet rs=stmt.executeQuery("select * from emp");
				while(rs.next())
				{
					out.print(rs.getInt(1)+" "+rs.getString(2)+" "+rs.getString(3)+" "+rs.getString(4));
					out.println("<br>");
				}
				*/
				
				PreparedStatement pstmt=con.prepareStatement("select * from emp where id=?");
				pstmt.setInt(1,empId);
				ResultSet rs=pstmt.executeQuery();
				if(!rs.isBeforeFirst())
				{
					out.print("no record found");
				}
				else
				{
					while(rs.next())
					{
						out.print(rs.getInt(1)+" "+rs.getString(2)+" "+rs.getString(3)+" "+rs.getString(4));
						out.println("<br>");
					}
				}
				
				
			}
			catch(Exception exception)
			{
				exception.printStackTrace();
			}
			finally
			{
				con.close();
			}
		}
	%>
</body>
</html>
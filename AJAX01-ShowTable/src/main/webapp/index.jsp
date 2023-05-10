<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>anant</title>
</head>
<body>
	<%
		int n=Integer.parseInt(request.getParameter("val"));
		
		out.print("<h3>The Table of "+n+"</h3>");
		
		for(int i=1;i<=10;i++)
		{
			int result=n*i;
			out.print(result+" ");
		}
	%>
</body>
</html>
<%@page import="com.ajaxSpringMVC.model.EmployeeModel"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page isELIgnored="false" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	
	<%
		//printing emp list using getAttribute 
		/* List<EmployeeModel> empList=(List<EmployeeModel>)request.getAttribute("allEmp");
		for(EmployeeModel e : empList)
		{
			out.print(e.getId()+" "+e.getName()+" "+e.getEmail()+" "+e.getAddress());
			out.print("<br>");
		} */
	%>
	
	<!-- printing emp list using forEach of jstl-->	
	<table>
		<tr>
			<th>Id</th>
			<th>Name</th>
			<th>Email</th>
			<th>Address</th>
		</tr>
		<c:forEach items="${allEmp }" var="emp">
			<tr>
				<td>${emp.id }</td>
				<td>${emp.name }</td>
				<td>${emp.email }</td>
				<td>${emp.address }</td>
			</tr>
		</c:forEach>
	</table>
</body>
</html>
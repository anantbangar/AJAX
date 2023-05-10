<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>

<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>

<script src="./js/app.js"></script>

</head>
<body>
	<h2>AJAX with Jquery,Servlet,Jsp,Hibernate</h2>
	
	<h3>Country-State-City Loading with AJAX</h3>
	
	<table>
		<tr>
			<td><b>Select Country</b></td>
			<td>
				<select id="country">
					<option value="">---select country---</option>
				</select>
			</td>
		</tr>
		<tr>
			<td><b>Select State</b></td>
			<td>
				<select id="state">
					<option value="">---select state---</option>
				</select>
			</td>
		</tr>
		<tr>
			<td><b>Select City</b></td>
			<td>
				<select id="city">
					<option value="">---select city---</option>
				</select>
			</td>
		</tr>
		
	</table>

</body>
</html>
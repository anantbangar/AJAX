<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>

<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>

<script type="text/javascript">
	$(document).ready(function(){
		
		$("#name").keyup(function(){
			
			var name=$("#name").val();
			
			$.ajax({
				url : "responseName",
				data : {
					name : name
				},
				success : function(result){
					$("#responseNameDiv").html(result);
				}
			});
		});
		
		$("#showEmpDbBtn").click(function(){
									
			$.ajax({
				url : "getAllEmp",
				success : function(result){
					$("#responseEmpDbDiv").html(result);
				}
			});
		});
		
		$("#chkEmailAvailBtn").click(function(){
			
			var email=$("#email").val();
			
			$.ajax({
				url : "chkEmailAvail",
				data : {
					email : email
				},
				success : function(result){
					if(result=="Duplicate")
					{
						$("#chkEmailAvailMsg").css("color","red");
						$("#chkEmailAvailMsg").html("Email is already Resisterd...");
						$("#submitBtn").prop("disabled",true);
						$("#email").focus();

					}
					else
					{
						$("#chkEmailAvailMsg").css("color","green");
						$("#chkEmailAvailMsg").html("This email is available");	
						$("#submitBtn").prop("disabled",false);

					}
					
				}
			});
		});
	});
</script>

</head>
<body>
	<h2>this is start page</h2>
	<h3>Ajax using Spring MVC</h3>
	
	<input type="text" name="name" id="name" placeholder="enter your name" />&nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp
	
	<input type="button" name="showEmpDbBtn" id="showEmpDbBtn" value="Show Empm DB"/><br>
	
	<label>Response from server for name</label>&nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp
	
	<label>Response from server for Emp Db</label><br>
	
	<div id="responseNameDiv"></div>
		
	<div id="responseEmpDbDiv"></div>
	
	<br><br>
	<input type="email" name="email" id="email" placeholder="enter your email" />
	<input type="button" name="chkEmailAvailBtn" id="chkEmailAvailBtn" value="Check Email Availability"/>
	<span id="chkEmailAvailMsg"></span><br>
	<input type="button" name="submit" id="submitBtn" value="Submit"/>
	
	
	
</body>
</html>
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
			
			var enteredName=$("#name").val();
			
			$.ajax({
				
				type : "GET",
				url : "ajaxServlet",
				
				data : {
					name : enteredName
				},
				
				success : function(responseText){
					
					$("#div1").empty();
					$("#div1").append(responseText);
				}
				
			});
		});
	});
</script>

</head>
<body>
	<h1>AJAX using Servlet</h1>
	
	<form>
		Enter name <input type="text" name="name" id="name" placeholder="enter your name"/><br>
		<div id="div1"></div>
	</form>
</body>
</html>
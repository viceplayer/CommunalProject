<%@page import="Manager.DatabaseRelation"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.2/jquery.min.js"></script>
<script src="scripts.js"></script> 
<link rel="stylesheet" type="text/css" href="css/style.css">


<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Home</title>
</head>
<body>
	<div class = "header">
		<div class = "name">
			
		</div>
		
		<div class = nav>
			<ul>
			<li><a href="http://localhost:8080/CommunalProject/LogOutServlet">Logout</a></li>
			<li><a href="#">Transactions</a></li>
				<li><a href="http://localhost:8080/CommunalProject/AccountPanel.jsp">Panel</a></li>
				<li><a href="#" class="active">Home</a></li>
				<li class="title"><a class="title">Communal Project</a></li>
				
			</ul>
			
			
		</div>
	</div>
	<div class=folderManager>
		<ul class=data>
			<div class=ticket>
			<div>
				<div class=title1>ქვითრის ნომერი:</div>
				<div class = number>123456</div>
				<div class = title2>გადახდის ვადა</div>
				</div>
				<div>
				<div class = title1>მომხმარებელი:</div>
				<div class = number>წიკლაური</div>
				<div class = dedaline>12/01/16</div>
				</div>
				<div>
				
				<div class = title1>წყალმომარაგების დავალიანება:</div>
				<div class = number>30.00</div>
				<button class = pay>ადახდა</button>
				</div>
				
				
			</div>
		</ul>
	</div>



</body>
</html>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Login Page</title>
</head>
<body>
	<h1>Please log in</h1>

	<form action="LoginServlet" method="post">
		PersonalId:<br> <input type="text" name="personalId"><br>
		Password:<br> <input type="text" name="password"> <br>
		<input type="submit" value="Submit"> <br> 
		<a href="http://localhost:8080/CommunalProject/Registration.jsp">Register</a>
		<br>
		<a href="http://localhost:8080/CommunalProject/ForgetPassword.jsp">Forget Password</a>
	</form>
</body>
</html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" type="text/css" href="css/Form.css">
<title>Login Page</title>
</head>
<body>

	<form action="LoginServlet" method="post">
		<h5>
			<%
				String loginError = (String) request.getParameter("error");
				if (loginError != null)
					out.println("<font color=red size=4px>" + loginError + "</font>");
			%>
		</h5>
		PersonalId:<br> <input type="text" name="personalId"><br>
		Password:<br> <input type="password" name="password"> <br>
		<input type="submit" value="Submit"> <br>
		<div class="blobs">
			<a href="http://localhost:8080/CommunalProject/Registration.jsp" class="blob">Register</a>
			<a href="http://localhost:8080/CommunalProject/ForgetPassword.jsp" class="blob">Forgot Password</a>
		</div>
		
	</form>
</body>
</html>
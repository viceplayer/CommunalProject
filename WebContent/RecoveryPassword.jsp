<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" type="text/css" href="css/Form.css">
<title>Recovery Password</title>
</head>
<body>
	<form action="RecoveryPasswordServlet" method="post">
		<h5>Your new password to sent mail:</h5>
		<h5>
			<%
				String mail = (String) request.getAttribute("mail");
				if (mail != null)
					out.println("<font color=Green size=4px>" + mail + "</font>");
			%>
		</h5>
		<h5>Go end check you mail!</h5>
		<input type="submit" value="Login"> <br>
	</form>


</body>
</html>
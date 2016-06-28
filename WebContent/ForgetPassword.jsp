<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" type="text/css" href="css/Form.css">
<title>Recover password</title>
</head>
<body>

	<form action="ForgetPasswordServlet" method="post">
		<h5>
			<%
				String error = (String) request.getAttribute("error");
				if (error != null)
					out.println("<font color=red size=4px>" + error + "</font>");
			%>
		</h5>
		<h5>Enter Your ID:</h5>
		User ID:<br> <input type="text" name="User Id"> <br>
		<input type="submit" value="Submit"> <br>
	</form>

</body>
</html>
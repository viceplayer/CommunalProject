<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" type="text/css" href="css/Form.css">
<title>Registration</title>
</head>
<body>
	<form action="RegistrationServlet" method="post">
		PersonalId:<br> <input type="text" name="personalId"><br>
		First name:<br> <input type="text" name="firstName"><br>
		Last name:<br> <input type="text" name="lastName"><br>
		Password:<br> <input type="Password" name="password"><br>
		E-mail:<br> <input type="email" name="mail"><br>
		Birth Date:<br> <input type="text" name="date"><br>
		Mobile:<br> <input type="text" name="mobile"><br>
		<input type="submit" value="Submit">
	</form>

</body>
</html>
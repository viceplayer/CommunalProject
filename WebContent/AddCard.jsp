<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" type="text/css" href="css/Form.css">
<title>Add your card</title>
</head>
<body>
	<form action="AddCardServlet" method="post">
		Card Number:<br> <input type="text" name="cardNumber"><br>
		Expiration Date:<br> <input type="text" name="date"><br>
		firstname:<br> <input type="text" name="firstName"><br>
		lastname:<br> <input type="Password" name="lastName"><br>

	</form>

</body>
</html>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<form action="AddServlet" method="post">
		Name:<br> <input type="text" name="objectName"><br>
		<select name="type">
		  <option value="0">Home</option>
		  <option value="1">Car</option>
		  <option value="2">Other</option>
		</select>
		<input type="submit" value="Submit">
	</form>
</body>
</html>
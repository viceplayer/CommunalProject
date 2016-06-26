<%@page import="Manager.DatabaseRelation"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

	<form action="AccountUpdateServlet" method="post">
	<h5> Name : <%out.write(DatabaseRelation.getUserData((int)session.getAttribute("userId"), "firstName"));%> <br>
	Change: <input type="text" name="newName"> </h5>
	<h5>Last name : <%out.write(DatabaseRelation.getUserData((int)session.getAttribute("userId"), "lastName"));%> 
	Change: <input type="text" name="newLastName"> </h5>
	<h5>Personal Id : <%out.write(DatabaseRelation.getUserData((int)session.getAttribute("userId"), "personalId"));%> 
	Change: <input type="text" name="newPersonalId"> </h5>
	<h5>Mail : <%out.write(DatabaseRelation.getUserData((int)session.getAttribute("userId"), "mail"));%> 
	Change: <input type="mail" name="newMail"> </h5>
	<h5>Mobile : <%out.write(DatabaseRelation.getUserData((int)session.getAttribute("userId"), "mobile"));%> 
	Change: <input type="text" name="newMobile"> </h5>
		Old password:<br> <input type="text" name="oldPassword"> <br>
		New password:<br> <input type="text" name="newPassword"> <br>
		<input type="submit" value="Submit"> <br> 
	</form>

	
	
</body>
</html>
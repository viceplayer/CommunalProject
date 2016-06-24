<%@page import="Manager.DatabaseRelation"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Home</title>
</head>
<body>
	<h1>Home Page</h1>
	<h4>
		<%
			for (int i = 0; i < DatabaseRelation
					.getObjects(DatabaseRelation.getUserId(request.getParameter("personalId"))).size(); i++) {
		%>
		<a href="http://localhost:8080/CommunalProject/Folder.jsp"> <%=DatabaseRelation.getObjects(DatabaseRelation.getUserId(request.getParameter("personalId")))
						.get(i).getName()%></a> 

		<%
			}
		%>
		<a href="http://localhost:8080/CommunalProject/Other.jsp">Other</a> <a
			href="http://localhost:8080/CommunalProject/Add.jsp">Add</a>
	</h4>



</body>
</html>
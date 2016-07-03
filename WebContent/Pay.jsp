<%@page import="Manager.DatabaseRelation"%>
<%@ page language="java" contentType="text/html; charset=utf8"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf8">
<link rel="stylesheet" type="text/css" href="css/Form.css">
<title>Pay</title>
</head>
<body>
	<form action="PayServlet" method="post">
		<input type="hidden" name="id" value=<%=request.getParameter("id")%> />
		Choose Card: <select name="cardId">
			<%
		for (int i = 0; i < DatabaseRelation.getCards((int)session.getAttribute("userId")).size(); i++) {
		%>
		<option value="i"><%(DatabaseRelation.getCards((int)session.getAttribute("userId"))).get(i).getCardNumber(); %> </option>
		<%
			}
		%>
		</select> 
		 Amount: <input type="number" name="amount" min="1" max="1000"> <br>
		 <input type="submit" value="Submit"> <br>
	</form>

</body>
</html>
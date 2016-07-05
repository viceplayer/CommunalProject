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
	<form action="PayServlet" method="post" style = "margin-top:10px;">
		<input type="hidden" name="companyId" value=<%=request.getParameter("companyId")%> />
		Choose Card: <select name="cardId">
			<% for (int i = 0; i < DatabaseRelation.getCards((int)session.getAttribute("userId")).size(); i++) {
			String card = DatabaseRelation.getCards((int)session.getAttribute("userId")).get(i).getCardNumber();
			out.write("<option value =");
			out.write(card);
			out.write(">");
			out.write(card);
			out.write("</option>");
			
			}%>
		</select> 
		 Amount: <input type="text" name="amount"> <br>
		 CVC: <input type="text" name="CVC"><br>
		 <input type="submit" value="Pay"> <br>
	</form>

</body>
</html>
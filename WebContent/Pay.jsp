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
		<%
			String success = (String) request.getParameter("success");
			if (success != null)
				out.println("<font color=green size=3px>" + success + "</font>");
		%>
		<br><%
			String cardNum = (String) request.getParameter("cardNum");
			if (cardNum != null)
				out.println("<font color=red size=3px>" + cardNum + "</font>");
		%>
		<br>Choose Card: <select name="cardId">
			<% for (int i = 0; i < DatabaseRelation.getCards((int)session.getAttribute("userId")).size(); i++) {
			String card = DatabaseRelation.getCards((int)session.getAttribute("userId")).get(i).getCardNumber();
			out.write("<option value =");
			out.write(card);
			out.write(">");
			out.write(card);
			out.write("</option>");
			
			}%>
		</select> 
		<br><%
			String amountError = (String) request.getParameter("amount");
			if (amountError != null)
				out.println("<font color=red size=3px>" + amountError + "</font>");
		%>
		 <br>Amount: <input type="text" name="amount"> 
		 <br><%
			String cvcError = (String) request.getParameter("cvc");
			if (cvcError != null)
				out.println("<font color=red size=3px>" + cvcError + "</font>");
		%>
		 <br>CVC: <input type="text" name="CVC"><br>
		 <input type="submit" value="Pay"> <br>
	</form>

</body>
</html>
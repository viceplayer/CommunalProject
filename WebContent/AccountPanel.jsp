<%@page import="Manager.DatabaseRelation"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" type="text/css" href="css/Form.css">
<link rel="stylesheet" type="text/css" href="css/style.css">
<title>Account Control Panel</title>
</head>
<body>
	<div class="header">
		<div class="name"></div>

		<div class=nav>
			<ul>
				<li><a
					href="http://localhost:8080/CommunalProject/LogOutServlet">Logout</a></li>
				<li><a href="#">Transactions</a></li>
				<li><a href="#" class="active">Panel</a></li>
				<li><a href="http://localhost:8080/CommunalProject/Home.jsp">Home</a></li>
				<li class="title"><a class="title">Communal Project</a></li>

			</ul>


		</div>
	</div>

	<form action="AccountUpdateServlet" method="post"
		style="margin-top: 50px;">
		<h5>
			First Name :
			<%
			out.write(DatabaseRelation.getUserData((int) session.getAttribute("userId"), "firstName"));
		%>
			<br> <br>
			<%
				String firstNameError = (String) request.getParameter("firstName");
				if (firstNameError != null)
					out.println("<font color=red size=3px>" + firstNameError + "</font>");
			%>
			<br>Change: <input type="text" name="newName">
		</h5>
		<h5>
			Last name :
			<%
			out.write(DatabaseRelation.getUserData((int) session.getAttribute("userId"), "lastName"));
		%>
			<br> <br>
			<%
				String lastNameError = (String) request.getParameter("lastName");
				if (lastNameError != null)
					out.println("<font color=red size=3px>" + lastNameError + "</font>");
			%>
			<br>Change: <input type="text" name="newLastName">
		</h5>
		<h5>
			Mail :
			<%
			out.write(DatabaseRelation.getUserData((int) session.getAttribute("userId"), "mail"));
		%>
			<br> <br>
			<%
				String mailError = (String) request.getParameter("mail");
				if (mailError != null)
					out.println("<font color=red size=3px>" + mailError + "</font>");
			%>
			<br>Change: <input type="text" name="newMail">
		</h5>
		<h5>
			Mobile :
			<%
			out.write(DatabaseRelation.getUserData((int) session.getAttribute("userId"), "mobile"));
		%>
			<br> <br>
			<%
				String mobileError = (String) request.getParameter("mobile");
				if (mobileError != null)
					out.println("<font color=red size=3px>" + mobileError + "</font>");
			%>
			<br>Change: <input type="text" name="newMobile">
		</h5>
		<h5>Change Password:</h5>
		Old password: <br>
		<%
			String oldPasswordError = (String) request.getParameter("oldPassword");
			if (oldPasswordError != null)
				out.println("<font color=red size=3px>" + oldPasswordError + "</font>");
		%>
		<br> <input type="text" name="oldPassword"> <br> New
		password: <br>
		<%
			String newPasswordError = (String) request.getParameter("newPassword");
			if (newPasswordError != null)
				out.println("<font color=red size=3px>" + newPasswordError + "</font>");
		%>
		<br> <input type="text" name="newPassword"> <br> <input
			type="submit" value="Submit"> <br>
	</form>



</body>
</html>
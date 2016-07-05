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
	<div style = "width:50%;float:left;">
	<form action="AccountUpdateServlet" method="post"
		style="margin-top: 50px;">
		<h5>
			First Name :
			<%
			out.write(DatabaseRelation.getUserData((int) session.getAttribute("userId"), "firstName"));
			%>
			<br><%
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
		<br><%
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
			<br><%
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
			<br><%
				String mobileError = (String) request.getParameter("mobile");
				if (mobileError != null)
					out.println("<font color=red size=3px>" + mobileError + "</font>");
			%>
			<br>Change: <input type="text" name="newMobile">
		</h5>
		<h5>Change Password:</h5>
		<%
			String match = (String) request.getParameter("match");
			if (match != null)
				out.println("<font color=red size=3px>" + match + "</font>");
		%>
		<br>Old password:
		<br><%
			String oldPasswordError = (String) request.getParameter("oldPassword");
			if (oldPasswordError != null)
				out.println("<font color=red size=3px>" + oldPasswordError + "</font>");
		%>
		<br> <input type="password" name="oldPassword"> <br> New
		password:
		<br><%
			String newPasswordError = (String) request.getParameter("newPassword");
			if (newPasswordError != null)
				out.println("<font color=red size=3px>" + newPasswordError + "</font>");
		%>
		<br> <input type="password" name="newPassword"> <br> 
				
		
		<input type="submit" value="Submit"> <br>
		
	</form>
	</div>
	<div style = "width:50%;float:right">
	<form action="AddCardServlet" method="post"
		style="margin-top: 50px;">
		<%
			String cardError = (String) request.getParameter("cardError");
			if (cardError != null)
				out.println("<font color=red size=3px>" + cardError + "</font>");
		%>
		<br><%
			String cardAdd = (String) request.getParameter("cardAdd");
			if (cardAdd != null)
				out.println("<font color=green size=3px>" + cardAdd + "</font>");
		%>
		<br>First Name:
		<br><%
			String cardFirstNameError = (String) request.getParameter("cardFirstName");
			if (cardFirstNameError != null)
				out.println("<font color=red size=3px>" + cardFirstNameError + "</font>");
		%>
		<input type="text" name="firstName" >
		Last Name:
		<br><%
			String cardLastNameError = (String) request.getParameter("cardLastName");
			if (cardLastNameError != null)
				out.println("<font color=red size=3px>" + cardLastNameError + "</font>");
		%>
		<input type="text" name="lastName">
		Card Name:
		<br><%
			String cardNameError = (String) request.getParameter("cardName");
			if (cardNameError != null)
				out.println("<font color=red size=3px>" + cardNameError + "</font>");
		%>
		<input type="text" name="cardNumber">
		Expire Date:<select name="month">
                
                <option value="01">Jan (01)</option>
                <option value="02">Feb (02)</option>
                <option value="03">Mar (03)</option>
                <option value="04">Apr (04)</option>
                <option value="05">May (05)</option>
                <option value="06">June (06)</option>
                <option value="07">July (07)</option>
                <option value="08">Aug (08)</option>
                <option value="09">Sep (09)</option>
                <option value="10">Oct (10)</option>
                <option value="11">Nov (11)</option>
                <option value="12">Dec (12)</option>
              </select>
              <select name="year">
                <option value="16">2016</option>
                <option value="17">2017</option>
                <option value="18">2018</option>
                <option value="19">2019</option>
                <option value="20">2020</option>
                <option value="21">2021</option>
                <option value="22">2022</option>
                <option value="23">2023</option>
                <option value="19">2024</option>
                <option value="20">2025</option>
                <option value="21">2026</option>
                <option value="22">2027</option>
                <option value="23">2028</option>
              </select>
              <input type="submit" value="Add Card"> <br>
	</form>
	<form action="DeleteCardServlet" method="post"
		style="margin-top: 50px;">
		<br><%
			String delete = (String) request.getParameter("delete");
			if (delete != null)
				out.println("<font color=green size=3px>" + delete + "</font>");
		%>
		<br>Card:
		<select name=card>
		<% for (int i = 0; i < DatabaseRelation.getCards((int)session.getAttribute("userId")).size(); i++) {
			String card = DatabaseRelation.getCards((int)session.getAttribute("userId")).get(i).getCardNumber();
			out.write("<option value =");
			out.write(card);
			out.write(">");
			out.write(card);
			out.write("</option>");
			
			}%>
		</select>
		<input type="submit" value="Delete Card"> <br>
		</form>
	</div>



</body>
</html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" type="text/css" href="css/Form.css">
<title>Registration</title>
</head>
<body>
	<form action="RegistrationServlet" method="post">
	AccountAlreadyExists
			<h5>
			<%
				String AccountAlreadyExists = (String) request.getParameter("AccountAlreadyExists");
				if (AccountAlreadyExists != null)
					out.println("<font color=red size=3px>" + AccountAlreadyExists + "</font>");
			%>
		</h5>
	
		PersonalId:
		<h5>
			<%
				String personalIdError = (String) request.getParameter("personalId");
				if (personalIdError != null)
					out.println("<font color=red size=3px>" + personalIdError + "</font>");
			%>
		</h5>
		<br> <input type="text" name="personalId"> <br>
		First name:
		<h5>
			<%
				String firstNameError = (String) request.getParameter("firstName");
				if (firstNameError != null)
					out.println("<font color=red size=3px>" + firstNameError + "</font>");
			%>
		</h5>
		<br> <input type="text" name="firstName"><br>
		Last name:
		<h5>
			<%
				String lastNameError = (String) request.getParameter("lastName");
				if (lastNameError != null)
					out.println("<font color=red size=3px>" + lastNameError + "</font>");
			%>
		</h5>
		<br> <input type="text" name="lastName"><br>
		Password:
		<h5>
			<%
				String passwordError = (String) request.getParameter("password");
				if (passwordError != null)
					out.println("<font color=red size=3px>" + passwordError + "</font>");
			%>
		</h5>
		<br> <input type="Password" name="password"><br>
		E-mail:
		<h5>
			<%
				String mailError = (String) request.getParameter("mail");
				if (mailError != null)
					out.println("<font color=red size=3px>" + mailError + "</font>");
			%>
		</h5>
		<br> <input type="text" name="mail"><br>
		Birth Date:
		<% 
				String birthDateError = (String) request.getParameter("birthDate");
				if (birthDateError != null)
					out.println("<font color=red size=3px>" + birthDateError + "</font>");
			%>

		<br> <input type="text" name="date"><br>		
		Mobile:
		<h5>
			<% 
				String mobileError = (String) request.getParameter("mobile");
				if (mobileError != null)
					out.println("<font color=red size=3px>" + mobileError + "</font>");
			%>
		</h5>
		<br> <input type="text" name="mobile"><br>
		<input type="submit" value="Submit">
	</form>

</body>
</html>
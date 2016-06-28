<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" type="text/css" href="css/Form.css">

<title>Add Ticket</title>
</head>
<body>
	<form action="AddTicketServlet" method="post">
	<input type="hidden" name="id" value=<%= request.getParameter("id") %> />
		Company:
		<select name="companyId">
			<option value="0">Telasi</option>
			<option value="1">GWP</option>
			<option value="2">Junk</option>
		</select> <input type="submit" value="Submit"><br>
		Ticket Number:<br> <input type="text" name="ticketNumber">
		
	</form>

</body>
</html>
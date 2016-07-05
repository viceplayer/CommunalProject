<%@page import="Manager.DatabaseRelation"%>
<%@page import="Manager.Transaction"%>
<%@page import="java.util.ArrayList" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.2/jquery.min.js"></script>
<script src="scripts.js"></script> 
<link rel="stylesheet" type="text/css" href="css/style.css">


<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Home</title>
</head>
<body>
	<div class = "header">
		<div class = "name">
			
		</div>
		
		<div class = nav>
			<ul>
			<li><a href="http://localhost:8080/CommunalProject/LogOutServlet">Logout</a></li>
			<li><a href="#" class="active">Transactions</a></li>
				<li><a href="http://localhost:8080/CommunalProject/AccountPanel.jsp">Panel</a></li>
				<li><a href="http://localhost:8080/CommunalProject/Home.jsp" >Home</a></li>
				<li class="title"><a class="title">Communal Project</a></li>
				
			</ul>
			
			
		</div>
	</div>
	<table width="59%" border="1">
	<thead>
  <tr>
     <th>#</th>
     <th>Company</th>
     <th>Amount</th>
     <th>Date</th>
  </tr>
 </thead>
    <%
    	int userId = (int)session.getAttribute("userId");
    	ArrayList<Transaction> list = DatabaseRelation.getTransactions(userId);
    	
        for(int i = 0; i<list.size();i++){
        	Transaction trans = list.get(i);
        	out.write("<tr>");
        	out.write("<td>");
        	out.write(""+(i+1));
        	out.write("</td>");
        	out.write("<td>");
        	out.write(trans.getName());
        	out.write("</td>");
        	out.write("<td>");
        	out.write(""+trans.getAmount());
        	out.write("</td>");
        	out.write("<td>");
        	out.write(trans.getDate());
        	out.write("</td>");
        	out.write("</tr>");
        }
        
        	%>
          
                   
                   
</table>



</body>
</html>
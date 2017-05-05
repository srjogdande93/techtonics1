<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Statement"%>
<%@page import="java.sql.Connection"%>


<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>UpdateEvent</title>
</head>
<body>

<%

Class.forName("com.mysql.jdbc.Driver");
Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/techtalk","root","root");
Statement stmt = con.createStatement();

String eventid = request.getParameter("update");

int id = eventid.charAt(6);

session.setAttribute("eventid",id);
ResultSet rs = stmt.executeQuery("select * from events where eventid='"+id+"'");

if(rs.next())
{%>
	
	<form  action="UpdateTechTalk" method="post" autocomplete="on"> 
	 <h1>Update Events</h1> 
     <p> 
         <label for="username" class="uname"> Date </label>
         <input id="fname" name="edate" required="required" type="text" value=<%=rs.getString(2) %>/>
     </p>
     <p> 
         <label for="password" class="youpasswd"> Title </label>
         <input id="fpass" name="title" required="required" type="text" value=<%=rs.getString(3) %> /> 
     </p>
      <p> 
         <label for="password" class="youpasswd"> Description </label>
         <input id="fpass" name="desc" required="required" type="text" value=<%=rs.getString(4) %> /> 
     </p>
      <p> 
         <label for="password" class="youpasswd"> Presenter </label>
         <input id="fpass" name="pres" required="required" type="text" value=<%=rs.getString(5) %> /> 
     </p>
     
     
     <p class="login button"> 
         <input type="submit" value="Add" /> 
		</p>
	</form>
	
	
	<%}
%>
</body>
</html>

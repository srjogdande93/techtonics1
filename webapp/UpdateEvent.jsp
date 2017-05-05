<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@page import="pojos.EventPojo"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Update TechTalk Events</title>
<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Sign Up Form</title>
<link rel="stylesheet" href="css/normalize.css">
<link href='http://fonts.googleapis.com/css?family=Nunito:400,300'
	rel='stylesheet' type='text/css'>
<link rel="stylesheet" href="css/main.css">
</head>

</head>
<body>
	<form action="UpdateTechTalk" method="post">

		<h1>Update TechTalk</h1>

		<%
			EventPojo evpo = new EventPojo();

			evpo = (EventPojo) session.getAttribute("dataObject");
		%>


		<label for="eventid">Eventid</label> <input type="text" id="eventid"
			name="eventid" value="<%=evpo.getEventid()%>"> <label
			for="date">Date</label> <input type="text" id="date" name="date"
			value="<%=evpo.getDate()%>"> <label for="time">Time:</label>
		<input type="text" id="time" name="time" value="<%=evpo.getTime()%>">

		<label for="presenter">Presenter:</label> <input type="text"
			id="presenter" name="presenter" value="<%=evpo.getPresenter()%>">

		<label for="description">Description:</label>AS <input type="text"
			id="description" name="Description"
			value="<%=evpo.getDescription()%>"> <label for="title">Title:</label>
		<input type="text" id="title" name="title"
			value="<%=evpo.getTitle()%>">


		<button type="submit">Update TechTalk</button>
	</form>
</body>
</html>
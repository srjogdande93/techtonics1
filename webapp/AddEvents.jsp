<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Add TechTalk Events</title>

<head>
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>Sign Up Form</title>
        <link rel="stylesheet" href="css/normalize.css">
        <link href='http://fonts.googleapis.com/css?family=Nunito:400,300' rel='stylesheet' type='text/css'>
        <link rel="stylesheet" href="css/main.css">
    </head>

</head>
<body>
<form action="AddEvent" method="post">
      
        <h1>Add TechTalk</h1>
        
       
        
          <label for="date">Date</label>
          <input type="text" id="date" name="date">
          
          <label for="time">Time:</label>
          <input type="text" id="time" name="time">
          
          <label for="presenter">Presenter:</label>
          <input type="text" id="presenter" name="presenter">
          
           <label for="description">Description:</label>
          <input type="text" id="description" name="Description">
          
           <label for="title">Title:</label>
          <input type="text" id="title" name="title">
          
          
          <button type="submit">Add TechTalk</button>
      </form>
</body>
</html>
<%@page import="org.omg.CORBA.Current"%>
<%@page import="pojos.EventPojo"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Statement"%>
<%@page import="java.sql.Connection"%>
<%@page import="java.util.*"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="en">

<head>

<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta name="description" content="">
<meta name="author" content="">

<title>TechTalk Employee</title>

<!-- Bootstrap Core CSS -->
<link href="vendor1/bootstrap/css/bootstrap.min.css" rel="stylesheet">

<!-- MetisMenu CSS -->
<link href="vendor1/metisMenu/metisMenu.min.css" rel="stylesheet">

<!-- Custom CSS -->
<link href="dist1/css/sb-admin-2.css" rel="stylesheet">

<!-- Morris Charts CSS -->
<link href="vendor1/morrisjs/morris.css" rel="stylesheet">

<style>
#events {
	font-family: "Trebuchet MS", Arial, Helvetica, sans-serif;
	border-collapse: collapse;
	width: 100%;
}

#events td, #events th {
	border: 1px solid #ddd;
	padding: 8px;
}

#events tr:nth-child(even) {
	background-color: #f2f2f2;
}

#events tr:hover {
	background-color: #ddd;
}

#events th {
	padding-top: 12px;
	padding-bottom: 12px;
	text-align: left;
	background-color: #4CAF50;
	color: white;
}
</style>



</head>


<body>

	<div id="wrapper">

		<!-- Navigation -->
		<nav class="navbar navbar-default navbar-static-top" role="navigation"
			style="margin-bottom: 0">
			<div class="navbar-header">
				<button type="button" class="navbar-toggle" data-toggle="collapse"
					data-target=".navbar-collapse">
					<span class="sr-only">Toggle navigation</span> <span
						class="icon-bar"></span> <span class="icon-bar"></span> <span
						class="icon-bar"></span>
				</button>
				<a class="navbar-brand" href="EmployeeTechTalk.jsp">TechTonics</a>
			</div>
			<br />
			<h6>
				Welcome,<%=session.getAttribute("email")%>
			</h6>

			<!-- /.navbar-header -->

			<ul class="nav navbar-top-links navbar-right">



				<li class="dropdown"><a class="dropdown-toggle"
					data-toggle="dropdown" href="#"> <i class="fa fa-user fa-fw"></i>
						<i class="fa fa-caret-down"></i>

						<li><a href="index.jsp"><i class="fa fa-sign-out fa-fw"></i>
								Logout</a></li>
			</ul>
			<!-- /.dropdown-user -->
			</li>
			<!-- /.dropdown -->
			</ul>
			<!-- /.navbar-top-links -->


			</ul>
	</div>
	<!-- /.sidebar-collapse -->
	</div>
	<!-- /.navbar-static-side -->
	</nav>

	<form></form>
	<div id="page-wrapper">
		<div class="row">
			<div class="col-lg-12">
				<h1 class="page-header">TechTalk Events</h1>
				<table id="events">
					<tr>
						<th>Event no:</th>
						<th>Date</th>
						<th>Time</th>
						<th>Presenter</th>
						<th>Description</th>
						<th>Title</th>
					</tr>



					<%
						List<EventPojo> techtalkList = (List<EventPojo>) request
								.getAttribute("tecktalkList");

						for (EventPojo event : techtalkList) {
					%>
					<tr>
						<td style="font-size: x-large; width: 12%">
							<%
								out.print(event.getEventid());
							%>
						</td>


						<td style="font-size: x-large; width: 12%">
							<%
								out.print(event.getDate());
							%>
						</td>

						<td style="font-size: x-large; width: 12%">
							<%
								out.print(event.getTime());
							%>
						</td>

						<td style="font-size: x-large;">
							<%
								out.print(event.getPresenter());
							%>
						</td>

						<td style="font-size: x-large;">
							<%
								out.print(event.getDescription());
							%>
						</td>

						<td style="font-size: x-large;">
							<%
								out.print(event.getTitle());
							%>
						</td>
						<td><form action="EmployeeTechTalk" method="post">
								<%
									session.setAttribute("dataObject", event);
								%>
								<input type="hidden" id="hidden" name="id"
									value=<%=event.getEventid()%>> <input type="submit"
									name="Register" value=<%="Register"%>>
							</form></td>
					
					</tr>
					<%
						}
						pageContext.setAttribute("list", techtalkList);
						int count = 1;
					%>

				</table>




			</div>
			<!-- /#wrapper -->

			<!-- jQuery -->
			<script src="vendor1/jquery/jquery.min.js"></script>

			<!-- Bootstrap Core JavaScript -->
			<script src="vendor1/bootstrap/js/bootstrap.min.js"></script>

			<!-- Metis Menu Plugin JavaScript -->
			<script src="vendor/metisMenu/metisMenu.min.js"></script>

			<!-- Morris Charts JavaScript -->
			<script src="vendor1/raphael/raphael.min.js"></script>
			<script src="vendor1/morrisjs/morris.min.js"></script>
			<script src="data1/morris-data.js"></script>

			<!-- Custom Theme JavaScript -->
			<script src="dist1/js/sb-admin-2.js"></script>
</body>

</html>

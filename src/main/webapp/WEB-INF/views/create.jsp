<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@ page import="java.util.Date"%>
<%@ page import="java.text.SimpleDateFormat"%>

<%
Date currentDate = new Date();

SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd ");
String formattedDate = dateFormat.format(currentDate);
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Date</title>
</head>
<body >
<div align="center">
<h1>Date:</h1>
	<p><%=formattedDate%></p>
</div>
	<div align="center">
		<form action="postTask" method="post">

			<table border="1px solid">
				
				<tr>
					<td>Task</td>
					<td><input type="text" name="task"></td>
				</tr>
			</table>
			<br> <input type="submit" value="Add Task">
		</form>
	</div>

	<%
	String message = (String) request.getAttribute("message");

	if (message != null) {
	%>
	<div align="center">
		<h1><%=message%></h1>
	</div>
	<%
	}
	%>

</body>
</html>


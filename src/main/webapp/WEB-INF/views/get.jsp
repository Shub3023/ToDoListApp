<%@page import="com.jspiders.todolist.pojo.Admin"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Get Task By Id</title>
</head>
<body>
<%
	Admin admin = (Admin) request.getAttribute("admin");
	if (admin != null) {
	%>
	<div align="center">
		<table border="1">
			<thead>
				<th>ID</th>
				<th>Name</th>
				<th>Email</th>
				<th>Contact</th>
			</thead>

			<tbody>
				<tr>
					<td><%=admin.getId()%></td>
					<td><%=admin.getName()%></td>
					<td><%=admin.getEmail()%></td>
					<td><%=admin.getContact()%></td>
				</tr>
				<%
				}
				%>
			</tbody>
		</table>
	</div>
	<div>
		<form action="getbyid" method="post">
			<table>
				<tr>
					<td>id</td>
					<td><input type="id" name="id"></td>
				</tr>
			</table>
			<input type="submit" value="GetTaskID">
		</form>
	</div>
</body>
</html>
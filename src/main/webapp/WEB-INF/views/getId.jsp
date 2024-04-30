<%@page import="com.jspiders.todolist.pojo.TaskList"%>
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
	TaskList taskList = (TaskList) request.getAttribute("taskList");
	if (taskList != null) {
	%>
	<div align="center">
		<table border="1">
			<thead>
				<th>ID</th>
				<th>Status</th>
				<th>Task</th>
				<th>AdminId</th>
			</thead>

			<tbody>
				<tr>
					<td><%=taskList.getId()%></td>
					<td><%=taskList.getStatus()%></td>
					<td><%=taskList.getTask()%></td>
					<td><%=taskList.getAdmin()%></td>
				</tr>
				<%
				}
				%>
			</tbody>
		</table>
	</div>
	<div>
		<form action="getTaskbyid" method="post">
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
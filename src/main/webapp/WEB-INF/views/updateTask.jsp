<%@page import="com.jspiders.todolist.pojo.TaskList"%>
<%@page import="com.jspiders.todolist.pojo.Admin"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<div align="center">
		<%
		TaskList taskList = (TaskList) request.getAttribute("task");

		if (taskList != null) {
		%>
		<form action="updatedTask" method="post">
			<table border="1px solid">
				<tr>
					<td>ID</td>
					<td><input type="text" name="id" value="<%=taskList.getId()%>"
						readonly="readonly"></td>
				</tr>
				<tr>
					<td>Task</td>
					<td><input type="text" name="task"
						value="<%=taskList.getTask()%>"></td>
				</tr>


				<tr>
					<td>Status</td>
					<td><input type="text" name="status"
						value="<%=taskList.getStatus()%>"></td>
				</tr>


			</table>
			<input type="submit" value="UPDATE TASK">
		</form>
		<%
		}
		%>
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
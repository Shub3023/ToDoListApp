<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>DELETE TASK</title>
</head>
<body>
	<div align="center">
		<form action="deletedTask" method="post">
			<table border="1px solid">
				<tr>
					<th>Task</th>
					<td><input type="text" name="task"></td>
				</tr>
			</table>
			<input type="submit" value="DELETE TASK">

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
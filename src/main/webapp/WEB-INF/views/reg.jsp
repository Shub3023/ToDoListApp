<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Registration Page</title>
<style>
h2 {
	color: orange;
}

body {
	font-family: Arial, sans-serif;
	margin: 0;
	padding: 0;
	background-color: #f4f4f4;
	display: flex;
	justify-content: center;
	align-items: center;
	height: 100vh;
}

.login-container {
	background-color: #fff;
	border-radius: 5px;
	padding: 20px;
	box-shadow: 0 2px 5px rgba(0, 0, 0, 0.1);
}

.login-container h2 {
	margin-top: 0;
	text-align: center;
}

.login-container form {
	display: flex;
	flex-direction: column;
}

.login-container input[type="text"], .login-container input[type="password"]
	{
	margin-bottom: 10px;
	padding: 8px;
	border: 1px solid #ccc;
	border-radius: 3px;
}

.login-container input[type="submit"] {
	background-color: orange;
	color: white;
	border: none;
	padding: 10px;
	border-radius: 3px;
	cursor: pointer;
}

.login-container input[type="submit"]:hover {
	background-color: orange;
}
</style>
</head>
<body>

	<div class="login-container">
		<h2>REGISTERATION</h2>
		<form action="addregister" method="post">
			<input type="text" name="email" placeholder="Email" required>
			<input type="text" name="name" placeholder="Name" required> <input
				type="text" name="contact" placeholder="Contact" required> <input
				type="password" name="pass" placeholder="Password" required>
			<input type="submit" value="REGISTER">
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
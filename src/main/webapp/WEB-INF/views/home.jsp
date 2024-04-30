<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<style>
#home {
	margin-top: 180px;
	margin-left:120px;
}

nav {
	background-color: #333;
	padding: 10px 20px;
	
}

nav ul {
	list-style-type: none;
	margin: 0;
	padding: 0;
}

nav ul li {
	display: inline;
}

nav ul li a {
	color: orange;
	text-decoration: none;
	padding: 10px 20px;
}

nav ul li a.active {
	background-color: #555; 
}
</style>
<meta charset="ISO-8859-1">
<link rel="stylesheet" type="text/css" href="styles.css">
<title>Insert title here</title>
</head>
<body>
	<nav>
		<ul>
			<li><a class="active" href="home">Home</a></li>
			<li><a href="getTask">Add Task </a></li>
			<li><a href="editTask">Edit Task </a></li>
			<li><a href="gettasks">All Task </a></li>
			<li><a href="deletetask">Delete Task </a></li>
			<li><a href="log_out">Log Out </a></li>
		</ul>
	</nav>
	<div id="home">
		<h1>WELCOME TO THE HOME PAGE!!.</h1>
	</div>
</body>
</html>

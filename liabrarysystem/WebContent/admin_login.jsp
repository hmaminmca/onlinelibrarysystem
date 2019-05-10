<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Admin Login</title>
<link rel="stylesheet" type="text/css" href="CSS/login.css">
<link rel="stylesheet" type="text/css" href="CSS/btnback.css">

</head>
<body bgcolor="f0dda1">
<div style="border:solid;background-color: white ">
<img src="img/logo.png" align="left">
<h1 align="left" style="font-style: italic;font-family: serif; color:#804000;">Library Management System</h1>
</div>
<div style="margin-top: 100px">
<h3 align="center"> Admin Login</h3>
<form method="post" action="${pageContext.request.contextPath}/AdmLoginCheck">
<table class="login">
<tr>
<td>
<label>Username :</label>
</td>
<td>
<input type="text" name="txtadmuname" placeholder="Enter username" />
</td>
</tr>
<tr>
<td>
<label>Password :</label>
</td>
<td>
<input type="password" name="txtadmupass" placeholder="Enter password" /><br><br>
</td>
</tr>
<tr>
<td>
<input type="Submit" value="Login">
</td>
<td>
<input type="Button" value="Cancel">
</td>
</tr>
</table>
</form>
</div>
<a href="index.jsp">Back</a>
</body>
</html>
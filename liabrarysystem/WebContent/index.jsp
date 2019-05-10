<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Home Page</title>
<style type="text/css">
input[type=submit].admin {
  width: 20%;
  background-color: #804000;
  color: white;
  padding: 14px 20px;
  //margin: 8px 0;
  margin-top : 150px;
  margin-left : 550px;
  border: none;
  border-radius: 4px;
  cursor: pointer;
}
input[type=submit].lib {
  width: 20%;
  background-color: #804000;
  color: white;
  padding: 14px 20px;
  //margin: 8px 0;
  margin-top : 100px;
  margin-left : 550px;
  border: none;
  border-radius: 4px;
  cursor: pointer;
}

</style>
</head>
<body bgcolor="f0dda1">
<div style="border:solid;background-color: white ">
<img src="img/logo.png" align="left">
<h1 align="left" style="font-style: italic;font-family: serif; color:#804000;">Library Management System</h1>
</div>
<form method="post" action="admin_login.jsp">
<input type="Submit" value ="Admin Login" class="admin">
</form>
<form method="post" action="librarian_login.jsp">
<input type="Submit" value ="Librarian Login" class="lib">
</form>
</body>
</html>
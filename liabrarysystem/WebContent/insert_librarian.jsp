<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Add Librarian</title>
<link rel="stylesheet" type="text/css" href="CSS/mainform.css">

<!-- <style type="text/css">
div.one
{
	border : solid;
	width : 400px;
	margin-left : 450px;
}
table
{
	margin-top : 20px;
}
</style> -->
</head>
<body>
<jsp:include page="admin_main.jsp"></jsp:include>
<h3 align ="center">Add Librarian Details</h3>
<div class="one">

<form method="post" action="${pageContext.request.contextPath}/InsertLibrarian">

<table class="frm">
<tr>
<td><label>Name :</label></td>
<td><input type="text" placeholder="Enter name" name="txtlname" /></td>
</tr>
<tr>
<td><label>Username :</label></td>
<td><input type="text" placeholder="Enter username" name="txtluname" /></td>
</tr>
<tr>
<td><label>Password :</label></td>
<td><input type="password" placeholder="Enter password" name="txtlpass" /></td>
</tr>
<tr>
<td><label>Email :</label></td>
<td><input type="text" placeholder="Enter email" name="txtemail"/></td>
</tr>
<tr>
<td><label>Address :</label></td>
<td><textarea name="txtaddress" rows="5" cols="20"></textarea></td>
</tr>
<tr>
<td><label>City :</label></td>
<td><input type="text" placeholder="Enter city" name="txtscity"/></td>
</tr>
<tr>
<td><label>Contact no :</label></td>
<td><input type="text" placeholder="Enter contact no" name="txtcontact"/></td>
</tr>
<tr>
<td><input type="submit" value="Add"></td>
</tr>
</table>
</form>
</div>
</body>
</html>
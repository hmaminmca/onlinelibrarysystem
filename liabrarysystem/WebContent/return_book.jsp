<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Return Book</title>
<link rel="stylesheet" type="text/css" href="CSS/mainform.css">
<link rel="stylesheet" type="text/css" href="CSS/buttonsub.css">
</head>
<body>
<jsp:include page="lib_main.jsp"></jsp:include>

<h3 align ="center">Return Book</h3>
<div>
<form method="post" action="${pageContext.request.contextPath}/ReturnBook">
<table class="frm">
<tr>
<td><label>Book ID :</label></td>
<td><input type="text" placeholder="Enter Book ID" name="txtrbid" /></td>
</tr>
<tr>
<td><label>Student ID :</label></td>
<td><input type="text" placeholder="Enter Student Id" name="txtrstid" /></td>
</tr>
</table>
<input type="submit" value="Return Book" class="btn"> 
</form>
</div>
</body>
</html>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Issue Book</title>
<link rel="stylesheet" type="text/css" href="CSS/mainform.css">
<link rel="stylesheet" type="text/css" href="CSS/buttonsub.css">
</head>
<body>
<jsp:include page="lib_main.jsp"></jsp:include>
<h3 align ="center">Issue Book</h3>
<div>
<form method="post" action="${pageContext.request.contextPath}/IssueBook">
<table class="frm">
<tr>
<td><label>Book ID :</label></td>
<td><input type="text" placeholder="Enter Book ID" name="txtbookid" /></td>
</tr>
<tr>
<td><label>Student ID :</label></td>
<td><input type="text" placeholder="Enter Book Name" name="txtstuid" /></td>
</tr>
<tr>
<td><label>Student Name :</label></td>
<td><input type="text" placeholder="Enter Book Author" name="txtstuname" /></td>
</tr>
<tr>
<td><label>Student Contact :</label></td>
<td><input type="text" placeholder="Enter Book Publisher" name="txtstucontact"/></td>
</tr>
</table>
<input type="submit" value="Issue Book" class="btn">
</form>
</div>

</body>
</html>
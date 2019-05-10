<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Delete Book</title>
<link rel="stylesheet" type="text/css" href="CSS/mainform.css">
</head>
<body>
<jsp:include page="lib_main.jsp"></jsp:include>
<form method="post" action="DeleteBook">
<h3 align="center">Delete Book Details</h3>
<table class="frm">
<tr>
<td><label>Enter Book ID :</label></td>
<td><input type="text" name="txtbook_id" placeholder="Enter Book ID"></td>
 <td align="center"><input type="submit" value="Delete"></td>
</tr>
</table>
</form>
</body>
</html>
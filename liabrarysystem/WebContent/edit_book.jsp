<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Edit Book</title>
<link rel="stylesheet" type="text/css" href="CSS/mainform.css">
</head>
<body>
<jsp:include page="lib_main.jsp"></jsp:include>
<form method="post" action="update_book.jsp">
<h3 align="center">Update Book Details</h3>
<div>
<table class="frm">
<tr>
<td><label>Enter Book ID :</label></td>
<td><input type="text" name="txtedtbid" placeholder="Enter Book ID"></td>
 <td align="center">
 <input type="submit" value="show"></td>
</tr>
</table>
</div>
</form>
</body>
</html>
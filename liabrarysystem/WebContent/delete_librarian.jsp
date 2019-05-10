<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Delete Librarian</title>
<link rel="stylesheet" type="text/css" href="CSS/mainform.css">

</head>
<body>
<jsp:include page="admin_main.jsp"></jsp:include>
<form method="post" action="DeleteLibrarian">
<h3 align="center">Delete Librarian</h3>
<table class="frm">
<tr>
<td><label>Enter ID :</label></td>
<td><input type="text" name="txtlib_id" placeholder="Enter Librarian ID"></td>
 <td align="center"><input type="submit" value="Delete"></td>
</tr>
</table>
</form>
</body>
</html>
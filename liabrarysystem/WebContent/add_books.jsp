<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Add Books</title>
<link rel="stylesheet" type="text/css" href="CSS/mainform.css">
<link rel="stylesheet" type="text/css" href="CSS/buttonsub.css">
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
<jsp:include page="lib_main.jsp"></jsp:include>
<h3 align ="center">Add Book Details</h3>
<div>
<form method="post" action="${pageContext.request.contextPath}/InsertBookDetails">
<table class="frm">
<tr>
<td><label>Call No :</label></td>
<td><input type="text" placeholder="Enter Call No" name="txtbcallno" /></td>
</tr>
<tr>
<td><label>Name :</label></td>
<td><input type="text" placeholder="Enter Book Name" name="txtbname" /></td>
</tr>
<tr>
<td><label>Author :</label></td>
<td><input type="text" placeholder="Enter Book Author" name="txtbauthor" /></td>
</tr>
<tr>
<td><label>Publisher :</label></td>
<td><input type="text" placeholder="Enter Book Publisher" name="txtbpublisher"/></td>
</tr>
<tr>
<td><label>Quantity :</label></td>
<td><input type="text" placeholder="Enter Quantity" name="txtbqty"/></td>
</tr>
</table>

<input type="submit" value="Add" class="btn">


</form>
</div>
</body>
</html>
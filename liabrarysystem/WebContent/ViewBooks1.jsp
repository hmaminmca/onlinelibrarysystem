<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
     <%@ page import="java.sql.*"%>
    <%@ page import="java.io.*" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<jsp:include page="lib_main.jsp"></jsp:include>
<form method="post" action="ViewBooks">
<input type="submit" value="show" >
</form>
<h2 align="center">Book Details</h2>
<table border="1" class="one">
<tr>
<th>Book ID</th>
<th>Call No</th>
<th>Book Name</th>
<th>Author</th>
<th>Publisher</th>
<th>Total Books</th>
<th>Issued Books</th>
</tr>
</table>

</body>
</html>
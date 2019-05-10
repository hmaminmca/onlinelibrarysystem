<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page import="java.sql.*"%>
    <%@ page import="java.io.*" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title></title>
<link rel="stylesheet" type="text/css" href="CSS/mainform.css">
</head>
<body>
<jsp:include page="lib_main.jsp"></jsp:include>
<h2 align="center">Book Details</h2>
<%
try
{
	
	Connection connection = null;
	Statement st=null;
	Class.forName("org.sqlite.JDBC");
	connection = DriverManager.getConnection("jdbc:sqlite:d://ComIT_Project//liabrarysystem//library.db");
	String query="select * from tbl_book_details where book_id='"+request.getParameter("txtedtbid")+"'";
	st=connection.createStatement();
	ResultSet rs=st.executeQuery(query);
while(rs.next())
{

%>
<form method="post" action="UpdateBook">
	<table class="frm">
	<tr>
	<td>Book ID :</td>
	<td><input type="text" name="txtupbid" readonly value="<%=rs.getInt("book_id")%>"></td>
	</tr>
	<tr>
	<td>Call No :</td>
	<td><input type="text" name="txtupbcallno" value="<%=rs.getString("callno")%>"></td>
	</tr>
	<tr>
	<td>Book Name :</td>
	<td><input type="text" name="txtupbname" value="<%=rs.getString("book_name")%>"></td>
	</tr>
	<tr>
	<td>Author :</td>
	<td><input type="text" name="txtupbauthor" value="<%=rs.getString("author") %>"></td>
	</tr>
	<tr>
	<td>Publisher :</td>
	<td><input type="text" name="txtupbpub" value="<%=rs.getString("publisher")%>"></td>
	</tr>
	<tr>
	<td>Quantity :</td>
	<td><input type="text" name="txtupbqty" value="<%=rs.getInt("quantity")%>"></td>
	</tr>
	</table>
	
 <%

}

    
    rs.close();
    st.close();
    connection.close();
}

catch(Exception e)
{
    e.printStackTrace();
}
%>
<input type="submit" value="Update" style="margin-left: 630px;margin-top: 20px;">
</form>
</body>
</html>
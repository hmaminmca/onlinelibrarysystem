<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page import="java.sql.*"%>
    <%@ page import="java.io.*" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Edit Librarian</title>
<link rel="stylesheet" type="text/css" href="CSS/mainform.css">
</head>
<body>
<jsp:include page="admin_main.jsp"></jsp:include>
<h2 align="center">Librarian Details</h2>
<%
try
{
	
	Connection connection = null;
	Statement st=null;
	Class.forName("org.sqlite.JDBC");
	connection = DriverManager.getConnection("jdbc:sqlite:d://ComIT_Project//liabrarysystem//library.db");
	String query="select * from tbl_librarian where librarian_id='"+request.getParameter("txtlibid1")+"'";
	st=connection.createStatement();
	ResultSet rs=st.executeQuery(query);
while(rs.next())
{

%>
<form method="post" action="UpdateLibrarian">
	<table class="frm">
	<tr>
	<td>ID :</td>
	<td><input type="text" name="txtupid" readonly value="<%=rs.getInt("librarian_id")%>"></td>
	</tr>
	<tr>
	<td>Name :</td>
	<td><input type="text" name="txtupname" value="<%=rs.getString("name")%>"></td>
	</tr>
	<tr>
	<td>Email :</td>
	<td><input type="text" name="txtupemail" value="<%=rs.getString("l_email")%>"></td>
	</tr>
	<tr>
	<td>Address :</td>
	<td><input type="text" name="txtupadd" value="<%=rs.getString("address") %>"></td>
	</tr>
	<tr>
	<td>City :</td>
	<td><input type="text" name="txtupcity" value="<%=rs.getString("city")%>"></td>
	</tr>
	<tr>
	<td>Contact No :</td>
	<td><input type="text" name="txtupcont" value="<%=rs.getInt("contact_no")%>"></td>
	</tr>
	<tr>
	<td>Username :</td>
	<td><input type="text" name="txtupuname" readonly value="<%=rs.getString("l_uname")%>"></td>
	</tr>
	<tr>
	<td>Password :</td>
	<td><input type="password" name="txtuppass" value="<%=rs.getString("l_pass")%>"></td>
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
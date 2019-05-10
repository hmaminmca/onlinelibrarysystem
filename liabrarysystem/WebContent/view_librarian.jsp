<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
 <%@ page import="java.sql.*"%>
    <%@ page import="java.io.*" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>View Librarian</title>
</head>
<body>
<jsp:include page="admin_main.jsp"></jsp:include>
<h2 align="center">Librarian Details</h2>
<table class="one" border="1">
<tr>
<th>ID</th>
<th>NAME</th>
<th>EMAIL</th>
<th>Address</th>
<th>City</th>
<th>Contact No</th>
</tr>
<%
try
{
	Connection connection = null;
	Statement st=null;
	Class.forName("org.sqlite.JDBC");
	connection = DriverManager.getConnection("jdbc:sqlite:d://ComIT_Project//liabrarysystem//library.db");
	String query="select * from tbl_librarian";
	st=connection.createStatement();
	ResultSet rs=st.executeQuery(query);
while(rs.next())
{

%>
    <tr>
    <td width="10%" align="center"><%=rs.getInt("librarian_id") %></td>
   <td width="20%" align="center"><%=rs.getString("name") %></td>
    <td width="20%" align="center"><%=rs.getString("l_email") %></td>
   <td width="35%" align="center"><%=rs.getString("address") %></td>
   <td width="10%" align="center"><%=rs.getString("city") %></td>
      <td width="10%" align="center"><%=rs.getInt("contact_no") %></td>
   
    </tr>
        <%

}
%>
    </table>
    <%
    rs.close();
    st.close();
    connection.close();
}
catch(Exception e)
{
    e.printStackTrace();
}
%>
</body>
</html>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page import="java.sql.*"%>
    <%@ page import="java.io.*" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Issued Book</title>
</head>
<body>
<jsp:include page="lib_main.jsp"></jsp:include>

<h3 align="center">Issued Book Details</h3>
<table border="1" class="one" align="center">
<tr>
<th>Book ID</th>
<th>Student ID</th>
<th>Student Name</th>
<th>Student Contact No</th>
</tr>
<%
try
{
	Connection connection = null;
	Statement st=null;
	Class.forName("org.sqlite.JDBC");
	connection = DriverManager.getConnection("jdbc:sqlite:d://ComIT_Project//liabrarysystem//library.db");
	String query="select * from tbl_issue_book_details";
	st=connection.createStatement();
	ResultSet rs=st.executeQuery(query);
while(rs.next())
{

%>
    <tr>
   <td width="10%" align="center"><%=rs.getInt("book_id") %></td>
    <td width="30%" align="center"><%=rs.getInt("student_id") %></td>
   <td width="20%" align="center"><%=rs.getString("student_name") %></td>
   <td width="30%" align="center"><%=rs.getInt("student_contact") %></td>
   
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
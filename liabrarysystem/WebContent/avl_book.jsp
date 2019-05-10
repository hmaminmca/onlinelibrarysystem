<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
      <%@ page import="java.sql.*"%>
    <%@ page import="java.io.*" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Books Avaibility</title>
</head>
<body>
<jsp:include page="lib_main.jsp"></jsp:include>
<h3 align="center">Available Book Details</h3>
<table border="1" class="one">
<tr>
<th>Book ID</th>
<th>Call No</th>
<th>Book Name</th>
<th>Author</th>
<th>Publisher</th>
<th>Total Books</th>
<th>Available Books</th>
<th>Issued Books</th>
</tr>
<%
try
{
	Connection connection = null;
	Statement st=null;
	Class.forName("org.sqlite.JDBC");
	connection = DriverManager.getConnection("jdbc:sqlite:d://ComIT_Project//liabrarysystem//library.db");
	
	
	//String query="select * from tbl_book_details";
	String query1="select tbl_issue_book_details.book_id,count(*)as issue_qty,tbl_book_details.book_name,tbl_book_details.author,tbl_book_details.publisher,tbl_book_details.quantity,tbl_book_details.callno from  tbl_issue_book_details join tbl_book_details on tbl_issue_book_details.book_id = tbl_book_details.book_id group by tbl_issue_book_details.book_id"; 
	st=connection.createStatement();
	//ResultSet rs=st.executeQuery(query);
	ResultSet rs=st.executeQuery(query1);
	
	while(rs.next())
{
		/* int tot_qty=rs.getInt("quantity");
		int avl_qty=rs.getInt("avl_qty");
		int issued_qty=tot_qty-avl_qty; */
%>
    <tr>
       <td width="10%" align="center"><%=rs.getInt("book_id") %></td>
   <td width="10%" align="center"><%=rs.getString("callno") %></td>
    <td width="20%" align="center"><%=rs.getString("book_name") %></td>
   <td width="10%" align="center"><%=rs.getString("author") %></td>
   <td width="20%" align="center"><%=rs.getString("publisher") %></td>
      <td width="10%" align="center"><%=rs.getInt("quantity") %></td>
     <td width="10%" align="center"><%=rs.getInt("quantity")-rs.getInt("issue_qty") %></td>
	<td width="10%" align="center"><%=rs.getInt("issue_qty") %></td> 
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
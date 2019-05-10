package admin;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import javax.swing.*;

/**
 * Servlet implementation class InsertBookDetails
 */
@WebServlet("/InsertBookDetails")
public class InsertBookDetails extends HttpServlet {
	private static final long serialVersionUID = 1L;
	int i;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public InsertBookDetails() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//doGet(request, response);
		Connection connection = null;
		Statement st=null;
		String callno,b_name,b_author,b_publisher;
		int b_qty;
		callno = request.getParameter("txtbcallno");
		b_name = request.getParameter("txtbname");
		b_author = request.getParameter("txtbauthor");
		b_publisher=request.getParameter("txtbpublisher");
		b_qty=Integer.parseInt(request.getParameter("txtbqty"));
		response.setContentType("text/html;charset=UTF-8");
		try
		{
			Class.forName("org.sqlite.JDBC");	
			connection = DriverManager.getConnection("jdbc:sqlite:d://ComIT_Project//liabrarysystem//library.db");
			st=connection.createStatement();
			String sql="insert into tbl_book_details (callno,book_name,author,publisher,quantity,avl_qty) values ('"+callno+"','"+b_name+"','"+b_author+"','"+b_publisher+"','"+b_qty+"','"+b_qty+"')";
			i=st.executeUpdate(sql);
			
			connection.close();
			JOptionPane.showMessageDialog(null,"Record Successfully Saved");
			response.sendRedirect("add_books.jsp");
		}
		
		catch(Exception e)
		{
			System.out.println(e.getMessage());
		}
	}

}

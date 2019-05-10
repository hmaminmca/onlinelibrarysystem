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
import javax.swing.JOptionPane;

/**
 * Servlet implementation class ReturnBook
 */
@WebServlet("/ReturnBook")
public class ReturnBook extends HttpServlet {
	private static final long serialVersionUID = 1L;
      int i,i2;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ReturnBook() {
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
		int r_book_id,r_stu_id;
		r_book_id= Integer.parseInt(request.getParameter("txtrbid"));
		r_stu_id = Integer.parseInt(request.getParameter("txtrstid"));
		try
		{
			Class.forName("org.sqlite.JDBC");	
			connection = DriverManager.getConnection("jdbc:sqlite:d://ComIT_Project//liabrarysystem//library.db");
			st=connection.createStatement();
			String sql="insert into tbl_return_book_details (r_book_id,stu_id) values ('"+r_book_id+"','"+r_stu_id+"')";
			i=st.executeUpdate(sql);
			//JOptionPane.showMessageDialog(null,"Saved");		
			//connection.close();
			
			   st = connection.createStatement(); 
			  String sql2="Delete from tbl_issue_book_details where book_id='"+r_book_id+"' and student_id='"+r_stu_id+"'"; 
			  i2=st.executeUpdate(sql2);
			  connection.close();
			 
			JOptionPane.showMessageDialog(null,"Book Return Successfully");
			response.sendRedirect("return_book.jsp");
		}
		
		catch(Exception e)
		{
			e.getMessage();
		}
		
	}

}

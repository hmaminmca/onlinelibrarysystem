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
 * Servlet implementation class IssueBook
 */
@WebServlet("/IssueBook")
public class IssueBook extends HttpServlet {
	private static final long serialVersionUID = 1L;
       int i;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public IssueBook() {
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
		String stuname;
		int book_id,stu_id,stucontact;
		book_id = Integer.parseInt(request.getParameter("txtbookid"));
		stu_id = Integer.parseInt(request.getParameter("txtstuid"));
		stuname = request.getParameter("txtstuname");
		stucontact =Integer.parseInt(request.getParameter("txtstucontact"));
		try
		{
			Class.forName("org.sqlite.JDBC");	
			connection = DriverManager.getConnection("jdbc:sqlite:d://ComIT_Project//liabrarysystem//library.db");
			st=connection.createStatement();
			String sql="insert into tbl_issue_book_details (book_id,student_id,student_name,student_contact) values ('"+book_id+"','"+stu_id+"','"+stuname+"','"+stucontact+"')";
			i=st.executeUpdate(sql);
			//JOptionPane.showMessageDialog(null,"Saved");		
			connection.close();
			JOptionPane.showMessageDialog(null,"Book Issue Successfully");
			response.sendRedirect("issue_book.jsp");
		}
		
		catch(Exception e)
		{
			System.out.println(e.getMessage());
		}
		
	}

}

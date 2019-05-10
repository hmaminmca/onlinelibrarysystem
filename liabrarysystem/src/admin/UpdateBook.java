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
 * Servlet implementation class UpdateBook
 */
@WebServlet("/UpdateBook")
public class UpdateBook extends HttpServlet {
	private static final long serialVersionUID = 1L;
	int i;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateBook() {
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
		
		int book_no,book_qty;
		String callno,b_name,b_author,b_publisher;
		
		book_no=Integer.parseInt(request.getParameter("txtupbid"));
		callno= request.getParameter("txtupbcallno");
		b_name = request.getParameter("txtupbname");
		b_author = request.getParameter("txtupbauthor");
		b_publisher=request.getParameter("txtupbpub");
		book_qty=Integer.parseInt(request.getParameter("txtupbqty"));	
		try
		{
			Class.forName("org.sqlite.JDBC");	
			connection = DriverManager.getConnection("jdbc:sqlite:d://ComIT_Project//liabrarysystem//library.db");
			st=connection.createStatement();
			System.out.println("Connected");
			String sql="update tbl_book_details set callno='"+callno+"',book_name='"+b_name+"',author='"+b_author+"',publisher='"+b_publisher+"',quantity='"+book_qty+"' where book_id='"+book_no+"'";
			i = st.executeUpdate(sql);
			//JOptionPane.showMessageDialog(null,"Saved");				
			connection.close();
			JOptionPane.showMessageDialog(null,"Record Successfully Updated");
			response.sendRedirect("edit_book.jsp");
		}
		
		catch(Exception e)
		{
			System.out.println(e.getMessage());
		}
	}

}

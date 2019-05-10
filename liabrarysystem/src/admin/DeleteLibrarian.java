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
 * Servlet implementation class DeleteLibrarian
 */
@WebServlet("/DeleteLibrarian")
public class DeleteLibrarian extends HttpServlet {
	private static final long serialVersionUID = 1L;
       int i;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DeleteLibrarian() {
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
		
		int lib_id;
		lib_id=Integer.parseInt(request.getParameter("txtlib_id"));
		
		try
		{
			Class.forName("org.sqlite.JDBC");	
			connection = DriverManager.getConnection("jdbc:sqlite:d://ComIT_Project//liabrarysystem//library.db");
			st=connection.createStatement();
			System.out.println("Connected");
			String sql="delete from tbl_librarian where librarian_id='"+lib_id+"'";
			i = st.executeUpdate(sql);
			//JOptionPane.showMessageDialog(null,"Saved");				
			connection.close();
			JOptionPane.showMessageDialog(null,"Record Successfully Deleted");
			response.sendRedirect("delete_librarian.jsp");
		}
		
		catch(Exception e)
		{
			System.out.println(e.getMessage());
		}
	}

}

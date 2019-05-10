package admin;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.swing.JOptionPane;

/**
 * Servlet implementation class LibLoginCheck
 */
@WebServlet("/LibLoginCheck")
public class LibLoginCheck extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LibLoginCheck() {
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
		PreparedStatement st=null;
		String libusername = request.getParameter("txtlibuname");
		String libpassword = request.getParameter("txtlibpass");
		try
		{
			Class.forName("org.sqlite.JDBC");	
			connection = DriverManager.getConnection("jdbc:sqlite:d://ComIT_Project//liabrarysystem//library.db");
			System.out.println("SQLite DB Connected!");
			String sql="select * from tbl_librarian where l_uname='"+ libusername +"' and l_pass='"+ libpassword +"'";
			st=connection.prepareStatement(sql);
			ResultSet rset=st.executeQuery();
			if (rset.next())
			{
				JOptionPane.showMessageDialog(null,"Login Succesfully");
				response.sendRedirect("lib_main.jsp");
			}
			else
			{
				JOptionPane.showMessageDialog(null,"Please Enter Correct Username and Password");
				response.sendRedirect("librarian_login.jsp");
			}
			connection.close();
			
		}
		
		catch(Exception e)
		{
			System.out.println(e.getMessage());
		}
	}

}

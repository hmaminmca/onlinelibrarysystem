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
import javax.swing.*;
/**
 * Servlet implementation class AdmLoginCheck
 */
@WebServlet("/AdmLoginCheck")
public class AdmLoginCheck extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AdmLoginCheck() {
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
		String uname = request.getParameter("txtadmuname");
		String pass = request.getParameter("txtadmupass");
		try
		{
			Class.forName("org.sqlite.JDBC");	
			connection = DriverManager.getConnection("jdbc:sqlite:d://ComIT_Project//liabrarysystem//library.db");
			System.out.println("SQLite DB Connected!");
			String sql="select * from tbl_admin where admin_username='"+ uname +"' and admin_pass='"+ pass +"'";
			st=connection.prepareStatement(sql);
			ResultSet rset=st.executeQuery();
			if (rset.next())
			{
				JOptionPane.showMessageDialog(null,"Login Succesfully");
				response.sendRedirect("admin_main.jsp");
			}
			else
			{
				JOptionPane.showMessageDialog(null,"Please Enter Correct Username and Password");
				response.sendRedirect("admin_login.jsp");
			}
			connection.close();
			
		}
		
		catch(Exception e)
		{
			System.out.println(e.getMessage());
		}
	}
}


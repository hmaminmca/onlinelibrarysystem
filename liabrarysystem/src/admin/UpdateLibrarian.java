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
 * Servlet implementation class UpdateLibrarian
 */
@WebServlet("/UpdateLibrarian")
public class UpdateLibrarian extends HttpServlet {
	private static final long serialVersionUID = 1L;
       int i;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateLibrarian() {
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
		
		String u_name,u_uname,u_upass,u_email,u_address,u_city;
		int u_id,u_contactno;
		
		u_id=Integer.parseInt(request.getParameter("txtupid"));
		u_name = request.getParameter("txtupname");
		u_uname = request.getParameter("txtupuname");
		u_upass = request.getParameter("txtuppass");
		u_email=request.getParameter("txtupemail");
		u_address=request.getParameter("txtupadd");
		u_city=request.getParameter("txtupcity");
		u_contactno=Integer.parseInt(request.getParameter("txtupcont"));
		
		try
		{
			Class.forName("org.sqlite.JDBC");	
			connection = DriverManager.getConnection("jdbc:sqlite:d://ComIT_Project//liabrarysystem//library.db");
			st=connection.createStatement();
			System.out.println("Connected");
			String sql="update tbl_librarian set name='"+u_name+"',l_uname='"+u_uname+"',l_pass='"+u_upass+"',l_email='"+u_email+"',address='"+u_address+"',city='"+u_city+"',contact_no='"+u_contactno+"' where librarian_id='"+u_id+"'";
			i = st.executeUpdate(sql);
			connection.close();
			JOptionPane.showMessageDialog(null,"Record Successfully Updated");
			response.sendRedirect("edit_librarian.jsp");
		}
		
		catch(Exception e)
		{
			System.out.println(e.getMessage());
		}
	}

}

package admin;

import java.io.IOException;
import java.sql.*;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.swing.JOptionPane;


/**
 * Servlet implementation class InsertLibrarian
 */
@WebServlet("/InsertLibrarian")
public class InsertLibrarian extends HttpServlet {
	private static final long serialVersionUID = 1L;
	int i;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public InsertLibrarian() {
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
		String name,uname,upass,email,address,city;
		int contactno;
		name = request.getParameter("txtlname");
		uname = request.getParameter("txtluname");
		upass = request.getParameter("txtlpass");
		email=request.getParameter("txtemail");
		address=request.getParameter("txtaddress");
		city=request.getParameter("txtscity");
		contactno=Integer.parseInt(request.getParameter("txtcontact"));
		try
		{
			Class.forName("org.sqlite.JDBC");	
			connection = DriverManager.getConnection("jdbc:sqlite:d://ComIT_Project//liabrarysystem//library.db");
			st=connection.createStatement();
			String sql="insert into tbl_librarian (name,l_uname,l_pass,l_email,address,city,contact_no) values ('"+name+"','"+uname+"','"+upass+"','"+email+"','"+address+"','"+city+"','"+contactno+"')";
			i=st.executeUpdate(sql);
			//JOptionPane.showMessageDialog(null,"Saved");	
			
			connection.close();
			JOptionPane.showMessageDialog(null,"Record Successfully Saved");
			response.sendRedirect("insert_librarian.jsp");
		}
		
		catch(Exception e)
		{
			System.out.println(e.getMessage());
		}
	}
	
}



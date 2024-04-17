package Controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.sql.*;

@WebServlet(name="db_In", urlPatterns={"/db_In"})

public class db_In extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	protected String url = "jdbc:mysql://localhost:3306/mca";
	protected String username = "root";
	protected String password = "mysqlpassword";
	
    protected void doLogin (HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	response.setContentType("text/html; charset=ISO-8859-1");
    	
    	String user = request.getParameter("username");
		String pass = request.getParameter("password");
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			Connection connect = DriverManager.getConnection(url,username,password);
			PreparedStatement prep;
			ResultSet res;
			
			prep = connect.prepareStatement("SELECT id, password FROM employees WHERE id = ? AND password = ?;");
			prep.setString(1, user);
			prep.setString(2, pass);
			
			res = prep.executeQuery();
			
			if(res.next()) {
		        request.getRequestDispatcher("/newOrder.html").forward(request,response);
			} else {
				response.sendRedirect("unknownUser.html");
			}
			
		} catch(Exception e){
			System.out.println(e);
		}
    }
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doLogin(request, response);
	}

}

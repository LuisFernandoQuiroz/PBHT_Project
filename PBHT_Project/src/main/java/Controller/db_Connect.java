package Controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

@WebServlet(name="db_Connect", urlPatterns={"/db_Connect"})

public class db_Connect extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	protected String url = "jdbc:mysql://localhost:3306/mca";
	protected String username = "root";
	protected String password = "mysqlpassword";
	
    protected void dbProcess(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	response.setContentType("text/html; charset=ISO-8859-1");
		int f1 = Integer.parseInt(request.getParameter("f1"));
		int f2 = Integer.parseInt(request.getParameter("f2"));
		int f3 = Integer.parseInt(request.getParameter("f3"));
		int f4 = Integer.parseInt(request.getParameter("f4"));
		int f5 = Integer.parseInt(request.getParameter("f5"));
		int f6 = Integer.parseInt(request.getParameter("f6"));
		int f7 = Integer.parseInt(request.getParameter("f7"));
		int f8 = Integer.parseInt(request.getParameter("f8"));
		int f9 = Integer.parseInt(request.getParameter("f9"));
		
		int d1 = Integer.parseInt(request.getParameter("d1"));
		int d2 = Integer.parseInt(request.getParameter("d2"));
		int d3 = Integer.parseInt(request.getParameter("d3"));
		
		String u1 = request.getParameter("userN");
		String u2 = request.getParameter("userA");
		String u3 = request.getParameter("userP");
		String u4 = request.getParameter("userE");
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			Connection connect = DriverManager.getConnection(url,username,password);
			PreparedStatement prep;
			
			prep = connect.prepareStatement("INSERT INTO orders (cid_1, cid_2, cid_3, cid_4, cid_5, cid_6, cid_7, cid_8, cid_9, bid_1, bid_2, bid_3, u_nom, u_dir, u_num, u_cor) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?);");
			prep.setInt(1, f1);
			prep.setInt(2, f2);
			prep.setInt(3, f3);
			prep.setInt(4, f4);
			prep.setInt(5, f5);
			prep.setInt(6, f6);
			prep.setInt(7, f7);
			prep.setInt(8, f8);
			prep.setInt(9, f9);
			prep.setInt(10, d1);
			prep.setInt(11, d2);
			prep.setInt(12, d3);
			prep.setString(13, u1);
			prep.setString(14, u2);
			prep.setString(15, u3);
			prep.setString(16, u4);
			
			prep.executeUpdate();
			
			request.getRequestDispatcher("/order_placed.html").forward(request, response);
		} catch(Exception e){
			System.out.println(e);
		}
    }
    
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		dbProcess(request, response);
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}
}

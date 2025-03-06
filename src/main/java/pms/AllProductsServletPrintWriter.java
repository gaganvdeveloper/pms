package pms;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
//@WebServlet(urlPatterns = "/allproducts")
public class AllProductsServletPrintWriter extends HttpServlet{
	@Override
	public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
		
		String s1  = "";
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/pms", "root", "root");
			PreparedStatement ps = con.prepareStatement("select * from product");
			ResultSet rs = ps.executeQuery();
			s1  = "<html><body ><table border='5' cellpadding='10' cellspacing='10' style=' font-size:30px; border-collapse:collapse; margin:auto;'><tr><th>ID</th><th>Name</th><th>Price</th><th>Brand</th><th>Description</th></tr>"; 
			while(rs.next())
			{
				String tr = "<tr>";
				tr = tr + "<td>"+rs.getString(1)+"</td>";
				tr = tr + "<td>"+rs.getString(2)+"</td>";
				tr = tr + "<td>"+rs.getString(3)+"</td>";
				tr = tr + "<td>"+rs.getString(4)+"</td>";
				tr = tr + "<td>"+rs.getString(5)+"</td>";
				tr = tr+"</tr>";
				s1 = s1 + tr;
			}
			s1 = s1 +"</table></body></html>";
			rs.close();
			ps.close();
			con.close();
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		PrintWriter pw = res.getWriter();
		pw.write(s1);
	}
}

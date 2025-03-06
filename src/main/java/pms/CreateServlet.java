package pms;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;

@WebServlet(urlPatterns = "/create")
public class CreateServlet extends HttpServlet {
	@Override
	public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {

		String id = req.getParameter("id");
		String name = req.getParameter("name");
		String price = req.getParameter("price");
		String brand = req.getParameter("brand");
		String description = req.getParameter("description");

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/pms", "root", "root");
			PreparedStatement ps = con.prepareStatement("insert into product values(?,?,?,?,?)");
			ps.setString(1, id);
			ps.setString(2, name);
			ps.setString(3, price);
			ps.setString(4, brand);
			ps.setString(5, description);
			int row = ps.executeUpdate();
			System.out.println(row + " : Row Inserted");
			ps.close();
			con.close();
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}

		req.getRequestDispatcher("success.jsp").forward(req, res);

	}
}

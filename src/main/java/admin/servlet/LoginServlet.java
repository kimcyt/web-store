package admin.servlet;
   
import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;

import webstore.domain.Admins;
import webstore.domain.User;
import webstore.utils.JdbcUtil;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/admin/login")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		System.out.println("admin login is called");
		String accountId = req.getParameter("accountId");
		String password = req.getParameter("password");
		QueryRunner qr = new QueryRunner(JdbcUtil.getDataSource());
		String sql = "select * from admins where accountId=? and password=?";
		Admins admin = null;
		try {
			admin = qr.query(sql, new BeanHandler<Admins>(Admins.class), accountId, password);
		} catch(SQLException e) {
			e.printStackTrace();
		}
		
		if(admin == null) {
			res.getWriter().write("Login failed: invalid account or password.");
			res.setHeader("refresh", "2;url=http://localhost:8080/webstorepractise/admin/adminLogin.jsp");
		} else {
			res.getWriter().write("Login succeeded: loading system......");
			HttpSession session = req.getSession();
			session.setAttribute("admin", admin);
			res.sendRedirect(req.getContextPath() + "/admin/main.jsp");
		}
		
	}

}

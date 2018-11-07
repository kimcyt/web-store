package webstore.servlet;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletContext;
//import javax.servlet.*;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;

import model.User;
import webstore.utils.JdbcUtil;

@WebServlet("/loginuser")
public class LoginServlet extends HttpServlet{

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {

		
		String userId = req.getParameter("userId");
		String password = req.getParameter("password");
		QueryRunner qr = new QueryRunner(JdbcUtil.getDataSource());
		String sql = "select * from users where userId=? and password=?";
		User user = null;
		try {
			user = qr.query(sql, new BeanHandler<User>(User.class), userId, password);
		} catch(SQLException e) {
			e.printStackTrace();
		}
		
		if(user == null) {
			res.getWriter().write("Login failed");
			//save user
			HttpSession session = req.getSession();
			session.setAttribute("user", user);
			res.setHeader("refresh", "1;url=http://localhost:8080/webstorepractise/webstore/login.jsp");
		} else {
			res.getWriter().write("Login succeeded");
			res.setHeader("refresh", "1;url=http://localhost:8080/webstorepractise/webstore/main.jsp");
		}
		
	}

}

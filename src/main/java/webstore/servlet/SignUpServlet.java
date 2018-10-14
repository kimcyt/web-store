package webstore.servlet;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.sql.SQLException;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.dbutils.QueryRunner;
//import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanHandler;

import webstore.utils.JdbcUtil;
import webstore.domain.User;

/**
 * Servlet implementation class SignUpServlet
 */
@WebServlet("/signup")
public class SignUpServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
     

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest req, HttpServletResponse response) throws ServletException, IOException {
		//if user inputs are in chinese, need to convert it
		req.setCharacterEncoding("UTF-8"); //only apply to POST, GET needs to use getBytes/string(UTF-8)
		
		String userId = req.getParameter("userId");
		String username = req.getParameter("userId");
		String password = req.getParameter("password");
		String email = req.getParameter("email");
//		Map<String, String[]> allInputs = req.getParameterMap();
//
//		User user = new User();
//		try {
//			BeanUtils.populate(user, allInputs);
//			System.out.println(user);
//		} catch (IllegalAccessException e1) {
//			e1.printStackTrace();
//		} catch (InvocationTargetException e1) {
//			e1.printStackTrace();
//		}
		
		User user = null;
		QueryRunner qr = new QueryRunner(JdbcUtil.getDataSource());
		String sql = "select * from users where userId=?";
		
		try {
			user = qr.query(sql, new BeanHandler<User>(User.class), userId);
		} catch(SQLException e) {
			e.printStackTrace();
		}
		if(user != null) {
			response.getWriter().write("The userId was already taken.");
			response.setHeader("refresh", "2;url=http://localhost:8080/webStore/signup.jsp");
		} else {
			sql = "insert into users value(?, ?, ?, ?)";
			try {
				qr.update(sql, userId, username, password, email);
			} catch(SQLException e) {
				e.printStackTrace();
			}
			response.getWriter().write("You have signed up successfully.");
			response.setHeader("refresh", "2;url=http://localhost:8080/webStore/login.jsp");
		}
	}

}
	

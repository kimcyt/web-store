package admin.servlet;
   
import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import admin.service.AdminsService;

/**
 * Servlet implementation class AdminServlet
 */
@WebServlet("/updateAdmin")
public class AdminServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private AdminsService service = new AdminsService();

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		String accountId = req.getParameter("accountId");
		String oldPwd = req.getParameter("oldPwd");
		String newPwd = req.getParameter("newPwd1");
		try {
			if(service.updatePassword(accountId, oldPwd, newPwd)) {
				res.getWriter().write("Password changed.");
			} else {
				res.getWriter().write("Incorrect password, please try again.");
			}
			res.setHeader("refresh", "2;url=http://localhost:8080/webstorepractise/admin/manageAccount.jsp");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}

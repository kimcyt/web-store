package admin.servlet;
   
import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import admin.service.GoodsService;
import model.Category;
import model.Good;

/**
 * Servlet implementation class BaseServlet
 */

@WebServlet("/admin/manageGoods")
public class BaseServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		System.out.println("goodsServlet called---------");
		String action = req.getParameter("action");
		System.out.println("received action: " + action);
		if(action == null) {
			return;
		}
		Class<? extends BaseServlet> clazz = this.getClass();
		try {
			//call the corresponding method from subclass given the method name and parameter types
			java.lang.reflect.Method method = clazz.getMethod(action, HttpServletRequest.class, HttpServletResponse.class);
			if(method!=null) {
				//the method has to be public, or use setAccessible to access it
				String forwardTo = (String) method.invoke(this, req, res);
				System.out.println("forwarding to " + forwardTo);
				req.getRequestDispatcher(forwardTo).forward(req, res);
			}
			
		} catch(Exception e) {
			System.out.println("error occured with good operation " + action);
			e.printStackTrace();
		}
	}

}

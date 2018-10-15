package admin.servlet;
   
import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import admin.service.GoodsService;
import webstore.domain.Categories;
import webstore.domain.Goods;

/**
 * Servlet implementation class BaseServlet
 */

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
			GoodsService service = new GoodsService();
//			List<Catogories> allCatos = service.getAllCatogories();
//			req.setAttribute("allCatogories", allCatos);
			
			//call the corresponding method from subclass given the method name and parameter types
			java.lang.reflect.Method method = clazz.getMethod(action, HttpServletRequest.class, HttpServletResponse.class);
			if(method!=null) {
				//the method has to be public, or use setAccessible to access it
				String forwardTo = (String) method.invoke(this, req, res);
				System.out.println("forwarding to " + forwardTo);
				req.getRequestDispatcher(forwardTo).forward(req, res);
			}
			
		} catch(Exception e) {
			e.printStackTrace();
		}
	}

}

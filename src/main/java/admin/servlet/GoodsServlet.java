package admin.servlet;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;
import java.util.Properties;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.beanutils.BeanUtils;

import admin.service.GoodsService;
import webstore.domain.Categories;
import webstore.domain.Goods;
import webstore.domain.PageInfo;
import webstore.utils.JdbcUtil;

/**
 * Servlet implementation class GoodListServlet
 */
@WebServlet("/admin/manageGoods")
public class GoodsServlet extends BaseServlet {
	//extends base servlet, all the requests will be handled by service() in baseServlet
	private static final long serialVersionUID = 1L;
	private GoodsService service = new GoodsService();
	private static Properties p;
	
	static {
		p = new Properties();
		//any classes inside folder classes, use its classLoader, can load any resources inside the folder
		String path = GoodsServlet.class.getClassLoader()
				.getResource("db.properties").getPath();
		FileInputStream in;
		try {
			in = new FileInputStream(path);
			p.load(in);
		} catch (Exception e) {
			System.out.println("failed to load properties");
			e.printStackTrace();
		}
	}

	//add methods corresponding to each command
	
	public String getGoods(HttpServletRequest req, HttpServletResponse res) {
		System.out.println("iam in getGoods-----------");
		try {
			List<Goods> allGoods = service.getAllGoods();
			for(Goods good: allGoods) {
				System.out.println("good" + good);
			}
			req.setAttribute("allGoods", allGoods);
			List<Categories> allCategories = service.getAllCategories();
			req.setAttribute("allCategories", allCategories);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return "goods-management.jsp";
	}
	
	public String getGood(HttpServletRequest req, HttpServletResponse res) {
		System.out.println("iam in getGood-----------");
		try {
			Goods currentGood = service.getCurrentGood(req.getParameter("gId"));
			req.setAttribute("currentGood", currentGood);
			List<Categories> allCategories = service.getAllCategories();
			req.setAttribute("allCategories", allCategories);
			req.setAttribute("currentPage", req.getParameter("currentPage"));
			if(req.getParameter("category")!=null) {
				req.setAttribute("category", req.getParameter("category"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return "updateGood.jsp";
	}
	
	public String getPageData(HttpServletRequest req, HttpServletResponse res) {
		System.out.println("iam in getPageData-----------");
		String dest="";
		try {
			//--todo: given currentPage number, return pageInfo object of that page
			PageInfo pageInfo;
			String category = req.getParameter("category");
			System.out.println("--------------category in get page data:" + category);
			String itemsPerPage=req.getParameter("itemsPerPage");
			String pageNum = req.getParameter("currentPage");
			if(itemsPerPage==null) {
				itemsPerPage=p.getProperty("itemsPerPage").toString();
			} 
			if(category==null) {
				pageInfo = service.getPageInfo(pageNum, itemsPerPage);
				dest = "goods-management.jsp";
			} else {
				pageInfo = service.getCategoryPageInfo(category, pageNum, itemsPerPage);
				req.setAttribute("category", category);
				dest = "category-goods.jsp";
			}
			req.setAttribute("pageInfo", pageInfo);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return dest;
	}
	
	public String getCategories(HttpServletRequest req, HttpServletResponse res) {
		System.out.println("iam in getCatos-----------");
		try {
			List<Categories> allCategories = service.getAllCategories();
			req.setAttribute("allCategories", allCategories);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return "addGood.jsp";
	}
	
	public String getCategory(HttpServletRequest req, HttpServletResponse res) {
		System.out.println("iam in getCate-----------");
		int no = Integer.parseInt(req.getParameter("category"));
		String category = Categories.getCategories().get(no);
		Categories categ = new Categories(no, category);
		req.setAttribute("category", categ);

		return "addGood.jsp";
	}

	public String add(HttpServletRequest req, HttpServletResponse res) {

		System.out.println("iam in add-----------");
		try {
			service.addGood(req.getParameter("name"), req.getParameter("image"), 
					req.getParameter("price"), req.getParameter("category"), req.getParameter("onsale"));
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return "manageGoods?action=getPageData&currentPage=1";
	}
	
	public String update(HttpServletRequest req, HttpServletResponse res) {
		System.out.println("iam in update-----------" + req.getParameter("gId"));
		try {
			service.updateGood(req.getParameter("gId"), req.getParameter("name"), req.getParameter("image"), 
					req.getParameter("price"), req.getParameter("category"), req.getParameter("onsale"));
		} catch (SQLException e) {
			e.printStackTrace();
		}
		if(req.getParameter("currentCategory")==null) {
			return "manageGoods?action=getPageData&currentPage="+req.getParameter("currentPage");
		} else {
			return "manageGoods?action=getPageData&currentPage="+req.getParameter("currentPage")+"&category="+req.getParameter("currentCategory");
		}
		
	}
	
	public String delete(HttpServletRequest req, HttpServletResponse res) {
		System.out.println("iam in delete-----------");
		try {
			service.deleteGood(req.getParameter("gId"));
			if(req.getParameter("category")!=null) {
				req.setAttribute("category", req.getParameter("category"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		if(req.getParameter("category")==null) {
			return "manageGoods?action=getPageData&currentPage="+req.getParameter("currentPage");
		} else {
			return "manageGoods?action=getPageData&currentPage="+req.getParameter("currentPage")+"&category="+req.getParameter("category");
		}
		
	}

}

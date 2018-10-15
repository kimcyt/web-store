package admin.dao;
  
import java.sql.SQLException;
import java.util.Collections;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import webstore.domain.Categories;
import webstore.domain.Goods;
import webstore.domain.PageInfo;
import webstore.utils.JdbcUtil;

public class GoodsDao {
	
	private QueryRunner qr = new QueryRunner(JdbcUtil.getDataSource());
	private String sql = "";
	
	public void addGood(String name, String image, String pricc, String cate, String sale) throws SQLException {
		Double price = Double.parseDouble(pricc);
		Integer category = Integer.parseInt(cate);
		Integer onsale = Integer.parseInt(sale);
		
		sql = "insert into goods(name,price,category,onsale) values(?,?,?,?)";
		qr.update(sql, name, price, category, onsale);
	}
	
	public void updateGood(String gid, String name, String image, String pricc, String cato, String sale) throws SQLException {
		sql = "update goods set name=?, image=?, price=?, category=?, onsale=? where gid=?";
//		qr.update(sql, good.getName(), good.getPrice(), good.getImage(), 
//				good.getCatogory(), good.getOnsale(), good.getGId());
		Integer gId = Integer.parseInt(gid);
		Double price = Double.parseDouble(pricc);
		Integer category = Integer.parseInt(cato);
		Integer onsale = Integer.parseInt(sale);
		qr.update(sql, name, image, price, category, onsale, gId);
	}
	
	public void deleteGood(String id) throws SQLException {
		Integer gid = Integer.parseInt(id);
		sql = "delete from goods where gid=?";
		qr.update(sql, gid);
	}

	public List<Goods> findAllGoods() throws SQLException {
			
		sql = "select * from goods";
		List<Goods> allGoods = null;
		allGoods = qr.query(sql, new BeanListHandler<Goods>(Goods.class));
		Collections.reverse(allGoods);
		return allGoods;
	}
	
	public Goods findCurrentGood(String gid) throws SQLException {
		Integer gId = Integer.parseInt(gid);
		sql = "select * from goods where gId=?";
		List<Goods> goods = qr.query(sql, new BeanListHandler<Goods>(Goods.class), gId);
		if(!goods.isEmpty())
			return goods.get(0);
		return null;
	}

	public List<Categories> findAllCategories() throws SQLException {
		List<Categories> allCategories = qr.query("select * from categories", new BeanListHandler<Categories>(Categories.class));
		return allCategories;
	}
	
	public PageInfo getPageInfo(String pageNum, String itemsPerPage) throws SQLException {
		int itemsNum =Integer.parseInt(itemsPerPage);
		int start = (Integer.parseInt(pageNum)-1)*itemsNum;
		List<Goods> goods = this.getPageGoods(start, start+itemsNum);
		sql = "select count(*) from goods";
		long count = (long)qr.query(sql, new ScalarHandler());
		PageInfo pageInfo = PageInfo.getPageInfo(Integer.parseInt(pageNum), count, goods, itemsNum);
		return pageInfo;
	}
	
	public PageInfo getPageInfoInCategory(String category, String pageNum, String itemsPerPage) throws SQLException {
		int itemsNum =Integer.parseInt(itemsPerPage);
		int start = (Integer.parseInt(pageNum)-1)*itemsNum;
		List<Goods> goods = this.getPageGoodsinCategory(category, start, start+itemsNum);
		sql = "select count(*) from goods where category=?";
		long count = (long)qr.query(sql, new ScalarHandler(), Integer.parseInt(category));
		PageInfo pageInfo = PageInfo.getPageInfo(Integer.parseInt(pageNum), count, goods, itemsNum);
		return pageInfo;
	}
	
	
	private List<Goods> getPageGoods(int start, int end) throws SQLException {
		sql = "select * from goods order by ? desc limit ?,?";  //limit from index to index
		List<Goods> allGoods = null;
		allGoods = qr.query(sql, new BeanListHandler<Goods>(Goods.class), "gId", start, end);
		Collections.reverse(allGoods);
		return allGoods;
	}

	public List<Goods> getPageGoodsinCategory(String category, int start, int end) throws NumberFormatException, SQLException {
		sql = "select * from goods where category=? limit ?,?";
		List<Goods> goods = qr.query(sql, new BeanListHandler<Goods>(Goods.class), Integer.parseInt(category), start, end);
		System.out.println("-------------------printing goods:");
		for (Goods good: goods) {
			System.out.println(good);
		}
		return goods;
	}

}

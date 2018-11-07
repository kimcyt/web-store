package admin.dao;
  
import java.sql.SQLException;

import java.util.Collections;
import java.util.List;
import webstore.utils.HibernateSession;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import model.Category;
import model.Good;
import model.PageInfo;
import webstore.utils.JdbcUtil;

public class GoodsDao {
	
	private QueryRunner qr = new QueryRunner(JdbcUtil.getDataSource());
	private String hql = "";
	private Session session = HibernateSession.createSession();
	private Transaction transaction = null;
	/*
	 * open new session for every transaction, if catch error, use transation.rollback()
	 */
	
	public void addGood(String name, String image, String pricc, String cate, String sale) throws SQLException {
		Double price = Double.parseDouble(pricc);
		Integer category = Integer.parseInt(cate);
		Integer onsale = Integer.parseInt(sale);
		
		transaction = session.beginTransaction();
//		hql = "insert into goods(name,price,category,onsale) values(?,?,?,?)";
//		qr.update(hql, name, price, category, onsale);
		Good good = new Good(name, image, price, category, onsale);
		session.save(good);
		transaction.commit();
	}
	
	public void updateGood(String gid, String name, String image, String pricc, String cato, String sale) throws SQLException {
//		hql = "update goods set name=?, image=?, price=?, category=?, onsale=? where gid=?";
//		qr.update(sql, good.getName(), good.getPrice(), good.getImage(), 
//				good.getCatogory(), good.getOnsale(), good.getGId());
		Integer gId = Integer.parseInt(gid);
		Double price = Double.parseDouble(pricc);
		Integer category = Integer.parseInt(cato);
		Integer onsale = Integer.parseInt(sale);
		transaction = session.beginTransaction();
		Good good = session.get(Good.class, gId);
		if(gid!=null) {
			good.setName(name);
			good.setImage(image);
			good.setPrice(price);
			good.setCategory(category);
			good.setOnsale(onsale);
			session.save(good);
		}	
		transaction.commit();
	}
	
	public void deleteGood(String id) throws SQLException {
		Integer gid = Integer.parseInt(id);
		transaction = session.beginTransaction();
		Good good = session.load(Good.class, gid);
		if(good!=null)
		session.delete(good);
		transaction.commit();
	}

	public List<Good> findAllGoods() throws SQLException {
		hql = "from Good";
		List<Good> allGoods = session.createQuery(hql).list();
//		allGoods = qr.query(hql, new BeanListHandler<Good>(Good.class));
		Collections.reverse(allGoods);
		return allGoods;
	}
	
	public Good findCurrentGood(String gid) throws SQLException {
//		if(!transaction.isActive())
//			transaction = session.beginTransaction();
		Integer gId = Integer.parseInt(gid);
//		hql = "select * from goods where gId=?";
//		List<Good> goods = qr.query(hql, new BeanListHandler<Good>(Good.class), gId);
//		if(!goods.isEmpty())
//			return goods.get(0);
		Good good = session.get(Good.class, gId);
//		transaction.commit();
		return good;
	}

	public List<Category> findAllCategories() throws SQLException {
		hql = "from Category";
//		if(!transaction.isActive())
//			transaction = session.beginTransaction();
		List<Category> allCategories = session.createQuery(hql).list();
//		transaction.commit();
		return allCategories;
	}
	
	public PageInfo getPageInfo(String pageNum, String itemsPerPage) throws SQLException {
		int itemsNum =Integer.parseInt(itemsPerPage);
		int start = (Integer.parseInt(pageNum)-1)*itemsNum;
//		if(!transaction.isActive())
//			transaction = session.beginTransaction();
		List<Good> goods = this.getPageGoods(start, start+itemsNum);
		hql = "select count(g) from Good g";
		long count = (long)session.createQuery(hql).list().get(0);
		System.out.println("-------count is " + count);
		PageInfo pageInfo = PageInfo.getPageInfo(Integer.parseInt(pageNum), count, goods, itemsNum);
//		transaction.commit();
		return pageInfo;
	}
	
	public PageInfo getPageInfoInCategory(String category, String pageNum, String itemsPerPage) throws SQLException {
		int itemsNum =Integer.parseInt(itemsPerPage);
		int start = (Integer.parseInt(pageNum)-1)*itemsNum;
//		if(!transaction.isActive())
//			transaction = session.beginTransaction();
		List<Good> goods = this.getPageGoodsinCategory(category, start, start+itemsNum);
		hql = "select count(g) from Good g where category=:cate";
		long count = (long) session.createQuery(hql).setParameter("cate", Integer.parseInt(category)).list().get(0);
		System.out.println("-------count is " + count);
//		long count = (long)qr.query(hql, new ScalarHandler(), Integer.parseInt(category));
		PageInfo pageInfo = PageInfo.getPageInfo(Integer.parseInt(pageNum), count, goods, itemsNum);
//		transaction.commit();
		return pageInfo;
	}
	
	
	private List<Good> getPageGoods(int start, int end) throws SQLException {
//		hql = "select * from goods order by ? desc limit ?,?";  //limit from index to index
//		if(!transaction.isActive())
//			transaction = session.beginTransaction();
		hql = "from Good";
		Query<Good> query = session.createQuery(hql);
		query.setFirstResult(start);
		query.setMaxResults(end);
		List<Good> allGoods = query.list();
//		allGoods = qr.query(hql, new BeanListHandler<Good>(Good.class), "gId", start, end);
		Collections.reverse(allGoods);
//		transaction.commit();
		return allGoods;
	}

	public List<Good> getPageGoodsinCategory(String category, int start, int end) throws NumberFormatException, SQLException {
		hql = "from Good where category=:cate";
//		List<Good> goods = qr.query(hql, new BeanListHandler<Good>(Good.class), Integer.parseInt(category), start, end);
		System.out.println("category: " + category);
		Query<Good> query = session.createQuery(hql)
				.setParameter("cate", Integer.parseInt(category));
		query.setFirstResult(start);
		query.setMaxResults(end);
		List<Good> allGoods = query.list();
		return allGoods;
	}

}

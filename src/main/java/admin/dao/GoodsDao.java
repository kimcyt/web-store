package admin.dao;
  
import java.sql.SQLException;


import java.util.Collections;
import java.util.List;
import webstore.utils.HibernateUtils;

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
	
//	private QueryRunner qr = new QueryRunner(JdbcUtil.getDataSource());
//	private String hql = "";
//	private Session session;
//	private Transaction transaction = null;
	/*
	 * open new session for every transaction, if catch error, use transation.rollback()
	 */
	
	public void addGood(String name, String image, String pricc, String cate, String sale) throws SQLException {
		//proper way to use session
		Session session = HibernateUtil.getInstance().getCurrentSession();
		Transaction transaction = null;
		try {
			Double price = Double.parseDouble(pricc);
			Integer category = Integer.parseInt(cate);
			Integer onsale = Integer.parseInt(sale);
			
			transaction = session.beginTransaction();
			Good good = new Good(name, image, price, category, onsale);
			session.save(good);
			//session auto closed by transaction
			transaction.commit();
		} catch(Exception e) {
			if(transaction!=null)
				transaction.rollback();
			throw e;
		}
	}
	
	public void updateGood(String gid, String name, String image, String pricc, String cato, String sale) throws SQLException {
//		hql = "update goods set name=?, image=?, price=?, category=?, onsale=? where gid=?";
//		qr.update(sql, good.getName(), good.getPrice(), good.getImage(), 
//				good.getCatogory(), good.getOnsale(), good.getGId());
		
		Session session = HibernateUtil.getInstance().getCurrentSession();
		Transaction transaction = null;
		try {
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
		} catch(Exception e) {
			if(transaction!=null)
				transaction.rollback();
			throw e;
		}
		
	}
	
	public void deleteGood(String id) throws SQLException {
		Session session = HibernateUtil.getInstance().getCurrentSession();
		Transaction transaction = null;
		try {
			Integer gid = Integer.parseInt(id);
			transaction = session.beginTransaction();
			
			Good good = session.load(Good.class, gid);
			if(good!=null)
			session.delete(good);
			transaction.commit();
		} catch(Exception e) {
			if(transaction!=null)
				transaction.rollback();
			throw e;
		}
	}

	public List<Good> findAllGoods() throws SQLException {
		Session session = HibernateUtil.getInstance().openSession();
		try {
			String hql = "from Good";
			List<Good> allGoods = session.createQuery(hql).list();
//			allGoods = qr.query(hql, new BeanListHandler<Good>(Good.class));
			Collections.reverse(allGoods);
			return allGoods;
		} catch(Exception e) {
			throw e;
		} finally {
			session.close();
		}
	}
	
	public Good findCurrentGood(String gid) throws SQLException {
//		if(!transaction.isActive())
//			transaction = session.beginTransaction();
		Session session = HibernateUtil.getInstance().openSession();
		try {
			Integer gId = Integer.parseInt(gid);
			Good good = session.get(Good.class, gId);
			return good;
		} catch(Exception e) {
			throw e;
		} finally {
			session.close();
		}
		
	}

	public List<Category> findAllCategories() throws SQLException {
		Session session = HibernateUtil.getInstance().openSession();
		try {
			String hql = "from Category";
//			if(!transaction.isActive())
//				transaction = session.beginTransaction();
			List<Category> allCategories = session.createQuery(hql).list();
//			transaction.commit();
			return allCategories;
		} catch(Exception e){
			throw e;
		} finally {
			session.close();
		}
	}
	
	public PageInfo getPageInfo(String pageNum, String itemsPerPage) throws SQLException {
	
		Session session = HibernateUtil.getInstance().openSession();
		try {
			int itemsNum =Integer.parseInt(itemsPerPage);
			int start = (Integer.parseInt(pageNum)-1)*itemsNum;
//			if(!transaction.isActive())
//				transaction = session.beginTransaction();
			List<Good> goods = this.getPageGoods(start, start+itemsNum);
			String hql = "select count(g) from Good g";
			long count = (long)session.createQuery(hql).list().get(0);
			System.out.println("-------count is " + count);
			PageInfo pageInfo = PageInfo.getPageInfo(Integer.parseInt(pageNum), count, goods, itemsNum);
//			transaction.commit();
			return pageInfo;
		} catch(Exception e) {
			throw e;
		} finally {
			session.close();
		}
	}
	
	public PageInfo getPageInfoInCategory(String category, String pageNum, String itemsPerPage) throws SQLException {
		Session session = HibernateUtil.getInstance().openSession();
		try {
			int itemsNum =Integer.parseInt(itemsPerPage);
			int start = (Integer.parseInt(pageNum)-1)*itemsNum;
//			if(!transaction.isActive())
//				transaction = session.beginTransaction();
			List<Good> goods = this.getPageGoodsinCategory(category, start, start+itemsNum);
			String hql = "select count(g) from Good g where category=:cate";
			long count = (long) session.createQuery(hql).setParameter("cate", Integer.parseInt(category)).list().get(0);
			System.out.println("-------count is " + count);
//			long count = (long)qr.query(hql, new ScalarHandler(), Integer.parseInt(category));
			PageInfo pageInfo = PageInfo.getPageInfo(Integer.parseInt(pageNum), count, goods, itemsNum);
//			transaction.commit();
			return pageInfo;
		} catch(Exception e) {
			throw e;
		} finally {
			session.close();
		}
	}
	
	
	private List<Good> getPageGoods(int start, int end) throws SQLException {
//		hql = "select * from goods order by ? desc limit ?,?";  //limit from index to index
//		if(!transaction.isActive())
//			transaction = session.beginTransaction();
		Session session = HibernateUtil.getInstance().openSession();
		try {
//			transaction = session.beginTransaction();
			String hql = "from Good";
			Query<Good> query = session.createQuery(hql);
			query.setFirstResult(start);
			query.setMaxResults(end);
			List<Good> allGoods = query.list();
//			allGoods = qr.query(hql, new BeanListHandler<Good>(Good.class), "gId", start, end);
//			Collections.reverse(allGoods);
//			transaction.commit();
			return allGoods;
		} catch(Exception e) {
			throw e;
		} finally {
			session.close();
		}
	}

	public List<Good> getPageGoodsinCategory(String category, int start, int end) throws NumberFormatException, SQLException {
		Session session = HibernateUtil.getInstance().openSession();
		try {
			String hql = "from Good where category=:cate";
//			List<Good> goods = qr.query(hql, new BeanListHandler<Good>(Good.class), Integer.parseInt(category), start, end);
			System.out.println("category: " + category);
			Query<Good> query = session.createQuery(hql)
					.setParameter("cate", Integer.parseInt(category));
			query.setFirstResult(start);
			query.setMaxResults(end);
			List<Good> allGoods = query.list();
			return allGoods;
		} catch(Exception e) {
			throw e;
		} finally{
			session.close();
		}
	}
}
